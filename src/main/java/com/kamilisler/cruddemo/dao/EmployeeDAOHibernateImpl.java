package com.kamilisler.cruddemo.dao;

import com.kamilisler.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
    // define field for entity manager
    private final EntityManager entityManager;
    //  set up const injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        // get the current hibernate session
        Query<Employee> theQuery;
        try (Session currentSession = entityManager.unwrap(Session.class)) {
            // create a query
            theQuery = currentSession.createQuery("from Employee", Employee.class);
        }
        // execute the query and result list

        //return the results
        return theQuery.getResultList();
    }
}

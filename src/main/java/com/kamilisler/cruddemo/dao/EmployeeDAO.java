package com.kamilisler.cruddemo.dao;

import com.kamilisler.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}

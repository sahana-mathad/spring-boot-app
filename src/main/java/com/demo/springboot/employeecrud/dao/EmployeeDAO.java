package com.demo.springboot.employeecrud.dao;

import com.demo.springboot.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}

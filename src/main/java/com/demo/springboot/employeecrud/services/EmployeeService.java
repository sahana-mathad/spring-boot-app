package com.demo.springboot.employeecrud.services;

import com.demo.springboot.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeService {


    public List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theID);
}

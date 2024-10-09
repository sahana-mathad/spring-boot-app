package com.demo.springboot.employeecrud.services;

import com.demo.springboot.employeecrud.dao.EmployeeDAO;
import com.demo.springboot.employeecrud.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //inject DAO

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO)
    {
        employeeDAO=theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}

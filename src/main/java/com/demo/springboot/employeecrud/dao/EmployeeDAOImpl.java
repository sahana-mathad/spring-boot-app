package com.demo.springboot.employeecrud.dao;

import com.demo.springboot.employeecrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    //define a field for entityManager

    private EntityManager entityManager;

    //Define a constructor ti inject entityManager

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a JPA Query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);

        // Execute the query and  get the results
        List<Employee> employees= theQuery.getResultList();

        //return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get employee
        Employee theEmployee = entityManager.find(Employee.class,theId);

        //return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save the employee

        Employee dbEmployee=entityManager.merge(theEmployee);

        //return the new data
        return dbEmployee;
    }

    @Override
    public void deleteById(int theID) {

        //find the employee by ID

        Employee theEmployee = entityManager.find(Employee.class,theID);

        //delete an employee

        entityManager.remove(theEmployee);

    }
}

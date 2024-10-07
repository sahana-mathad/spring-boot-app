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
}

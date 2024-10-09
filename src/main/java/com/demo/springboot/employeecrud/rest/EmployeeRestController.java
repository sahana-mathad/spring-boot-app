package com.demo.springboot.employeecrud.rest;

import com.demo.springboot.employeecrud.dao.EmployeeDAO;
import com.demo.springboot.employeecrud.entity.Employee;
import com.demo.springboot.employeecrud.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //inject Employee DAO
    //private EmployeeDAO employeeDAO;

    //Constructor injector to inject employee DAO

   // public EmployeeRestController(EmployeeDAO theEmployeeDAO){
       // employeeDAO=theEmployeeDAO;
  //  }

    //use service
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
     employeeService=theEmployeeService;
      }

    //Expose the employees endpoint to return all the employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

}

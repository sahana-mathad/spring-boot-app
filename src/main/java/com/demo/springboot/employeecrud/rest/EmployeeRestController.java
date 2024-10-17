package com.demo.springboot.employeecrud.rest;


import com.demo.springboot.employeecrud.entity.Employee;
import com.demo.springboot.employeecrud.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
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


    //Add mapping for GET /employees/{employeeID}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee not found"+employeeId);
        }
        return theEmployee;
    }

// Add the mapping for /employees- add new emploees

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //if id is given as 0.we will force to insert

        theEmployee.setId(0);
        Employee dbEmployee= employeeService.save(theEmployee);
        return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID){
        Employee theEmployee = employeeService.findById(employeeID);

        if(theEmployee == null){
            throw new RuntimeException("Employee ID not found"+employeeID);
        }
        employeeService.deleteById(employeeID);

        return "Deleted Employee ID" + employeeID;
    }


}

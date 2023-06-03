package com.example.employee.management.system.controllers;


import com.example.employee.management.system.models.Employee;
import com.example.employee.management.system.repositories.EmployeeRepository;
import com.example.employee.management.system.services.impl.EmployeeServiceImpl;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeServiceImpl.findAll();
    }

    @GetMapping(value = "employees/{id}")
    public ResponseEntity getEmployee(@PathVariable Long id){
        Optional<Employee> employee= employeeServiceImpl.findById(id);
        return employee.isPresent()?
                ResponseEntity.status(200).body(employee.get()):
                ResponseEntity.status(401).body("Employee "+id+" not found!!");
    }


    @PostMapping(value = "employees/store")
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(200).body(employeeServiceImpl.save(employee));
    }

    @DeleteMapping(value = "employees/{id}/delete")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        employeeServiceImpl.deleteById(id);
        return ResponseEntity.status(200).body("Employee "+id+" has been deleted successfully");
    }
}

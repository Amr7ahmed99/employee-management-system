package com.example.employee.management.system.controllers;


import com.example.employee.management.system.models.Employee;
import com.example.employee.management.system.repositories.EmployeeRepository;
import com.example.employee.management.system.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeServiceImpl.findAll();
    }

    @GetMapping(value = "employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id){
        return employeeServiceImpl.findById(id);
    }


    @PostMapping(value = "employees/store")
    public void insertEmployee(@RequestBody Employee employee){
        employeeServiceImpl.save(employee);
    }

    @DeleteMapping(value = "employees/{id}/delete")
    public void deleteEmployee(@PathVariable long id){
        employeeServiceImpl.deleteById(id);
    }
}

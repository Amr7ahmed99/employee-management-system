package com.example.employee.management.system.services.impl;

import com.example.employee.management.system.models.Employee;
import com.example.employee.management.system.repositories.EmployeeRepository;
import com.example.employee.management.system.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
        System.out.println(employee);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
        System.out.println(id);
    }
}

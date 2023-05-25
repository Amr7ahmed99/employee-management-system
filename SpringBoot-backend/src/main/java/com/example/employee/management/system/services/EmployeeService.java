package com.example.employee.management.system.services;

import com.example.employee.management.system.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface EmployeeService {

    List<Employee> findAll();

    Optional < Employee > findById(Long id);

    void save(Employee employee);

    void deleteById(long id);
}
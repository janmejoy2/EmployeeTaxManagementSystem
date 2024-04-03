package com.employee.tax.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.employee.tax.management.model.Employee;
import com.employee.tax.management.repository.EmployeeRepository;

@RestController
@Validated
public class EmployeeAddController {
	@Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
    public ResponseEntity<String> createEmployee(@Validated @RequestBody Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
    }
    
    @PostMapping("/addMultipleEmployees")
    public ResponseEntity<String> createMultipleEmployees(@Validated @RequestBody List<Employee> employees) {
        employeeRepository.saveAll(employees);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
    }
}

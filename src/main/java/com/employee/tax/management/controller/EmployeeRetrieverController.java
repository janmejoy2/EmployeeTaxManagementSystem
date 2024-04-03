package com.employee.tax.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.tax.management.model.Employee;
import com.employee.tax.management.repository.EmployeeRepository;

@RestController
public class EmployeeRetrieverController {
	@Autowired
    private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }
}

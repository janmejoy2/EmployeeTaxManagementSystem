package com.employee.tax.management.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.tax.management.model.Employee;
import com.employee.tax.management.model.TaxDeductionResponse;
import com.employee.tax.management.repository.EmployeeRepository;
import com.employee.tax.management.util.EmployeeTaxDeductionCalculation;

@RestController
public class EmployeeTaxDeductionController {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Autowired
    private EmployeeTaxDeductionCalculation taxDeductionCalculator;
	
	
	@GetMapping("/taxDeduction")
    public ResponseEntity<List<TaxDeductionResponse>> getTaxDeductions() {
		 List<Employee> employees = employeeRepository.findAll();
	        
	        List<TaxDeductionResponse> taxDeductions = employees.stream()
	                .map(taxDeductionCalculator::calculateTaxDeduction)
	                .collect(Collectors.toList());

	        return ResponseEntity.ok(taxDeductions);
    }
}

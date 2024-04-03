package com.employee.tax.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.tax.management.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

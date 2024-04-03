package com.employee.tax.management.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Employee {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Employee ID is mandatory")
	    @Column(nullable = false, unique = true)
	    private String employeeId;

	    @NotBlank(message = "First Name is mandatory")
	    @Column(nullable = false)
	    private String firstName;

	    @NotBlank(message = "Last Name is mandatory")
	    @Column(nullable = false)
	    private String lastName;
	    
	    @NotBlank(message = "Email is mandatory")
	    @Email(message = "Invalid email format")
	    @Column(nullable = false, unique = true)
	    private String email;

	    @NotEmpty(message = "At least one phone number is required")
	    @ElementCollection
	    @CollectionTable(name = "phone_numbers", joinColumns = @JoinColumn(name = "employee_id"))
	    @Column(name = "phone_number", nullable = false)
	    private List<String> phoneNumbers = new ArrayList<>();

	    @NotBlank(message = "Date of Joining is mandatory")
	    @Column(nullable = false)
	    private String doj;

	    @NotNull(message = "Salary is mandatory")
	    @Column(nullable = false)
	    private double salary;
	    
	    
	    public Employee() {
	    }

	    public Employee(String employeeId, String firstName, String lastName, String email, List<String> phoneNumbers, String doj, double salary) {
	        this.employeeId = employeeId;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.phoneNumbers = phoneNumbers;
	        this.doj = doj;
	        this.salary = salary;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getEmployeeId() {
	        return employeeId;
	    }

	    public void setEmployeeId(String employeeId) {
	        this.employeeId = employeeId;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public List<String> getPhoneNumbers() {
	        return phoneNumbers;
	    }

	    public void setPhoneNumbers(List<String> phoneNumbers) {
	        this.phoneNumbers = phoneNumbers;
	    }

	    public String getDoj() {
	        return doj;
	    }

	    public void setDoj(String doj) {
	        this.doj = doj;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }
}

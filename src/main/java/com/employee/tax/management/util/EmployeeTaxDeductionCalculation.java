package com.employee.tax.management.util;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.employee.tax.management.model.Employee;
import com.employee.tax.management.model.TaxDeductionResponse;

@Component
public class EmployeeTaxDeductionCalculation {
	
	public TaxDeductionResponse calculateTaxDeduction(Employee employee) {
        double yearlySalary = calculateYearlySalary(employee);
        double taxAmount = calculateTaxAmount(yearlySalary);
        double cessAmount = calculateCessAmount(yearlySalary);

        TaxDeductionResponse response = new TaxDeductionResponse();
        response.setEmployeeId(employee.getEmployeeId());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setYearlySalary(yearlySalary);
        response.setTaxAmount(taxAmount);
        response.setCessAmount(cessAmount);

        return response;
    }

    private double calculateYearlySalary(Employee employee) {
        double totalSalary = employee.getSalary() * calculateNumberOfMonths(LocalDate.parse(employee.getDoj()));
        double lossOfPayPerDay = employee.getSalary() / 30;
        int daysWorked = calculateDaysWorkedInCurrentYear(LocalDate.parse(employee.getDoj()));
        totalSalary -= lossOfPayPerDay * (30 - daysWorked); // Deduct loss of pay
        
        return totalSalary;
    }

    private int calculateNumberOfMonths(LocalDate doj) {
        LocalDate today = LocalDate.now();
        int months = 12 - doj.getMonthValue() + 1; // Including the partial month of DOJ
        if (doj.getYear() == today.getYear()) {
            months = today.getMonthValue() - doj.getMonthValue() + 1;
        }
        return Math.max(0, months);
    }

    private int calculateDaysWorkedInCurrentYear(LocalDate doj) {
        LocalDate today = LocalDate.now();
        int daysWorked = 0;
        if (doj.getYear() == today.getYear()) {
            int totalDaysInCurrentYear = today.getDayOfYear();
            int dojDayOfYear = doj.getDayOfYear();
            daysWorked = totalDaysInCurrentYear - dojDayOfYear + 1; // Including DOJ day
        }
        return Math.max(0, daysWorked);
    }

    private double calculateTaxAmount(double yearlySalary) {
        double taxAmount = 0.0;

        double taxableIncome = yearlySalary - 250000; // Assuming basic exemption limit of 2,50,000 INR
        
        if (taxableIncome <= 0) {
            taxAmount = 0;
        } else if (taxableIncome <= 250000) {
            taxAmount = 0; // No tax for income up to 2,50,000 INR
        } else if (taxableIncome <= 500000) {
            taxAmount = taxableIncome * 0.05; // 5% tax for income between 2,50,001 to 5,00,000 INR
        } else if (taxableIncome <= 1000000) {
            taxAmount = (taxableIncome - 500000) * 0.1 + 12500; // 10% tax for income between 5,00,001 to 10,00,000 INR
        } else {
            taxAmount = (taxableIncome - 1000000) * 0.2 + 112500; // 20% tax for income above 10,00,000 INR
        }

        return taxAmount;
    }

    private double calculateCessAmount(double yearlySalary) {
        double cessAmount = 0.0;

        if (yearlySalary > 2500000) {
            cessAmount = (yearlySalary - 2500000) * 0.02; // 2% cess for the amount more than 2500000
        }

        return cessAmount;
    }

}

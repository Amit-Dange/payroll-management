package com.epam.payroll_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.payroll_management.repository.Employee;


@Service
public class ReadEmployee {
	
private final List<Employee> employeeDatabase ;
	
	@Autowired
    public ReadEmployee(List<Employee> employeeDatabase) {
        this.employeeDatabase = employeeDatabase;
    }
	
	public Employee getEmployeeById(int empId) {
		
		int low = 0 ;
		int high = employeeDatabase.size()-1;
		while(low <= high) {
			int mid = low + (high - low )/2 ;
			Employee midEmp = employeeDatabase.get(mid) ;
			if(midEmp.getEmpId() == empId) {
				return midEmp ;
			}
			if(midEmp.getEmpId() < empId) {
				low = low + 1 ;
			}
			else {
				high = mid - 1 ;
			}
		}		
		
		throw new IllegalArgumentException("ERROR404 : Employee not Found!!!!");
	}
}

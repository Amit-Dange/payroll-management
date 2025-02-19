package com.epam.payroll_management.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.payroll_management.repository.Employee;

@Repository
public class EmployeeDatabase {
	private static final List<Employee> employeeDatabase = new ArrayList<>();

	public static List<Employee> getEmployeedatabase() {
		return employeeDatabase;
	}
	
}

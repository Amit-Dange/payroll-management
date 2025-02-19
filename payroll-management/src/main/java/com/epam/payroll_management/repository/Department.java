package com.epam.payroll_management.repository;

import java.util.Map;

import com.epam.payroll_management.utility.ValidationsUtils;

public class Department {
	private String department ;
	private static final Map<String, String> facilitiesByDepartment = Map.ofEntries(
	        Map.entry("HR", "Employee Training, Recruitment Support, Payroll Management"),
	        Map.entry("IT", "Software Development, Cybersecurity, Infrastructure Management"),
	        Map.entry("Finance", "Budgeting, Auditing, Payroll Processing"),
	        Map.entry("Marketing", "Advertising, Social Media Management, SEO Optimization"),
	        Map.entry("Operations", "Logistics, Supply Chain Management, Quality Control")
	    );

	public Department(String department) {
		ValidationsUtils.validateString(department);
		this.department = department;
	}

	@Override
	public String toString() {
		return department ;
	}
	
	
	
	
}

package com.epam.payroll_management.repository;

import java.util.*;

import com.epam.payroll_management.utility.ValidationsUtils;

public class Designation {
	private String designation ;
	private double salary ;
	
	private static final Map<String, Double> salaryByDesignations = Map.ofEntries(
		    Map.entry("Junior Software Engineer", 70000.00),
		    Map.entry("Senior Software Engineer", 90000.00),
		    Map.entry("Team Lead", 110000.00),
		    Map.entry("Project Manager", 130000.00),
		    Map.entry("CTO", 200000.00)
		);
	
	public Designation(String designation) {
		ValidationsUtils.validateString(designation);
        if(!salaryByDesignations.containsKey(designation)) {
        	throw new IllegalArgumentException("please enter valid designation!!");
        }
        this.designation = designation;
        this.salary = salaryByDesignations.get(designation);
	}
	
	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return designation;
	}
	
	
}

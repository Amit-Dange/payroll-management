package com.epam.payroll_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.payroll_management.repository.Employee;

@Service
public class DatabaseSummary {
	
private final List<Employee> employeeDatabase ;
	
	@Autowired
    public DatabaseSummary(List<Employee> employeeDatabase) {
        this.employeeDatabase = employeeDatabase;
    }
	
	public int totalEmployees() {
		return this.employeeDatabase.size();
	}
	
//	public static Map<String , Integer> employeesPerDepartment(String department){
//		System.out.println("Total Employees :"+totalEmployees());
//		return null;
//	}
//	
//	public static Map<String , Integer> employeesWithDesignationStatus(){
//		System.out.println("Total Employees :"+totalEmployees());
//		return null;
//	}
//	
//	public static Map<String , Integer> departmentwiseEmployeesTable(){
//		System.out.println("Total Employees :"+totalEmployees());
//		return null;
//	}
	
	public void ShowDatabase() {
//		System.out.println("here!1");
		employeeDatabase.stream().forEach(System.out::println);
	}
	
}

package com.epam.payroll_management.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.payroll_management.repository.Department;
import com.epam.payroll_management.repository.Designation;
import com.epam.payroll_management.repository.Employee;

@Service
public class CreateEmployee {
	
	private final List<Employee> employeeDatabase ;
	
	@Autowired
    public CreateEmployee(List<Employee> employeeDatabase) {
        this.employeeDatabase = employeeDatabase;
    }

	public LocalDate getLocalDate(String localDate){
		if("NOW".equals(localDate)) {
			return LocalDate.now();
		}
		LocalDate date=null;    
		try {        
			date=  LocalDate.parse(localDate);    
		}
		
		catch (Exception e) {
			System.out.println("Invalid date format. Please use yyyy-MM-dd.");    
		}    
		return date;
	}
	
	public void addEmployeeBinary(Employee employee) {
		int left = 0;
		int right = this.employeeDatabase.size() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int midEmpId = employeeDatabase.get(mid).getEmpId();

			if (midEmpId == employee.getEmpId()) {
				throw new IllegalArgumentException("Employee Aready Exist!!!!");
			} else if (midEmpId < employee.getEmpId()) {
				left = mid + 1; 
			} else {
				right = mid - 1; 
			}
		}
		employeeDatabase.add(left, employee);
	}

	public void addEmployee(int empId , String name, String designation, String department, String localdate) {
    	Employee employee = Employee.builder()
    			.empId(empId)
    			.name(name)
    			.designation(new Designation(designation))
    			.department(new Department(department))
    			.dateOfJoining(this.getLocalDate(localdate))
    			.build();
    	addEmployeeBinary(employee);
    	
    }
}

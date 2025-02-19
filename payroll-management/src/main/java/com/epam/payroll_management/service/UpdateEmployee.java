package com.epam.payroll_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.payroll_management.repository.Department;
import com.epam.payroll_management.repository.Designation;
import com.epam.payroll_management.repository.Employee;


@Service
public class UpdateEmployee {
	
	private final List<Employee> employeeDatabase ;
	
	@Autowired
    public UpdateEmployee(List<Employee> employeeDatabase) {
        this.employeeDatabase = employeeDatabase;
    }
	
	public Employee updateEmployeeById(int empId , String name, String designation, String department ) {
//		Employee updatedEmployee = new Employee(empId , name , new Designation(designation) , new Department(department));
//		LocalDate dateOfJoining = .getEmployeeById(empId).getDateOfJoining();
		Employee updatedEmployee = Employee.builder()
				.empId(empId)
				.name(name)
				.designation(new Designation(designation))
				.department(new Department(department))
//				.dateOfJoining(dateOfJoining)
				.build();
		
		int low = 0 ;
		int high = employeeDatabase.size()-1;
		while(low <= high) {
			int mid = low + (high - low )/2 ;
			Employee midEmp = employeeDatabase.get(mid) ;
			if(midEmp.getEmpId() == empId) {
				employeeDatabase.set(mid, updatedEmployee);
				return employeeDatabase.get(mid);
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

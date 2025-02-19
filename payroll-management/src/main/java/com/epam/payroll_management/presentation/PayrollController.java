package com.epam.payroll_management.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.payroll_management.repository.Employee;
import com.epam.payroll_management.service.CreateEmployee;
import com.epam.payroll_management.service.DeleteEmployee;
import com.epam.payroll_management.service.ReadEmployee;
import com.epam.payroll_management.service.UpdateEmployee;

@RestController
public class PayrollController {
	
	private CreateEmployee createEmployee ;
	private DeleteEmployee deleteEmployee ;
	private ReadEmployee readEmployee ;
	private UpdateEmployee updateEmployee ;

	@Autowired
	public PayrollController(
			CreateEmployee createEmployee,
			DeleteEmployee deleteEmployee, 
			ReadEmployee readEmployee,
			UpdateEmployee updateEmployee
			) 
	{
		this.createEmployee = createEmployee;
		this.deleteEmployee = deleteEmployee;
		this.readEmployee = readEmployee;
		this.updateEmployee = updateEmployee;
	}


	static class EmployeeRequest {
        public int empid;
        public String name;
        public String designation;
        public String department;
        public String dateOfJoining;
    }
	
	
	@GetMapping("/employeeDatabase")
	public List<Employee> getEmployeeDatabase() {
		return null;
//		return employeeDatabase;
	}
	
	@PostMapping("/create")
	public void createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		
		createEmployee.addEmployee(
                employeeRequest.empid, 
                employeeRequest.name, 
                employeeRequest.designation, 
                employeeRequest.department, 
                employeeRequest.dateOfJoining
        );
	}
	
	@GetMapping("/read/{empid}")
    public Employee readEmployee(@PathVariable int empid) {
        return readEmployee.getEmployeeById(empid);
    }
	
	@PutMapping("/update")
    public Employee updateEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return updateEmployee.updateEmployeeById(
                employeeRequest.empid, 
                employeeRequest.name, 
                employeeRequest.designation, 
                employeeRequest.department
        );
    }
	
	@DeleteMapping("/delete/{empid}")
    public Employee deleteEmployee(@PathVariable int empid) {
        return deleteEmployee.deleteEmployeeById(empid);
    }
	
}

package com.epam.payroll_management.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.epam.payroll_management.utility.ValidationsUtils;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
//@Component
//@NoArgsConstructor
public @Builder
class Employee {

	private int empId;
    private String name;
    private Designation designation;
    private Department department;
    private LocalDate dateOfJoining ;
    private double salary; 

    public void setEmpId(int empId) {
        ValidationsUtils.validateValue(empId);
        this.empId = empId;
    }

    public void setName(String name) {
        ValidationsUtils.validateString(name);
        this.name = name;
    }

    public void setDesignation(Designation designation) {
        ValidationsUtils.validateObject(designation);
        this.designation = designation;
    }

    public void setDepartment(Department department) {
        ValidationsUtils.validateObject(department);
        this.department = department;
    }
    public void setDateOfJoining(LocalDate dateOfJoining) {
    	ValidationsUtils.validateObject(dateOfJoining);
    	this.dateOfJoining = dateOfJoining;
    }    
    
    

    @Override
    public String toString() {
        return String.format(
            "Employee Details:\n" +
            "-----------------\n" +
            "ID           : %d\n" +
            "Name         : %s\n" +
            "Designation  : %s\n" +
            "Department   : %s\n" +
            "Date Joined  : %s\n" +
            "Salary        : %s\n",
            empId, name, designation, department, dateOfJoining, designation.getSalary()
        );
    }

}

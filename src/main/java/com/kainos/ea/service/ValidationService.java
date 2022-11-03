package com.kainos.ea.service;

import com.kainos.ea.model.*;
import com.kainos.ea.validation.*;

public class ValidationService {

    public static boolean validEmployee(Employee employee){
        return EmployeeValidation.validForename(employee.getFirst_name()) &&
                EmployeeValidation.validSurname(employee.getLast_name()) &&
                EmployeeValidation.validAddressLine(employee.getAddress()) &&
                EmployeeValidation.validPostcode(employee.getPostcode()) &&
                EmployeeValidation.validNIN(employee.getNin()) &&
                EmployeeValidation.validBankNo(employee.getBankNo()) &&
                EmployeeValidation.validStartingSalary(employee.getStartSalary());
    }

    public static boolean validSalesEmployee(SalesEmployee salesEmployee){
        return ValidationService.validEmployee(salesEmployee) &&
                SalesEmployeeValidation.validCommissionRate(salesEmployee.getCommissionRate()) &&
                SalesEmployeeValidation.validTotalSales(salesEmployee.getTotalSales());
    }

    public static boolean validDepartment(Department department){
        return DepartmentValidation.validDepartmentName(department.getDepartmentName());
    }

    public static boolean validProject(Project project){
        return ProjectValidation.validProjectName(project.getProjectName());
    }
}

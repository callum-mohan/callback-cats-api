package com.kainos.ea.controller;

import com.kainos.ea.model.DeliveryEmployee;
import com.kainos.ea.model.Employee;
import com.kainos.ea.model.SalesEmployee;
import com.kainos.ea.service.DeliveryEmployeeService;
import com.kainos.ea.service.EmployeeService;
import com.kainos.ea.service.SalesEmployeeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HR {
    public Boolean insertEmployee(Employee emp){
        try{
            EmployeeService employeeService = new EmployeeService();
            employeeService.insertEmployee(emp);
            return true;
        }
        catch(SQLException ex){
            return false;
        }
    }

    public Boolean insertEmployee(SalesEmployee emp){
        try{
            SalesEmployeeService salesEmployeeService = new SalesEmployeeService();
            salesEmployeeService.insertSalesEmployee(emp);
            return true;
        }
        catch(SQLException ex){
            return false;
        }
    }

    public Boolean insertEmployee(DeliveryEmployee emp){
        try{
            DeliveryEmployeeService deliveryEmployeeService = new DeliveryEmployeeService();
            return deliveryEmployeeService.insertDeliveryEmployee(emp);
        }
        catch(SQLException ex){
            return false;
        }
    }

    public List<Employee> getAllEmployees() throws SQLException{
        List<Employee> allEmployees = new ArrayList<>();
        EmployeeService employeeService = new EmployeeService();
        allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    public List<SalesEmployee> getAllSalesEmployees(){
        List<SalesEmployee> allSalesEmployees = new ArrayList<>();
        try{
            SalesEmployeeService salesEmployeeService = new SalesEmployeeService();
            allSalesEmployees = salesEmployeeService.getAllSalesEmployees();
        }
        catch(SQLException ex){
            System.out.println("Couldn't retrieve Sales Employee Details!");
        }
        return allSalesEmployees;
    }

    public List<DeliveryEmployee> getAllDeliveryEmployees(){
        List<DeliveryEmployee> allDelEmployees = new ArrayList<>();
        try{
            DeliveryEmployeeService deliveryEmployeeService = new DeliveryEmployeeService();
            allDelEmployees = deliveryEmployeeService.getAllDeliveryEmployees();
        }
        catch(SQLException ex){
            System.out.println("Couldn't retrieve Delivery Employee Details!");
        }
        return allDelEmployees;
    }
}

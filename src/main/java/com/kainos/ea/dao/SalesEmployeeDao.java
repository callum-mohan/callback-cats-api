package com.kainos.ea.dao;

import com.kainos.ea.model.Employee;
import com.kainos.ea.model.SalesEmployee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesEmployeeDao {
    public void insertSalesEmployee(SalesEmployee emp, Connection c) throws SQLException {
        Statement st = c.createStatement();
        String insertSalesEmployee = "INSERT INTO SalesEmployee VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStmt2 = c.prepareStatement(insertSalesEmployee);
        preparedStmt2.setInt(1, emp.getSalesId());
        preparedStmt2.setFloat(2, emp.getCommissionRate());
        preparedStmt2.setFloat(3, emp.getTotalSales());
        preparedStmt2.setInt(4, emp.getEmployeeId());
        preparedStmt2.executeUpdate();
    }

    public List<SalesEmployee> selectAllSalesEmployees(Connection c) throws SQLException{
        List<SalesEmployee> allSalesEmployees = new ArrayList<>();
        Statement st = c.createStatement();
        String selectAllSalesEmployees = "SELECT Employee.EmployeeId, Employee.first_name, Employee.last_name, Employee.Address, Employee.Postcode, Employee.NIN, Employee.BankNo, Employee.StartSalary, Employee.DepartmentId, SalesEmployee.SalesId, SalesEmployee.CommissionRate, SalesEmployee.TotalSales FROM SalesEmployee INNER JOIN Employee ON SalesEmployee.EmployeeID = Employee.EmployeeID";
        PreparedStatement preparedStmt = c.prepareStatement(selectAllSalesEmployees);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            SalesEmployee dbEmp = new SalesEmployee(rs.getInt("EmployeeId"),
                    rs.getString("first_name"), rs.getString("last_name"), rs.getString("Address"),
                    rs.getString("Postcode"), rs.getString("NIN"), rs.getString("BankNo"), rs.getFloat("StartSalary"), rs.getInt("DepartmentId"), rs.getFloat("CommissionRate"), rs.getFloat("TotalSales"), rs.getInt("SalesId"));
            allSalesEmployees.add(dbEmp);
        }
        return allSalesEmployees;
    }

    public SalesEmployee selectSalesEmployeeByID(int id, Connection c) throws SQLException{
        SalesEmployee dbEmp = new SalesEmployee();
        Statement st = c.createStatement();
        String selectSalesEmployeeByID = "SELECT Employee.EmployeeId, Employee.first_name, Employee.last_name, Employee.Address, Employee.Postcode, Employee.NIN, Employee.BankNo, Employee.StartSalary, Employee.DepartmentId, SalesEmployee.SalesId, SalesEmployee.CommissionRate, SalesEmployee.TotalSales FROM SalesEmployee INNER JOIN Employee ON SalesEmployee.EmployeeID = Employee.EmployeeID WHERE SalesEmployee.EmployeeID = ?";
        PreparedStatement preparedStmt = c.prepareStatement(selectSalesEmployeeByID);
        preparedStmt.setInt(1, id);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            dbEmp = new SalesEmployee(rs.getInt("EmployeeId"),
                    rs.getString("first_name"), rs.getString("last_name"), rs.getString("Address"),
                    rs.getString("Postcode"), rs.getString("NIN"), rs.getString("BankNo"), rs.getFloat("StartSalary"), rs.getInt("DepartmentId"), rs.getFloat("CommissionRate"), rs.getFloat("TotalSales"), rs.getInt("SalesId"));
        }
        return dbEmp;
    }

    public SalesEmployee selectHighestSalesTotal(Connection c) throws SQLException{
        SalesEmployee dbEmp = new SalesEmployee();
        Statement st = c.createStatement();
        String selectHighestSalesTotal = "SELECT SalesEmployee.EmployeeId, Employee.first_name, Employee.last_name, SalesEmployee.TotalSales FROM SalesEmployee INNER JOIN Employee ON SalesEmployee.EmployeeID = Employee.EmployeeID WHERE SalesEmployee.TotalSales = (SELECT MAX(TotalSales) FROM SalesEmployee)";
        PreparedStatement preparedStmt = c.prepareStatement(selectHighestSalesTotal);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            dbEmp = new SalesEmployee(rs.getInt("EmployeeId"),
                    rs.getString("first_name"), rs.getString("last_name"),
                    rs.getFloat("TotalSales"));
        }
        return dbEmp;
    }
}

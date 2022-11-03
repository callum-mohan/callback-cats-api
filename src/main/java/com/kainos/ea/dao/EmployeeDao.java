package com.kainos.ea.dao;

import com.kainos.ea.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public void insertEmployee(Employee emp, Connection c) throws SQLException {
        String insertOrderQuery = "INSERT INTO Employee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = c.prepareStatement(insertOrderQuery);
        preparedStmt.setInt(1, emp.getEmployeeId());
        preparedStmt.setString(2, emp.getFirst_name());
        preparedStmt.setString(3, emp.getLast_name());
        preparedStmt.setString(4, emp.getAddress());
        preparedStmt.setString(5, emp.getPostcode());
        preparedStmt.setString(6, emp.getNin());
        preparedStmt.setString(7, emp.getBankNo());
        preparedStmt.setFloat(8, emp.getStartSalary());
        preparedStmt.setInt(9, emp.getDepartmentId());
        preparedStmt.executeUpdate();
    }

    public List<Employee> selectAllEmployees(Connection c) throws SQLException{
        List<Employee> allEmployees = new ArrayList<>();
        String selectLastEmployee = "SELECT * FROM Employee";
        PreparedStatement preparedStmt = c.prepareStatement(selectLastEmployee);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            Employee dbEmp = new Employee(rs.getInt("EmployeeId"),
                    rs.getString("first_name"), rs.getString("last_name"), rs.getString("Address"),
                    rs.getString("Postcode"), rs.getString("NIN"), rs.getString("BankNo"), rs.getFloat("StartSalary"), rs.getInt("DepartmentId"));
            allEmployees.add(dbEmp);
        }
        return allEmployees;
    }

    public Employee selectEmployeeByID(int id, Connection c) throws SQLException{
        Employee dbEmp = new Employee();
        String selectLastEmployee = "SELECT * FROM Employee WHERE EmployeeID = ?";
        PreparedStatement preparedStmt = c.prepareStatement(selectLastEmployee);
        preparedStmt.setInt(1, id);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            dbEmp = new Employee(rs.getInt("EmployeeId"),
                    rs.getString("first_name"), rs.getString("last_name"), rs.getString("Address"),
                    rs.getString("Postcode"), rs.getString("NIN"), rs.getString("BankNo"), rs.getFloat("StartSalary"), rs.getInt("DepartmentId"));
        }
        return dbEmp;
    }

    public int lastInsertID(Connection c) throws SQLException{
        int lastID = 0;
        String lastInsertId = "SELECT EmployeeId FROM Employee ORDER BY EmployeeId DESC LIMIT 1";
        PreparedStatement preparedStmt = c.prepareStatement(lastInsertId);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            lastID = rs.getInt("EmployeeId");
        }
        return lastID;
    }

    public List<Employee> getEmployeeGrossPay(Connection c) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String getGrossPay = "SELECT * FROM Employee";
        PreparedStatement preparedStmt = c.prepareStatement(getGrossPay);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            Employee dbEmp = new Employee(rs.getInt("EmployeeId"),
                    rs.getString("first_name"), rs.getString("last_name"), rs.getString("Address"),
                    rs.getString("Postcode"), rs.getString("NIN"), rs.getString("BankNo"), rs.getFloat("StartSalary"), rs.getInt("DepartmentId"));
            employees.add(dbEmp);
        }
        return employees;
    }
}

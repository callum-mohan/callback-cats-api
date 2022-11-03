package com.kainos.ea.dao;

import com.kainos.ea.model.DeliveryEmployee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryEmployeeDao {
    public void insertDeliveryEmployee(int empId, DeliveryEmployee emp, Connection c) throws SQLException {
        Statement st = c.createStatement();
        String insertDeliveryEmployee = "INSERT INTO DeliveryEmployee VALUES (?, ?)";
        PreparedStatement preparedStmt2 = c.prepareStatement(insertDeliveryEmployee);
        preparedStmt2.setInt(1, emp.getDeliveryId());
        preparedStmt2.setInt(2, empId);
        preparedStmt2.executeUpdate();
    }

    public List<DeliveryEmployee> selectAllDeliveryEmployees(Connection c) throws SQLException{
        List<DeliveryEmployee> allDeliveryEmployees = new ArrayList<>();
        Statement st = c.createStatement();
        String selectAllDeliveryEmployees = "SELECT DeliveryEmployee.DeliveryId, Employee.EmployeeId, Employee.first_name, Employee.last_name, Employee.Address, Employee.Postcode, Employee.NIN, Employee.BankNo, Employee.StartSalary" +
                "FROM DeliveryEmployee INNER JOIN Employee ON DeliveryEmployee.EmployeeId = Employee.EmployeeId";
        PreparedStatement preparedStmt = c.prepareStatement(selectAllDeliveryEmployees);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            DeliveryEmployee dbEmp = new DeliveryEmployee(rs.getInt("EmployeeId"),
                    rs.getString("first_name"), rs.getString("last_name"), rs.getString("Address"),
                    rs.getString("Postcode"), rs.getString("NIN"), rs.getString("BankNo"), rs.getFloat("StartSalary"), rs.getInt("DepartmentId"), rs.getInt("DeliveryId"));
            allDeliveryEmployees.add(dbEmp);
        }
        return allDeliveryEmployees;
    }

    public DeliveryEmployee selectDeliveryEmployeeByID(int id, Connection c) throws SQLException{
        DeliveryEmployee dbEmp = new DeliveryEmployee();
        Statement st = c.createStatement();
        String selectDeliveryEmployeeByID = "SELECT Employee.EmployeeId, Employee.first_name, Employee.last_name, Employee.Address, Employee.Postcode, Employee.NIN, Employee.BankNo, Employee.StartSalary, DeliveryEmployee.DeliveryId FROM DeliveryEmployee INNER JOIN Employee ON DeliveryEmployee.EmployeeId = Employee.EmployeeId WHERE DeliveryEmployee.EmployeeId = ?";
        PreparedStatement preparedStmt = c.prepareStatement(selectDeliveryEmployeeByID);
        preparedStmt.setInt(1, id);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            dbEmp = new DeliveryEmployee(rs.getInt("EmployeeId"),
                    rs.getString("first_name"), rs.getString("last_name"), rs.getString("Address"),
                    rs.getString("Postcode"), rs.getString("NIN"), rs.getString("BankNo"), rs.getFloat("StartSalary"), rs.getInt("DepartmentId"), rs.getInt("DeliveryId"));
        }
        return dbEmp;
    }
}

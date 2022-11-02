package com.kainos.ea.dao;

import com.kainos.ea.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    public void insertDepartment(Department department, Connection c) throws SQLException {
        Statement st = c.createStatement();
        String insertDepartment = "INSERT INTO Department VALUES (?, ?, ?)";
        PreparedStatement preparedStmt = c.prepareStatement(insertDepartment);
        preparedStmt.setInt(1, department.getDepartmentId());
        preparedStmt.setString(2, department.getDepartmentName());
        preparedStmt.setString(3, department.getDepartmentDescription());
        preparedStmt.executeUpdate();
    }

    public List<Department> selectAllDepartments(Connection c) throws SQLException{
        List<Department> allProjects = new ArrayList<>();
        Statement st = c.createStatement();
        String selectAllProjects = "SELECT DepartmentId, DepartmentName, DepartmentDescription FROM Department";
        PreparedStatement preparedStmt = c.prepareStatement(selectAllProjects);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            Department dbDepartment = new Department(rs.getInt("ProjectId"), rs.getString("ProjectName"), rs.getString("ProjectDescription"));
            allProjects.add(dbDepartment);
        }
        return allProjects;
    }

    public Department selectDepartmentById(int id, Connection c) throws SQLException{
        Department dbDepartment = new Department();
        Statement st = c.createStatement();
        String selectProjectByID = "SELECT DepartmentId, DepartmentName, DepartmentDescription FROM Department WHERE DepartmentId = ?";
        PreparedStatement preparedStmt = c.prepareStatement(selectProjectByID);
        preparedStmt.setInt(1, id);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            dbDepartment = new Department(rs.getInt("ProjectId"), rs.getString("ProjectName"), rs.getString("ProjectDescription"));
        }
        return dbDepartment;
    }
}

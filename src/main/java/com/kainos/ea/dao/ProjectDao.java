package com.kainos.ea.dao;

import com.kainos.ea.model.DeliveryEmployee;
import com.kainos.ea.model.Employee;
import com.kainos.ea.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    public void insertProject(Project project, Connection c) throws SQLException {
        Statement st = c.createStatement();
        String insertProject = "INSERT INTO Project VALUES (?, ?, ?)";
        PreparedStatement preparedStmt = c.prepareStatement(insertProject);
        preparedStmt.setInt(1, project.getProjectId());
        preparedStmt.setString(2, project.getProjectName());
        preparedStmt.setString(3, project.getProjectDescription());
        preparedStmt.executeUpdate();
    }

    public List<Project> getAllProjects(Connection c) throws SQLException{
        List<Project> allProjects = new ArrayList<>();
        Statement st = c.createStatement();
        String selectAllProjects = "SELECT ProjectId, ProjectName, ProjectDescription FROM Project";
        PreparedStatement preparedStmt = c.prepareStatement(selectAllProjects);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            Project dbProject = new Project(rs.getInt("ProjectId"), rs.getString("ProjectName"), rs.getString("ProjectDescription"));
            allProjects.add(dbProject);
        }
        return allProjects;
    }

    public Project selectProjectByID(int id, Connection c) throws SQLException{
        Project dbProject = new Project();
        Statement st = c.createStatement();
        String selectProjectByID = "SELECT ProjectId, ProjectName, Finished, CustomerID FROM Project WHERE ProjectID = ?";
        PreparedStatement preparedStmt = c.prepareStatement(selectProjectByID);
        preparedStmt.setInt(1, id);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            dbProject = new Project(rs.getInt("ProjectId"), rs.getString("ProjectName"), rs.getString("ProjectDescription"));
        }
        return dbProject;
    }

    public void addEmployeeToProject(int projectID, int empID, Connection c) throws SQLException {
        Statement st = c.createStatement();
        String insertDelEmployeeIntoProject = "INSERT INTO ProjectEmployee (EmployeeId, ProjectId) VALUES (?, ?)";
        PreparedStatement preparedStmt = c.prepareStatement(insertDelEmployeeIntoProject);
        preparedStmt.setInt(1, empID);
        preparedStmt.setInt(2, projectID);
        preparedStmt.executeUpdate();
    }

    public int noOfEmployeesByProjectID(int projectID, Connection c) throws SQLException {
        int noOfEmployees = 0;
        Statement st = c.createStatement();
        String insertProject = "SELECT COUNT(EmployeeId) AS NoOfEmployees FROM ProjectEmployee WHERE ProjectId = ?";
        PreparedStatement preparedStmt = c.prepareStatement(insertProject);
        preparedStmt.setInt(1, projectID);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            noOfEmployees = rs.getInt("NoOfEmployees");
        }
        return noOfEmployees;
    }

    public List<Employee> employeesNoProject(Connection c) throws SQLException{
        List<Employee> projectsNoEmployees = new ArrayList<>();
        Statement st = c.createStatement();
        String selectAllProjectsNoEmployees = "SELECT Employee.EmployeeId, Employee.first_name, Employee.last_name, Employee.Address, Employee.Postcode, Employee.NIN, Employee.BankNo, Employee.StartSalary, Employee.DepartmentId FROM Employee LEFT JOIN ProjectEmployee ON Employee.EmployeeId = ProjectEmployee.EmployeeId WHERE ProjectId IS NULL;";
        PreparedStatement preparedStmt = c.prepareStatement(selectAllProjectsNoEmployees);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            Employee dbEmp = new Employee(rs.getInt("EmployeeId"),
                    rs.getString("first_name"), rs.getString("last_name"), rs.getString("Address"),
                    rs.getString("Postcode"), rs.getString("NIN"), rs.getString("BankNo"), rs.getFloat("StartSalary"), rs.getInt("DepartmentId"));
            projectsNoEmployees.add(dbEmp);
        }
        return projectsNoEmployees;
    }

    public List<Project> projectsNoEmployees(Connection c) throws SQLException{
        List<Project> projectsNoEmployees = new ArrayList<>();
        Statement st = c.createStatement();
        String selectAllProjects = "SELECT Project.ProjectId, Project.ProjectName, Project.ProjectDescription FROM Project LEFT JOIN ProjectEmployee ON Project.ProjectId = ProjectEmployee.ProjectID WHERE ProjectEmployee.ProjectID IS NULL;";
        PreparedStatement preparedStmt = c.prepareStatement(selectAllProjects);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            Project dbProject = new Project(rs.getInt("ProjectId"), rs.getString("ProjectName"), rs.getString("ProjectDescription"));
            projectsNoEmployees.add(dbProject);
        }
        return projectsNoEmployees;
    }
}

package com.kainos.ea.dao;

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

    public List<Project> selectAllProjects(Connection c) throws SQLException{
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
}

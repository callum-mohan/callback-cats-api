package com.kainos.ea.service;

import com.kainos.ea.dao.ProjectDao;
import com.kainos.ea.db.dbConnection;
import com.kainos.ea.model.Project;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    public List<Project> getAllProjects() throws SQLException {
        ProjectDao projectDao = new ProjectDao();
        return projectDao.selectAllProjects(dbConnection.getConnection());
    }

    public Project getEmployeeById(int projectId) throws SQLException {
        ProjectDao projectDao = new ProjectDao();
        return projectDao.selectProjectByID(projectId,dbConnection.getConnection());
    }

    public boolean insertProject(Project project) throws SQLException {
        ProjectDao projectDao = new ProjectDao();
        projectDao.insertProject(project, dbConnection.getConnection());
        return true;
    }

//    public void insertEmployeeIntoProject(int projectId, int employeeId)throws SQLException{
//        ProjectDao projectDao = new ProjectDao();
//        projectDao.insertEmployeeIntoProject(projectId, employeeId, connection);
//    }

//    public List<DeliveryEmployee> getEmployeesOnProjectById(int projectId) throws SQLException {
//        ProjectDao projectDao = new ProjectDao();
//        return projectDao.getEmployeesByProjectID(projectId, connection);
//    }


}

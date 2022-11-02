package com.kainos.ea.service;

import com.kainos.ea.dao.ProjectDao;
import com.kainos.ea.db.dbConnection;
import com.kainos.ea.model.Project;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    Connection connection = dbConnection.getConnection();
    public List<Project> getAllProjects() throws SQLException {
        ProjectDao projectDao = new ProjectDao();
        return projectDao.selectAllProjects(connection);
    }

    public Project getEmployeeById(int projectId) throws SQLException {
        ProjectDao projectDao = new ProjectDao();
        return projectDao.selectProjectByID(projectId,connection);
    }

    public boolean insertProject(Project project) throws SQLException {
        ProjectDao projectDao = new ProjectDao();
        projectDao.insertProject(project, connection);
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

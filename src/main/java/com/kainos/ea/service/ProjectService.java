package com.kainos.ea.service;

import com.kainos.ea.dao.ProjectDao;
import com.kainos.ea.db.dbConnection;
import com.kainos.ea.model.DeliveryEmployee;
import com.kainos.ea.model.Employee;
import com.kainos.ea.model.Project;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    public List<Project> getAllProjects() throws SQLException {
        ProjectDao projectDao = new ProjectDao();
        return projectDao.getAllProjects(dbConnection.getConnection());
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

    public void addEmployeeToProject(int projectId, int employeeId)throws SQLException{
        ProjectDao projectDao = new ProjectDao();
        projectDao.addEmployeeToProject(projectId, employeeId, dbConnection.getConnection());
    }

    public int noOfEmployeesByProjectID(int projectID) throws SQLException {
        ProjectDao dao = new ProjectDao();
        return dao.noOfEmployeesByProjectID(projectID, dbConnection.getConnection());
    }

    public List<Employee> employeesNoProject() throws SQLException {
        ProjectDao dao = new ProjectDao();
        return dao.employeesNoProject(dbConnection.getConnection());
    }

    public List<Project> projectNoEmployees() throws SQLException {
        ProjectDao dao = new ProjectDao();
        return dao.projectsNoEmployees(dbConnection.getConnection());
    }
}

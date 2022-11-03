package com.kainos.ea.controller;

import com.kainos.ea.model.DeliveryEmployee;
import com.kainos.ea.model.Employee;
import com.kainos.ea.model.Project;
import com.kainos.ea.service.ProjectService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Talent {
    public Boolean insertProject(Project project){
        try{
            ProjectService projectService = new ProjectService();
            projectService.insertProject(project);
        }
        catch(SQLException ex){
            return false;
        }
        return true;
    }
    public Boolean addEmployeeToProject(int projectID, int empID){
        try{
            ProjectService projectService = new ProjectService();
            projectService.addEmployeeToProject(projectID, empID);
        }catch(SQLException ex){
            return false;
        }
        return true;
    }

    public List<Project> getAllProjects(){
        List<Project> projects = new ArrayList<>();
        try{
            ProjectService projectService = new ProjectService();
            projects = projectService.getAllProjects();
        }
        catch(SQLException ex){
            System.out.println("Couldn't retrieve Projects!");
        }
        return projects;
    }

    public int getNoOfEmployeesByProject(int projectID){
        int noOfEmployees = 0;
        try{
            ProjectService projectService = new ProjectService();
            noOfEmployees = projectService.noOfEmployeesByProjectID(projectID);
        }
        catch(SQLException ex){
            System.out.println("Couldn't retrieve Number of Employees in a given Project!");
        }
        return noOfEmployees;
    }

    public List<Employee> getEmployeesNoProjects(){
        List<Employee> deliveryEmployees = new ArrayList<>();
        try{
            ProjectService projectService = new ProjectService();
            deliveryEmployees = projectService.employeesNoProject();
        }
        catch(SQLException ex){
            System.out.println("Couldn't retrieve Employees with no Projects!");
        }
        return deliveryEmployees;
    }

    public List<Project> getProjectsNoEmployees(){
        List<Project> projects = new ArrayList<>();
        try{
            ProjectService projectService = new ProjectService();
            projects = projectService.projectNoEmployees();
        }
        catch(SQLException ex){
            System.out.println("Couldn't retrieve Projects with no Employees!");
        }
        return projects;
    }
}

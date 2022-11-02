package com.kainos.ea.controller;

import com.kainos.ea.model.Project;
import com.kainos.ea.service.ProjectService;
import java.sql.SQLException;

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
}

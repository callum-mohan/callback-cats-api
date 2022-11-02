package com.kainos.ea.model;

public class Project {
    private int projectId;
    private String projectName;
    private String projectDescription;

    public Project(){

    }

    public Project(int projectId, String projectName, String projectDescription) {
      setProjectId(projectId);
      setProjectName(projectName);
      setProjectDescription(projectDescription);
    }

    public int getProjectId() {
        return projectId;
    }
    
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
}

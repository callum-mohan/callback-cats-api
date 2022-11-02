package com.kainos.ea.model;

public class Department {
    private int departmentId;
    private String departmentName;
    private String departmentDescription;

    public Department(){

    }

    public Department(int departmentId, String departmentName,String departmentDescription) {
        setDepartmentId(departmentId);
        setDepartmentName(departmentName);
        setDepartmentDescription(departmentDescription);
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }
}

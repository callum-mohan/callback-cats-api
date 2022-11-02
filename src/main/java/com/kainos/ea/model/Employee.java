package com.kainos.ea.model;

public class Employee {
    private int employeeId;
    private String first_name;
    private String last_name;
    private String address;
    private String postcode;
    private String nin;
    private String bankNo;
    private float startSalary;
    private int departmentId;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public float getStartSalary() {
        return startSalary;
    }

    public void setStartSalary(float startSalary) {
        this.startSalary = startSalary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Employee(int employeeId, String first_name,String last_name, String address, String postcode,String nin, String bankNo, float startSalary,  int departmentId) {
        setEmployeeId(employeeId);
        setFirst_name(first_name);
        setLast_name(last_name);
        setAddress(address);
        setPostcode(postcode);
        setNin(nin);
        setStartSalary(startSalary);
        setBankNo(bankNo);
        setDepartmentId(departmentId);
    }

}

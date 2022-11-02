package com.kainos.ea.model;

public class SalesEmployee extends Employee{

    private int salesId;
    private float commissionRate;
    private float totalSales;


    public SalesEmployee(int employeeId, String first_name, String last_name, float totalSales) {
        super(employeeId, first_name, last_name);
        setTotalSales(totalSales);
    }

    public SalesEmployee(int employeeId, String first_name, String last_name, String address, String postcode, String nin, String bankNo, float startSalary, int departmentId, float commissionRate, float totalSales, int salesId) {
        super(employeeId, first_name, last_name, address, postcode, nin, bankNo, startSalary, departmentId);
        setCommissionRate(commissionRate);
        setTotalSales(totalSales);
        setSalesId(salesId);
    }

    public float getCommissionRate() {
        return commissionRate;
    }
    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }
    public float getTotalSales() {
        return totalSales;
    }
    public void setTotalSales(float totalSales) {
        this.totalSales = totalSales;
    }

    public int getSalesId() {
        return salesId;
    }
    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }
}

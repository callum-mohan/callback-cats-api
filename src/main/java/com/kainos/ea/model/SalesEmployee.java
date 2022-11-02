package com.kainos.ea.model;

public class SalesEmployee extends Employee{

    private float commissionRate;
    private float totalSales;

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

    public SalesEmployee(int employeeId, String first_name, String last_name, String address, String postcode, String nin, String bankNo, float startSalary, int departmentId, float commissionRate, float totalSales) {
        super(employeeId, first_name, last_name, address, postcode, nin, bankNo, startSalary, departmentId);
        setCommissionRate(commissionRate);
        setTotalSales(totalSales);
    }
}

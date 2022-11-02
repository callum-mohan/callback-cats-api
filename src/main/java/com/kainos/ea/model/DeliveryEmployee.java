package com.kainos.ea.model;

public class DeliveryEmployee extends Employee{
    private int deliveryId;

    public DeliveryEmployee(){

    }

    public DeliveryEmployee(int employeeId, String first_name, String last_name, String address, String postcode, String nin, String bankNo, float startSalary, int departmentId, int deliveryId) {
        super(employeeId, first_name, last_name, address, postcode, nin, bankNo, startSalary, departmentId);
        setDeliveryId(deliveryId);
    }

    public int getDeliveryId() {
        return deliveryId;
    }
    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

}

package com.kainos.ea.controller;

import com.kainos.ea.model.Employee;

public class Payroll {
    private final float taxRate = 0.25f;

    public float netPay(Employee payee){
        float grossPay = payee.getStartSalary();
        float taxToPay = grossPay * taxRate;
        return Math.round((grossPay - taxToPay)*100)/100;
    }
}

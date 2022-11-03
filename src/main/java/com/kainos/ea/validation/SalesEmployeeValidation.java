package com.kainos.ea.validation;

public class SalesEmployeeValidation extends EmployeeValidation{
    public static boolean validCommissionRate(float commissionRate){
        if(commissionRate > 100.00){
            return false;
        }
        return true;
    }

    public static boolean validTotalSales(float totalSales){
        if(totalSales > 9999999.99){
            return false;
        }
        return true;
    }
}

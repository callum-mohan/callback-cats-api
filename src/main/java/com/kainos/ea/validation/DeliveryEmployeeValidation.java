package com.kainos.ea.validation;

public class DeliveryEmployeeValidation extends EmployeeValidation{
    public static boolean validCodingLang(String codingLang){
        if(codingLang.length() > 30){
            return false;
        }
        else if(!codingLang.matches("^[A-Za-z1-9]+$")){
            return false;
        }
        return true;
    }
}

package com.kainos.ea.validation;

public class DepartmentValidation {
    public static boolean validDepartmentName(String name){
        if (name.length() > 50){
            return false;
        }
        else if(name.matches("^[A-Za-z1-9]+$")){
            return false;
        }
        return true;
    }
}

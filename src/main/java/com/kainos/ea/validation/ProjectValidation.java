package com.kainos.ea.validation;

public class ProjectValidation {
    public static boolean validProjectName(String name){
        if (name.length() > 50){
            return false;
        }
        else if(name.matches("^[A-Za-z1-9]+$")){
            return false;
        }
        return true;
    }
}

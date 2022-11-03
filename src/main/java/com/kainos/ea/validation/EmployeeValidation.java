package com.kainos.ea.validation;

public class EmployeeValidation {

    public static boolean validForename(String forename){
        if (forename.length() > 50){
            System.out.println("Invalid forename");
            return false;
        }
        else if(!forename.matches("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)")){
            System.out.println("Invalid forename");
            return false;
        }
        System.out.println("Valid forename");
        return true;
    }
    public static boolean validSurname(String surname){
        if (surname.length() > 50){
            System.out.println("Invalid surname");
            return false;
        }
        else if(!surname.matches("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)")){
            System.out.println("Invalid surname");
            return false;
        }
        System.out.println("valid surname");
        return true;
    }
    public static boolean validAddressLine(String addressLine){
        if (addressLine.length() > 50){
            System.out.println("Invalid address");
            return false;
        }
        else if(!addressLine.matches("^[A-Za-z1-9]+$")){
            System.out.println("Invalid address");
            return false;
        }
        System.out.println("valid address");
        return true;
    }
    public static boolean validPostcode(String postCode){
        if (postCode.length() > 7){
            System.out.println("Invalid postcode");
            return false;
        }
        else if(!postCode.matches("([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})\n")){
            System.out.println("Invalid postcode");
            return false;
        }
        System.out.println("valid postcode");
        return true;
    }
    public static boolean validNIN(String NIN){
        if (NIN.length() > 9){
            System.out.println("Invalid nin");
            return false;
        }
        else if(!NIN.matches("^(?!BG)(?!GB)(?!NK)(?!KN)(?!TN)(?!NT)(?!ZZ)(?:[A-CEGHJ-PR-TW-Z][A-CEGHJ-NPR-TW-Z])(?:\\s*\\d\\s*){6}([A-D]|\\s)$\n")){
            System.out.println("Invalid nin");
            return false;
        }
        System.out.println("valid nin");
        return true;
    }
    public static boolean validBankNo(String bankNo){
        if (bankNo.length() > 22){
            System.out.println("Invalid bankNo");
            return false;
        }
        else if(!bankNo.matches("^[1-9]+$")){
            System.out.println("Invalid bankNo");
            return false;
        }
        System.out.println("Valid bankNo");
        return true;
    }
    public static boolean validStartingSalary(float startingSalary){
        if (startingSalary > 9999999.99){
            System.out.println("Invalid salary");
            return false;
        }
        System.out.println("Valid salary");
        return true;
    }
}

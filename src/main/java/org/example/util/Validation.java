package org.example.util;

public class Validation {
    public static boolean validatePassword(String password) {
        return password.matches("[A-Z][a-zA-z]{6,}[0-9/@ _-|?}{#$^><:()+*&%]+");
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.startsWith("+"))return phoneNumber.matches("[+1-9][0-9]{6,13}");
        else return phoneNumber.matches("0[7-9][0-1][0-9]{8}");
    }

    public static boolean validateDomain(String domainName) {
        return domainName.matches("[A-Za-z0-9+-._]+[0-9+-._]+");
    }

}

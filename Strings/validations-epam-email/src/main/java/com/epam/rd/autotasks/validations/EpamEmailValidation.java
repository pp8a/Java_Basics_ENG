package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
    	if(email == null) return false;
    	String reg = "[\\w]+[_]{1}[\\w]+@epam.com";
		return Pattern.matches(reg, email);
        }
}






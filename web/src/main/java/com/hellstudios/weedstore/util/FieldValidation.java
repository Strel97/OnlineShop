package com.hellstudios.weedstore.util;

import com.hellstudios.weedstore.core.util.StringUtils;
import com.hellstudios.weedstore.rest.JSONResponse;

import java.util.regex.Pattern;

/**
 * @author strel
 */
public class FieldValidation {

    private static final Pattern emailPattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:" +
            "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@" +
            "(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]" +
            "?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-" +
            "\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

    private static final Pattern countryCodePattern = Pattern.compile("[A-Z]{2}");

    private static final int PASSWORD_LENGTH = 6;


    public static boolean validateEmail(String email) {
        return !StringUtils.isEmpty(email) && emailPattern.matcher(email).matches();
    }

    public static boolean validateEmail(String email, JSONResponse res) {
        if (StringUtils.isEmpty(email)) {
            res.addError(FieldParams.EMAIL.getName(), "Email is empty, please check");
            return false;
        }

        if (!emailPattern.matcher(email).matches()) {
            res.addError(FieldParams.EMAIL.getName(), "Email is in wrong format, please check");
            return false;
        }

        return true;
    }

    public static boolean validatePassword(String password) {
        return !StringUtils.isEmpty(password) && password.length() > PASSWORD_LENGTH;
    }

    public static boolean validatePassword(String password, JSONResponse res) {
        if (StringUtils.isEmpty(password)) {
            res.addError(FieldParams.PASSWORD.getName(), "Password is empty, please check");
            return false;
        }

        if (password.length() < PASSWORD_LENGTH) {
            res.addError(FieldParams.PASSWORD.getName(), String.format("Password should have at least %d symbols", PASSWORD_LENGTH));
            return false;
        }

        return true;
    }

    public static boolean validateName(String name, JSONResponse res) {
        if (StringUtils.isEmpty(name)) {
            res.addError(FieldParams.NAME.getName(), "Name is empty, please check");
            return false;
        }

        return true;
    }

    public static boolean validateOriginCountry(String country, JSONResponse res) {
        if (StringUtils.isEmpty(country)) {
            res.addError(FieldParams.COUNTRY_CODE.getName(), "Country code is empty, please check");
            return false;
        }

        if (!countryCodePattern.matcher(country).matches()) {
            res.addError(FieldParams.COUNTRY_CODE.getName(), "Country code is in wrong format, please check");
            return false;
        }

        return true;
    }
}

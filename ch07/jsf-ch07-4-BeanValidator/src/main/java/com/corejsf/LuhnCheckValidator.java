/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author PC
 */
public class LuhnCheckValidator implements ConstraintValidator<LuhnCheck, String> {

    private static boolean luhnCheck(String cardNumber) {
        int sum = 0;
        for (int i = cardNumber.length() - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(cardNumber.substring(i, i + 1));
            if (i > 0) {
                int d = 2 * Integer.parseInt(cardNumber.substring(i - 1, i));
                if (d > 9) {
                    d -= 9;
                }
                sum += d;
            }
        }
        return sum % 10 == 0;
    }

    @Override
    public void initialize(LuhnCheck constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return luhnCheck(value.replace("\\D", "")); //remueve non-digits
    }
}

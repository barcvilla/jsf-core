/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
import java.lang.annotation.Retention;
import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * Custom validator escrito para demostrar la extensibilidad de framework de validacion
 * @author PC
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = LuhnCheckValidator.class)
public @interface LuhnCheck {
    String message() default "{com.corejsf.LuhnCheck.message}";
    Class[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

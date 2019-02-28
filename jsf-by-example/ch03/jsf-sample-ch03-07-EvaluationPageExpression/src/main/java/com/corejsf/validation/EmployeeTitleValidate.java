/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * JSF Validator se emplean para registrar un validador en cualquier componente text field o componente input que 
 * necesitan ser validados. En el ejemplo utilizamos validadores predefinidos para dos componenten h:inputText a fin
 * de asegurarnos que los valores ingresados tengan una longitud apropiada. 
 * Un validador personalizado se ha adicionado al tercer componente y es el responsable de asegurarse que el texto
 * contenga un especifico String. Los tres campos maquillan el formulario de ingreso de empleado y cuando el empleado
 * es ingresado y se validan los datos satisfactoriamente. Un nuevo empleado es creado y adicionado a la lista de 
 * empleados. 
 * @author PC
 */
@FacesValidator("employeeTitleValidate")
public class EmployeeTitleValidate implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        checkTitle(value);
    }
    
    private void checkTitle(Object value)
    {
        String title = value.toString();
        if(!title.contains("Java"))
        {
            //este mensaje aparecera junto al componente en la pagina web
            String messageText = "Title does not include the word Java";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, messageText, messageText));
        }
    }
}

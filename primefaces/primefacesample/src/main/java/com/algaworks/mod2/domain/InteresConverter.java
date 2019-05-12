/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.mod2.domain;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author PC
 */
@FacesConverter("interes")
public class InteresConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null)
        {
            for(Interes interes : PerfilUsuarioBean.INTERESES)
            {
                if(value.equals(interes.getNombreIcono()))
                {
                    return interes;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null)
        {
            Interes interes = (Interes) value;
            return interes.getNombreIcono(); //si tuviera un id se pasaria el id de la clase
        }
        return null;
    }
    
}

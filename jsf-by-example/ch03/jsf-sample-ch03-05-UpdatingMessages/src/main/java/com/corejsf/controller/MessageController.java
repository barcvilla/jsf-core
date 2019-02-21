/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf.controller;

import javax.inject.Named;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Managed bean class responsable de crear el mensaje y enviarlo al componente h:messages via FacesContext.
 * En el ejemplo, el bundle contiene el nombre de propiedad ExampleMessage, con un valor correspondiente. Cuando la
 * vista en JSF es cargada en el browser, el managed bean MessageController es instanciado, causando que su constructor
 * sea ejecutado. Una instancia de FacesMessage es creada, generando un mensaje de tipo FacesMessage.SEVERITY_INFO
 * y este lee el resource bundle y obtiene el valor de la propiedad ExampleMessage.
 * Luego que el mensaje es creado, el mensaje se adiciona a la actual instancia del FacesContext y se muestra en la
 * pagina cuando es renderizada. Usando resource bundle para especificar mensajes puede hacer la vida mas facil ya que
 * no requiere que el codigo sea recompilado para ver los efectos.
 * @author PC
 */
@Named(value = "messageController")
@RequestScoped
public class MessageController implements Serializable {
    
    private String messageProperty;
    /**
     * Creates a new instance of MessageController
     */
    public MessageController() 
    {
        messageProperty = "Used to instantiate the bean";
        // obtenemos el valor de la propedad ExampleMessage del message bundle: bundle.propiedades
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, ResourceBundle.getBundle("/com/corejsf/message/Bundle").getString("ExampleMessage"), null);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public String getMessageProperty() {
        return messageProperty;
    }

    public void setMessageProperty(String messageProperty) {
        this.messageProperty = messageProperty;
    }
    
    
    
}

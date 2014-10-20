/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.regex.*;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;

/**
 *
 * @author Douglas
 */
public class ValidatorEmail implements Validator{
 
    private static final String EMAIL_REGEXP =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
    @Override
    public void validate(FacesContext context, UIComponent c, Object val) throws ValidatorException
    {
        String email = (String) val;
        Pattern mask = null;
        mask = Pattern.compile(EMAIL_REGEXP);
        Matcher matcher = mask.matcher(email);
 
        if (!matcher.matches()) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Favor inserir um e-mail válido");
            message.setSummary("E-mail inválido");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
 
 
    }
 
}


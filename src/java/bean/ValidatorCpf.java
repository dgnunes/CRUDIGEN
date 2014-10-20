/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.InputMismatchException;
import java.util.regex.*;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;

/**
 *
 * @author Douglas
 */
public class ValidatorCpf implements Validator{
 
    @Override
    public void validate(FacesContext context, UIComponent c, Object val) throws ValidatorException
    {
        String cpf = (String) val;
 
        if (!isCpfValid(cpf)) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Favor entrar um CPF válido (apenas números)");
            message.setSummary("CPF Inválido");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
 
 
    }
    
    public boolean isCpfValid(String cpf){
	if ((cpf.length() != 11 || 
		cpf.equals("00000000000") || cpf.equals("11111111111") ||
		cpf.equals("22222222222") || cpf.equals("33333333333") ||
		cpf.equals("44444444444") || cpf.equals("55555555555") ||
		cpf.equals("66666666666") || cpf.equals("77777777777") ||
		cpf.equals("88888888888") || cpf.equals("99999999999"))
		) return(false);
        char d10, d11;
        int sm, i, r, num, peso;

        try {
            sm   = 0;
            peso = 10;

            for (i=0; i<9; i++) {              
              num = (cpf.charAt(i) - 48); 
              sm  = (sm + (num * peso));
              peso = (peso - 1);
            }

            r = (11 - (sm % 11));

            if ((r == 10) || (r == 11)){  
               d10 = '0';
            } 
            else {
                d10 = (char)(r + 48);
            }

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
              num =(cpf.charAt(i) - 48);
              sm = (sm + (num * peso));
              peso = (peso - 1);
            }

            r = (11 - (sm % 11));

            if ((r == 10) || (r == 11)){
                d11 = '0';		      
            }
            else {
                d11 = (char)(r + 48);
            }

            if ((d10 == cpf.charAt(9)) && (d11 == cpf.charAt(10))){
               return(true);
            }
            else {
                return(false);
            }
          } 
        catch (InputMismatchException erro) {
              return(false);
          }
    }

 
}
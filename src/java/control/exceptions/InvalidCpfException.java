/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.exceptions;

/**
 *
 * @author Douglas
 */
public class InvalidCpfException extends Exception {
    public InvalidCpfException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidCpfException(String message) {
        super(message);
    }
}

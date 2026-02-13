/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.pedro.OSApiAplication.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import br.dev.pedro.OSApiAplication.api.exceptionhandler.ProblemaException;
import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class DomainException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public DomainException(String message) {
        super (message);
    }
    


}

package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AutomovelExisteException extends RuntimeException {
    private String mensagem;

    public AutomovelExisteException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }

    public AutomovelExisteException(){
    }

}

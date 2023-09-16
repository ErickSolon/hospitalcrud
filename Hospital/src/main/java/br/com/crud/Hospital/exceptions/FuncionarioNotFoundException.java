package br.com.crud.Hospital.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FuncionarioNotFoundException extends Exception {
    public FuncionarioNotFoundException() {
        super("Funcionário não encontrado!");
    }
}

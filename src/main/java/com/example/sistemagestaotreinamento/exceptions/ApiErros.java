package com.example.sistemagestaotreinamento.exceptions;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErros {
    
    @Getter
    private List<String> erros;

    public ApiErros(String msgErro){
        erros = Arrays.asList(msgErro);
    }
}

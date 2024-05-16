package com.example.sistemagestaotreinamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.sistemagestaotreinamento.exceptions.ApiErros;
import com.example.sistemagestaotreinamento.exceptions.RegraNegocioException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {

  @ExceptionHandler(RegraNegocioException.class)
  public ApiErros handleRegraNegocioException(RegraNegocioException e) {
    return new ApiErros(e.getMessage());
  }
}

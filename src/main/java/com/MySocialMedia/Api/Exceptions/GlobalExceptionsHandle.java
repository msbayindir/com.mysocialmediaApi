package com.MySocialMedia.Api.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionsHandle extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errorList = new ArrayList<>();

        ex.getAllErrors().forEach(m->errorList.add(m.getDefaultMessage()));



        ex.getAllErrors();

        return new ResponseEntity(Exception.builder()
                .httpStatusCode(status.value())
                .exceptionDetails(MessageException
                        .builder()
                        .messageDetail(ex.getBody().getDetail())
                        .message(ex.getDetailMessageCode())
                        .errorList(errorList)
                        .build()).
                build(),status);
    }


}

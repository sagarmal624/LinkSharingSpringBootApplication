package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.exception.RecordNotFoundException;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseDTO handleAllExceptions(Exception ex, WebRequest request) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(false);
        responseDTO.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseDTO.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() + "  With " + request.getDescription(false));
        return responseDTO;
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseDTO handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(false);
        responseDTO.setErrorCode(HttpStatus.NOT_FOUND.value());
        responseDTO.setMessage(ex.getMessage() + " " + HttpStatus.NOT_FOUND.getReasonPhrase() + "  With " + request.getDescription(false));
        return responseDTO;
    }

}

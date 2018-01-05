package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.exception.RecordNotFoundException;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.jws.WebParam;
import javax.xml.bind.DataBindingException;

@ControllerAdvice
@RestController
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
   // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseDTO handleAllExceptions(Exception ex, WebRequest request) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(false);
        responseDTO.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseDTO.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() + "  With " + request.getDescription(false));
        return responseDTO;
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseDTO handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(false);
       // responseDTO.setErrorCode(HttpStatus.NOT_FOUND.value());
        responseDTO.setMessage(ex.getMessage() + " " + HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() + "  With " + request.getDescription(false));
        return responseDTO;
    }
    /*@ExceptionHandler(DataBindingException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public final ResponseDTO handleDataNotFound(Exception ex,WebRequest request)
    {
        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.setMessage("DataNotFound" +"" + HttpStatus.NO_CONTENT.getReasonPhrase());
        return responseDTO;
    }
*/


}

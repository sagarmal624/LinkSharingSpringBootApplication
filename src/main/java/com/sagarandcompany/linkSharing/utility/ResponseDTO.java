package com.sagarandcompany.linkSharing.utility;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
    private String message;
    private Boolean status = false;
    private Object data;
    private Integer errorCode;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ResponseDTO() {
    }

    public ResponseDTO(Boolean status) {
        this.status = status;
    }

    public ResponseDTO(String message) {
        this.message = message;
    }

    public ResponseDTO(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public ResponseDTO(String message, Boolean status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessageAndStatus(String message, Boolean status) {
        this.status = status;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getData() {

        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

package com.example.ratemanagment.exception;

import com.example.ratemanagment.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ServiceConfigurationError;

@ControllerAdvice
public class RateExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<ErrorResponse> handleInternalServerError(ServiceException serverException) {
        return generateErrorResponse(serverException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidRateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ResponseEntity<ErrorResponse> handleInternalServerError(InvalidRateException invalidRateException) {
        return generateErrorResponse(invalidRateException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> generateErrorResponse(Exception ex, HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErroCode(String.valueOf(httpStatus.value()));
        errorResponse.setErrorMessage(ex.getLocalizedMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, httpStatus);
    }
}

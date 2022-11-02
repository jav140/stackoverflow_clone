package com.example.stackoverflow_mono.handler;

import com.example.stackoverflow_mono.exception.GenericNotFoundException;
import com.example.stackoverflow_mono.exception.TokenRefreshException;
import com.example.stackoverflow_mono.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handle404(GenericNotFoundException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .friendlyMessage(e.getMessage())
                .requestPath(request.getRequestURL().toString())
                .timestamp(Timestamp.valueOf(LocalDateTime.now()))
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TokenRefreshException.class)
    public ResponseEntity<ApiErrorResponse> handleTokenRefreshException(TokenRefreshException ex, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .developerMessage(Arrays.toString(ex.getStackTrace()))
                .friendlyMessage(ex.getMessage())
                .requestPath(request.getRequestURL().toString())
                .timestamp(Timestamp.valueOf(LocalDateTime.now()))
                .build(), HttpStatus.FORBIDDEN);
    }
}

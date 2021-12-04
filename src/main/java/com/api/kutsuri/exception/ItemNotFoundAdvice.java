package com.api.kutsuri.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ItemNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Map<String, Object>> itemNotFoundHandler(ItemNotFoundException ex) {
        final Map<String, Object> errorInfo = new LinkedHashMap<>();
        errorInfo.put("errorMessage", ex.getMessage());
        return new ResponseEntity<Map<String, Object>>(errorInfo, HttpStatus.NOT_FOUND);
    }
}

package com.api.kutsuri.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Integer id, String item) {
        super("Could not find " + item + " with id " + id);
    }    
}

package com.haydikodlayalim.exceptionhandling.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String param) {
        super(param);
    }
}

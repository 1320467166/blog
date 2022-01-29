package com.example.blog.exceptions;

public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private int code;

    private Object errData;

    public BusinessException(String message) {
        super(message);
    }

}

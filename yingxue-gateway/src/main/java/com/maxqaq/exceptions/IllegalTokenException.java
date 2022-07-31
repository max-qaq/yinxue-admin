package com.maxqaq.exceptions;

//自定义异常
public class IllegalTokenException extends RuntimeException {

    public IllegalTokenException(String message) {
        super(message);
    }
}

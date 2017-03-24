package com.hellstudios.dev.core.api;

/**
 * @author strel
 */
public class APIException extends Exception {

    public APIException() { super(); }
    public APIException(String message) { super(message); }
    public APIException(String message, Throwable cause) { super(message, cause); }
    public APIException(Throwable cause) { super(cause); }
}

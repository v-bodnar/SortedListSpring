package com.springapp.dao;

/**
 * Created by Volodymyr Bodnar on 04.02.2015.
 * Exception class to use instead of any exceptions from persistent storage
 */
public class PersistException extends Exception {
    public PersistException() {
    }

    public PersistException(String message) {
        super(message);
    }
    public PersistException(String message, Throwable cause) {
        super(message, cause);
    }
    public PersistException(Throwable cause) {
        super(cause);
    }
    public PersistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
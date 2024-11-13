package org.mapper.exception;

public class ObjectMapperException extends RuntimeException {

    public ObjectMapperException(String message) {
        super(message);
    }

    public ObjectMapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectMapperException(Throwable cause) {
        super(cause);
    }

    public ObjectMapperException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

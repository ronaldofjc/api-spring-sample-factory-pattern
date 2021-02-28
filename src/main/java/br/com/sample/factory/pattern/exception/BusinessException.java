package br.com.sample.factory.pattern.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(final String message) {
        super(message);
    }
}

package com.rowatk.invoicer.exception;

public class InvoicerException extends RuntimeException {

    public InvoicerException() {
    }

    public InvoicerException(String message) {
        super(message);
    }

    public InvoicerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvoicerException(Throwable cause) {
        super(cause);
    }

    public InvoicerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

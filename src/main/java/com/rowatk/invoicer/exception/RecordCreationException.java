package com.rowatk.invoicer.exception;

public class RecordCreationException extends InvoicerException {

    public RecordCreationException() {
    }

    public RecordCreationException(String message) {
        super(message);
    }

    public RecordCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordCreationException(Throwable cause) {
        super(cause);
    }

    public RecordCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

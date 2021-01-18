package com.rowatk.invoicer.exception;

public class NoRecordException extends RuntimeException {

    private String type;
    private Long id;

    public NoRecordException(String type, Long id) {
        this.type = type;
        this.id = id;
    }

    public NoRecordException(String message, String type, Long id) {
        super(message);
        this.type = type;
        this.id = id;
    }

    public NoRecordException(String message, Throwable cause, String type, Long id) {
        super(message, cause);
        this.type = type;
        this.id = id;
    }

    public NoRecordException(Throwable cause, String type, Long id) {
        super(cause);
        this.type = type;
        this.id = id;
    }

    public NoRecordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String type, Long id) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

// No record with ID
// No records in DB
// IllegalID
//

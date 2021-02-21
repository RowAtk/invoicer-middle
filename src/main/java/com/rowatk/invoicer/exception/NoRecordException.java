package com.rowatk.invoicer.exception;

public class NoRecordException extends RuntimeException {

    private String type;
    private String idType;
    private String idValue;

    public NoRecordException(String type, String idType, String idValue) {
        this.type = type;
        this.idType = idType;
        this.idValue = idValue;
    }

    public NoRecordException(String message, String type, String idType, String idValue) {
        super(message);
        this.type = type;
        this.idType = idType;
        this.idValue = idValue;
    }

    public NoRecordException(String message, Throwable cause, String type, String idType, String idValue) {
        super(message, cause);
        this.type = type;
        this.idType = idType;
        this.idValue = idValue;
    }

    public NoRecordException(Throwable cause, String type, String idType, String idValue) {
        super(cause);
        this.type = type;
        this.idType = idType;
        this.idValue = idValue;
    }

    public NoRecordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String type, String idType, String idValue) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.type = type;
        this.idType = idType;
        this.idValue = idValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }

    //    public NoRecordException(String type, Long id) {
//        this.type = type;
//        this.id = id;
//    }

//    public NoRecordException(String message, String type, Long id) {
//        super(message);
//        this.type = type;
//        this.id = id;
//    }
//
//    public NoRecordException(String message, Throwable cause, String type, Long id) {
//        super(message, cause);
//        this.type = type;
//        this.id = id;
//    }
//
//    public NoRecordException(Throwable cause, String type, Long id) {
//        super(cause);
//        this.type = type;
//        this.id = id;
//    }
//
//    public NoRecordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String type, Long id) {
//        super(message, cause, enableSuppression, writableStackTrace);
//        this.type = type;
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}

// No record with ID
// No records in DB
// IllegalID
//

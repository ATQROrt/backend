package com.ort.atqr.Model;

public class Response {
    private Object object;
    private String message;
    private Integer statusCode;

    public Response(Object object, String message, Integer status) {
        this.object = object;
        this.message = message;
        this.statusCode = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}

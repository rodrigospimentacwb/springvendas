package com.pepper.edu.springvendas.handlers;

import java.io.Serializable;

public class FieldMessage  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fieldMassage;
    private String message;

    public FieldMessage() {
    }

    public FieldMessage(String fieldMassage, String message) {
        super();
        this.fieldMassage = fieldMassage;
        this.message = message;
    }

    public String getFieldMassage() {
        return fieldMassage;
    }

    public void setFieldMassage(String fieldMassage) {
        this.fieldMassage = fieldMassage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.javarush.quest.cooper.entity;

import java.io.Serializable;

public class Result implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                '}';
    }
}

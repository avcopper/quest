package com.javarush.quest.cooper.entity;

import java.util.List;
import java.io.Serializable;

public class QuestItem implements Serializable {
    private String message;
    private List<QuestOption> options;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<QuestOption> getOptions() {
        return options;
    }

    public void setOptions(List<QuestOption> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "QuestItem{" +
                "message='" + message + '\'' +
                ", options=" + options +
                '}';
    }
}

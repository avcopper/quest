package com.javarush.quest.cooper.entity;

import java.io.Serializable;

public class QuestOption implements Serializable {
    private String answer;
    private boolean isWin;
    private boolean isLose;
    private Result result;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public boolean isLose() {
        return isLose;
    }

    public void setLose(boolean lose) {
        isLose = lose;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "QuestOption{" +
                "answer='" + answer + '\'' +
                ", isWin=" + isWin +
                ", isLose=" + isLose +
                ", result=" + result +
                '}';
    }
}

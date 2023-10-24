package com.javarush.quest.cooper.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestOptionTest {
    @Test
    void getAnswer() {
        QuestOption questOption = new QuestOption();
        questOption.setAnswer("Test message...");
        assertEquals("Test message...", questOption.getAnswer());
    }

    @Test
    void getTrueWin() {
        QuestOption questOption = new QuestOption();
        questOption.setWin(true);
        assertTrue(questOption.isWin());
    }

    @Test
    void getFalseWin() {
        QuestOption questOption = new QuestOption();
        questOption.setWin(false);
        assertFalse(questOption.isWin());
    }

    @Test
    void getTrueLose() {
        QuestOption questOption = new QuestOption();
        questOption.setLose(true);
        assertTrue(questOption.isLose());
    }

    @Test
    void getFalseLose() {
        QuestOption questOption = new QuestOption();
        questOption.setLose(false);
        assertFalse(questOption.isLose());
    }

    @Test
    void getResultMessage() {
        QuestOption questOption = new QuestOption();
        questOption.setResult(new Result());
        questOption.getResult().setMessage("Test result");
        assertEquals("Test result", questOption.getResult().getMessage());
    }
}

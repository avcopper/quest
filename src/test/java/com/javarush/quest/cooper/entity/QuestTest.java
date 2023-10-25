package com.javarush.quest.cooper.entity;

import java.io.IOException;

import com.javarush.quest.cooper.exceptions.AppException;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class QuestTest {
    @Test
    void getName() throws IOException, AppException {
        Quest quest = Quest.getQuestsFromJson();
        quest.setName("Test player");
        assertEquals("Test player", quest.getName());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void getFalseResults(int level) throws IOException, AppException {
        Quest quest = Quest.getQuestsFromJson();

        assertFalse(quest.getQuests().get(level).getOptions().get(1).isWin());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void getTrueResults(int level) throws IOException, AppException {
        Quest quest = Quest.getQuestsFromJson();
        assertTrue(quest.getQuests().get(level).getOptions().get(0).isLose());
    }

    @Test
    void getGameCount() throws IOException, AppException {
        Quest quest = Quest.getQuestsFromJson();
        quest.setLose(true);
        quest.setWin(true);
        quest.setWin(true);
        quest.setLose(true);
        assertEquals(4, quest.getCount());
    }

    @Test
    void getWin() throws IOException, AppException {
        Quest quest = Quest.getQuestsFromJson();
        quest.setWin(true);
        assertTrue(quest.isWin());
    }

    @Test
    void getWins() throws IOException, AppException {
        Quest quest = Quest.getQuestsFromJson();
        quest.setWin(true);
        quest.setWin(true);
        quest.setWin(true);
        quest.setWin(false);
        quest.setWin(true);
        assertEquals(4, quest.getWins());
    }

    @Test
    void getLose() throws IOException, AppException {
        Quest quest = Quest.getQuestsFromJson();
        quest.setLose(true);
        assertTrue(quest.isLose());
    }

    @Test
    void getLoses() throws IOException, AppException {
        Quest quest = Quest.getQuestsFromJson();
        quest.setLose(true);
        quest.setLose(true);
        quest.setLose(false);
        quest.setLose(true);
        assertEquals(3, quest.getLoses());
    }

    @Test
    void getQuest() throws IOException, AppException {
        Quest quest1 = Quest.getQuest(mock(HttpSession.class));
        Quest quest2 = Quest.getQuestsFromJson();
        assertEquals(quest1, quest2);
    }
}

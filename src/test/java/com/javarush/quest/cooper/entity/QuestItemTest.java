package com.javarush.quest.cooper.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestItemTest {
    @Test
    void getMessage() {
        QuestItem questItem = new QuestItem();
        questItem.setMessage("Test message");
        assertEquals("Test message", questItem.getMessage());
    }
}

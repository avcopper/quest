package com.javarush.quest.cooper.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {
    @Test
    void getMessage() {
        Result result = new Result();
        result.setMessage("test message");
        assertEquals("test message", result.getMessage());
    }
}

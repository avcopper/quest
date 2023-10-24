package com.javarush.quest.cooper;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import jakarta.servlet.http.HttpServletRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameServletTest {
    @Test
    void getName() {
        assertEquals("Nameless Clown", new NameServlet().getName(mock(HttpServletRequest.class)));
    }
}

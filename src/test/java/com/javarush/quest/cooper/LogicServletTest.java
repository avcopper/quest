package com.javarush.quest.cooper;

import static org.mockito.Mockito.mock;
import jakarta.servlet.http.HttpServletRequest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import com.javarush.quest.cooper.exceptions.AppException;

public class LogicServletTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "987"})
    void isTrueNumeric(String param) {
        assertTrue(new LogicServlet().isNumeric(param));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1,888", "test"})
    void isFalseNumeric(String param) {
        assertFalse(new LogicServlet().isNumeric(param));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1w", "1,888", "test"})
    void getParamFromRequest(String param) {
        Exception exception = assertThrows(
                AppException.class,
                () -> new LogicServlet().getParamFromRequest(mock(HttpServletRequest.class), param)
        );
        assertEquals("Unsupported value", exception.getMessage());
    }
}

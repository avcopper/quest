package com.javarush.quest.cooper;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import jakarta.servlet.http.HttpSession;
import com.javarush.quest.cooper.entity.Quest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitServletTest {
    @Test
    void getQuest() throws IOException {
        assertEquals(Quest.getQuest(mock(HttpSession.class)), Quest.getQuestsFromJson());
    }
}

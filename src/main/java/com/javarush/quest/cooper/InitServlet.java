package com.javarush.quest.cooper;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import com.javarush.quest.cooper.entity.Quest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.javarush.quest.cooper.exceptions.AppException;
import com.javarush.quest.cooper.constants.QuestConstants;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);

        try {
            currentSession.setAttribute(QuestConstants.ERROR, null);
            currentSession.setAttribute(QuestConstants.LEVEL, 0);
            currentSession.setAttribute(QuestConstants.QUEST, Quest.getQuest(currentSession));
        } catch (AppException e) {
            currentSession.setAttribute(QuestConstants.ERROR, e.getMessage());
        }

        req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}

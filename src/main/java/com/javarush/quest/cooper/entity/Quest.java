package com.javarush.quest.cooper.entity;

import java.util.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.io.Serializable;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import com.javarush.quest.cooper.exceptions.AppException;
import com.javarush.quest.cooper.constants.QuestConstants;

public class Quest implements Serializable {
    private ArrayList<QuestItem> quests;
    private String name;
    private int count;
    private int wins;
    private int loses;
    private boolean isWin;
    private boolean isLose;

    private Quest() {
    }

    public static Quest getQuest(HttpSession currentSession) throws IOException, AppException {
        Quest quest = null;
        Object questObj = currentSession.getAttribute(QuestConstants.QUEST);

        if (questObj != null) {
            if (Quest.class != questObj.getClass()) {
                currentSession.invalidate();
                throw new AppException(QuestConstants.SESSION_IS_BROKEN);
            }

            quest = (Quest) questObj;
            quest.setLose(false);
            quest.setWin(false);
        }

        return quest != null ? quest : getQuestsFromJson();
    }

    public static Quest getQuestsFromJson() throws IOException, AppException {
        Path questFile = getQuestFile();

        if (questFile != null){
            String json = Files.readString(questFile);
            return new Gson().fromJson(json, Quest.class);
        }
        else throw new AppException(QuestConstants.QUEST_FILE_IS_LOST);
    }

    private static Path getQuestFile() {
        Path questFile = Path.of(QuestConstants.QUEST_FILE);
        if (Files.isRegularFile(questFile)) return questFile;

        String currentDir = Objects.requireNonNull(Quest.class.getResource("/")).getPath().substring(1);
        Path projectDir = Path.of(currentDir).getParent().getParent().getParent().getParent();
        questFile = Path.of(projectDir + "\\quest.json");

        return Files.isRegularFile(questFile) ? questFile : null;
    }

    public ArrayList<QuestItem> getQuests() {
        return quests;
    }

    public void setQuests(ArrayList<QuestItem> quests) {
        this.quests = quests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
        if (win) {
            this.count++;
            this.wins++;
        }
    }

    public boolean isLose() {
        return isLose;
    }

    public void setLose(boolean lose) {
        isLose = lose;
        if (lose) {
            this.count++;
            this.loses++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quest quest = (Quest) o;
        return count == quest.count && wins == quest.wins && loses == quest.loses && isWin == quest.isWin &&
                isLose == quest.isLose && Objects.equals(name, quest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quests, name, count, wins, loses, isWin, isLose);
    }

    @Override
    public String toString() {
        return "QuestNew{" +
                "quests=" + quests +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", wins=" + wins +
                ", loses=" + loses +
                ", isWin=" + isWin +
                ", isLose=" + isLose +
                '}';
    }
}

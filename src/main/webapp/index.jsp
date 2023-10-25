<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>My Quest</title>
    <link href="static/main.css" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <script src="<c:url value="/static/scripts.js"/>"></script>
</head>

<body>
<c:set var="quest" value="${quest}" />
<c:set var="error" value="${error}" />
<div class="quest">
    <c:if test="${error == null}">
        <c:if test="${quest.getName() != null}">
            <div class="results">
                <table>
                    <tr>
                        <td>Игрок</td>
                        <td class="name">${quest.getName()}</td>
                    </tr>
                    <tr>
                        <td>Всего игр</td>
                        <td>${quest.getCount()}</td>
                    </tr>
                    <tr>
                        <td>Выиграно</td>
                        <td>${quest.getWins()}</td>
                    </tr>
                    <tr>
                        <td>Проиграно</td>
                        <td>${quest.getLoses()}</td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <c:if test="${quest.isWin() || quest.isLose()}">
                                <button onclick="restart()">Новый игрок</button>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </div>
        </c:if>

        <h1>My Quest</h1>

        <c:if test="${quest.getName() == null}">
            <div class="prolog">
                <h3>Пролог</h3>
                <p>
                    Ты стоишь в космическом порту и готов подняться на борт своего корабля. Разве ты не об этом мечтал? Стать
                    капитаном галактического судна с экипажем, который будет совершать подвиги под твоим командованием. Так что
                    вперед!
                </p>

                <h3>Знакомство с экипажем</h3>
                <p>
                    Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:<br>
                    - Здравствуйте, командир! Я Зинаида - ваша помощница. Видите? Там в углу пьет кофе на штурман - сержант
                    Перегарный Шлейф, под штурвалом спит наш бортмеханик - Черный Богдан, а фотографирует его Сергей Стальная
                    Пятка - наш навигатор.
                </p>

                <label>
                    Сообщите Ваше имя, капитан:
                    <input type="text" name="name">
                    <button  onclick="setName()">Начать игру</button>
                </label>
            </div>
        </c:if>

        <c:if test="${quest.getName() != null}">
            <div class="main">
                <c:if test="${!quest.isWin() && !quest.isLose()}">
                    <p>${quest.getQuests().get(level).getMessage()}</p>

                    <c:set var="size" value="${quest.getQuests().get(level).getOptions().size() - 1}" />
                    <c:forEach var = "i" begin = "0" end = "${size}">
                        <c:set var="answer" value="${quest.getQuests().get(level).getOptions().get(i).getAnswer()}" />

                        <label onclick="window.location='/logic?answer=${i}'">
                            <input name="level1" type="radio" value="${i}">${answer}
                        </label>
                    </c:forEach>
                </c:if>

                <c:if test="${quest.isWin() || quest.isLose()}">
                    <c:set var="result" value="${quest.getQuests().get(level).getOptions().get(answer).getResult().getMessage()}" />

                    <p>${result}</p>

                    <c:if test="${quest.isWin()}">
                        <p class="win">Победа</p>
                    </c:if>

                    <c:if test="${quest.isLose()}">
                        <p class="lose">Поражение</p>
                    </c:if>

                    <button onclick="reload()">Новая игра</button>
                </c:if>
            </div>
        </c:if>
    </c:if>

    <c:if test="${error != null}">
        <div class="error">
                ${error}
        </div>
    </c:if>
</div>

</body>
</html>

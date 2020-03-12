<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Freeroed
  Date: 25.02.2020
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Личный кабинет</title>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body link="#008080" vlink="#008080" alink="#008080">
<header class="site-header">
    <table border="0" width="100%">
        <tr>
            <td><img src="<c:url value='/img/logo.jpg'/>" alt="логотип" width="60" height="60"></td>
            <td><font size="8" color="#000000" face="garamond">
                SystemName
            </font>
            </td>
            <td><p align="right"><font size="5" color="#66CDAA" face="garamond">
                Контактный телефон
            </font></p>
            </td>
            <td><p align="right"><font size="5" color="#008080" face="garamond">
                <u>Справочная информация</u>
            </font></p>
            </td>
        </tr>
        <tr>
            <td></td><td></td>
            <td><p align="right"><font size="4" color="#66CDAA" face="garamond">
                8 888 888 88 88
            </font></p>
            </td>
            <td><p align="right"><font size="5" color="#008080" face="garamond">
                <u>Личный кабинет </u>
            </font></p>
            </td>
        </tr>
    </table>
    <hr>
</header>

<main>
    <table border="1" align="right">
        <tr>
            <td><font size="4" face="garamond"><b>Личный кабинет</b></font></td>
        </tr>
        <tr>
            <td><a href="account.html">Обо мне</a></td>
        </tr>
        <tr>
            <td> <a href="../index.html">Выход</a></td>
        </tr>
    </table>
    <p><font size="7" color="#008080" face="garamond">Обо мне: </font> </p>
    <p><font size="4" color="#008080" face="garamond"><b>Фамилия: </b>Очень</font></br>
        <font size="4" color="#008080" face="garamond"><b>Имя: </b>Оригинальное</font></br>
        <font size="4" color="#008080" face="garamond"><b>Отчество: </b>Имя</font></br>
        <font size="4" color="#008080" face="garamond"><b>Логин: </b>ochenoriginalnodva</font> </br>
        <font size="4" color="#008080" face="garamond"><b>Телефон: </b>0-000-000-00-00</font></br>
        <font size="4" color="#008080" face="garamond"><b>Место работы: </b>Клиника "8 лапок"</font></p>
    <font size="4" color="#008080" face="garamond"><b>Должность: </b>Ветеринарный врач</font></p>

    <form action="requestDone.html">
        <p><font size="7" color="#008080" face="garamond">Введите номер заявки посетителя: </font> </p>
        <input type="text" name="reqNumber">
        <br/><br/>
        <button type="submit">Проверить</button>
    </form>
</main>
</body>
</html>

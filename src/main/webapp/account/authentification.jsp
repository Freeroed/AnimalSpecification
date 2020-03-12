<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Freeroed
  Date: 24.02.2020
  Time: 15:30
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
    <form action="account">
        <p align="center">
            <font size="7" color="#008080" face="garamond">
                Введите логин и пароль:
            </font>
        </p>
        <p align="center">
            Логин:
            <input type='text'/>
        </p>
        <p align="center">
            Пароль:
            <input type='text'/>
        </p>
        <p align="center">
            <button type="submit">Войти</button>
        </p>
    </form>
    <br/>
    <br/>
    <p align="center">
        <font size="5" color="#008080" face="garamond">
            Регистрация
        </font>
    </p>
</main>
</body>
</html>
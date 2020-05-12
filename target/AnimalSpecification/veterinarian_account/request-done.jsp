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
    <p><font size="7" color="black" face="garamond">Заявка № 56456: </font> </p>

    <table border="3" width="40%">
        <tr>
            <td><font size="4" color="#008080" face="garamond"><b>Тип животного</b></font></td>
            <td width="170"><font size="4" color="#008080" face="garamond">
                <input type="text" name="typeAnimal" value="кот">
            </font></td>
        </tr>
        <tr>
            <td><font size="4" color="#008080" face="garamond"><b>Кличка</b></font></td>
            <td width="170"><font size="4" color="#008080" face="garamond">
                <input type="text" name="animalName" value="Кошак">
            </font></td>
        </tr>
        <tr>
            <td><font size="4" color="#008080" face="garamond"><b>Страна назначения</b></font></td>
            <td width="170"><font size="4" color="#008080" face="garamond">
                <input type="text" name="country" value="Германия">
            </font></td>
        </tr>
        <tr>
            <td><font size="4" color="#008080" face="garamond"><b>Тип транспорта</b></font></td>
            <td width="170"><font size="4" color="#008080" face="garamond">
                <input type="text" name="transport" value="Самолет">
            </font></td>
        </tr>
        <tr>
            <td><font size="4" color="#008080" face="garamond"><b>Дата оформления</b></font></td>
            <td width="170"><font size="4" color="#008080" face="garamond">
                <input type="date" name="dateDoc">
            </font></td>
        </tr>

    </table>

</main>
</body>
</html>

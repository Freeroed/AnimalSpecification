<%--
  Created by IntelliJ IDEA.
  User: Freeroed
  Date: 24.02.2020
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Вакцинация</title>
    <link rel="stylesheet" href="../style.css">
</head>
<body link="#008080" vlink="#008080" alink="#008080">
<header class="site-header">
    <table border="0" width="100%">
        <tr>
            <td><img src="../img/logo.jpg" alt="логотип" width="60" height="60"></td>
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
                <u><a href="account">Личный кабинет</a></u>
            </font></p>
            </td>
        </tr>
    </table>
    <hr>
</header>
<form>
    <main>
        <p align="center"><font size="7" color="#008080" face="garamond">Добавление вакцины: </font> </p>
        <table align="center" border="0">
            <tr>
                <td>
                    Название
                </td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>
                    Дата вакцинации
                </td>
                <td>
                    <input type="date" name="is">
                </td>
            </tr>
            <tr>
                <td>
                    Срок окончания действия
                </td>
                <td>
                    <input type="date" name="as">
                </td>
            </tr>
            <tr>
                <td>
                    Место вакцинации
                </td>
                <td>
                    <input type="text" name="place">
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit" formaction="animal/create">Отмена</button>
                </td>
                <td>
                    <button type="submit" formaction="animal/create">Сохранить</button>
                </td>
            </tr>
        </table>


    </main>
</form>

<%--
  Created by IntelliJ IDEA.
  User: Freeroed
  Date: 24.02.2020
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создание заявки</title>
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
<p align="center"><font size="5" color="black" face="garamond">
    Для поездки Вам необходимо внести дополнительную информацию:
</font></p>
<form action="done">
    <p align="left"><font size="5" color="#008080" face="garamond">
        Способ пересечения границы:
    </font></p>
    <select size="1" name="transport[]">
        <option disabled>Выберите транспорт</option>
        <option value="ES">Автомобиль</option>
        <option value="RF">Самолет</option>
        <option value="other">Водный транспорт</option>
    </select>
    <p align="left"><font size="5" color="#008080" face="garamond">
        Номер автомобился
        (пример: а543лв33, ф322тт152):
    </font></p>
    <input type="text" name="autoNumber"/>
    <p align="left"><font size="5" color="#008080" face="garamond">
        Имя получателя животного:
    </font></p>
    <input type="text" name="nameRecipient"/>
    <p align="left"><font size="5" color="#008080" face="garamond">
        Место происхождения животного:
    </font></p>
    <input type="text" name="placeOfOrigin"/>
    <p align="left"><font size="5" color="#008080" face="garamond">
        Дата отправления:
    </font></p>
    <input type="date" name="departureDate"/>
    <p align="left"><font size="5" color="#008080" face="garamond">
        Пункт пропуска в ЕС:
    </font></p>
    <input type="text" name="checkpoint"/>
    <br/>
    <br/>
    <button type="submit">Создать заявку</button>
</form>
<main>

</main>

</body>
</html>

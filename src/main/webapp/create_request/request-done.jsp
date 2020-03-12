<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Создание заявки</title>
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
                <u><a href="account">Личный кабинет</a></u>
            </font></p>
            </td>
        </tr>
    </table>
    <hr>
</header>
<main>
    <p align="center"><font size="5" color="black" face="garamond">
        Ваша заявка успешно создана!
    </font></p>
    <p align="left"><font size="5" color="#008080" face="garamond">
        Далее Вам необходимо явиться в государственную ветеринарную клинику для получения ветеринарного сертификаты формы 1.
        Внимание! Сертификат формы № 1 действителен на протяжении пяти дней от даты получения.
    </font></p>
    <p align="left"><font size="5" color="#008080" face="garamond">
        Не забудьте сказать врачу-ветеринару номер Вашей заявки!
    </font></p>
    <p align="left"><font size="8" color="#008080" face="garamond">
        Номер Вашей заявки: 45232
    </font></p>
    <p>Вот список ветеринарных клиник, в которых вы можете оформить ветеринарный сертификат формы 1:</p>
    <table border="0" align="left">
        <tr>
            <td rowspan="15">
                <iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d17785.409476362798!2d40.38689782574482!3d56.13676598824228!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1z0LLQtdGC0LXRgNC40L3QsNGA0L3QsNGPINC60LvQuNC90LjQutCw!5e0!3m2!1sru!2sru!4v1581192702204!5m2!1sru!2sru" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""></iframe></iframe>
            </td>
        </tr>
        <tr><td rowspan="1">&#8195;Первая клиника</td></tr>
        <tr><td rowspan="1">&#8195;Вторая клиника</td></tr>
        <tr><td rowspan="1">&#8195;Третья клиника</td></tr>
        <tr><td rowspan="1">&#8195;Четвёртая клиника</td></tr>
        <tr><td rowspan="1">&#8195;Пятая клиника</td></tr>
        <tr><td rowspan="1">&#8195;Шестая клиника</td></tr>
        <tr><td rowspan="1">&#8195;Седьмая клиника</td></tr>
        <tr><td rowspan="1">&#8195;Восьмая клиника</td></tr>
        <tr><td rowspan="1">&#8195;Девятая клиника</td></tr>
        <tr><td rowspan="1">&#8195;Десятая клиника</td></tr>
        <tr><td rowspan="1">&#8195;Одиннадцатая клиника</td></tr>
        <tr><td rowspan="1">&#8195;Двенадцатая клиника</td></tr>

    </table>
</main>

</body>
</html>

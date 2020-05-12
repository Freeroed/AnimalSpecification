<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Freeroed
  Date: 24.02.2020
  Time: 15:29
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
                <u><a href="account">Личный кабинет</a></u>
            </font></p>
            </td>
        </tr>
    </table>
    <hr>
</header>

<main>
    <form>
        <table border="1" align="right">
            <tr>
                <td><font size="4" face="garamond"><b>Личный кабинет</b></font></td>
            </tr>
            <tr>
                <td><a href="account">Обо мне</a></td>
            </tr>
            <tr>
                <td><a href="animal">Мои животные</a></td>
            </tr>
            <tr>
                <td> <a href="../index">Выход</a></td>
            </tr>
        </table>
        <p><font size="7" color="#008080" face="garamond">Подробно о животном: </font> </p>
        <br/>
        <img src="<c:url value="/img/cat.jpg"/>" align="left"  alt="фото кота">
        <p><font size="4" color="#008080" face="garamond"><b>Кличка: </b>Кошак</font></p>
        <p><font size="4" color="#008080" face="garamond"><b>Тип: </b>Кот</font></p>
        <p><font size="4" color="#008080" face="garamond"><b>Порода: </b>Андефаундер</font></p>
        <p><font size="4" color="#008080" face="garamond"><b>Возраст: </b> 20 </font> </p>
        <p><font size="4" color="#008080" face="garamond"><b>Вес: </b>50 кг</font></p>

        <br><br><p><font size="5" color="#008080" face="garamond">Сведения о вакцинах:</font></p>
        <table border="1" align="left">
            <tr>
                <td><font size="4" face="garamond"><b>№</b></font></td>
                <td><font size="4" face="garamond"><b>Название</b></font></td>
                <td><font size="4" face="garamond"><b>Дата вакцинации</b></font></td>
                <td><font size="4" face="garamond"><b>Срок действия</b></font></td>
                <td><font size="4" face="garamond"><b>Статус</b></font></td>
                <td><button type="submit" formaction="../index.html">Добавить информацию</button></td>
            </tr>
            <tr>
                <td><font size="4" face="garamond"><b>1</b></font></td>
                <td><font size="4" face="garamond"><b>Название вакцины</b></font></td>
                <td><font size="4" face="garamond"><b>01.01.2020</b></font></td>
                <td><font size="4" face="garamond"><b>01.01.2021</b></font></td>
                <td><font size="4" face="garamond" color="green"><b>Действующая</b></font></td>
                <td><form><button type="submit" formaction="../index.html">Подробнее</button></form></td>
            </tr>
            <tr>
                <td><font size="4" face="garamond"><b>2</b></font></td>
                <td><font size="4" face="garamond"><b>Второе название</b></font></td>
                <td><font size="4" face="garamond"><b>03.04.2018</b></font></td>
                <td><font size="4" face="garamond"><b>05.04.2019</b></font></td>
                <td><font size="4" face="garamond" color="red"><b>Просрочена</b></font></td>
                <td><button type="submit" formaction="../index.html">Подробнее</button></td>
            </tr>
        </table>

        <br><br><br><br><p><font size="5" color="#008080" face="garamond" align="left">История поездок</font></p>
        <p><font size="4" face="garamond"><b>Кошак ещё никуда не ездил</b></font></p>
        <button type="submit" formaction="../request/create">Создать заявку на новую поездку</button>


        <p><font size="5" color="#008080" face="garamond" >Сведения о лабораторных исследованиях:</font></p>
        <table border="1" align="left">
            <tr>
                <td><font size="4" face="garamond"><b>№</b></font></td>
                <td><font size="4" face="garamond"><b>Лаборатория</b></font></td>
                <td><font size="4" face="garamond"><b>Показатель</b></font></td>
                <td><font size="4" face="garamond"><b>Дата исследования</b></font></td>
                <td><font size="4" face="garamond"><b>№ экспертицы</b></font></td>
                <td><font size="4" face="garamond"><b>Результат</b></font></td>
                <td><button type="submit" formaction="../index.html">Добавить информацию</button></td>
            </tr>
            <tr>
                <td><font size="4" face="garamond"><b>1</b></font></td>
                <td><font size="4" face="garamond"><b>Сколкого</b></font></td>
                <td><font size="4" face="garamond"><b>На бешенсто</b></font></td>
                <td><font size="4" face="garamond"><b>26.03.2005</b></font></td>
                <td><font size="4" face="garamond"><b>#36547-A5</b></font></td>
                <td><font size="4" face="garamond" color="green"><b>Отрицательный</b></font></td>

            </tr>
        </table>
    </form>
</main>
</body>
</html>

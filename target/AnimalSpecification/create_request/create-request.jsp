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

<main>
    <form>
        <p align="left"><font size="7" color="#008080" face="garamond">Выбор животных: </font> </p>
        <br>
        <select size="1" name="amimal[]">
            <option disabled>Выберите животного</option>
            <option value="cat">Кошак</option>
            <option value="cat">Собак</option>
        </select> Или <button type="submit" formaction="../animal/create">Добавьте новое</button>
        <br>
        <button type="submit" formaction="add-information">Создать заявку</button>

    </form>
</main>

</body>
</html>
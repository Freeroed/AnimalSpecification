<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <title>Электронное оформление ветеринарно-сопроводительных документов</title>
    <link rel="stylesheet" href="style.css">
</head>
<body link="#008080" vlink="#008080" alink="#008080">
<header>
    <table border="0" width="100%">
        <tr>
            <td><img src="img/logo.jpg" alt="логотип" width="60" height="60"></td>
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
                <u><a href="account/authentication.html">Личный кабинет</a></u>
            </font></p>
            </td>
        </tr>
    </table>
    <hr>
</header>
<p>ПРИВЕТ</p>
<main>
    <p align="center">
        <font size="6" color="#000000" face="garamond">
            Электронное оформление ветеринарно-сопроводительных документов
        </font>
    </p>
    <p align="left">
        <font size="3" color="#000000" face="garamond">
            &#9888; Внимание! Для создания заявки Вам потребуется ветеринарный паспорт животного.
            Для оформления ветеринарного паспорта обратитесь в любую ветеринарную клинику.
        </font>
    </p>
    <br/>
    <p align="left">
        <font size="5" color="#000000" face="garamond">
            Выберите регион назначения:
        </font>
    </p>
    <p>
    <form action="create_request/create-request.html">
        <select size="1" name="region[]">
            <option disabled>Выберите регион</option>
            <option value="ES">Страны Евросоюза</option>
            <option value="RF">Регионы Российской Федерации</option>
            <option value="other">Другое</option>
        </select>
        <select size="1" name="county[]">
            <option disabled>Выберите страну</option>
            <option value="Austria">Австрия </option>
            <option value="Belgium">Бельгия</option>
            <option value="Bulgaria">Болгария</option>
            <option value="Hungary">Венгрия</option>
            <option value="Germany">Германия</option>
            <option value="Greece">Греция</option>
            <option value="Denmark">Дания</option>
            <option value="Ireland">Ирландия</option>
            <option value="Spain">Испания</option>
            <option value="Italy">Италия</option>
            <option value="Cyprus">Кипр</option>
            <option value="Latvia">Латвия</option>
            <option value="Lithuania">Литва</option>
            <option value="Luxembourg">Люксембург</option>
            <option value="Malta">Мальта</option>
            <option value="Netherlands">Нидерланды</option>
            <option value="Poland">Польша</option>
            <option value="Slovakia">Словакия</option>
            <option value="Slovenia">Словения</option>
            <option value="Portugal">Португалия</option>
            <option value="Romania">Румыния</option>
            <option value="Finland">Финляндия</option>
            <option value="France">Франция</option>
            <option value="Croatia">Хорватия</option>
            <option value="Czech">Чехия</option>
            <option value="Sweden">Швеция</option>
            <option value="Estonia">Эстония</option>
        </select>

        <input type="submit" value="Создать заявку">
    </form>
    </p>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
</main>
<!-- Страница слишком маленькая, хедер с футером видны одновременно. Раскомментить, как понадобится
<footer>
    <table border="0" width="100%">
        <tr>
            <td><font size="8" color="#66CDAA" face="garamond">
                    SystemName
                </font>
            </td>
            <td></td>
            <td><p align="right"><font size="5" color="#66CDAA" face="garamond">
                Контактный телефон
                </font></p>
            </td>
            <td><p align="right"><font size="5" color="#008080" face="garamond">
                <u>Справочная информация</u>
                </font></p>
            </td>
        </tr>
    </table>
</footer>
-->
</body>


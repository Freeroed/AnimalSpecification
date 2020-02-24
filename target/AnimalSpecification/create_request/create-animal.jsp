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
    <title>Добавление животного</title>
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
        <p><font size="7" color="#008080" face="garamond">Добавление сведений о животном: </font> </p>
        <table border="0" align="center">
            <tr>
                <td colspan="2">
                    <p align="left"><font size="4">Идентификатор чипа</font>
                        <br>
                        <input type="text" name="identificator" /> <button>Проверить</button>
                    </p>
                </td>

                <td><p>Тип животного
                    <br>
                    <select size="1" name="animalType[]">
                        <option disabled>Выберите тип животного</option>
                        <option value="cat">Кот</option>
                        <option value="dog">Пёс</option>
                        <option value="hom">Хомяк</option>
                        <option value="los">Лось</option>
                        <option value="other">Другое</option>
                    </select>
                </p></td>

            </tr>

            <tr>
                <td colspan="2">
                    <br>
                    <p align="left"><font size="4">Кличка животного</font>
                        <br>
                        <input type="text" name="name"/>
                    </p>
                </td>

                <td>
                    <p> Прикрепите фото вашего животного <br>
                        <input type="file" name="">
                    </p>
                </td>
            </tr>

            <tr>
                <td align="left">
                    <p>Вес
                        <br><input type="text" name="ves" size="4">
                    </p>
                </td>
                <td align="right">
                    <p align="right">Возраст
                        <br><input type="text" name="age" size="2">
                    </p>
                </td>
            </tr>
            <tr>
                <td colspan="2"><p>Порода
                    <br>
                    <select size="1" name="animalBreen[]">
                        <option disabled>Выберите породу животного</option>
                        <option value="cat">Сиамский</option>
                        <option value="dog">Андефаундер</option>
                        <option value="other">Другое</option>
                    </select>
                </p></td>
            </tr>
            <tr>
                <td colspan="2">
                    <p>Окрас
                        <br>
                        <input type="text" name="color">
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    Место рождения
                    <br><input type="text" name="burn" size="25">
                </td>
            </tr>
        </table>

        <br>
        <h3 align="center">Информация о вакцинациях: </h3>
        <table border="1" align="center">
            <tr>
                <td><font size="4" face="garamond"><b>№</b></font></td>
                <td><font size="4" face="garamond"><b>Название</b></font></td>
                <td><font size="4" face="garamond"><b>Дата вакцинации</b></font></td>
                <td><font size="4" face="garamond"><b>Срок действия</b></font></td>
            </tr>
            <tr>
                <td><font size="4" face="garamond"><b>1</b></font></td>
                <td><font size="4" face="garamond"><b>Название вакцины</b></font></td>
                <td><font size="4" face="garamond"><b>01.01.2020</b></font></td>
                <td><font size="4" face="garamond"><b>01.01.2021</b></font></td>
            </tr>
        </table>
        <p align="center"><button type="submit" formaction="add-vakcination.html" >Добавить информацию</button> </p>
        </table>

        <h3 align="center"> Проведённые лабораторные исследования: </h3>
        <h4 align="center"> Не было исследований</h4>
        <p align="center"><button type="submit" formaction="../index.html" >Добавить информацию</button> </p>
    </form>
</main>
</body>
</html>

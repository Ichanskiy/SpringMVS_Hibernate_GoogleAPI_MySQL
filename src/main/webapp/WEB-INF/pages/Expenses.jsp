<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <title>Google Maps : Sample 5 : WebCoding Solutions</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>

        *,
        *:before,
        *:after {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        html,
        body {
            height: 100%;
        }

        body {
            font: 14px/1 "Open Sans", sans-serif;
            color: #555;
            background: #fafafa;
        }
        /* фиксированное верхнее меню*/

        .top-nav {
            background: #555555;
            box-shadow: 0 2px 6px 0 rgba(0, 0, 0, 0.4);
            left: 0;
            opacity: 0.95;
            padding: 8px;
            position: fixed;
            right: 0;
            top: 0;
            z-index: 9999;
        }

        .topnav-wrapper {
            margin: 0 auto;
            max-width: 980px;
        }

        .top-logo {
            color: #ddd;
            font: bold 16px/20px "Crete Round", serif;
            padding-left: 10px;
            text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.5);
        }

        .top-logo a {
            color: #B8B8B8;
            text-decoration: none;
        }

        .top-logo a:hover {
            color: #ddd;
        }

        .topnav-right {
            float: right;
        }

        .right-menu {
            margin: 0;
            overflow: hidden;
        }

        .right-menu li {
            float: left;
            list-style-type: none;
            margin: 0;
        }

        .right-menu li a {
            color: #B8B8B8;
            display: block;
            padding: 0.05em 0.75em;
            text-decoration: none;
            text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.3);
        }

        .right-menu li a:hover {
            color: #fff;
            text-shadow: none;
        }

        .right-menu li span {
            font-size: 16px;
            line-height: 1.2;
        }

        .container {
            max-width: 980px;
            margin: 0 auto;
            padding: 25px 10px 0;
        }

        h1 {
            padding: 50px 0;
            font-weight: 400;
            text-align: center;
        }

        .info {
            color: rgba(78, 78, 78, 0.8);
            width: 100%;
            margin: 40px auto;
            text-align: center;
            font-weight: 300;
        }

        .info a {
            color: #bbb;
            text-decoration: none;
        }

        .info a:hover {
            color: #888;
        }
        /* Конец стилей демо-страницы */
        /* Базовый контейнер табов */

        .tabs {
            margin-right: auto;
            margin-left: auto;
            --max-width: 800px;
            padding: 0px;
            width: 400px;
        // margin: 0 auto;
        }
        /* Стили секций с содержанием */

        .tabs > section {
            display: none;
            padding: 15px;
            background: #fff;
            border: 1px solid #ddd;
        }

        .tabs > section > p {
            margin: 0 0 5px;
            line-height: 1.5;
            color: #383838;
            /* прикрутим анимацию */
            -webkit-animation-duration: 1s;
            animation-duration: 1s;
            -webkit-animation-fill-mode: both;
            animation-fill-mode: both;
            -webkit-animation-name: fadeIn;
            animation-name: fadeIn;
        }
        /* Описываем анимацию свойства opacity */

        @-webkit-keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        /* Прячем чекбоксы */

        .tabs > input {
            display: none;
            position: absolute;
        }
        /* Стили переключателей вкладок (табов) */

        .tabs > label {
            display: inline-block;
            margin: 0 0 -1px;
            padding: 15px 25px;
            font-weight: 600;
            text-align: center;
            color: #aaa;
            border: 0px solid #ddd;
            border-width: 1px 1px 1px 1px;
            background: #f1f1f1;
            border-radius: 3px 3px 0 0;
        }
        /* Шрифт-иконки от Font Awesome в формате Unicode */

        .tabs > label:before {
            font-family: fontawesome;
            font-weight: normal;
            margin-right: 10px;
        }

        .tabs > label[for*="1"]:before {
            content: "\f19a";
        }

        .tabs > label[for*="2"]:before {
            content: "\f17a";
        }

        .tabs > label[for*="3"]:before {
            content: "\f13b";
        }

        .tabs > label[for*="4"]:before {
            content: "\f13c";
        }
        /* Изменения стиля переключателей вкладок при наведении */

        .tabs > label:hover {
            color: #888;
            cursor: pointer;
        }
        /* Стили для активной вкладки */

        .tabs > input:checked + label {
            color: #555;
            border-top: 1px solid #009933;
            border-bottom: 1px solid #fff;
            background: #fff;
        }
        /* Активация секций с помощью псевдокласса :checked */

        #tab1:checked ~ #content-tab1,
        #tab2:checked ~ #content-tab2,
        #tab3:checked ~ #content-tab3,
        #tab4:checked ~ #content-tab4 {
            display: block;
        }
        /* Убираем текст с переключателей
* и оставляем иконки на малых экранах
*/

        @media screen and (max-width: 680px) {
            .tabs > label {
                font-size: 0;
            }
            .tabs > label:before {
                margin: 0;
                font-size: 18px;
            }
        }

        @media screen and (max-width: 400px) {
            .tabs > label {
                padding: 15px;
            }
        }
        #lat_div {
            display: none;
        }

        #long_div{
            display: none;
        }


        #map-canvas {
            margin-top: 1%;
            margin-left: 15%;
            padding: 16%;
            float: left;
            border: solid 1px black;
        }
        #field_div{
            margin-top: 1%;
            margin-right: 15%;
            border: solid 1px black;
            padding: 0.3%;
            float: right;
            background-color: lemonchiffon;
        }

        body{
            background-color: beige; /* Цвет фона веб-страницы */
        }

        ul {
            list-style: none;
        }

        #mainul > ul {
            display: none;
        }

        #mainul:hover > ul {
            display: block;
        }

        #mainul > ul > li > ul {
            display: none;
        }

        #mainul > ul > li:hover > ul {
            display: block;
        }

        .seacher {
            padding: 10px 0 10px 0;
        }

        .liFix {
            padding: 10px 0 0 0;
        }

        .liFirstFix {
            margin: 7px 0 0 0;
        }

        .colorGD {
            background-color: #8aeb97;
            cursor: pointer;
            padding: 10px 0 10px 0;
        }
        .colorGU {
            background-color: #deffa0;
            cursor: pointer;
        // color: lemonchiffon;
            border: 1px #fffa00 solid;
            margin-left: 15px;
        }


    </style>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDLg8g0NKwIwwgCCkd26kRe4ZLS0dpIg7A&sensor=false"></script>
    <script>
        var map;
        var geocoder;
        var infowindow;

        function addAdresFild(adr) {
            $('#text_adres').val(adr);
        }

        function addCoord(location) {
            $('#long').val(location.lng());
            $('#lat').val(location.lat());
        }

        function checkedSelect() {
            var s = $('#clr :selected').text();
            $('#infoSelect').attr("value", s);
        }

        function initialize() {
            var mapOptions = {
                zoom: 8,
                center: new google.maps.LatLng(50.4384221, 30.4796225)
            };
            map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
            geocoder = new google.maps.Geocoder();
            google.maps.event.addListener(map, 'click', function(event) {
                addMarker(event.latLng);
            });
        }
        function selectItem(element)
        {
            $('#typeProfit').val(element.innerHTML);
            var s = $(element).closest(".seacher").children("span").html();
            $('#parrentLI').attr("value", s);
        }

        function addMarker(location) {
            if(!location) return;
            if(infowindow) infowindow.close();
            var marker = new google.maps.Marker({
                position: location,
                map: map
            });
            geocoder.geocode({latLng:location}, function (results, status) {
                var addr = '';

                addCoord(location);

                if(status == 'OK') {
                    if(results.length == 0) {
                        addr = 'None';
                    } else {
                        addr = results[0].formatted_address;
                    }
                    addAdresFild(addr);
                    var text = 'Адрес: <br>' + addr;
                    infowindow = new google.maps.InfoWindow({ content: text });
                    infowindow.open(map,marker);

                    google.maps.event.addListener(marker, 'click', function () {
                        if(infowindow) infowindow.close();
                        infowindow = new google.maps.InfoWindow({ content: text });
                        infowindow.open(map, this);
                    });
                }
            });
        }
        google.maps.event.addDomListener(window, 'load', initialize);
    </script>

<body>

<h2 align="center">Дипломна робота</h2>

<div id="map-canvas"></div>

<div id= "field_div">
    <div class="tabs">
        <input id="tab1" type="radio" name="tabs" checked>
        <label for="tab1" style="display: inline-block;" title="Wordpress">Полля вводу</label>

        <input id="tab2" type="radio" name="tabs">
        <label for="tab2" style="display: inline-block;" title="Windows">Результати</label>


        <section id="content-tab1">
            <c:url var="addActions" value="/expenses/add" />
            <form:form action="${addActions}" commandName="dto">

                <div class="form-group">
                    <label for="date_name">Дата події</label>
                    <form:input path="userExpenses.userexperses_date" type="date" name="date_name" id="date_name" class="form-control" placeholder="Дата події" />
                </div>

                <div class="form-group">
                    <label for="text_adres">Адреса</label>
                    <form:input path="placePoint.placePointAddress" name="address" type="text" class="form-control" id="text_adres" placeholder="Введіть адресу"/>
                </div>

                <div class="form-group" id="lat_div">
                    <label for="lat">Широта</label>
                    <form:input path="placePoint.placePointLong"  name="lat" type="text" class="form-control" id="lat" placeholder="Широта"/>
                </div>

                <div class="form-group" id="long_div">
                    <label for="long">Довгота</label>
                    <form:input path="placePoint.placePointLat" name="long" type="text" class="form-control" id="long" placeholder="Довгота"/>
                </div>

                <div class="form-group">
                    <label for="money">Кількість потрачених грошей</label>
                    <form:input path="userExpenses.userexperses_count" name="amount" type="number" class="form-control" id="money" value="0" min="1" max="40000" step="1" />
                </div>


                <br>
                <div id="mainul">
                    <b><span class="colorGD">Виберіть тип витрат</span></b>
                    <ul>
                        <li class="seacher">
                            <span class="colorGD">Їжа</span>
                            <ul>
                                <li class="liFix liFirstFix">
                                    <span class="colorGU" onclick="selectItem(this)">Продукти</span>
                                </li>
                                <li class="liFix">
                                    <span class="colorGU" onclick="selectItem(this)">Ресторан</span>
                                </li>
                            </ul>
                        </li>

                        <li class="seacher">
                            <span class="colorGD">Одяг</span>
                            <ul>
                                <li class="liFix liFirstFix">
                                    <span class="colorGU" onclick="selectItem(this)">Взуття</span>
                                </li>
                                <li class="liFix">
                                    <span class="colorGU" onclick="selectItem(this)">Штани</span>
                                </li>
                                <li class="liFix">
                                    <span class="colorGU" onclick="selectItem(this)">Рубашки</span>
                                </li>
                                <li class="liFix">
                                    <span class="colorGU" onclick="selectItem(this)">Верхній одяг</span>
                                </li>
                            </ul>
                        </li>

                        <li class="seacher">
                            <span class="colorGD">Подарунки</span>
                            <ul>
                                <li class="liFix liFirstFix">
                                    <span class="colorGU" onclick="selectItem(this)">Іграшки</span>
                                </li>
                                <li class="liFix">
                                    <span class="colorGU" onclick="selectItem(this)">Прикраси</span>
                                </li>
                                <li class="liFix">
                                    <span class="colorGU" onclick="selectItem(this)">Квіти</span>
                                </li>
                            </ul>
                        </li>
                        <li class="seacher">
                            <span class="colorGD">Розваги</span>
                            <ul>
                                <li class="liFix liFirstFix">
                                    <span class="colorGU" onclick="selectItem(this)">Атракціони</span>
                                </li>
                                <li class="liFix">
                                    <span class="colorGU" onclick="selectItem(this)">Кінотеатр</span>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <form:input path="tag.tagNameParent"  name="parentTag" type="hidden"  id="parrentLI" class="form-control" value="type"/>
                    <form:input path="tag.tagName"  name="childrenTag" type="text" class="form-control" id="typeProfit" placeholder="Тип"/>
                </div>

                <button type="submit" class="btn btn-success" >Додати</button>
            </form:form>
        </section>


        <section id="content-tab2">
            <c:url var="addAction3" value="/expenses/dateInfo"/>
            <form:form action="${addAction3}" commandName="informationData">
                <b>Період витрат:</b>
                    <p></p>
                    <div class="form-group" style="display: inline-block;">
                        <label for="date_first">з:</label>
                        <form:input path="firstDate" type="date" style="width: 150px;" name="date_first" id="date_first" class="form-control"  />
                    </div>
                    <div class="form-group" style="display: inline-block;">
                        <label for="date_second">по:</label>
                        <form:input path="secondDate" type="date" style="width: 150px;" name="date_second" id="date_second" class="form-control" />
                    </div>
                <br>
                Розваги
                    <form:input path="avocation" type="range" name="avocation" min="0" max="1" step="0.1" id="size"  value="0"/>
                <br>
                Одяг
                     <form:input path="clothes" type="range" name="odyg_range" min="0" max="1" step="0.1" id="size"  value="0"/>
                <br>
                Їжа
                     <form:input path="food" type="range" name="eda_range" min="0" max="1" step="0.1" id="size"  value="0"/>
                <br>
                    <%--<a href="" target="_blank">--%>
                        <%--<button type="submit" class="btn btn-success">Переглянути</button>--%>
                    <%--</a>--%>
                <button type="submit" class="btn btn-success" >Переглянути</button>
                <a href="<c:url value="/expenses/user"/>" ><button type="button" class="btn btn-success">Редагувати</button></a>


            </form:form>
        </section>
    </div>

</div>

<script>
    (() => {
        let now = new Date;
        let Day = now.getDate();
        let Month = now.getMonth() + 1;
        let Year = now.getFullYear();

        if (Month < 10)
            Month = '0' + Month;

        if (Day < 10)
            Day = '0' + Day;

        let date_first = Year+"-"+(Month)+"-01";
        let date_second = Year+"-"+(Month)+"-"+(Day);
        let date_name = Year+"-"+(Month)+"-"+(Day);

        $('#date_first').attr('value',date_first);
        $('#date_second').attr('value',date_second);
        $('#date_name').attr('value',date_name);
    })();
</script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Diplom</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/maskinput.js"></script>
    <script type="text/javascript">
        jQuery(function($){
            $("#tel").mask("(999) 999-9999");
        });
    </script>


    <style>
        #div_reg{
            margin-top: 2%;
            margin-left: 35%;
            margin-right: 35%;
            border: solid 1px black;
            padding: 3%;
            float: inherit;
            background-color: lemonchiffon;
        }
    </style>
</head>
<body>
<br/><br/>
<center><h3>Авторизація</h3></center>

<div id="div_reg">
    <c:url var="addAction" value="/LogIn" />
    <form:form action="${addAction}" commandName="authorisationUser">

        <div class="form-group">
            <label for="email">Email</label>
            <form:input path = "user_email"  type = "email" class = "form-control" name = "email" id = "email"  placeholder = "Введіть email" pattern = "(\W|^)[\w.+\-]{0,25}@(yahoo|hotmail|gmail|i)\.com(\W|$)" />
        </div>

        <div class="form-group">
            <label for="email">Номер телефону</label>
            <form:input path = "user_phone" type = "text" name = "tel_reg"  class = "form-control" placeholder = "Мобільний телефон"  pattern = "[0-9]{2,10}"/>
        </div>

        <button type="submit" class="btn btn-success">Увійти</button>
        <a href="<c:url value="/registration"/>" ><button type="button" class="btn btn-success">Зареєструватися</button></a>
    </form:form>
</div>

</body>
</html>
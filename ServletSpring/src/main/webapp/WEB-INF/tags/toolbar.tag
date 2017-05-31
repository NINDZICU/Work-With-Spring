﻿<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content=" text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/primer.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap-theme.min.css" />">


</head>
<body>
<!-- Меню navbar -->
<nav class="navbar navbar-default">
    <!-- Бренд и переключатель, который вызывает меню на мобильных устройствах -->
    <div class="navbar-header">
        <!-- Кнопка с полосочками, которая открывает меню на мобильных устройствах -->
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-menu"
                aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <!-- Бренд или логотип фирмы (обычно содержит ссылку на главную страницу) -->
        <a href="/" class="navbar-brand"><s:message code="logo.name"/></a>
    </div>
    <!-- Содержимое меню (коллекция навигационных ссылок, формы и др.) -->
    <div class="collapse navbar-collapse" id="main-menu">
        <!-- Список ссылок, расположенных слева -->
        <ul class="nav navbar-nav">
            <!--Элемент с классом active отображает ссылку подсвеченной -->
            <li class="active"><a href="/"><s:message code="mainPage.name"/> <span class="sr-only">(current)</span></a></li>
            <li><a href="${s:mvcUrl('PC#showPosts').arg(0, "1").build()}"><s:message code="posts.name"/></a></li>
            <li><a href="/feedback"><s:message code="callback.name"/></a></li>
        </ul>
        <!-- Список ссылок, расположенный справа -->
        <ul class="nav navbar-nav navbar-right">
            <li><a href=${s:mvcUrl('JSRC#registration').build()}><s:message code="registrationjsr303.name"/></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href=${s:mvcUrl('MC#registration').build()}><s:message code="registrationvalidator.name"/></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/information"><s:message code="aboutUs.name"/></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <a href="?lang=en">en</a>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            |
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <a href="?lang=ru">ru</a>
        </ul>
    </div>
</nav>
<jsp:doBody/>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Anatoly
  Date: 04.04.2017
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<t:toolbar>

    <h2><s:message code="reg.name"/></h2>
    <%--<p><spring:message code="empty_field"/></p>--%>
    <form:form method="POST" cssclass="form-horizontal" commandName="user">
        <div class="form-group">
            <form:label path="email" cssClass="control-label col-xs-3" for="inputEmail"><s:message
                    code="reg.email.name"/></form:label>
            <div class="col-xs-9">
                <form:input path="email" id="inputEmail" cssClass="form-control"/>
            </div>
            <form:errors cssStyle="color: red" path="email"/><br>
        </div>

        <form:label path="surname" cssClass="control-label col-xs-3" for="lastName"><s:message code="reg.surname.name"/></form:label>
        <form:input path="surname"/>
        <form:errors cssStyle="color: red" path="surname"/><br>

        <form:label path="name">Имя:</form:label>
        <form:input path="name"/>
        <form:errors cssStyle="color: red" path="name"/><br>

        <form:label path="password"><s:message code="reg.pass.name"/></form:label>
        <form:password path="password"/>
        <form:errors cssStyle="color: red" path="password"/><br>

        <form:label path="repassword"><s:message code="reg.repass.name"/></form:label>
        <form:password path="repassword"/>
        <form:errors cssStyle="color: red" path="repassword"/><br>

        <form:label path="country"><s:message code="reg.country.name"/></form:label>
        <form:input path="country"/>
        <form:errors cssStyle="color: red" path="country"/><br>

        <form:label path="gender"><s:message code="reg.gender.name"/></form:label>
        <form:radiobutton path="gender" value="0"/>
        <form:label path="gender"><s:message code="male.name"/></form:label>

        <form:radiobutton path="gender" value="1"/>
        <form:label path="gender"><s:message code="female.name"/></form:label>
        <form:errors cssStyle="color: red" path="gender"/><br>

        <form:label path="news"><s:message code="reg.subscr.name"/></form:label>
        <form:checkbox path="news"/>
        <form:errors path="news"/><br>
        <input type="submit" value=<s:message code="btn.submit"/>>
    </form:form>
    <h2>${message}</h2>

    <form class="form-horizontal">
        <div class="form-group">
            <label class="control-label col-xs-3" for="lastName">Фамилия:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="lastName" placeholder="Введите фамилию">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="firstName">Имя:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="firstName" placeholder="Введите имя">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="inputEmail">Email:</label>
            <div class="col-xs-9">
                <input type="email" class="form-control" id="inputEmail" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="inputPassword">Пароль:</label>
            <div class="col-xs-9">
                <input type="password" class="form-control" id="inputPassword" placeholder="Введите пароль">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="confirmPassword">Подтвердите пароль:</label>
            <div class="col-xs-9">
                <input type="password" class="form-control" id="confirmPassword" placeholder="Введите пароль ещё раз">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3">Страна:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="country" placeholder="Введите вашу страну">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3">Пол:</label>
            <div class="col-xs-2">
                <label class="radio-inline">
                    <input type="radio" name="genderRadios" value="male"> Мужской
                </label>
            </div>
            <div class="col-xs-2">
                <label class="radio-inline">
                    <input type="radio" name="genderRadios" value="female"> Женский
                </label>
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
                <label class="checkbox-inline">
                    <input type="checkbox" value="agree"> Я согласен с <a href="#">условиями</a>.
                </label>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
                <input type="submit" class="btn btn-primary" value="Регистрация">
                <input type="reset" class="btn btn-default" value="Очистить форму">
            </div>
        </div>
    </form>
</t:toolbar>

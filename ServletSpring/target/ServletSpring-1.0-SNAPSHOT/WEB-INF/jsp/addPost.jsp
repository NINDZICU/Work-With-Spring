<%--
  Created by IntelliJ IDEA.
  User: Anatoly
  Date: 11.04.2017
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<t:toolbar>

    <form:form method="post" commandName="post">
        <div class="form-group">
            <form:label path="slug" cssClass="control-label col-xs-3"><s:message code="post.add.slug"/></form:label>
            <form:input path="slug" cssClass="form-control"/>
            <form:errors path="slug"/>
        </div>
        <div class="form-group">
            <form:label path="name_ru" cssClass="control-label col-xs-3"><s:message code="post.add.name"/></form:label>
            <form:input path="name_ru" cssClass="form-control"/>
            <form:errors path="name_ru"/>
        </div>
        <div class="form-group">
            <form:label cssClass="control-label col-xs-3" path="text_ru"><s:message code="post.add.text"/></form:label>
            <div class="col-xs-9">
                <form:textarea path="text_ru" cssClass="form-control"/>
                <form:errors path="text_ru"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="name_eng" cssClass="control-label col-xs-3"><s:message code="post.add.name"/></form:label>
            <form:input path="name_eng" cssClass="form-control"/>
            <form:errors path="name_eng"/>
        </div>
        <div class="form-group">
            <form:label cssClass="control-label col-xs-3" path="text_eng"><s:message code="post.add.text"/></form:label>
            <div class="col-xs-9">
                <form:textarea path="text_eng" cssClass="form-control"/>
                <form:errors path="text_eng"/>
            </div>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-primary" value=<s:message code="btn.submit"/>
        </div>

    </form:form>
    <h2 style="color: green">${message}</h2>
</t:toolbar>

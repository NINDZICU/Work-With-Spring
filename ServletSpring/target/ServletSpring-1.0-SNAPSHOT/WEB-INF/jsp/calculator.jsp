<%--
  Created by IntelliJ IDEA.
  User: Anatoly
  Date: 07.03.2017
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:toolbar>

<br>
${viewVariable}
<div id="calculator">
    <form name="calculator" method="post" action="/calc">
        <input type="text" name="value1" size="20" maxlength="9">
        <select name="operation" required>
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
        <input type="text" name="value2" maxlength="9" size="20">
        <br>
        <br>
        <input name="calculate" type="submit" value="result">
    </form>
    ${result}
    <div id="error">
        ${error}

    </div>
</div>
</t:toolbar>

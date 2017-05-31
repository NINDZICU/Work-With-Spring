<%--
  Created by IntelliJ IDEA.
  User: Anatoly
  Date: 10.04.2017
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:toolbar>
    <h2>${message}</h2>
    <a href="${s:mvcUrl('PC#addPost').build()}">
        <button><s:message code="btn.add.post"/></button>
    </a>
    <div>
        <c:forEach items="${posts}" var="post">
            <c:if test="${not empty post.name and not empty post.text}">
                <div>
                    <h2 style="color: saddlebrown">${post.name}</h2>
                </div>
                <div>
                    <p>${post.text}</p>
                </div>
                <a href="${s:mvcUrl('PC#editPost').arg(0, post.slug).build()}">
                    <button><s:message code="btn.edit.post"/></button>
                </a>
                <a href="${s:mvcUrl('PC#dropPost').arg(0, post.slug).build()}">
                    <button><s:message code="btn.drop.post"/></button>
                </a>
            </c:if>
        </c:forEach>
    </div>
    <nav>
        <ul class="pagination pagination-theme  no-margin">
            <li>
                <c:if test="${page > 1}">
                    <a href="${s:mvcUrl('PC#showPosts').arg(0, Integer.valueOf(page-1)).build()}"
                       aria-label="Previous">
                        <span aria-hidden="true">←</span>
                    </a>
                </c:if>
            </li>
            <li class="active"><a href="${s:mvcUrl('PC#showPosts').arg(0, firstnumber).build()}">${firstnumber}</a>
            </li>
            <c:if test="${secondnumber  > firstnumber+1}">
                <li><span>...</span></li>
            </c:if>
            <c:if test="${secondnumber ne null}">
                <li><a href="${s:mvcUrl('PC#showPosts').arg(0, secondnumber ).build()}">${secondnumber}</a></li>
            </c:if>
            <c:if test="${secondnumber  < lastnumber-1}">
                <li><span>...</span></li>
            </c:if>
            <c:if test="${lastnumber ne null}">
                <li><a href="${s:mvcUrl('PC#showPosts').arg(0, lastnumber ).build()}">${lastnumber}</a></li>
            </c:if>
            <c:if test="${page ne lastnumber and secondnumber ne null}">
                <li>
                    <a href="${s:mvcUrl('PC#showPosts').arg(0, Integer.valueOf(page+1)).build()}" aria-label="Next">
                        <span aria-hidden="true">→</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>

</t:toolbar>

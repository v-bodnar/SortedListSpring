<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" >
    <title><spring:message code="pageTitle"/></title>
</head>
<body>
<spring:message code="submitButtonLabel" var="submit"/>
<spring:message code="buttonUpLabel" var="up"/>
<spring:message code="buttonDownLabel" var="down"/>
<spring:message code="buttonSaveLabel" var="save"/>
<spring:message code="buttonDeleteLabel" var="delete"/>
<div id="container">
    <h1>${title}</h1>

    <div class="input-group">
        <input type="text" class="form-control"  id="newItem"/>
        <span class="input-group-btn">
            <input type="submit" class="btn btn-default" value="${submit}" onclick="add()">
        </span>
    </div>

    <div>
        <ul id="sortedList" class="list-group">
            <c:forEach var="item" items="${items}">
                <li class="list-group-item"><c:out value="${item}"/></li>
            </c:forEach>
        </ul>
    </div>

    <div id="button-group" class="btn-group" role="group">
        <button type="button" class="btn btn-default" id="up"     ><c:out value="${up}"/>   </button>
        <button type="button" class="btn btn-default" id="down"   ><c:out value="${down}"/> </button>
        <button type="button" class="btn btn-default" id="save"   ><c:out value="${save}"/> </button>
        <button type="button" class="btn btn-default" id="delete" ><c:out value="${delete}"/></button>
    </div>
</div>
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" />"></script>
<script src="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/js/ui.js" />"></script>
<script src="<c:url value="/js/api.js" />"></script>

</body>
</html>
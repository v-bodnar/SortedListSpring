<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" >
    <title><spring:message code="pageTitle"/></title>
</head>
<body>
<spring:message code="submitButtonLabel" var="submit"/>
<spring:message code="buttonUpLabel" var="up"/>
<spring:message code="buttonDownLabel" var="down"/>
<spring:message code="buttonSaveLabel" var="save"/>
<spring:message code="buttonDeleteLabel" var="delete"/>
<h1>${message}</h1>
<input type="text" id="newItem"/>
<input type="submit" value="${submit}" onclick="add()">
<ul id="sortedList">
    <c:forEach var="item" items="${items}">
        <li><c:out value="${item}"/></li>
    </c:forEach>
</ul>
<button id="up"     ><c:out value="${up}"/></button>
<button id="down"   ><c:out value="${down}"/></button>
<button id="save"   ><c:out value="${save}"/></button>
<button id="delete" ><c:out value="${delete}"/></button>

<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js" />"></script>
<script src="<c:url value="/js/ui.js" />"></script>
<script src="<c:url value="/js/api.js" />"></script>

</body>
</html>
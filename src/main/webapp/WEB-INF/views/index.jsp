<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="include/static-head.jsp" %>

<style>
    #main-title {
        width: 40%;
        margin: 200px auto;
        font-size: 40px;
        font-weight: 700;
        color: orange;
        text-align: center;
    }
</style>
</head>
<body>

    <%@ include file="include/header.jsp" %>

    <h1 id="main-title">
        <%-- session.getAttribute("login") --%>
        <c:if test="${sessionScope.login == null}">
            초보자님 안녕하세요~~
        </c:if>
        <c:if test="${sessionScope.login != null}">
            ${sessionScope.login.nickName}님 하이룽~
        </c:if>
    </h1>
    
       
   

    


</body>
</html>
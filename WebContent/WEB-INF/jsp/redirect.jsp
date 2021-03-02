<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="utf-8" import="org.example.tomcat1.bean.News"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	   
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>News site</title>
	<style type="text/css">
		<%@include file="css/main.css" %>	
	</style>
	<%@include file="localization.jsp" %>
</head>
<body>
	<c:set var="error" value="${requestScope.error}" />
	<div class="simpletext">
		<c:if test="${error != null}">
			<c:if test="${error.equals('registration')}">
				<c:out value="${fmt_error_registration}" /><br>
				<c:out value="${fmt_redirect}" />
				<% 
					response.setHeader("Refresh", "2;url=Controller?command=registration"); 
				%>
			</c:if>	
			<c:if test="${error.equals('logination')}">
				<c:out value="${fmt_error_logination}" /><br>
				<c:out value="${fmt_redirect}" />
				<% 
					response.setHeader("Refresh", "2;url=Controller?command=gotoindexpage"); 
				%>
			</c:if>	
		</c:if>
	</div>
</body>
</html>
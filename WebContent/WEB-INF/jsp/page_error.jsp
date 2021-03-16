<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="utf-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	   
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>News site</title>
	<style type="text/css">
		<%@include file="resources/css/main.css" %>	
	</style>
	<%@include file="resources/localization/localization.jsp" %>
</head>
<body>
	<div class="simpletext">
		<c:out value="${fmt_site_error}" />
	</div>
</body>
</html>
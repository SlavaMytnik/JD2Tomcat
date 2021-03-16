<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="utf-8" import="org.example.tomcat1.bean.News"%>   
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
	<script type="text/javascript">
		function go(a) {
			setTimeout(function () {
				location=a;
		    }, 2000);			
		}
	</script>
</head>
<body>
	<c:set var="error" value="${requestScope.error}" />
	<div class="simpletext">
		<c:if test="${error != null}">
			<c:if test="${error.equals('registration')}">
				<c:out value="${fmt_error_registration}" /><br>
				<c:out value="${fmt_redirect}" />
				<script type="text/javascript">
					go('Controller?command=gotoregistrationpage');
				</script>
			</c:if>	
			<c:if test="${error.equals('logination')}">
				<c:out value="${fmt_error_logination}" /><br>
				<c:out value="${fmt_redirect}" />
				<script type="text/javascript">
					go('Controller?command=gotoindexpage');
				</script>
			</c:if>	
		</c:if>
	</div>
</body>
</html>
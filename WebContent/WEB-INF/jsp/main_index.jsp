<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List, org.example.tomcat1.bean.News"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>	
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
	<table class="tablebase">
		<tr>
			<td class="tableleft">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="logination" /> 
					<span><c:out value="${fmt_logination}" /></span><br>
					<input type="text" name="login" value="" placeholder="${fmt_login}" /><br> 
					<input type="password" name="password" value="" placeholder="${fmt_password}" /><br> 		
					<input type="submit" value="${fmt_enter}" />
					<a href="Controller?command=registration"><c:out value="${fmt_registration}" /></a>	
				</form>
				<c:if test="${!fmt_language.equals('en')}">
					<a href="Controller?command=changelocal&local=en">${fmt_localbutton_en}</a>
				</c:if>
				<c:if test="${!fmt_language.equals('ru')}">
					<a href="Controller?command=changelocal&local=ru">${fmt_localbutton_ru}</a>
				</c:if>
			</td>			
			<td class="tableright">			
				<table>
				    <c:if test="${requestScope.news != null}">
					    <c:forEach var="news" items="${requestScope.news}">
							<tr>
								<td>
								   <b><c:out value="${news.title}" /></b>
								</td>
							</tr>
							<tr>
								<td>
								   <c:out value="${news.brief}" />
								</td>
							</tr>
							<tr>
								<td>
								   <br>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
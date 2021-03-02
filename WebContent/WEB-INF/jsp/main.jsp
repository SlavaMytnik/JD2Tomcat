<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="utf-8" import="java.util.List, org.example.tomcat1.bean.News"%>   
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
	<c:set var="username" value="${sessionScope.username}" />					
	<c:set var="role" value="${sessionScope.role}" />
	<table class="tablebase">
		<tr>
			<td class="tableleft">
				<span><c:out value="${fmt_hello}" />, 
					<c:if test="${username != null}">
						<c:if test="${role != null && role.equals('admin')}">
		    				<c:out value=" ${fmt_admin} " />
						</c:if>	
	    				<c:out value="${username}" />
					</c:if>			
				</span><br>
				<a href="Controller?command=logout"><c:out value="${fmt_logout}" /></a><br>
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
								   <c:out value="${news.brief}" /><br>						   
								   <a href="Controller?command=gotonewspage&id=<c:out value="${news.id}" />"><c:out value="${fmt_read}" /></a>
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
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
	</head>
	<%@include file="localization.jsp" %>
<body>
	<c:set var="username" value="${sessionScope.username}" />
	<c:set var="role" value="${sessionScope.role}" />
	<c:set var="news" value="${requestScope.news}" />
	<c:if test="${role != null && role.equals('admin')}">
		<table class="tablebase">
			<tr>
				<td class="tableleft">
					<span><c:out value="${fmt_hello}" />, 
						<c:if test="${username != null}">
							<c:out value=" ${fmt_admin} " />
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
					<c:if test="${news != null}">
						<form action="Controller" method="post">
							<input type="hidden" name="command" value="modifynews" /> 
							<input type="hidden" name="id" value="<c:out value="${news.id}" />" /> 
							<b><c:out value="${fmt_title}" /></b><br>
							<textarea name="title"><c:out value="${news.title}" /></textarea><br><br> 	
							<b><c:out value="${fmt_brief}" /></b><br>
							<textarea name="brief"><c:out value="${news.brief}" /></textarea><br><br> 	
							<b><c:out value="${fmt_content}" /></b><br>
							<textarea name="content"><c:out value="${news.content}" /></textarea><br><br>	
							<table class="links">
								<tr class="links">
									<td class="linksleft">
										<a href="Controller?command=gotonewspage&id=<c:out value="${news.id}" />"><c:out value="${fmt_back}" /></a>
									</td>
									<td class="linksright">
										<input type="submit" value="<c:out value="${fmt_save}" />" />
									</td>
								</tr>
							</table>	
						</form>		
					</c:if>
				</td>
			</tr>
		</table>	
	</c:if>
	<c:if test="${role == null || !role.equals('admin')}">
	<%
		response.sendRedirect("Controller?command=gotoindexpage");	
	%>
	</c:if>
</body>
</html>
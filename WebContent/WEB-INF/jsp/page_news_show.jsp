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
</head>
<body>
	<c:set var="username" value="${sessionScope.username}" />
	<c:set var="role" value="${sessionScope.role}" />
	<c:set var="news" value="${requestScope.news}" />
	<c:set var="edited" value="${requestScope.edited}" />
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
					<c:if test="${news != null}">
						<tr>
							<td>
								<b>
								<c:if test="${edited != null && edited == true}">
	    							<c:out value="(${fmt_modified}) " />
								</c:if>								   
								<c:out value="${news.title}" /></b>
							</td>
						</tr>
						<tr>
							<td>
							   ${news.content}<br>
							</td>
						</tr>
						<tr>
							<td class="links">			   
								<table class="links">
									<tr class="links">
										<td class="linksleft">
											<a href="Controller?command=gotomainpage"><c:out value="${fmt_back}" /></a>
										</td>										
										<c:if test="${role != null && role.equals('admin')}">
						    				<td class="linksright">
												<a href="Controller?command=gotoeditpage&id=<c:out value="${news.id}" />"><c:out value="${fmt_edit}" /></a>
											</td>
											<td class="linksright">
												<form action="Controller" method="post">
													<input type="hidden" name="command" value="deletenews" /> 
													<input type="hidden" name="id" value="<c:out value="${news.id}" />" /> 
													<input type="submit" value="<c:out value="${fmt_delete}" />" />
												</form>	
											</td>
										</c:if>											
									</tr>
								</table>						   
							</td>
						</tr>
					</c:if>	
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
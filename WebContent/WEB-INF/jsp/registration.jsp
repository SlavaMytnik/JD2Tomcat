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
					<input type="hidden" name="command" value="savenewuser" /> 
					<span><c:out value="${fmt_registration}" /></span><br>
					<input type="text" name="login" value="" placeholder="${fmt_login} (${fmt_necessarily})" /><br> 
					<input type="password" name="password" value="" placeholder="${fmt_password} (${fmt_necessarily})" /><br> 		
					<input type="text" name="name" value="" placeholder="${fmt_name}" /><br> 
					<input type="text" name="surname" value="" placeholder="${fmt_surname}" /><br> 
					<input type="submit" value="${fmt_save}" />
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
					<tr>
						<td>
							<%@include file="termsofservice.jsp" %>						   
						</td>
					</tr>
					<tr>
						<td class="links">			   
							<table class="links">
								<tr class="links">
									<td class="linksleft">
										<a href="Controller?command=gotoindexpage"><c:out value="${fmt_back}" /></a>
									</td>										
								</tr>
							</table>						   
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
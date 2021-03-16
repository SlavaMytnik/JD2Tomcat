<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>	
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.localization" var="fmt_loc" />
<fmt:message bundle="${fmt_loc}" key="language" var="fmt_language" />
<fmt:message bundle="${fmt_loc}" key="hello" var="fmt_hello" />
<fmt:message bundle="${fmt_loc}" key="localbutton.en" var="fmt_localbutton_en" />
<fmt:message bundle="${fmt_loc}" key="localbutton.ru" var="fmt_localbutton_ru" />
<fmt:message bundle="${fmt_loc}" key="logination" var="fmt_logination" />
<fmt:message bundle="${fmt_loc}" key="registration" var="fmt_registration" />
<fmt:message bundle="${fmt_loc}" key="logout" var="fmt_logout" />
<fmt:message bundle="${fmt_loc}" key="login" var="fmt_login" />
<fmt:message bundle="${fmt_loc}" key="password" var="fmt_password" />
<fmt:message bundle="${fmt_loc}" key="enter" var="fmt_enter" />
<fmt:message bundle="${fmt_loc}" key="back" var="fmt_back" />
<fmt:message bundle="${fmt_loc}" key="edit" var="fmt_edit" />
<fmt:message bundle="${fmt_loc}" key="read" var="fmt_read" />
<fmt:message bundle="${fmt_loc}" key="modified" var="fmt_modified" />
<fmt:message bundle="${fmt_loc}" key="save" var="fmt_save" />
<fmt:message bundle="${fmt_loc}" key="title" var="fmt_title" />
<fmt:message bundle="${fmt_loc}" key="brief" var="fmt_brief" />
<fmt:message bundle="${fmt_loc}" key="content" var="fmt_content" />
<fmt:message bundle="${fmt_loc}" key="admin" var="fmt_admin" />
<fmt:message bundle="${fmt_loc}" key="delete" var="fmt_delete" />
<fmt:message bundle="${fmt_loc}" key="name" var="fmt_name" />
<fmt:message bundle="${fmt_loc}" key="surname" var="fmt_surname" />
<fmt:message bundle="${fmt_loc}" key="error.registration" var="fmt_error_registration" />
<fmt:message bundle="${fmt_loc}" key="error.logination" var="fmt_error_logination" />
<fmt:message bundle="${fmt_loc}" key="redirect" var="fmt_redirect" />
<fmt:message bundle="${fmt_loc}" key="necessarily" var="fmt_necessarily" />
<fmt:message bundle="${fmt_loc}" key="site.error" var="fmt_site_error" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>	
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="fmt_loc" />
<fmt:message bundle="${fmt_loc}" key="local.language" var="fmt_language" />
<fmt:message bundle="${fmt_loc}" key="local.hello" var="fmt_hello" />
<fmt:message bundle="${fmt_loc}" key="local.localbutton.en" var="fmt_localbutton_en" />
<fmt:message bundle="${fmt_loc}" key="local.localbutton.ru" var="fmt_localbutton_ru" />
<fmt:message bundle="${fmt_loc}" key="local.logination" var="fmt_logination" />
<fmt:message bundle="${fmt_loc}" key="local.registration" var="fmt_registration" />
<fmt:message bundle="${fmt_loc}" key="local.logout" var="fmt_logout" />
<fmt:message bundle="${fmt_loc}" key="local.login" var="fmt_login" />
<fmt:message bundle="${fmt_loc}" key="local.password" var="fmt_password" />
<fmt:message bundle="${fmt_loc}" key="local.enter" var="fmt_enter" />
<fmt:message bundle="${fmt_loc}" key="local.back" var="fmt_back" />
<fmt:message bundle="${fmt_loc}" key="local.edit" var="fmt_edit" />
<fmt:message bundle="${fmt_loc}" key="local.read" var="fmt_read" />
<fmt:message bundle="${fmt_loc}" key="local.modified" var="fmt_modified" />
<fmt:message bundle="${fmt_loc}" key="local.save" var="fmt_save" />
<fmt:message bundle="${fmt_loc}" key="local.title" var="fmt_title" />
<fmt:message bundle="${fmt_loc}" key="local.brief" var="fmt_brief" />
<fmt:message bundle="${fmt_loc}" key="local.content" var="fmt_content" />
<fmt:message bundle="${fmt_loc}" key="local.admin" var="fmt_admin" />
<fmt:message bundle="${fmt_loc}" key="local.delete" var="fmt_delete" />
<fmt:message bundle="${fmt_loc}" key="local.name" var="fmt_name" />
<fmt:message bundle="${fmt_loc}" key="local.surname" var="fmt_surname" />
<fmt:message bundle="${fmt_loc}" key="local.error.registration" var="fmt_error_registration" />
<fmt:message bundle="${fmt_loc}" key="local.error.logination" var="fmt_error_logination" />
<fmt:message bundle="${fmt_loc}" key="local.redirect" var="fmt_redirect" />
<fmt:message bundle="${fmt_loc}" key="local.necessarily" var="fmt_necessarily" />
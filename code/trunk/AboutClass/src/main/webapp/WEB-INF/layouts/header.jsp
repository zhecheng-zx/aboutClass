<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="header">
	<h1>头部</h1>
	<shiro:user>
		<h2>有登陆状态时，显示这部分</h2>
	</shiro:user>
</div>
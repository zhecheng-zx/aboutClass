<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<title>瑜伽约课-<sitemesh:title /></title>
	<meta charset="UTF-8">
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<link href="${ctx }/static/vendor/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
	<%-- <link href="${ctx }/static/vendor/bootstrap-3.3.7/css/bootstrap-theme.min.css" rel="stylesheet" /> --%>
	<link href="${ctx }/static/vendor/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" />
	<link href="${ctx }/static/vendor/icheck-1.x/skins/minimal/_all.css" rel="stylesheet" />
	<script type="text/javascript" src="${ctx}/static/vendor/jquery/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="${ctx}/static/vendor/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/vendor/icheck-1.x/icheck.min.js"></script>
	<sitemesh:head />
</head>
<body class="gray-bg">
	<%@ include file="/WEB-INF/layouts/header.jsp"%>
	<sitemesh:body />
	<%@ include file="/WEB-INF/layouts/footer.jsp"%>
</body>
</html>
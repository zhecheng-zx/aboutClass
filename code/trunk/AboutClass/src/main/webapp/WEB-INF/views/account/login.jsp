<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<link href="${ctx }/static/vendor/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${ctx }/static/vendor/bootstrap-3.3.7/css/bootstrap-theme.min.css" rel="stylesheet" />
	<link href="${ctx }/static/css/login.css" rel="stylesheet" />
	<script>
      var _hmt = _hmt || [];
    </script>
</head>
<body>
	<div class="login-banner" style="background-color:#f3726d;">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<h1 class="text-center" style="text-shadow: -5px 5px 0 rgba(0,0,0,0.1);"><span class="">文案-</span>为梦想而生</h1>
				</div>
			</div>
		</div>
	</div>
	<header class="login-navigation">
		<nav class="navbar navbar-default" role="navigation"> 
			<div class="container">
				<div class="col-md-12">
				    <div class="container-fluid"> 
				        <div class="navbar-header"> 
				            <a class="navbar-brand" href="${ctx }/"><span class="glyphicon glyphicon-fire"></span>瑜伽约课</a> 
				        </div> 
				        <ul class="nav navbar-nav navbar-right"> 
				        	<li><a href="javascript:void(0);">首页</a></li>
				            <li><a href="javascript:void(0);"><span class="glyphicon glyphicon-user"></span> 注册</a></li> 
				            <li><a href="javascript:void(0);"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li> 
				        </ul> 
				    </div> 
		    	</div>
			</div>
		</nav>
	</header>
	<div class="login-wrapper">
		<div class="container">
			<div class=""></div>
		</div>
	</div>
	<footer class="footer">
		<div class="container">
			<div class="row">
                <div class="col-sm-4">
                    <div class="widget">
                        <h4 class="title">最新文章</h4>
                        <div class="content recent-post">
                            <div class="recent-single-post">
                                <a href="javascript：void(0);" class="post-title">开始动工做登录页面了</a>
                                <div class="date">2016年1月3日</div>
                            </div>
                            <div class="recent-single-post">
                                <a href="javascript：void(0);" class="post-title">开始搭建框架了,万事开头难</a>
                                <div class="date">2016年12月16日</div>
                            </div>
                            <div class="recent-single-post">
                                <a href="javascript：void(0);" class="post-title">找了小伙伴开始自己做项目，心情很愉悦</a>
                                <div class="date">2016年12月15日</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="widget">
                        <h4 class="title">标签云</h4>
                        <div class="content tag-cloud">
	                        <a href="javascript:void(0);">策划</a>
	                        <a href="javascript:void(0);">测试内容</a>
	                        <a href="javascript:void(0);">有长有短的</a>
	                        <a href="javascript:void(0);">为了测试不得已</a>
	                        <a href="javascript:void(0);">就这样还不是</a>
	                        <a href="javascript:void(0);">一个人的软件开发</a>
	                        <a href="javascript:void(0);">大框架</a>
	                        <a href="javascript:void(0);">小页面</a>
	                        <a href="javascript:void(0);">网站管理平台</a>
	                        <a href="javascript:void(0);">运维管理平台</a>
	                        <a href="javascript:void(0);">测试账户</a>
	                        <a href="javascript:void(0);">内容填充</a>
	                        <a href="javascript:void(0);">角色分配</a>
	                        <a href="javascript:void(0);">任务分工</a>
	                        <a href="javascript:void(0);">都没有</a>
                            <a href="javascript:void(0);">...</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="widget">
                        <h4 class="title">技术支持</h4>
                        <div class="content tag-cloud friend-links">
                            <a href="http://www.bootcss.com" title="Bootstrap中文网" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'bootcsscom'])" target="_blank">Bootstrap中文网</a>
                            <a href="http://www.bootcdn.cn" title="开放CDN服务" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'bootcdncn'])" target="_blank">开放CDN服务</a>
                            <a href="http://www.gruntjs.net" title="Grunt中文网" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'gruntjsnet'])" target="_blank">Grunt中文网</a>
                            <a href="http://www.gulpjs.com.cn/" title="Gulp中文网" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'gulpjscomcn'])" target="_blank">Gulp中文网</a>
                            <hr>
                            <a href="http://lodashjs.com/" title="Lodash中文文档" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'lodashjscom'])" target="_blank">Lodash中文文档</a>
                            <a href="http://www.jquery123.com/" title="jQuery中文文档" onclick="_hmt.push(['_trackEvent', 'link', 'click', 'jquery123com'])" target="_blank">jQuery中文文档</a>
                            <hr>
                            <a href="javascript:void(0);" title="谷新玉" onclick="" target="_blank">谷新玉</a>
                        </div>
                </div></div>
            </div>
		</div>
	</footer>
	<div class="copyright">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <span>Copyright © <a href="javascript:void(0);">瑜伽约课</a></span> |
                    <span><a href="javascript:void(0);" target="_blank">未备案</a></span> |
                    <span>未备案</span>
                </div>
            </div>
        </div>
    </div>
	<script type="text/javascript" src="${ctx}/static/vendor/jquery/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="${ctx}/static/vendor/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
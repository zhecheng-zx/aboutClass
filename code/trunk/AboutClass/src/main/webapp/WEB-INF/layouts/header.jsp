<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div class="header">
	<div class="login-banner">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<h1 class="text-center"><span class="">文案-</span>为梦想而生</h1>
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
				            <a class="navbar-brand" href="${ctx }/"><span class="fa fa-fire"></span>瑜伽约课</a> 
				        </div> 
				        <ul class="nav navbar-nav navbar-right"> 
				        	<li class="hide"><a href="javascript:void(0);">首页</a></li>
				            <li><a href="javascript:void(0);"><span class="fa fa-etsy"></span> 注册</a></li> 
				            <li><a data-toggle="modal" data-target="#loginModal"><span class="fa fa-user"></span> 登录</a></li> 
				        </ul>
				    </div> 
		    	</div>
			</div>
		</nav>
	</header>
	<shiro:user>
		<nav class="login-navigation">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12">
	                    <div class="navbar-header">
	                        <span class="nav-toggle-button collapsed" data-toggle="collapse" data-target="#main-menu">
	                        <span class="sr-only">Toggle navigation</span>
	                        <i class="fa fa-bars"></i>
	                        </span>
	                    </div>
	                    <div class="collapse navbar-collapse" id="main-menu">
	                        <ul class="menu">
						        <li role="presentation"><a href="${ctx }/">首页</a></li>
							    <li role="presentation"><a href="javascript:void(0);">Lumen</a></li>
							    <li role="presentation"><a href="javascript:void(0);">问答社区</a></li>
							    <li role="presentation"><a href="javascript:void(0);">中文文档</a></li>
							    <li role="presentation"><a href="javascript:void(0);">下载离线文档</a></li>
							    <li role="presentation"><a href="javascript:void(0);">API</a></li>
							    <li role="presentation"><a href="javascript:void(0);">PHP中文手册</a></li>
							    <li role="presentation"><a href="javascript:void(0);">Composer</a></li>
							</ul>   
	                    </div>
	                </div>
	            </div>
	        </div>
	    </nav>
	</shiro:user>
</div>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
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
    <div class="modal custom fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myLoginTitle" aria-hidden="false">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" id="myLoginTitle">账号登录</h4>
	            </div>
	            <div class="modal-body">
	                <form class="form-horizontal" id="loginForm" action="#" method="post">
	                    <div class="form-group">
	                        <div class="input-icon">
	                            <i class="fa fa-user"></i>
	                            <input type="text" class="form-control" name="username" placeholder="手机号">
	                        </div>
                        </div>
	                    <div class="form-group">
	                        <div class="input-icon">
	                            <i class="fa fa-lock"></i>
	                            <input type="password" class="form-control" name="password" placeholder="密码">
	                        </div>
	                    </div>
	                    <div class="form-group">
	                        <div class="form-control-static clearfix">
	                            <div class="checkbox pull-left">
	                            <label class="remebarMe" for="remebarMe">
	                                <input tabindex="1" type="checkbox" name="remembered" id="remembered" class="remebarMe">
	                                	记住我</label>
	                            </div>
	                            <a href="javascript:void(0);" class="forgetPwd pull-right">忘记密码</a>
	                        </div>
	                    </div>
	                    <div class="form-group">
	                        <div class="btn-box">
	                            <a href="javascript:void(0);" class="btn-login">立即登录</a>
	                        </div>
	                    </div>
	                    <div class="form-group mb0">
	                        <div class="form-control-static ml20">没有账号？<a class="text-5aaa60" href="javascript:void(0);">立即注册</a></div>
	                    </div>
	                </form>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	<script>
		$(function(){
			$("#remembered").iCheck({
				checkboxClass: 'icheckbox_minimal-red',
				radioClass: 'iradio_minimal-red',
			});
		})
	</script>
    <shiro:user>
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
	</shiro:user>
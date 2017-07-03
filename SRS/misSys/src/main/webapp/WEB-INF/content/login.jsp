<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="/public/website-head.jspf"%>  
	<title>登录</title>
 <!-- BEGIN PAGE LEVEL PLUGINS -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/global/plugins/select2/css/select2.min.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/global/plugins/select2/css/select2-bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/pages/css/login-4.min.css"/>
        <!-- END PAGE LEVEL PLUGINS -->
        
</head>
 <body class=" login">
    	<div id="control-heigh">
	        <!-- BEGIN LOGO -->
	        <div class="logo" id="logo-area">
	            <a href="${pageContext.request.contextPath}/index" style="color:#FFFFFF">
	              <i class="icon-home fa-2x" ></i> </a>
	        </div>
	        <!-- END LOGO -->
	        <!-- BEGIN LOGIN -->
	        <div class="content" id="content-area">
	            <!-- BEGIN LOGIN FORM -->
	            <form class="login-form">
	                <h3 class="form-title"><center>学生登录</center></h3>
	                <div id="error" style="display:none;color:#FF0000;margin:10px 0;">	
					</div>
	                <div class="alert alert-danger display-hide">
	                    <button class="close" data-close="alert"></button>
	                    <span> 请输入用户名和密码！ </span>
	                </div>
	                <div class="form-group">
	                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
	                    <label class="control-label visible-ie8 visible-ie9">用户名</label>
	                    <div class="input-icon">
	                        <i class="fa fa-user"></i>
	                        <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="username" id="username"/> </div>
	                </div>
	                <div class="form-group">
	                    <label class="control-label visible-ie8 visible-ie9">密码</label>
	                    <div class="input-icon">
	                        <i class="fa fa-lock"></i>
	                        <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password" id="password" /> </div>
	                </div>
	                <div class="form-actions">
	                    <button type="submit" id="loginBtn" class="btn green pull-right btn-block"> 确认登录 </button>
	                </div>
	                
	                <div class="create-account">	                	                    
	                	<a class="btn green-meadow btn-block" href="javascript:;" id="register-btn"> 教师登录 </a>
                	</div>	
	            </form>
	            <!-- END LOGIN FORM -->
	            <!-- BEGIN REGISTRATION FORM -->
	            <form class="register-form" method="post">
	                <h3 class="form-title"><center>教师登录</center></h3>
	                <div id="error2" style="display:none;color:#FF0000;margin:10px 0;"></div>	
	                <div class="form-group">
	                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
	                    <label class="control-label visible-ie8 visible-ie9">用户名</label>
	                    <div class="input-icon">
	                        <i class="fa fa-user"></i>
	                        <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="proUsername" id="proUsername"/> </div>
	                </div>
	                <div class="form-group">
	                    <label class="control-label visible-ie8 visible-ie9">密码</label>
	                    <div class="input-icon">
	                        <i class="fa fa-lock"></i>
	                        <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="proPassword" id="proPassword" /> </div>
	                </div>
	                <div class="form-actions">
	                    <button id="register-back-btn" type="button" class="btn red btn-outline"> 返回学生登录 </button>
	                    <button type="submit" id="register-submit-btn" class="btn green pull-right"> 确认登录 </button>
	                </div>
	            </form>
				<!-- END REGISTER FORM -->	
	        </div>
	        <!-- END LOGIN -->
	        
	        <!-- BEGIN COPYRIGHT -->
	        <div class="copyright" id="copur-area"> 2016 &copy; hui </div>
	        <!-- END COPYRIGHT -->
		<div>
        
        <!-- BEGIN PAGE LEVEL PLUGINS 表单验证-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/js/additional-methods.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/select2/js/select2.full.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/backstretch/jquery.backstretch.min.js"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/pages/scripts/login-4.js"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
      
        <script>
			$(function(){
				var h=document.documentElement.clientHeight ;
				var logoH=$("#logo-area").outerHeight(true); 
				var contentH=$("#content-area").outerHeight(true); 
				var copurH=$("#copur-area").outerHeight(true); 
				var getM=(h-logoH-contentH-copurH)/2;
				$('#control-heigh').css("margin-top",getM);	
				goNext();
			})	
			
			function goNext(){
				　var myName="<%=session.getAttribute("professor")%>"; 
					if(myName==="null"){
						
					}else{						
						location.href ="/misSys/base/back_index";   
					}
			}
			
        </script>

</body>
</html>
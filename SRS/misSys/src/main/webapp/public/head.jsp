<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>           

<!-- BEGIN HEADER -->
        <div class="page-header navbar navbar-fixed-top">
            <!-- BEGIN HEADER INNER -->
            <div class="page-header-inner ">
                <!-- BEGIN LOGO -->
                <div class="page-logo">
                    <a class="logo-default" href="${pageContext.request.contextPath}/plan/preplan/plan_index.action" style="color:#FFFFFF;font-size:18px;font-weight:bold;margin-top:10px"> 预案管理系统</a>
                    <div class="menu-toggler sidebar-toggler"> </div>
                </div>
                <!-- END LOGO -->
				<!-- BEGIN RESPONSIVE MENU TOGGLER -->
                <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
                        <span></span>
                </a>
                <!-- END RESPONSIVE MENU TOGGLER -->
                <!-- BEGIN TOP NAVIGATION MENU -->
               <div class="top-menu">
                  <ul class="nav navbar-nav pull-right">
                  			<li class="dropdown dropdown-extended dropdown-notification" id="header_notification_bar">
                                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                    <i class="icon-bell"></i>
                                    <span class="badge badge-default" id="myMsgSize"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="external">
                                        <h3>
                                            	共<span class="bold" id="myMsgSizeTitle"></span>条消息</h3>
                                    </li>
                                    <li>
                                        <ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283" id="myMsgList">                                           

                                        </ul>
                                    </li>
                                </ul>
                            </li>
							<li class="dropdown dropdown-user">
	                            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
	                                <i class="icon-user"></i> 
	                                <span class="username username-hide-on-mobile">${preplanUsername}</span>
	                                <i class="fa fa-angle-down"></i>
	                            </a>
	                            <ul class="dropdown-menu dropdown-menu-default">
	                                <li>
	                                    <a href="javascript:;">
	                                        <i class="icon-user"></i> ${Session.session_bean.org.orgName}
	                                    </a>
	                                </li>
	                                <li>
	                                    <a href="javascript:;" onclick="loginOut()">
	                                        <i class="icon-key"></i>退出系统 
	                                    </a>
	                                </li>
	                            </ul>
	                        </li> 
				 	</ul>
                </div>
                <!-- END TOP NAVIGATION MENU -->		
            </div>
            <!-- END HEADER INNER -->
        </div>
        <!-- END HEADER -->   

	<script type="text/javascript">	
	
	
	function loginOut(){
		$.ajax({
			url:'/plan/preplan/preplan_person_loginOut.action',
			method:'POST',
			dataType:'json',
			data:{
			},
			success:function(data){
				if(data=="ok"){
		        	location.href ="/plan/preplan/plan_login.action";   
		        }else{
					swal({
						title: "请先登录!",
						text: '未知错误，请确定您已经登录!<a href="${pageContext.request.contextPath}/plan" style="color:#F8BB86">请点击此处登录</a>',
						type: "error",
						html:true,
						confirmButtonText: "确认"  
					});				
		        }
			}
		})
	}
	
	

	
	</script>   
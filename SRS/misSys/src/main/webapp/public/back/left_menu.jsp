<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>           
<%@taglib prefix="s" uri="/struts-tags"%> 
 <!-- BEGIN SIDEBAR -->
 <div class="page-sidebar-wrapper">
     <!-- BEGIN SIDEBAR -->
     <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
     <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
     <div class="page-sidebar navbar-collapse collapse">
         <!-- BEGIN SIDEBAR MENU -->
         <!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
         <!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
         <!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
         <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
         <!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
         <!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
         <!--左侧导航-->
         <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
             <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
             <li class="sidebar-toggler-wrapper hide">
                 <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                 <div class="sidebar-toggler"> </div>
                 <!-- END SIDEBAR TOGGLER BUTTON -->
             </li> 
             <s:if test="null != #session.professor">	      
             <li class="nav-item changeNavPage" id="back_index_home">
                 <a href="javascript:;" class="nav-link nav-toggle" >
                     <i class="icon-home"></i>
                     <span class="title">主页</span>                                
                 </a>                            
             </li>    
             <s:if test='{#session.professor.loginName == "sa"}'>
             	<li class="nav-item start">
                     <a href="javascript:;" class="nav-link nav-toggle">
                         <i class="fa fa-group"></i>
                         <span class="title">人员管理</span>
                         <span class="arrow"></span>
                     </a>
                     <ul class="sub-menu">
                         <li class="nav-item start changeNavPage liChildren">
                             <a href="javascript:;" class="nav-link ">
                                 <i class="fa fa-graduation-cap"></i>
                                 <span class="title">学生管理</span>
                             </a>
                         </li>
                         <li class="nav-item start changeNavPage liChildren" id="back_index_pro">
                             <a href="javascript:;" class="nav-link ">
                                 <i class="fa fa-user-md"></i>
                                 <span class="title">教师管理</span>
                             </a>
                         </li>
                     </ul>
                 </li>	
             </s:if>      
             <li class="nav-item changeNavPage" id="back_index_course">
                 <a href="javascript:;" class="nav-link nav-toggle">
                     <i class=" icon-wrench"></i>
                     <span class="title">课程设置</span>
                 </a>
             </li>  

             <li class="nav-item start changeNavPage " id="back_index_plan">
                 <a href="javascript:;" class="nav-link nav-toggle">
                     <i class=" fa fa-calendar-check-o"></i>
                     <span class="title">学习计划设置</span>
                 </a>
             </li>  

             <li class="nav-item  start changeNavPage" id="back_index_section">
                 <a href="javascript:;" class="nav-link nav-toggle">
                     <i class="fa fa-play "></i>
                     <span class="title">选课管理</span>
                 </a>
             </li>  


             <li class="nav-item  start changeNavPage" id="back_index_transcript">
                 <a href="javascript:;" class="nav-link nav-toggle">
                     <i class="fa fa-list"></i>
                     <span class="title">成绩管理</span>
                 </a>
             </li>  

              </s:if>                                                   
         </ul>
         <!-- END SIDEBAR MENU -->
         <!-- END SIDEBAR MENU -->
     </div>
     <!-- END SIDEBAR -->
 </div>
 <!-- END SIDEBAR -->
 
 	<script>
       	$(function(){
       		addActive();  
       		changeNavPage();
       	})
       	
       	function addActive(){
       		var url =window.location.pathname;
       		if(url.indexOf("back_index")>0){
       			$('#back_index_home').addClass('start active open');
       			return true;	
       		}{
				return false;
			}
       	}
       	
       	//更改内容
       	function changeNavPage(){
       		$('.changeNavPage').click(function(){
       			swal({title: '', text:'加载中，请稍后...<i class="fa fa-spinner fa-spin fa-fw"></i>',showConfirmButton: false, html: true   });
       			$('.page-sidebar-menu .nav-item').removeClass('active open');
       		  	var $this=$(this);
       		  	if($this.hasClass('liChildren')){
       		  		$this.parent().parent().addClass('start active open');
       		  	}
       		 	$this.addClass('start active open');
       		  	var pageName=$this.attr("id");
       		  	if(typeof(pageName)!="undefined"){
	       		  	if(pageName==="back_index_home"){
	       		  		location.href ="/misSys/base/back_index";   
	       		  	}else{
	           			$.ajax({
	           				url:'/misSys/base/'+pageName,
	           				method:'POST',
	           				dataType:'html',
	           				data:{
	           					
	           				},
	           				success:function(data){
								$('#back_index_content').html(data);
								swal.close();
	           				},
	           				error:function(data){
	           					swal.close();																
	           				},
	           			})
	       		  	}
       		  	}      		  	
       		});
       	}
       	
       	//更改url
       	function changeUrl(){
       		var url = location.pathname;
			console.log(url)
			history.pushState({
                url : url
            },'',url);
       	}
	</script>
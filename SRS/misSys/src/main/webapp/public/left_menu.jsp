<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>           

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
                              
                        <li class="nav-item " id="navPlanIndexLi">
                            <a href="${pageContext.request.contextPath}/plan/preplan/plan_index.action" class="nav-link nav-toggle" >
                                <i class="icon-home"></i>
                                <span class="title">主页</span>                                
                            </a>                            
                        </li>          
                        <li class="nav-item" id="navPlanEditLi">
                            <a href="${pageContext.request.contextPath}/plan/preplan/plan_edit_do.action" class="nav-link nav-toggle">
                                <i class=" icon-wrench"></i>
                                <span class="title">预案编制</span>
                                <span class="selected"></span>
                            </a>
                        </li>  

                        <li class="nav-item  " id="navPlanReviewLi">
                            <a href="${pageContext.request.contextPath}/plan/preplan/plan_review_do.action" class="nav-link nav-toggle">
                                <i class=" fa fa-calendar-check-o"></i>
                                <span class="title">预案审核</span>
                            </a>
                        </li>  
  
                        <li class="nav-item  " id="navPlanExecuteLi">
                            <a href="${pageContext.request.contextPath}/plan/preplan/plan_map.action" class="nav-link nav-toggle">
                                <i class="fa fa-play "></i>
                                <span class="title">预案执行</span>
                            </a>
                        </li>  
  
                        <li class="nav-item " id="navPlanReviseLi"> 
                            <a href="${pageContext.request.contextPath}/plan/preplan/plan_revise_do.action" class="nav-link nav-toggle">
                                <i class="fa fa-edit"></i>
                                <span class="title">预案修订</span>
                            </a>
                        </li> 

                        <li class="nav-item  " id="navPlanListLi">
                            <a href="${pageContext.request.contextPath}/plan/preplan/plan_list_do.action" class="nav-link nav-toggle">
                                <i class="fa fa-list"></i>
                                <span class="title">预案列表</span>
                            </a>
                        </li>  

                        <li class="nav-item " id="navPlanShowLi">
                            <a href="${pageContext.request.contextPath}/plan/preplan/plan_drill.action" class="nav-link nav-toggle">
                                <i class="fa fa-circle-o-notch"></i>
                                <span class="title">预案演练</span>
                            </a>
                        </li>
                                                                          
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
            	})
            	
            	function addActive(){
            		var url =window.location.pathname;
            		//console.log(url);
            		if(url.indexOf("plan_index")>0){
            			$('#navPlanIndexLi').addClass('start active open');
            			return true;	
            		}else if(url.indexOf("plan_edit")>0){
            			$('#navPlanEditLi').addClass('start active open');
            			return true;
            		}else if(url.indexOf("plan_review")>0){
            			$('#navPlanReviewLi').addClass('start active open');
            			return true;
            		}else if(url.indexOf("plan_map")>0){
            			$('#navPlanSrcLi').addClass('start active open');
            			return true;
            		}else if(url.indexOf("plan_list")>0){
            			$('#navPlanListLi').addClass('start active open');
            			return true;
            		}else if(url.indexOf("plan_revise")>0){
            			$('#navPlanReviseLi').addClass('start active open');
            			return true;
            		}else{
						return false;
					}
            	}
            </script>
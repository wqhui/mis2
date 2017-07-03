<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>后台首页</title>
	<%@include file="/public/website-head.jspf"%>  	
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/global/plugins/morris/morris.css"/>
    <!-- END PAGE LEVEL PLUGINS -->
        
</head>
<!-- END HEAD -->		  	
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white"> 
   	     <%@include file="/public/back/head.jsp"%> 	
        <!-- BEGIN HEADER & CONTENT DIVIDER -->
        <div class="clearfix"> </div>
        <!-- END HEADER & CONTENT DIVIDER -->
        <!-- BEGIN CONTAINER -->
        <div class="page-container">
            <%@include file="/public/back/left_menu.jsp"%>  
		   	<!-- BEGIN CONTENT -->
            <div class="page-content-wrapper" id="back_index_content">
                <!-- BEGIN CONTENT BODY -->
                <div class="page-content">
                    <!-- BEGIN PAGE HEADER-->                  
                    <!-- BEGIN PAGE TITLE-->
                    <h3 class="page-title"> 
                        <center>欢迎来到选课后台</center>   
                    </h3>
                    <!-- END PAGE TITLE-->
                    <!-- END PAGE HEADER-->


                </div>
                <!-- END CONTENT BODY -->
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END CONTAINER -->
       	<%@include file="/public/footer.jsp"%>   
        <!--[if lt IE 9]>
		<script src="../assets/global/plugins/respond.min.js"></script>
		<script src="../assets/global/plugins/excanvas.min.js"></script> 
		<![endif]-->

        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/morris/morris.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/morris/raphael-min.js"></script>      
        <!-- END PAGE LEVEL PLUGINS -->
        
        <script>

        </script> 

</body>
</html>
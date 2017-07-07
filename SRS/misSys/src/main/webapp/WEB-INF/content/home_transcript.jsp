<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>           
<%@taglib prefix="s" uri="/struts-tags"%> 


<!-- BEGIN CONTENT BODY -->
     <div class="page-content">
         <!-- BEGIN PAGE HEADER-->                  
         <!-- BEGIN PAGE TITLE-->
         <h3 class="page-title"> 
            	 成绩单
         </h3>
         <!-- END PAGE TITLE-->
         <!-- END PAGE HEADER-->
		 <!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box green">
		    <div class="portlet-title">
		        <div class="caption">
		            <i class="fa fa-globe"></i>成绩列表 </div>
		    </div>
		    
		    <div class="portlet-body" id="">
				<table id="proListTable" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>课程名字</th>
			                <th>学分</th>
			                <th>教师 </th>
			                <th>分数</th>
			            </tr>
			        </thead>
			
			    </table>
			</div>
				  
		    
		</div>
		<!-- END EXAMPLE TABLE PORTLET-->  	

     </div>
<!-- END CONTENT BODY -->






	<!-- BEGIN PAGE LEVEL PLUGINS -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/select2/js/select2.full.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/js/additional-methods.min.js"></script>
    	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/pages/scripts/form-validation.min.js"></script>        
    	
    <!-- END PAGE LEVEL PLUGINS -->
    
    
	<script>      
		$(document).ready(function() {
			loadProList();
		} );
		
		
		
		function loadProList(){
			$('#proListTable').dataTable( {
				"ajax": {
				    "url": "${pageContext.request.contextPath}/base/student_getTranscriptByStu",
				    "type": "POST",
				    "data": function ( d ) {

				    }
				},
			  	"deferRender": true,
			  	"searching": true,
			  	"autoWidth": true,
			  	"processing": true,
			  	"destroy": true,//如果需要重新加载的时候请加上这个
		        "columns": [
                    { "data": "courseName"},   
                    { "data": "courseCredits"},  
                    { "data": "professorName"},  
                    { "data": "grade"},
                ],			        
		        "oLanguage": {
		            "sLengthMenu": "每页显示 _MENU_ 条",
		            "sZeroRecords": "没有找到符合条件的数据",
		            "sInfo": "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",
		            "sInfoEmpty": "没有记录",
		            "sInfoFiltered": "(从 _MAX_ 条记录中过滤)",
		            "sSearch": "搜索",
		            "sProcessing": "数据加载中...",
		            "oPaginate": {
		                "sFirst": "首页",
		                "sPrevious": "上一页",
		                "sNext": "下一页",
		                "sLast": "尾页"
		            }
		        }
			});
		}
		
		
		
		
	</script>      		

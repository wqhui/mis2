<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>           
<%@taglib prefix="s" uri="/struts-tags"%> 


<!-- BEGIN CONTENT BODY -->
     <div class="page-content">
         <!-- BEGIN PAGE HEADER-->                  
         <!-- BEGIN PAGE TITLE-->
         <h3 class="page-title"> 
            	自主选课
         </h3>
         <!-- END PAGE TITLE-->
         <!-- END PAGE HEADER-->
		 <!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box green">
		    <div class="portlet-title">
		        <div class="caption">课程列表 </div>
		    </div>
		    
		    <div class="portlet-body" id="">
				<table id="proListTable" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			            	<th>课程编号</th>
			                <th>课程名字</th>
			                <th>教师姓名</th>
			                <th>容量 </th>
			                <th>上课时间</th>
			                <th>上课周 </th>
			                <th>教室 </th>
			                <th>操作 </th>
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
			$('#staticAdd').on('hidden.bs.modal', function () {
				$('#myProId').val(0);
				$('#staticAddForm')[0].reset();
			})
		} );
		
		
		//加载列表
		function loadProList(){
			$('#proListTable').dataTable( {
				"ajax": {
				    "url": "${pageContext.request.contextPath}/base/section_queryList",
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
                    { "data": "sectionNo"},   
                    { "data": "representedCourse"},  
                    { "data": "instructor"},  
                    { "data": "seatingCapacity"},
                    { "data": "timeOfDay"},  
                    { "data": "dayOfWeek"},  
                    { "data": "room"},
                    { "data": null}
                ],
                "columnDefs": [ {
		            "targets": -1,//最后一列
		            "data": null,
		            render: function(data, type, row, meta) {
		            var showHtml='<button class="btn  green" onclick="choseCourse('+row.id+')">'
                                      +          	'<i class="fa fa-edit">选课 </i>'
                                      +      '</button>'           
		            
			            return showHtml;

			        }
		        } ],			        
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
		
		//选课
		function choseCourse(id){
        	$.ajax({    
                url:'${pageContext.request.contextPath}/base/student_chooseCourse',
                method:'POST',
                dataType:"json",
                data:{
                	sectionId:id
                    },	  
                success:function(data){   
                    if(data.status=="ok"){
						successModal();
                    }else{
                    	 errorModal();
                    }
                }
            })
		}
		
		
		//编辑
		function alterPro(id){
        	$.ajax({    
                url:'${pageContext.request.contextPath}/base/section_getProfessorById',
                method:'POST',
                dataType:"json",
                data:{
                		id:id
                    },	  
                success:function(data){   
                    if(data.status=="ok"){
                    	$('#myProId').val(data.data.id)
    					//$('#ssn').val(data.data.ssn);                         
                        addPro();
                    }else{
                    	 errorModal();
                    }
                }
            })
		}
		
	
		
		
	</script>      		

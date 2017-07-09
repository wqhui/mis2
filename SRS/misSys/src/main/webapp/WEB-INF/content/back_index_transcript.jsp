<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>           
<%@taglib prefix="s" uri="/struts-tags"%> 


<!-- BEGIN CONTENT BODY -->
     <div class="page-content">
         <!-- BEGIN PAGE HEADER-->                  
         <!-- BEGIN PAGE TITLE-->
         <h3 class="page-title"> 
            	 课程管理
         </h3>
         <!-- END PAGE TITLE-->
         <!-- END PAGE HEADER-->
		 <!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box green">
		    <div class="portlet-title">
		        <div class="caption">
		            <i class="fa fa-globe"></i>我的课程 </div>
		    </div>
		    
		    <div class="portlet-body" id="">
				<table id="proListTable" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>课程编号</th>			                
			                <th>课程名字</th>
			                <th>课程类别</th>
			                <th>学分 </th>
			                <th>操作 </th>
			            </tr>
			        </thead>
			
			    </table>
			</div>
				  
		    
		</div>
		<!-- END EXAMPLE TABLE PORTLET-->  	

     </div>
<!-- END CONTENT BODY -->


<!--Modals-->
<div id="staticAdd" class="modal fade bs-modal-lg modal-scroll" tabindex="-1" data-backdrop="static" data-keyboard="false" >
      <div class="modal-dialog modal-lg" >
          <div class="modal-content">
             <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                  <h4 class="modal-title"><span id="mySectionCourseName"></span>录入成绩</h4>
              </div>
              <div class="modal-body">
              	  <input id="mySectionId" type="hidden" value="0">
	               	<table id="courseListTablePre" class="display" cellspacing="0" width="100%">
				        <thead>
				            <tr>
				                <th>学生编号</th>			                
				                <th>学生名字</th>
				                <th>成绩 </th>
				                <th>操作 </th>
				            </tr>
				        </thead>			
			    	</table>                                                                                                                                
               </div>               
         </div>
     </div>
</div>
<!--End Modals-->



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
				$('#mySectionId').val(0);
				
			})
		} );
		
		
		
		function loadProList(){
			$('#proListTable').dataTable( {
				"ajax": {
				    "url": "${pageContext.request.contextPath}/base/section_queryListByProfessor",
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
                    { "data": "courseNo"},   
                    { "data": "courseName"},                     
                    { "data": "courseCatalogName"},
                    { "data": "credits"},  
                    { "data": null}
                ],
                "columnDefs": [ {
		            "targets": -1,//最后一列
		            "data": null,
		            render: function(data, type, row, meta) {

		            var showHtml='<button class="btn  green" onclick="getModal('+row.sectionId+',\''+row.courseName+'\')">'
                                      +          	'<i class="fa fa-edit">录入成绩 </i>'
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
		

		
		

		
		//录入成绩  打开模态框
		function getModal(sectionId,courseName){
			loadStuList(sectionId);
			$('#mySectionCourseName').html("《"+courseName+"》")
			$('#staticAdd').modal('show');
			
		}
		
		
		function loadStuList(sectionId){
			$('#courseListTablePre').dataTable({
				"ajax": {
				    "url": "${pageContext.request.contextPath}/base/section_queryStuMsgListById",
				    "type": "POST",
				    "data":{
				    	"id":sectionId
				    }
				},
			  	"deferRender": true,
			  	"searching": true,
			  	"autoWidth": true,
			  	"processing": true,
			  	"destroy": true,//如果需要重新加载的时候请加上这个
		        "columns": [
                    { "data": "ssn"},   
                    { "data": "realName"},                     
                    { "data": "grade"},
                    { "data": null}
                ],
                "columnDefs": [ {
			            "targets": -1,//最后一列
			            "data": null,
			            render: function(data, type, row, meta) {
			            	var showHtml=''
			            	if(row.grade==""){
				            	showHtml='<button class="btn  green" onclick="setModal('+row.studentId+','+row.sectionId+')">'
	                            +          	'<i class="fa fa-ok">确认提交 </i>'
	                            +      '</button>' 
			            	}else{

			            	}         		            
				            return showHtml;
	
				        }
		        	}, {
			            "targets": 2,//
			            "data": "grade",
			            render: function(data, type, row, meta) {
			            	var showHtml=''
			            	if(row.grade==""){
			            		showHtml='<input id="stuGrade'+row.studentId+'" type="text"  value>'
			            	}else{
			            		showHtml=row.grade;
			            	}         		            
				            return showHtml;
	
				        }
		        	}
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
		
		function setModal(studentId,sectionId){
			var inputId="#stuGrade"+studentId;
			var inputValue=$(inputId).val();
			if(typeof(inputValue)!="undefined" && inputValue!=""){
	        	$.ajax({    
	                url:'${pageContext.request.contextPath}/base/transcriptEntry_setGradeByStu',
	                method:'POST',
	                dataType:"json",
	                data:{
	                	studentId:studentId,
	                	grade:inputValue,
	                	sectionId:sectionId
	                 },	  
	                success:function(data){   
	                    if(data.status=="ok"){
	                    	 loadStuList();
	                    	 successModal();		
	                    }else{
	                    	 errorModal();
	                    }
	                }
	            })	
			}else{
				errorModal();
			}									
		}
		
		
	</script>      		

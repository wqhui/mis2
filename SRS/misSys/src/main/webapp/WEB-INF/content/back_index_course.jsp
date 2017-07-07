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
		            <i class="fa fa-globe"></i>课程列表 </div>
		        <div class="actions">
		            <a href="javascript:;" onClick="addCourse()" class="btn dark btn-outline sbold uppercase">
		                <i class="fa fa-plus"></i> 新增课程 </a>
		        </div>
		    </div>
		    
		    <div class="portlet-body" id="">
				<table id="courseListTable" class="display" cellspacing="0" width="100%">
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
                  <h4 class="modal-title">新增课程</h4>
              </div>
              <div class="modal-body">
              	  <input id="myProId" type="hidden" value="0">
	              <!-- BEGIN FORM-->
	              <form id="staticAddForm" class="form-horizontal form">
                       <div class="form-body">
                           <div class="alert alert-danger display-hide">
                               <button class="close" data-close="alert"></button> 请按照要求填写信息。</div>
                           <div class="alert alert-success display-hide">
                               <button class="close" data-close="alert"></button> 成功! </div> 
                             
                          <div class="form-group">
                               <label class="control-label col-md-3">课程编号
                                   <span class="required"> * </span>
                               </label>
                               <div class="col-md-6">
                                   <div class="input-icon right">
                                       <i class="fa"></i>
                                       <input type="text" id="courseNo" name="courseNo" data-required="1" class="form-control"  value=""/> 
                                   </div>  
                                   <span class="help-block">课程编号，不能为空</span>    
                               </div>
                           </div>
                           
                           <div class="form-group">
                               <label class="control-label col-md-3">课程名字
                                   <span class="required"> * </span>
                               </label>
                               <div class="col-md-6">
                                   <div class="input-icon right">
                                       <i class="fa"></i>
                                       <input type="text" id="courseName" name="courseName" data-required="1" class="form-control"  value=""/> 
                                   </div>  
                                   <span class="help-block">课程名字，不能为空</span>    
                               </div>
                           </div>
                           
                           <div class="form-group">
                               <label class="control-label col-md-3">选择课程类别
                                   <span class="required"> * </span>
                               </label>
                               <div class="col-md-6">
                                   <div class="input-icon right">
                                       <i class="fa"></i>      			                                                                                                                    
                                       <select class="form-control" name="curseCatalog" id="curseCatalog">
                                               <option value=""></option>                                                                                                                                   
                               			</select>                                                       
                                   </div>  
                                   <span class="help-block">课程类别，不能为空</span>   
                               </div>
                           </div> 
 
 						   <div class="form-group">
                               <label class="control-label col-md-3">选择学分
                                   <span class="required"> * </span>
                               </label>
                               <div class="col-md-6">
                                   <div class="input-icon right">
                                       <i class="fa"></i>      			                                                                                                                    
                                       <select class="form-control" name="credits" id="credits">
                                               <option value=""></option>  
                                               <option value="0.5">0.5</option>  
                                               <option value="1">1</option>  
                                               <option value="1.5">1.5</option>  
                                               <option value="2">2</option>  
                                               <option value="2.5">2.5</option>  
                                               <option value="3">3</option>  
                                               <option value="3.5">3.5</option>  
                                               <option value="4.5">4</option>  
                                               <option value="5">5</option> 
                                               <option value="5.5">5.5</option> 
                                               <option value="6">6</option> 
                                               <option value="6.5">6.5</option>   
                                               <option value="7">7</option> 
                                               <option value="7.5">7.5</option> 
                                               <option value="8">8</option>                                                                                                                              
                               			</select>                                                       
                                   </div>  
                                   <span class="help-block">课程学分，不能为空</span>   
                               </div>
                           </div> 
 							                                                                                  
                       </div>
                       <div class="form-actions right">
                           <button type="button" data-dismiss="modal" class="btn dark btn-outline ">取消</button>
                       		<button type="submit" class="btn green"> 提交</button>
                       </div>

     						
                   </form>
                   <!-- END FORM-->                                                                                                                                    
               </div>
               

         </div>
     </div>
</div>
<!--End Modals--> 

<!--Modals-->
<div id="coursePreAdd" class="modal fade bs-modal-lg modal-scroll" tabindex="-1" data-backdrop="static" data-keyboard="false" >
      <div class="modal-dialog modal-lg" >
          <div class="modal-content">
             <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                  <h4 class="modal-title"><span id="coursePreAddName"></span>添加先修课程</h4>
              </div>
              <div class="modal-body">
              	  <input id="myCourseId" type="hidden" value="0">
	               	<table id="courseListTablePre" class="display" cellspacing="0" width="100%">
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
			submitAddPro();
			loadCurseCatalogList();
			$('#staticAdd').on('hidden.bs.modal', function () {
				$('#myProId').val(0);
				$('#staticAddForm')[0].reset();
			})			
			$('#coursePreAdd').on('hidden.bs.modal', function () {
				$('#myCourseId').val(0);				
			})
			
		} );
		
		
		//加载列表
		function loadProList(){
			$('#courseListTable').dataTable( {
				"ajax": {
				    "url": "${pageContext.request.contextPath}/base/course_queryList",
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
			            var showHtml='<button class="btn  green" onclick="alterCourse('+row.id+')">'
				                        +          	'<i class="fa fa-edit">编辑 </i>'
				                        +      '</button>'
				                        +      ' '
				                        +		 '<button class="btn  green" onclick="addPreCourse('+row.id+',\''+row.courseName+'\')">'
				                        +          	'<i class="fa fa-add">添加先修课程 </i>'
				                        +      '</button>'
				                        +      ' '
				                        +  	 '<button  class="btn red"onclick="deleteCourse('+row.id+')">'
				                        +  			'<i class="fa fa-times">删除</i>'
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
		
		
		//加载 类别
		function  loadCurseCatalogList(){
			$.ajax({    
                url:'${pageContext.request.contextPath}/base/courseCatalog_queryList',
                method:'POST',
                dataType:"json",
                data:{
                    },	  
                success:function(data){  
                	var html="";
					for(var i=0;i<data.recordsTotal;i++){
						html=html+'<option value="'+data.data[i].id+'">'+data.data[i].catalogName+'</option>'
						
					}
					$('#curseCatalog').append(html)	
                }
            })
		}
		
		//删除课程
		function deleteCourse(id){
        	$.ajax({    
                url:'${pageContext.request.contextPath}/base/course_deleteCourse',
                method:'POST',
                dataType:"json",
                data:{
                		id:id
                    },	  
                success:function(data){    
                        if(data.status=="ok"){
                        	loadProList();
                        	successModal();
                        }else{
                        	deleteCourseErrorModal();
                        }
                }
            })
		}
		
		
		//编辑课程
		function alterCourse(id){
        	$.ajax({    
                url:'${pageContext.request.contextPath}/base/course_getCourseById',
                method:'POST',
                dataType:"json",
                data:{
                		id:id
                    },	  
                success:function(data){   
                    if(data.status=="ok"){
                    	$('#myProId').val(data.data.id)
    					$('#courseNo').val(data.data.courseNo);
    					$('#courseName').val(data.data.courseName);
    					$('#credits').val(data.data.credits);
    					$('#curseCatalog').val(data.data.id);                         
    					addCourse();
                    }else{
                    	 errorModal();
                    }
                }
            })
		}
		
		//打开模态框
		function addCourse(){
			$('#staticAdd').modal('show')
		}
		
		//提交课程信息
		function submitAddPro(){			
			var form2 = $('#staticAddForm');
            var error2 = $('.alert-danger', form2);
            var success2 = $('.alert-success', form2);			
            form2.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input
                rules: {
                	courseNo: {
                        required: true
                    },
                    courseName: {
                        required: true
                    },
                    credits: {
                        required: true
                    },
                    curseCatalog: {
                        required: true
                    },
                },
                invalidHandler: function (event, validator) { //display error alert on form submit              
                    success2.hide();
                    error2.show();
                    App.scrollTo(error2, -200);
                },

                errorPlacement: function (error, element) { // render error placement for each input type
                    var icon = $(element).parent('.input-icon').children('i');
                    icon.removeClass('fa-check').addClass("fa-warning");  
                    icon.attr("data-original-title", error.text()).tooltip({'container': 'body'});
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.form-group').removeClass("has-success").addClass('has-error'); // set error class to the control group   
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    
                },

                success: function (label, element) {
                    var icon = $(element).parent('.input-icon').children('i');
                    $(element).closest('.form-group').removeClass('has-error').addClass('has-success'); // set success class to the control group
                    icon.removeClass("fa-warning").addClass("fa-check");
                    	
                },

                submitHandler: function (form) {
                	var myProId=$('#myProId').val();
					var courseNo=$('#courseNo').val();
					var courseName=$('#courseName').val();
					var credits=$('#credits').val();
					var curseCatalogId=$('#curseCatalog').val();
	            	$.ajax({    
	                        url:'${pageContext.request.contextPath}/base/course_saveOrUpdateCourse',
	                        method:'POST',
	                        dataType:"json",
	                        data:{
	                        	id:myProId,
	                        	courseNo:courseNo,
	                        	courseName:courseName,
	                        	credits:credits,
	                        	curseCatalogId:curseCatalogId
	                            },	  
	                        success:function(data){    
	                                if(data.status=="ok"){
	                                	loadProList();
	                                	successModal();
	                                	$('#staticAdd').modal('hide');
	                                }else{
	                                	 errorModal();
	                                }
			                }
		                })
                 
	                return false; // 阻止表单自动提交事件
	                
                }
            });
		}
		
		//添加先修课程
		function addPreCourse(id,courseName){	
			$('#myCourseId').val(id);
			loadPreCourseList(id,courseName);
			$('#coursePreAdd #coursePreAddName').html('《'+courseName.replace(/'/g,"")+'》');
			$('#coursePreAdd').modal('show');
			
			
			
		}
		
		
		//加载先修列表
		function loadPreCourseList(id){
			$('#courseListTablePre').dataTable( {
				"ajax": {
				    "url": "${pageContext.request.contextPath}/base/course_queryListPre",
				    "type": "POST",
				    "data": {
				    	"id":id
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
		            	var showHtml='';
		            	if(row.id==id){
				            showHtml ='<button class="btn  green" disabled=true>'
                             +    '<i class="fa fa-edit">课程本身</i>'
                             +    '</button>' 
		            	}else{
					         showHtml ='<button class="btn  green" onclick="setPreCourse('+row.id+')">'
	                          +          	'<i class="fa fa-edit">设为先修课程</i>'
	                          +      '</button>' 
		            	}
           
		            
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
		
		
		//设置为先修课
		function setPreCourse(preId){
			var id=$('#myCourseId').val();
        	$.ajax({    
                url:'${pageContext.request.contextPath}/base/course_setPreCourse',
                method:'POST',
                dataType:"json",
                data:{
                	id:id,
                	preId:preId
                    },	  
                success:function(data){    
                        if(data.status=="ok"){
                        	loadPreCourseList(id);
                        	successModal();
                        }else{
                        	 errorModal();
                        }
                }
            })
		}
		
		
		function deleteCourseErrorModal(){
			swal({
				title: "删除出错",
				text: '删除对该课程的相关引用才能删除该课程！',
				type: "error",
				confirmButtonText: "确认"  
			});	
		}
	</script>      		

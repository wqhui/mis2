<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/public/website-head.jspf"%>
<title>guitar</title>
</head>
<body>
    <center><h3 id="guitarTitle">查询guitar</h3></center>
    <hr>
    <div id="resultGuitarList">
    </div>
    <div class="container">
       <div class="container">
        <div class="row">
            <div class="col-xs-12 col-md-3 col-sm-4">
        		<%@include file="/public/head.jsp"%>
        	</div>
            <div class="col-xs-12 col-md-9 col-sm-8">
            	<table class="table table-striped table-hover">
		          <thead>
		            <tr>
		              <th>类型</th>
		              <th>型号</th>
		              <th>价格</th>
		              <th>厂商</th>
		              <th>背板</th>
		              <th>指板</th>
		              <th>操作</th>
		            </tr>
		          </thead>
		          <tbody id="listBody">
		
		          </tbody>
		        </table> 
            </div>
        
        </div>
           
    </div>  
     </div>   
</body>
<script type="text/javascript">


$(function(){
	loadData();	
}) 
 
    	
function loadData(){
	$.ajax({	
    	url:'${pageContext.request.contextPath}/base/guitar_queryAllGuitarList.action',
    	type:'POST',
    	dataType:'json',
    	data:{

    	},
    	success:function(data){ 
    		console.log(data);
    		var html='';
			for(var i=0;i<data.length;i++){
				html=html+'<tr>'
				         +    '<td>'+data[i].type+'</td>'
				         +    '<td>'+data[i].model+'</td>'
				         +    '<td>'+data[i].price+'</td>'
				         +    '<td>'+data[i].builder+'</td>'
				         +    '<td>'+data[i].backWood+'</td>'
				         +    '<td>'+data[i].topWood+'</td>'
				         +    '<td><a type="button" class="btn btn-danger" role="button" href="javascript:;" onclick="deleteData('+data[i].id+')">删除</a></td>'
				         +  '</tr>'
				
			}
			
			$('#listBody').html(html);

    	},
    })		
} 
		    
function deleteData(id){
	$.ajax({	
    	url:'${pageContext.request.contextPath}/base/guitar_deleteGuitar.action',
    	type:'POST',
    	dataType:'json',
    	data:{
			id:id
    	},
    	success:function(data){ 
    		if(data.status==="ok"){
    			loadData();		
    		}else{
    			alert("删除失败！")  	
    		}
    		
    	},
    })	
}
 
</script>

</html>
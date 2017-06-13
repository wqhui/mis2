<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/public/website-head.jspf"%>
<title>插入guitar</title>
</head>
<body>
	
    <center><h3>插入guitar</h3></center>
    <hr>
    <div class="container">
        <div class="row">
        	<div class="col-xs-12 col-md-3 col-sm-4">
        		<%@include file="/public/head.jsp"%>
        	</div>
            <div class="col-xs-12 col-md-9 col-sm-8">
			<form class="form-horizontal" role="form">
                 <div id="error" style="display:none">
                        <div><p class="bg-info" style="padding:15px 10px"></p>   </div>
                                        
                  </div>
                  <div class="form-group">
                    <label for="price" class="col-sm-2 control-label">价格：</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="price" placeholder="">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="builder" class="col-sm-2 control-label">厂商：</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="builder" id="builder">
        				  <option value="JIANGSU">江苏</option>
        				  <option value="BEIJING">北京</option>
        				  <option value="GUANGZHOU">广州</option>
        				</select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="model" class="col-sm-2 control-label">型号：</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="model" value="0" readonly>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="type" class="col-sm-2 control-label">类型：</label>
                    <div class="col-sm-10">
                      	<select class="form-control" name="type" id="type">
        				  <option value="ACOUSTIC">木制</option>
        				  <option value="ELECTRIC">电吉他</option>
        				  <option value="UNSPECIFIED">未指定</option>
        				</select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="backWood" class="col-sm-2 control-label">背板：</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="backWood" id="backWood">
        				  <option value="CAMPHOR">樟木</option>
        				  <option value="BRICH">桦木</option>
        				  <option value="KOREANPINE">红松</option>
        				</select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="topWood" class="col-sm-2 control-label">指板：</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="topWood" id="topWood">
        				  <option value="CAMPHOR">樟木</option>
        				  <option value="BRICH">桦木</option>
        				  <option value="KOREANPINE">红松</option>
        				</select>
                    </div>
                  </div>
                </form>
            </div>
            <div class="col-xs-10 col-md-4 col-md-offset-6 col-sm-4 col-sm-offset-6">
                <button type="button" class="btn btn-primary btn-block" onclick="submitSearch()">插入</button>
            </div>       
        </div>
     </div>   
     
</body>
<script type="text/javascript">
 function submitSearch(){
	    var price=$('#price').val();
	    var builder=$('#builder').val();
	    var model=$('#model').val();
	    var type=$('#type').val();
	    var backWood=$('#backWood').val();
	    var topWood=$('#topWood').val();
	    if(price=="" || builder=="" || model=="" || type=="" || backWood=="" || topWood==""){
	    	$("#error p").html("请保证不为空！");
        	$('#error').fadeIn('slow');
			setTimeout(function(){
				$('#error').fadeOut('slow');
			},2000)
	    }else{	    	
	    	$.ajax({	
		    	url:'${pageContext.request.contextPath}/base/guitar_save.action',
		    	type:'POST',
		    	data:{
		    		price:price,	 
		    		builder:builder,
		    		guitarModel:model,
		    		type:type,
		    		backWood:backWood,
		    		topWood:topWood
		    	},
		    	success:function(data){    
		    		$("#error p").html('插入成功！');
		        	$('#error').fadeIn('slow');
					setTimeout(function(){
						$('#error').fadeOut('slow');
					},2000);	
		    	},
		    	error:function(data){
		    		$("#error p").html('插入失败！');
		        	$('#error').fadeIn('slow');
					setTimeout(function(){
						$('#error').fadeOut('slow');
					},2000);		    		
		    	}
		    })	 
		    
	    }
	    
 }
</script>

</html>
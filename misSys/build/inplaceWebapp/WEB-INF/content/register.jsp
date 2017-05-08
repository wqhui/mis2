<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>

</head>
<body>
    <center><h3>请注册</h3></center>
    <div>    
        <form>
            <input type="text" id="username" name="username"/>
            <input type="password" id="password"  name="password"/>
            <a type="button" onclick="submit()">注册</a>
        </form>    
    </div>
</body>
<script type="text/javascript">
//发送请求
function submit(){
    var username=$("#username").val();
    var password=$("#password").val();
    $.ajax({
        url:'${pageContext.request.contextPath}/base/person_register.action',
        type:'POST',
        dataType:'json',
        data:{
        	username:username,
        	password:password
        },
        success:function(data){    
            alert("ok");
        },
        error:function(){

        },
    });
}
</script>
</html>
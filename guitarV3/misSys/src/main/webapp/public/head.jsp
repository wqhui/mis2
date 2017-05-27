<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>           

<div class="list-group">
    <a href="list" class="list-group-item" id="listUrl">
        <h4 class="list-group-item-heading">
            guitar列表
        </h4>
    </a>
    <a href="search" class="list-group-item" id="searchUrl">
        <h4 class="list-group-item-heading">
            guitar查询
        </h4>
    </a>
    <a href="insert" class="list-group-item" id="insertUrl">
        <h4 class="list-group-item-heading">
            guitar插入
        </h4>
    </a>
</div>

<script type="text/javascript">
	$(function(){
		var url=window.location.pathname;
		if(url.indexOf('search')>0){
			$('#searchUrl').addClass("active")	
		}else if(url.indexOf('insert')>0){
			$('#insertUrl').addClass("active")		
		}else if(url.indexOf('list')>0){
			$('#listUrl').addClass("active")			
		}else{
			
		}
	})
</script>
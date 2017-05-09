<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <div class="container">
        <div class="row">
            <div class="col-xs-12">
            
            </div>
        
        </div>
        <table class="table table-striped table-hover">
          <thead>
            <tr>
              <th>类型</th>
              <th>型号</th>
              <th>价格</th>
              <th>厂商</th>
              <th>背板</th>
              <th>指板</th>
            </tr>
          </thead>
          <tbody>
          	<s:iterator value="guitarList" var="gList">
	          	<tr>
	              <td>${gList.type}</td>
	              <td>${gList.model}</td>
	              <td>${gList.price}</td>
	              <td>${gList.builder}</td>
	              <td>${gList.backWood}</td>
	              <td>${gList.topWood}</td>
	            </tr>
          	</s:iterator>
          </tbody>
        </table>    
    </div>
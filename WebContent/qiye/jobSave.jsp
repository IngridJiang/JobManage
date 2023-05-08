<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function checkForm(){
		var name=document.getElementById("name").value;
		var jiancheng=document.getElementById("jiancheng").value;
		
		if(name==""||jiancheng==""){
			document.getElementById("error").innerHTML="信息填写不完整！";
			return false;
		} 
		return true;
	}
	
	$(document).ready(function(){
		$("ul li:eq(2)").addClass("active");
	});
</script>
<div class="data_list">
		<div class="data_list_title">
		<c:choose>
			<c:when test="${job.uuid!=null }">
				修改职位
			</c:when>
			<c:otherwise>
				添加职位
			</c:otherwise>
		</c:choose>
		</div>
    
                
    <form action="jq?action=save" method="post" onsubmit="return checkForm()">
			
                    <div class="data_form" >
				<input type="hidden" id="uuid" name="uuid" value="${job.uuid }"/>
                       
                       
                                <c:choose>
			<c:when test="${job.uuid!=null }">
                            <input type="hidden" id="jiancheng" name="comid" value="${job.comid }"/>
                            <input type="hidden" id="jiancheng" name="jiancheng" value="${job.jiancheng }"/>
				<table align="center">
			</c:when>
			<c:otherwise>
				<table align="center">
						<tr>
							<td><font color="red">*</font>企业ID：</td>
							<td><input type="text" id="comid"  name="comid"  value="${job.comid }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>企业简称：</td>
							<td><input type="text" id="jiancheng"  name="jiancheng"  value="${job.jiancheng }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
			</c:otherwise>
		</c:choose>
					
                                            
                                            
                                            
                                            <tr>
							<td><font color="red">*</font>职位名称：</td>
							<td><input type="text" id="name"  name="name"  value="${job.name }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>城市：</td>
							<td><input type="text" id="city"  name="city"  value="${job.city }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>薪资：</td>
							<td><input type="text" id="money"  name="money"  value="${job.money }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>职位描述：</td>
							<td><input type="text" id="des"  name="des"  value="${job.des }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>企业邮箱：</td>
							<td><input type="text" id="email"  name="email"  value="${job.email }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                               
                                                <tr>
							<td><font color="red">*</font>类别：</td>
							<td><input type="text" id="leibie"  name="leibie"  value="${job.leibie }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                
				
		
                                                
		
					</table>
					<div align="center">
						<input type="submit" class="btn btn-primary" value="保存"/>
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='jq'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		</form>
</div>

    
    
    
   
                                
		
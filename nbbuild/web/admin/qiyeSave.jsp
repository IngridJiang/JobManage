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
		var quancheng=document.getElementById("quancheng").value;
		var jiancheng=document.getElementById("jiancheng").value;
		
		if(quancheng==""||jiancheng==""){
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
			<c:when test="${qiye.comid!=null }">
				修改企业
			</c:when>
			<c:otherwise>
				添加企业
			</c:otherwise>
		</c:choose>
		</div>
   
		<form action="q?action=save" method="post" onsubmit="return checkForm()">
			
                    <div class="data_form" >
				<input type="hidden" id="comid" name="comid" value="${qiye.comid }"/>
                       
                                
					<table align="center">
						<tr>
							<td><font color="red">*</font>企业全称：</td>
							<td><input type="text" id="quancheng"  name="quancheng"  value="${qiye.quancheng }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>企业简称：</td>
							<td><input type="text" id="jiancheng"  name="jiancheng"  value="${qiye.jiancheng }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>信用代码：</td>
							<td><input type="text" id="xindai"  name="xindai"  value="${qiye.xindai }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>企业描述：</td>
							<td><input type="text" id="descrip"  name="descrip"  value="${qiye.descrip }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>企业邮箱：</td>
							<td><input type="text" id="email"  name="email"  value="${qiye.email }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>在线职位数：</td>
							<td><input type="text" id="zaixianNum"  name="zaixianNum"  value="${qiye.zaixianNum }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>主账号电话：</td>
							<td><input type="text" id="qh"  name="qh"  value="${qiye.qh }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>城市：</td>
							<td><input type="text" id="city"  name="city"  value="${qiye.city }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
			
				
		
                                                
		
					</table>
					<div align="center">
						<input type="submit" class="btn btn-primary" value="保存"/>
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='q'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		</form>
</div>

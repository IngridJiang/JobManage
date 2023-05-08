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
		var city=document.getElementById("city").value;
		var tel=document.getElementById("tel").value;
		
		if(city==""||tel==""){
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
			<c:when test="${jianli.jianliid!=null }">
				修改和查看简历
			</c:when>
			<c:otherwise>
				添加简历
			</c:otherwise>
		</c:choose>
		</div>
    
                
    <form action="jg?action=save" method="post" onsubmit="return checkForm()">
			
                    <div class="data_form" >
		<input type="hidden" id="jianliid" name="jianliid" value="${jianli.jianliid }"/>
                       
                       
                                
					<table align="center">
						<tr>
							<td><font color="red">*</font>学生ID：</td>
							<td><input type="text" id="studentId"  name="studentId"  value="${jianli.studentId }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                            
                                            <tr>
							<td><font color="red">*</font>电话：</td>
							<td><input type="text" id="tel"  name="tel"  value="${jianli.tel }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                            
                                            <tr>
							<td><font color="red">*</font>性别：</td>
							<td><input type="text" id="sex"  name="sex"  value="${jianli.sex }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>城市：</td>
							<td><input type="text" id="city"  name="city"  value="${jianli.city }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>邮箱：</td>
							<td><input type="text" id="email"  name="email"  value="${jianli.email }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>教育经历：</td>
							<td><input type="text" id="jyjl"  name="jyjl"  value="${jianli.jyjl }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>项目经历：</td>
							<td><input type="text" id="xm"  name="xm"  value="${jianli.xm }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                               
                                                <tr>
							<td><font color="red">*</font>实习经历：</td>
							<td><input type="text" id="sx"  name="sx"  value="${jianli.sx }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>学术经历：</td>
							<td><input type="text" id="xs"  name="xs"  value="${jianli.xs }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
				<tr>
							<td><font color="red">*</font>获奖经历：</td>
							<td><input type="text" id="hj"  name="hj"  value="${jianli.hj }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>作品链接：</td>
							<td><input type="text" id="zp"  name="zp"  value="${jianli.zp }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
		<tr>
							<td><font color="red">*</font>兴趣爱好：</td>
							<td><input type="text" id="xq"  name="xq"  value="${jianli.xq }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                <tr>
							<td><font color="red">*</font>个人总结：</td>
							<td><input type="text" id="grzj"  name="grzj"  value="${jianli.grzj }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                
		
					</table>
					<div align="center">
						<input type="submit" class="btn btn-primary" value="保存"/>
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='jg'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		</form>
</div>

    
    
    
   
                                
		
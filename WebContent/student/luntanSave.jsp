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
		var contain=document.getElementById("contain").value;
		
		
		if(contain==""){
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
			<c:when test="${luntan.id!=null }">
				修改帖子
			</c:when>
			<c:otherwise>
				添加帖子
			</c:otherwise>
		</c:choose>
		</div>
   
		<form action="luntan?action=save" method="post" onsubmit="return checkForm()">
			
                    <div class="data_form" >
				<input type="hidden" id="id" name="id" value="${luntan.id }"/>
                               
                       <input type="hidden" id="student" name="student" value="${currentUser.userName }"/>
                                
					<table align="center">
						<tr>
							<td><font color="red">*</font>内容：</td>
							<td><input type="text" id="contain"  name="contain"  value="${luntan.contain }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                              <c:choose>
                     <c:when test="${luntan.id!=null }">
				<td><input type="hidden" id="nimingornot"  name="nimingornot"  value="${luntan.nimingornot }"  style="margin-top:5px;height:30px;" /></td>
			</c:when>
			<c:otherwise>
				       <tr>
							
                                                    
                                                    
                                                    <td> <select class="form-control" name="nimingornot" id="nimingornot">
        
                                     <option value="1">匿名</option>
                                                     <option value="0">不匿名</option></select>
 
                                                            </td>
                                                        
						</tr>
			</c:otherwise>
		           
                                                </c:choose>    
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                         
                                               
                                                <c:choose>
                     <c:when test="${luntan.id!=null }">
				<td><input type="hidden" id="zhuti"  name="zhuti"  value="${luntan.zhuti }"  style="margin-top:5px;height:30px;" /></td>
			</c:when>
			<c:otherwise>
				<tr>
							<td><font color="red">*</font>主题：</td>
							<td><select class="form-control" name="zhuti" id="zhuti">
        
                                       <option value="bank">银行</option>
                                    <option value="IT">IT</option>
                                   <option value="jg">金融公司</option>
                                     <option value="zhengquan">证券</option>
      
    </select></td>
                                                        
						</tr>
			</c:otherwise>
		           
                                                </c:choose>                        
		
					</table>
					<div align="center">
						<input type="submit" class="btn btn-primary" value="保存"/>
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='luntan'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		</form>
</div>

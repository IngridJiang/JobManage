<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function checkForm(){
		var contain=document.getElementById("contain").value;
		var adminName=document.getElementById("adminName").value;
		
		if(contain==""||adminName==""){
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
			<c:when test="${gonggao.id!=null }">
				修改公告
			</c:when>
			<c:otherwise>
				添加公告
			</c:otherwise>
		</c:choose>
		</div>
		<form action="gonggao?action=save" method="post" onsubmit="return checkForm()">
			<div class="data_form" >
				<input type="hidden" id="id" name="id" value="${gonggao.id }"/>
                                <input type="hidden" id="adminName" name="adminName" value="${currentUser.userName }"/>
					<table align="center">
						<tr>
							<td><font color="red">*</font>内容：</td>
							<td><input type="text" id="contain"  name="contain"  value="${gonggao.contain }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
						
					</table>
					<div align="center">
						<input type="submit" class="btn btn-primary" value="保存"/>
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='gonggao'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		</form>
</div>

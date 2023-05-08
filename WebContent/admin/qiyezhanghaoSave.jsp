<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function checkForm(){
		var userName=document.getElementById("userName").value;
		var password=document.getElementById("password").value;
		var rPassword=document.getElementById("rPassword").value;
		var comid=document.getElementById("comid").value;
		var mainornot=document.getElementById("mainornot").value;
		
		if(userName==""||password==""||rPassword==""||comid==""||mainornot==""){
			document.getElementById("error").innerHTML="信息填写不完整！";
			return false;
		} else if(password!=rPassword){
			document.getElementById("error").innerHTML="密码填写不一致！";
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
			<c:when test="${qiyezhanghao.qhId!=null }">
				修改企业账号信息
			</c:when>
			<c:otherwise>
				添加企业账号
			</c:otherwise>
		</c:choose>
		</div>
		<form action="qiyezhanghao?action=save" method="post" onsubmit="return checkForm()">
			<div class="data_form" >
				<input type="hidden" id="qhId" name="qhId" value="${qiyezhanghao.qhId }"/>
					<table align="center">
						<tr>
							<td><font color="red">*</font>电话：</td>
							<td><input type="text" id="userName"  name="userName" value="${qiyezhanghao.userName }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>密码：</td>
							<td><input type="password" id="password"  name="password" value="${qiyezhanghao.password }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>重复密码：</td>
							<td><input type="password" id="rPassword"  name="rPassword" value="${qiyezhanghao.password }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>企业ID：</td>
							<td><input type="text" id="comid"  name="comid" value="${qiyezhanghao.comid }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>账号类型：</td>
							<td>
								<select id="mainornot" name="mainornot" style="width: 90px;">
									<option value="">请选择...</option>
									<option value="1" ${qiyezhanghao.mainornot eq "1"?'selected':'' }>主账号</option>
									<option value="0" ${qiyezhanghao.mainornot eq "0"?'selected':'' }>子账号</option>
								</select>
							</td>
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

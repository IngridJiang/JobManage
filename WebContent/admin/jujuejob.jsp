<<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function checkForm(){
		var beizhu=document.getElementById("beizhu").value;
		
		
		if(beizhu==""){
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
		
				拒绝理由
			
		</div>
   
		<form action="js?action=save" method="post" onsubmit="return checkForm()">
			
                    <div class="data_form" >
				<input type="hidden" id="comid" name="comid" value="${job.comid }"/>
                       <input type="hidden" id="uuid" name="uuid" value="${job.uuid }" />
                             <input type="hidden" id="jiancheng" name="jiancheng" value="${job.jiancheng }"/> 
                             <input type="hidden" id="money" name="mooney" value="${job.money }"/>
                             <input type="hidden" id="des" name="des" value="${job.des }"/>
                             <input type="hidden" id="email" name="email" value="${job.email }"/>
                             <input type="hidden" id="shenhe" name="shenhe" value="${job.shenhe }"/>
                             <input type="hidden" id="name" name="name" value="${job.name }"/>
                             <input type="hidden" id="city" name="city" value="${job.city }"/>
                             <input type="hidden" id="leibie" name="leibie" value="${job.leibie }"/>
					<table align="center">
						<tr>
							<td><font color="red">*</font>拒绝理由：</td>
							<td><input type="text" id="beizhu"  name="beizhu"  value="${job.beizhu }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                
		
					</table>
					<div align="center">
						<input type="submit" class="btn btn-primary" value="保存"/>
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='js'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		</form>
</div>

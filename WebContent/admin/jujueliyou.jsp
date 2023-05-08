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
   
		<form action="qiyeshenhe?action=save" method="post" onsubmit="return checkForm()">
			
                    <div class="data_form" >
				<input type="hidden" id="comid" name="comid" value="${qiye.comid }"/>
                       <input type="hidden" id="quancheng" name="quancheng" value="${qiye.quancheng }"/>
                             <input type="hidden" id="jiancheng" name="jiancheng" value="${qiye.jiancheng }"/> 
                             <input type="hidden" id="xindai" name="xindai" value="${qiye.xindai }"/>
                             <input type="hidden" id="descrip" name="descrip" value="${qiye.descrip }"/>
                             <input type="hidden" id="email" name="email" value="${qiye.email }"/>
                             <input type="hidden" id="shenhe" name="shenhe" value="${qiye.shenhe }"/>
                             <input type="hidden" id="zaixianNum" name="zaixianNum" value="${qiye.zaixianNum }"/>
                             <input type="hidden" id="city" name="city" value="${qiye.city }"/>
                             <input type="hidden" id="qh" name="qh" value="${qiye.qh }"/>
					<table align="center">
						<tr>
							<td><font color="red">*</font>拒绝理由：</td>
							<td><input type="text" id="beizhu"  name="beizhu"  value="${qiye.beizhu }"  style="margin-top:5px;height:30px;" /></td>
                                                        
						</tr>
                                                
		
					</table>
					<div align="center">
						<input type="submit" class="btn btn-primary" value="保存"/>
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='qiyeshenhe'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		</form>
</div>

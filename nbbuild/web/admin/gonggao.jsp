<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">

$(document).ready(function(){
	$("ul li:eq(2)").addClass("active");
	$('.datatable').dataTable( {        				
		 "oLanguage": {
				"sUrl": "/JobManage/media/zh_CN.json"
		 },
		"bLengthChange": false, //改变每页显示数据数量
		"bFilter": false, //过滤功能
		
       
	});
});

window.onload = function(){ 
	$("#DataTables_Table_0_wrapper .row-fluid").remove();
};
	function gonggaoDelete(id) {
		if(confirm("您确定要删除这个公告吗？")) {
			window.location="gonggao?action=delete&id="+id;
		}
	}
</script>
<style type="text/css">
	.span6 {
		width:0px;
		height: 0px;
		padding-top: 0px;
		padding-bottom: 0px;
		margin-top: 0px;
		margin-bottom: 0px;
	}

</style>
<div class="data_list">
		<div class="data_list_title">
			公告管理
		</div>
		<form name="myForm" class="form-search" method="post" action="gonggao?action=search" style="padding-bottom: 0px">
				
				<span class="data_search">
					
					<select id="searchType" name="searchType" style="width: 80px;">
					<option value="adminName">管理员</option>
					<option value="contain" ${searchType eq "contain"?'selected':'' }>内容</option>
					
					</select>
					&nbsp;<input id="s_gonggaoText" name="s_gonggaoText" type="text"  style="width:120px;height: 30px;" class="input-medium search-query" value="${s_gonggaoText }">
					&nbsp;<button type="submit" class="btn btn-info" onkeydown="if(event.keyCode==13) myForm.submit()">搜索</button>
				</span>
		</form>
		<div>
			<table class="table table-striped table-bordered table-hover datatable">
				<thead>
					<tr>
					<!-- <th>编号</th> -->
					<th>内容</th>
					<th>管理员</th>
					
                                      
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach  varStatus="i" var="gonggao" items="${gonggaoList }">
					<tr>
						<%-- <td>${i.count+(page-1)*pageSize }</td> --%>
						<td>${gonggao.contain }</td>
						<td>${gonggao.adminName }</td>
						
                                               
						<td><button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='gonggao?action=preSave&id=${gonggao.id }'">修改</button>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div align="center"><font color="red">${error }</font></div>
		<%-- <div class="pagination pagination-centered">
			<ul>
				${pageCode }
			</ul>
		</div> --%>
</div>
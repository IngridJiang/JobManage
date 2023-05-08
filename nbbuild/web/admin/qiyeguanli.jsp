
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.lero.model.Qiyezhanghao" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("ul li:eq(0)").addClass("active");
	});
        window.onload = function(){ 
	$("#DataTables_Table_0_wrapper .row-fluid").remove();
};
	function qiyezhanghaoDelete(qhId) {
		if(confirm("您确定要删除这个企业账号吗？")) {
			window.location="qiyezhanghao?action=delete&qhId="+qhId;
		}
	}
</script>


         <form action="" method="post">
             企业电话:<input type="text" name="tel" id="tel" />
             <input type="submit" value="搜索" />
         
</form>
    <button class="btn btn-success" type="button" style="margin-right: 50px;" onclick="javascript:window.location='qiyezhanghao?action=preSave'">添加</button>
    <table class="table table-bordered">
        

   

  <caption>企业用户管理</caption>
  <br>
  <thead>
    <tr>
      <th>企业账号ID</th>
      <th>电话</th>
      <th>密码</th>
      <th>账号类别</th>
      <th>企业ID</th>
     <th>操作</th>
    </tr>
  </thead>
  <tbody>
   
  <%    
                    
                    Connection con;
                    Statement sql;
                    ResultSet rs;
                    String tel=request.getParameter("tel");
                    try{  Class.forName("com.mysql.jdbc.Driver");
                    }
                    catch(Exception e)
                    {
                        
                    }
                    try{
                     String uri="jdbc:mysql://localhost:3306/db";
                     String user="root";
                     String password="root";
                     con=DriverManager.getConnection(uri,user,password);
                     sql=con.createStatement();
                     if(tel!=null) 
                     {
                     rs=sql.executeQuery("SELECT * FROM t_qiyezhanghao where userName="+tel+"");
                     }
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_qiyezhanghao");}
                     String id="";
                     while(rs.next()){
                      
                       out.print(" <tr>");
                       out.print("<td>"+rs.getString(1)+"</td>");
                      id=rs.getString(1);
                       out.print("<td>"+rs.getString(2)+"</td>");
                       out.print("<td>"+rs.getString(3)+"</td>");
                       if(rs.getInt(4)==1){
                       out.print("<td>"+"主账号"+"</td>");
                    }else{
                       out.print("<td>"+"子账号"+"</td>");
                       
                       }
                       out.print("<td>"+rs.getInt(5)+"</td>");
                       out.print("<td>");
                %>
                       <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='qiyezhanghao?action=preSave&qhId=<%=id%>'">修改</button>&nbsp;
				<button class="btn btn-mini btn-danger" type="button" onclick="qiyezhanghaoDelete(<%=id%>)">删除</button>
                 <% 
                       out.print("</td>");
                       out.print(" </tr>");
                     }
                     con.close();
                     }
                     catch(SQLException e)
                     {
                     out.print(e);
                     }
                   
                %>
                
                </tbody>
</table>





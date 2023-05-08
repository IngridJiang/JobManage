<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.lero.model.Job" %>
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
	function jobDelete(uuid) {
		if(confirm("您确定要删除这个职位吗？")) {
			window.location="j?action=delete&uuid="+uuid;
		}
	}
</script>


         <form action="" method="post">
             企业ID:<input type="text" name="comid" id="comid" />
             <input type="submit" value="搜索" />
         
</form>
<button class="btn btn-success" type="button" style="margin-right: 50px;" onclick="javascript:window.location='j?action=preSave'">添加</button>
    <table class="table table-bordered">
        

   

  <caption>职位管理</caption>
  <br>
  <thead>
    <tr>
      <th>职位ID</th>
      
      <th>企业ID</th>
      
      <th>职位名称</th>
      <th>城市</th>
      <th>描述</th>
      <th>薪资</th>
      <th>邮箱</th>
      
      <th>企业简称</th>
      <th>类别</th>
     <th>操作</th>
    </tr>
  </thead>
  <tbody>
   
  <%    
                    
                    Connection con;
                    Statement sql;
                    ResultSet rs;
                    String comid=request.getParameter("comid");
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
                     if(comid!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_job where comid='"+comid+"'&&shenhe=1");}
                     
                     
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_job where shenhe=1");}
                     String uuid="";
                     
                     while(rs.next()){
                      


                       out.print(" <tr>");
                       out.print("<td>"+rs.getInt(1)+"</td>");
                      uuid=rs.getString(1);
                       out.print("<td>"+rs.getInt("comid")+"</td>");
                     
                      

                       out.print("<td>"+rs.getString("name")+"</td>");
                       out.print("<td>"+rs.getString("city")+"</td>");
                      
                           
                       out.print("<td>"+rs.getString("des")+"</td>");
                       out.print("<td>"+rs.getInt("money")+"</td>");
                       out.print("<td>"+rs.getString("email")+"</td>");
                       
                       out.print("<td>"+rs.getString("jiancheng")+"</td>");
                       out.print("<td>"+rs.getString("leibie")+"</td>");
                       
                       out.print("<td>");
                       
                %>
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='j?action=preSave&uuid=<%=uuid%>'">修改</button>&nbsp;
				<button class="btn btn-mini btn-danger" type="button" onclick="jobDelete(<%=uuid%>)">删除</button>
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

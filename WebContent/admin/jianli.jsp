<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.lero.model.Jianli" %>
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
	function jianliDelete(jianliid) {
		if(confirm("您确定要删除这个简历吗？")) {
			window.location="jg?action=delete&jianliid="+jianliid;
		}
	}
</script>


         <form action="" method="post">
             学生ID:<input type="text" name="studentId" id="studentId" />
             <input type="submit" value="搜索" />
         
</form>
<button class="btn btn-success" type="button" style="margin-right: 50px;" onclick="javascript:window.location='jg?action=preSave'">添加</button>
    <table class="table table-bordered">
        

   

  <caption>简历管理</caption>
  <br>
  <thead>
    <tr>
      <th>简历ID</th>
      
      <th>学生ID</th>
      
      <th>电话</th>
      <th>城市</th>
      <th>性别</th>
      
      <th>邮箱</th>
      
      
     <th>操作</th>
    </tr>
  </thead>
  <tbody>
   
  <%    
                    
                    Connection con;
                    Statement sql;
                    ResultSet rs;
                    String studentId=request.getParameter("studentId");
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
                     if(studentId!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_jianli where studentId='"+studentId+"' ");}
                     
                     
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_jianli ");}
                     String jianliid="";
                     
                     while(rs.next()){
                      


                       out.print(" <tr>");
                       out.print("<td>"+rs.getInt(1)+"</td>");
                      jianliid=rs.getString(1);
                       out.print("<td>"+rs.getInt("studentId")+"</td>");
                     
                      

                       out.print("<td>"+rs.getString("tel")+"</td>");
                       out.print("<td>"+rs.getString("city")+"</td>");
                      
                           
                       out.print("<td>"+rs.getString("sex")+"</td>");
                       
                       out.print("<td>"+rs.getString("email")+"</td>");
                       
                       
                       
                       out.print("<td>");
                       
                %>
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='jg?action=preSave&jianliid=<%=jianliid%>'">查看和修改</button>&nbsp;
				<button class="btn btn-mini btn-danger" type="button" onclick="jianliDelete(<%=jianliid%>)">删除</button>
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

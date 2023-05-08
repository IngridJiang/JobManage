<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.lero.model.Qiye" %>
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
	function qiyeTongguo(comid) {
		if(confirm("您确定要通过这个企业吗？")) {
			window.location="qiyeshenhe?action=tongguo&comid="+comid;
		}
	}
</script>


         <form action="" method="post">
             全称:<input type="text" name="quancheng" id="quancheng" />
             <input type="submit" value="搜索" />
         

    <table class="table table-bordered">
        

   

  <caption>企业审核</caption>
  <br>
  <thead>
    <tr>
      <th>企业ID</th>
      <th>全称</th>
      <th>简称</th>
      
      <th>信用代码</th>
      
      <th>描述</th>
      <th>邮箱</th>
      
      <th>城市</th>
      <th>未通过理由</th>
     <th>操作</th>
    </tr>
  </thead>
  <tbody>
   
  <%    
                    
                    Connection con;
                    Statement sql;
                    ResultSet rs;
                    String quancheng=request.getParameter("quancheng");
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
                     if(quancheng!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_qiye where quancheng='"+quancheng+"'&&shenhe=0");}
                     
                     
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_qiye where shenhe=0");}
                     String comid="";
                     
                     while(rs.next()){
                      


                       out.print(" <tr>");
                       out.print("<td>"+rs.getInt(1)+"</td>");
                      comid=rs.getString(1);
                       out.print("<td>"+rs.getString(2)+"</td>");
                     
                      

                       out.print("<td>"+rs.getString(3)+"</td>");
                       out.print("<td>"+rs.getString(4)+"</td>");
                      
                           
                       out.print("<td>"+rs.getString("descrip")+"</td>");
                       out.print("<td>"+rs.getString("email")+"</td>");
                       
                       out.print("<td>"+rs.getString("city")+"</td>");
                       out.print("<td>"+rs.getString("beizhu")+"</td>");
                       out.print("<td>");
                       
                %>
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='qiyeshenhe?action=preSave&comid=<%=comid%>'">拒绝</button>&nbsp;
				<button class="btn btn-mini btn-danger" type="button" onclick="qiyeTongguo(<%=comid%>)">通过</button>
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





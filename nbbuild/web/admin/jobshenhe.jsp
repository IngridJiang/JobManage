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
	function jobTongguo(uuid) {
		if(confirm("您确定要通过这个职位吗？")) {
			window.location="js?action=tongguo&uuid="+uuid;
		}
	}
</script>


         <form action="" method="post">
             企业简称:<input type="text" name="jiancheng" id="jiancheng" />
             <input type="submit" value="搜索" />
         

    <table class="table table-bordered">
        

   

  <caption>职位审核</caption>
  <br>
  <thead>
    <tr>
      <th>职位ID</th>
      <th>职位名称</th>
      <th>企业简称</th>
      
      <th>薪资</th>
      
      <th>描述</th>
      <th>邮箱</th>
       <th>类别</th>
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
                    String jiancheng=request.getParameter("jiancheng");
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
                     if(jiancheng!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_job where jiancheng='"+jiancheng+"'&&shenhe=0");}
                     
                     
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_job where shenhe=0");}
                     String uuid="";
                     
                     while(rs.next()){
                      


                       out.print(" <tr>");
                       out.print("<td>"+rs.getInt("uuid")+"</td>");
                      uuid=rs.getString(1);
                       out.print("<td>"+rs.getString("name")+"</td>");
                     
                      

                       out.print("<td>"+rs.getString("jiancheng")+"</td>");
                       out.print("<td>"+rs.getInt("money")+"</td>");
                      
                           
                       out.print("<td>"+rs.getString("des")+"</td>");
                       out.print("<td>"+rs.getString("email")+"</td>");
                       out.print("<td>"+rs.getString("leibie")+"</td>");
                       out.print("<td>"+rs.getString("city")+"</td>");
                       out.print("<td>"+rs.getString("beizhu")+"</td>");
                       out.print("<td>");
                       
                %>
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='js?action=preSave&uuid=<%=uuid%>'">拒绝</button>&nbsp;
				<button class="btn btn-mini btn-danger" type="button" onclick="jobTongguo(<%=uuid%>)">通过</button>
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

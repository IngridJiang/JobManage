<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.lero.model.Luntan" %>
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
	function luntanDelete(id) {
		if(confirm("您确定要删除这个帖子吗？")) {
			window.location="luntan?action=delete&id="+id;
		}
	}
</script>


         <form action="" method="post">
             主题:<input type="text" name="zhuti" id="zhuti" />
             <input type="submit" value="搜索" />
         
</form>

    <table class="table table-bordered">
        

   

  <caption>论坛管理</caption>
  <br>
  <thead>
    <tr>
      <th>论坛ID</th>
      <th>学生</th>
      <th>是否匿名</th>
      
      <th>内容</th>
      <th>主题</th>
     <th>操作</th>
    </tr>
  </thead>
  <tbody>
   
  <%    
                    
                    Connection con;
                    Statement sql;
                    ResultSet rs;
                    String zhuti=request.getParameter("zhuti");
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
                     if(zhuti!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_luntan where zhuti='"+zhuti+"'");}
                     
                     
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_luntan");}
                     String id="";
                     
                     while(rs.next()){
                      
                       out.print(" <tr>");
                       out.print("<td>"+rs.getInt(1)+"</td>");
                      id=rs.getString(1);
                       out.print("<td>"+rs.getString(2)+"</td>");
                       
                       if(rs.getInt(3)==1){
                       out.print("<td>"+"是"+"</td>");
                    }else{
                       out.print("<td>"+"否"+"</td>");
                       
                       }
                       
                       out.print("<td>"+rs.getString(5)+"</td>");
                        out.print("<td>"+rs.getString(4)+"</td>");
                       out.print("<td>");
                       
                %>
                      
				<button class="btn btn-mini btn-danger" type="button" onclick="luntanDelete(<%=id%>)">删除</button>
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





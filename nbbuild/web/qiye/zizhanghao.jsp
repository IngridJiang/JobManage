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
	function ziDelete(id) {
		if(confirm("您确定要删除这个子账号吗？")) {
			window.location="zi?action=delete&id="+id;
		}
	}
</script>



         <form action="" method="post">
             :<input type="hidden" id="qh" name="qh" value="${currentUser.userName }"/>
             <input type="submit" value="查找子账号" />
         
</form>

    <table class="table table-bordered">
        
        

   

  <caption>子账号</caption>
  <br>
  <thead>
    <tr>
      <th>企业账号ID</th>
      <th>电话</th>
      <th>操作</th>
    </tr>
  </thead>
  <tbody>

<%    
                    
                    Connection con;
                    Statement sql;
                     Statement sqlt;
                    ResultSet rs;
                    ResultSet r;
                    String qh=request.getParameter("qh");
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
                     sqlt=con.createStatement();
                     String id="";
                     if(qh!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_qiyezhanghao where userName='"+qh+"'");
                    
                     }
                     
                     
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_qiyezhanghao where qhId=0");}
                    
                     int comid=0;
                     while(rs.next()){
                    
                    comid=rs.getInt("comid");
                    String n=Integer.toString(comid);
                  %>  <form action="zi?action=add" method="post">
             <input type="hidden" id="comid" name="comid" value=<%=n%>  />
             电话：<input type="text" id="tel" name="tel" style="margin-top:5px;height:30px;" />
             <input type="submit" value="添加" />
         
</form><%
                    }
                     rs.last();
                     r=sql.executeQuery("SELECT * FROM t_qiyezhanghao where comid='"+comid+"'");
                     while(r.next()){
                     out.print(" <tr>");
                       out.print("<td>"+r.getInt(1)+"</td>");
                      id=r.getString(1);
                       out.print("<td>"+r.getString(2)+"</td>");
                       out.print("<td>");
                       int a=r.getInt("mainornot");
                       if(a==0){
                %>
                <button class="btn btn-mini btn-danger" type="button" onclick="ziDelete(<%=id%>)">删除</button>
                 <% }
                       out.print("</td>");
                       out.print(" </tr>");}
                     r.last();
                
                         con.close();
                         
                          }
                 
                     
                     
                     
                     
                     
                    
                     
                     
                    
                     
                     
                     catch(SQLException e)
                     {
                     out.print(e);
                     }
                   
                %>
                
                </tbody>
</table>





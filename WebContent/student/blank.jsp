<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("ul li:eq(0)").addClass("active");
	});
</script>

<div>
	<div class=blank style="padding-top: 100px;padding-left: 100px;">
		<font color="gray" size="20">欢迎您,同学!
                <br><br><br>公告：
                <%    
                    Connection con;
                    Statement sql;
                    ResultSet rs;
                    try{  Class.forName("com.mysql.jdbc.Driver");}
                    catch(Exception e){}
                     try{
                     String uri="jdbc:mysql://localhost:3306/db";
                     String user="root";
                     String password="root";
                     con=DriverManager.getConnection(uri,user,password);
                     sql=con.createStatement();
                     rs=sql.executeQuery("SELECT contain FROM t_gonggao");
                     while(rs.next()){out.print(rs.getString(1));}
                     con.close();
                     }
                     catch(SQLException e){
                     out.print(e);
                     }
                
                %></font>
	</div>
</div>
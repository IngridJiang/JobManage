<%-- 
    Document   : rss
    Created on : 2020-10-29, 14:33:15
    Author     : X
--%>

<%@page import="com.lero.util.DbUtil"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="javax.activation.DataSource"%>
<%@page import="javax.enterprise.context.spi.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>注册成功页面</title>
</head>

<body>

	<%
String stuNum = new String(request.getParameter("stuNum").getBytes("ISO8859_1"),"utf-8");
	 String pwd = request.getParameter("password");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            String email = request.getParameter("email");
            String city = request.getParameter("city");
            String sex= request.getParameter("sex");
            String jianliid="0";
    Class.forName("com.mysql.jdbc.Driver");

	String url = "jdbc:mysql://localhost:3306/db";

	String usename = "root";

	String psw= "root";  

    Connection conn = DriverManager.getConnection(url,usename,psw);//得到连接  

    PreparedStatement pStmt = conn.prepareStatement("select * from t_student where stuNum = '" + stuNum + "'");  

    ResultSet rs = pStmt.executeQuery();  			

	  if(rs.next()){  

          out.println("<script language='javascript'>alert('该用户已存在，请重新注册！');window.location.href='registerstu.jsp';</script>");  

      }else{  

          
String sql_insert="insert into t_student(stuNum,password,name,sex,tel,email,jianliid,city) values ('" + stuNum + "','" + pwd + "','" + name + "','" + sex + "','" + tel + "','" + email + "','" + jianliid + "','" + city + "')";
        PreparedStatement pst=conn.prepareStatement(sql_insert);

              int rst = pst.executeUpdate();  

              if (rst != 0){  

                    out.println("<script language='javascript'>alert('用户注册成功！');window.location.href='login.jsp';</script>");    

              }else{  

                 out.println("<script language='javascript'>alert('用户注册失败！');window.location.href='register.jsp';</script>");    

              }  

      }	

	%>

</body>
</html>



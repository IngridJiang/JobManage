<%-- 
    Document   : rqs
    Created on : 2020-10-29, 16:19:17
    Author     : X
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <title>注册成功页面</title>
</head>

<body>

	<%
String userName = new String(request.getParameter("userName").getBytes("ISO8859_1"),"utf-8");
	 String pwd = request.getParameter("password");
            String mainornot="0";
            String comid="0";
    Class.forName("com.mysql.jdbc.Driver");

	String url = "jdbc:mysql://localhost:3306/db";

	String usename = "root";

	String psw= "root";  

    Connection conn = DriverManager.getConnection(url,usename,psw);//得到连接  

    PreparedStatement pStmt = conn.prepareStatement("select * from t_qiyezhanghao where userName = '" + userName + "'");  

    ResultSet rs = pStmt.executeQuery();  			

	  if(rs.next()){  

          out.println("<script language='javascript'>alert('该用户已存在，请重新注册！');window.location.href='registerstu.jsp';</script>");  

      }else{  

          
String sql_insert="insert into t_qiyezhanghao(userName,password,comid,mainornot) values ('" + userName + "','" + pwd + "','" + comid + "','" + mainornot + "')";
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

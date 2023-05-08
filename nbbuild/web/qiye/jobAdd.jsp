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


 <form action="" method="post">
             <input type="hidden" id="un" name="un" value="${currentUser.userName }"/>
             <input type="submit" value="检查职位数" />
         

   
  <%    
                    Connection con;
                    Statement sql;
                     Statement sqlt;
                    ResultSet rs;
                    ResultSet r;
                    ResultSet s;
                    String comid="0";
                    String uuid="0";
                    String un=request.getParameter("un");
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
                     if(un!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_qiyezhanghao where userName='"+un+"'");}
                     else{
                     rs=sql.executeQuery("SELECT * FROM t_qiyezhanghao where qhId=0");
                     
                     }
                     while(rs.next()){
                     String a=rs.getString("comid");
                     
                     if(a!=null) 
                     {
                       comid=a;
                       if(comid.equals("0")){
                       out.print("您未加入企业，申请企业或联系企业已有账户添加");
                       }}
                     }
                           
                       
                       rs.last();
                       int count=0;
                     r=sql.executeQuery("SELECT count(*) FROM t_job where comid='"+comid+"'");
                        while(r.next()){
                      count=r.getInt(1);}
                    r.last();
                      int num=0;
                     s=sql.executeQuery("SELECT * FROM t_qiye where comid='"+comid+"'");
                        while(s.next()){
                      num=s.getInt("zaixianNum");}
                       if(num==count){
                       out.print("若无法添加，职位数已达上限，请联系管理员添加职位数，TEL：xxxxxxxx");
                       }
                       else{
                     
                %>
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='jq?action=preSave'">可添加</button>&nbsp;
				
                 <% 
                       
                     }
                       
                     con.close();
                     }
                     catch(SQLException e)
                     {
                     out.print(e);
                     }
                   
                %>
                
               

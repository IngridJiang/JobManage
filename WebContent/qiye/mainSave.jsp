<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form action="" method="post" onsubmit="return checkForm()">
			
                    <div class="data_form" >
				<input type="hidden" id="userNamet" name="userNamet" value="${currentUser.userName }"/>
                       
                                
					
					<div align="center">
						<input type="submit" class="btn btn-primary" value="传递添加企业ID"/>
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='m'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		</form>
                      <%    
                    
                    Connection con;
                    Statement sql;
                    ResultSet rs;
                    String userNamet=request.getParameter("userNamet");
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
                     if(userNamet!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_qiye where qh='"+userNamet+"'");}
                     
                     
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_qiye");}
                     int comid=0;
                     
                     while(rs.next()){
                      
                      
                      comid=rs.getInt("comid");
                       String c=Integer.toString(comid);
                      if(userNamet!=null) { 
                       
                %>
                      <form action="m?action=save" method="post" onsubmit="return checkForm()">
			
                    <div class="data_form" >
				<input type="hidden" id="userName" name="userName" value="${currentUser.userName }"/>
                       
                                <input type="hidden" id="comid" name="comid" value=<%=c%> />
					
					<div align="center">
						<input type="submit" class="btn btn-primary" value="确定设置该账号为主账号，则不可成为其他企业子账号"/>
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='qiyeduan'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		</form>
				
                 <% 
                      }
                     }
                     con.close();
                     }
                     catch(SQLException e)
                     {
                     out.print(e);
                     }
                   
                %>
                

		


<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.lero.util.StringUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form action="" method="post">
            城市：<input type="text" id="city" name="city"  />
            类别：<input type="text" id="leibie" name="leibie"  />
            公司简称：<input type="text" id="jiancheng" name="jiancheng"  />
             <input type="submit" value="搜索" />
         
</form>


<div class="data_list">
		<div class="data_list_title">
		投递

		</div>
           确定投递简历至此职位？
                <form action="" method="post">
            <input type="hidden" id="num" name="num" value="${currentUser.userName }"/>
            <input type="hidden" id="uuid" name="uuid" value="${job.uuid }"/>
            
             <input type="submit" value="确定" />
         
</form>
    &nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='jobs'">返回</button>
			
                   
</div>
<%    
                    
                    Connection con;
                    Statement sql;
                     Statement sqlt;
                    ResultSet rs;
                    ResultSet r;
                    String num=request.getParameter("num");
                     String uuid=request.getParameter("uuid");
                     
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
                     int studentId=0;
                      int u=0;
                      if( StringUtil.isNotEmpty(uuid) ){
                       u=Integer.parseInt(uuid);
                       }
                      
                     if(num!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_student where stuNum='"+num+"'");
                    
                     }
                     
                     
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_student where studentId=0");}
                    
                     while(rs.next()){
                     String s=rs.getString("studentId");
                       if( StringUtil.isNotEmpty(s) ){
                       studentId=Integer.parseInt(s);
                       }
                     rs.last();
                    
                         
                         r= sqlt.executeQuery("SELECT * FROM t_jianli where studentId='"+studentId+"'");
                          
                        while(r.next()) {
                         
                         String jianliid=r.getString("jianliid");
                            
                         if( !StringUtil.isNotEmpty(jianliid) )
                         {%>  
<br>请先完善简历！
<%
                          out.print("请先完善简历");
                          int j=0;
                         }
                         else{
                             int j=Integer.parseInt(jianliid);
                      %> <form action="jobs?action=toudi" method="post">
             <input type="hidden" id="studentId" name="studentId" value=<%=studentId%>  />
            <input type="hidden" id="uuid" name="uuid" value=<%=u%> />
            <input type="hidden" id="jianliid" name="jianliid" value=<%=j%>   />
            
             <input type="submit" value="二次确定" />
         
</form>
                        <%
     
                         }
                      
                        }
                     }
                     con.close();
                     }
                    catch(SQLException e)
                     {
                     out.print(e);
                     }
                   
                %>
    
    
    
   
                                
		

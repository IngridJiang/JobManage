<%@page import="com.lero.util.StringUtil"%>
<%@page import="com.mysql.jdbc.StringUtils"%>
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



         <form action="" method="post">
             :<input type="hidden" id="num" name="num" value="${currentUser.userName }"/>
             <input type="submit" value="查看简历" />
         
</form>

    <table class="table table-bordered">
        

<%    
                    
                    Connection con;
                    Statement sql;
                     Statement sqlt;
                    ResultSet rs;
                    ResultSet r;
                    String num=request.getParameter("num");
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
                      int   a=0;  
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
                          a++;  
                         if( StringUtil.isNotEmpty(jianliid) )
                         {
                          %>
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='jstu?action=preSave&jianliid=<%=jianliid%>&&studentId=<%=s%>'">进入简历修改</button>&nbsp;
			 	 
                 <% 
                         }
                        
                      
                     
                     
                     }
                        if(a==0){
                               %>
                      
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='jstu?action=preSave&studentId=<%=s%>'">添加简历</button>&nbsp;
                  
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
                
                </tbody>
</table>




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
             职位ID：<input type="text" id="uuid" name="uuid"   />
            <input type="hidden" id="un" name="un" value="${currentUser.userName }"/>
             <input type="submit" value="查找" />
         
</form>

    <table class="table table-bordered">
        

<%    
                    
                    Connection con;
                    Statement sql;
                     Statement sqlt;
                    ResultSet rs;
                    ResultSet r;
                    ResultSet s;
                    int comid=0;
                    String un=request.getParameter("un");
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
                     if(StringUtil.isNotEmpty("uuid")){
                     if(StringUtil.isNotEmpty("un")) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_qiyezhanghao where userName='"+un+"'");
                    
                     }
                     
                     
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_qiyezhanghao where qhId=0");}
                    
                     while(rs.next()){
                     comid=rs.getInt("comid");}
                      rs.last();
                     if( comid==0 ){
                   
                      out.print("");
               
                     }else{
                         
                         rs.last();
                         
                         r= sqlt.executeQuery("SELECT * FROM t_job where uuid='"+uuid+"'&&comid='"+comid+"'");
                          String name="";
                        while(r.next()) {
                            name=r.getString("name");
                        }
                      r.last();
                        if(StringUtil.isNotEmpty(name)){
                         s=sqlt.executeQuery("SELECT * FROM t_toudi where uuid='"+uuid+"'");
                     
                            %>
                 <table class="table table-bordered">

  <caption>投递查看</caption>
  <br>
  <thead>
    <tr>
      <th>学号</th>
     <th>操作</th>
    </tr>
  </thead>
  <tbody>
    
                      <%
                         while(s.next()){

                       out.print(" <tr>");
                       out.print("<td>"+s.getInt("studentId")+"</td>");
                       String jianliid=s.getString("jianliid");
                        out.print("<td>"); 
                      %>
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='tq?action=preSave&jianliid=<%=jianliid%>'">查看简历</button>&nbsp;
			
                 <% out.print("</td>");
                       out.print(" </tr>");
                        }
                  
                     }
                  else{
                     out.print("该职位不属于企业");
                     con.close();
                     } 
                 
                 
                    }
                
                 }
                     
                     else{
                     out.print("请输入职位Id");
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






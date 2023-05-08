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
            城市：<input type="text" id="city" name="city"  />
            类别：<input type="text" id="leibie" name="leibie"  />
            公司简称：<input type="text" id="jiancheng" name="jiancheng"  />
             <input type="submit" value="搜索" />
         
</form>

    <table class="table table-bordered">
        
<div data-spy="scroll" data-target="#navbar-example" data-offset="0"
     style="height:400px;overflow:auto; position: relative;">

<%    
                    
                    Connection con;
                    Statement sql;
                     
                    ResultSet rs;
                    String uuid="";
                    String city=request.getParameter("city");
                    String leibie=request.getParameter("leibie");
                    String jiancheng=request.getParameter("jiancheng");
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
                     
                       
                     if(StringUtil.isNotEmpty(city)&&StringUtil.isNotEmpty(jiancheng)&&StringUtil.isNotEmpty(leibie)) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_job where city='"+city+"'&&jiancheng='"+jiancheng+"'&&leibie='"+leibie+"'");
                    
                     }else if(StringUtil.isNotEmpty(city)&&StringUtil.isNotEmpty(jiancheng)&&!StringUtil.isNotEmpty(leibie)){
                      rs=sql.executeQuery("SELECT * FROM t_job where city='"+city+"'&&jiancheng='"+jiancheng+"'");
                     
                     }
                     else if(StringUtil.isNotEmpty(city)&&!StringUtil.isNotEmpty(jiancheng)&&StringUtil.isNotEmpty(leibie)){
                      rs=sql.executeQuery("SELECT * FROM t_job where city='"+city+"'&&leibie='"+leibie+"'");
                     
                     }
                     else if(!StringUtil.isNotEmpty(city)&&StringUtil.isNotEmpty(jiancheng)&&StringUtil.isNotEmpty(leibie)){
                      rs=sql.executeQuery("SELECT * FROM t_job where jiancheng='"+jiancheng+"'&&leibie='"+leibie+"'");
                     
                     }else if(StringUtil.isNotEmpty(city)&&!StringUtil.isNotEmpty(jiancheng)&&!StringUtil.isNotEmpty(leibie)){
                      rs=sql.executeQuery("SELECT * FROM t_job where city='"+city+"'");
                     
                     }else if(!StringUtil.isNotEmpty(city)&&StringUtil.isNotEmpty(jiancheng)&&!StringUtil.isNotEmpty(leibie)){
                      rs=sql.executeQuery("SELECT * FROM t_job where jiancheng='"+jiancheng+"'");
                     
                     }else if(!StringUtil.isNotEmpty(city)&&!StringUtil.isNotEmpty(jiancheng)&&StringUtil.isNotEmpty(leibie)){
                      rs=sql.executeQuery("SELECT * FROM t_job where leibie='"+leibie+"'");
                     
                     }else {
                      rs=sql.executeQuery("SELECT * FROM t_job ");
                     
                     }
                     
                     
                    
  
                     while(rs.next()){
            %>         <h4>&nbsp;&nbsp;<%
                       uuid=rs.getString("uuid");
                         String name=rs.getString("name");
                out.print(name);
                
                %>
                
            </h4>
    <p>&nbsp;&nbsp;&nbsp;城市：<%
                      
                         String cityt=rs.getString("city");
                out.print(cityt);
                
                %>
        &nbsp;&nbsp;&nbsp;薪资：
        <%
                      
                         String money=rs.getString("money");
                out.print(money);
                
                %>
        &nbsp;&nbsp;&nbsp;企业：<%
                      
                         String jianchengt=rs.getString("jiancheng");
                out.print(jianchengt);
                
                %>
        &nbsp;&nbsp;&nbsp;类别：<%
                      
                         String leibiet=rs.getString("leibie");
                out.print(leibiet);
                
                %>
         &nbsp;&nbsp;&nbsp;<button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='jobs?action=liulan&uuid=<%=uuid%>'">查看</button>&nbsp;
          <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='t?action=presave&uuid=<%=uuid%>'">投递</button>&nbsp;
    </p>

                 <%        
                     
                        
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




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
             :<input type="hidden" id="qh" name="qh" value="${currentUser.userName }"/>
             <input type="submit" value="查找自身账号绑定企业状态" />
         
</form>

    <table class="table table-bordered">
        

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
                     if(qh!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_qiyezhanghao where userName='"+qh+"'");
                    
                     }
                     
                     
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_qiyezhanghao where qhId=0");}
                    
                     while(rs.next()){
                     int comid=rs.getInt("comid");
                      rs.last();
                     if( comid==0 ){
                      %>
                      
                      
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='qiyeduan?action=preSave'">添加企业</button>&nbsp;
			<button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='m?action=preSave&chaxun=${currentUser.userName }'">添加后生成主账号，注：不要重复添加</button>&nbsp;
                      
                      
               

                      
                      
                     
                 <% 
                     }else{
                         out.print("企业ID：");
                         out.print(comid);
                         rs.last();
                         r= sqlt.executeQuery("SELECT * FROM t_qiye where qh='"+qh+"'");
                          
                        while(r.next()) {
                         
                         int shenhe=r.getInt("shenhe");
                        
                         if( shenhe==1 )
                         {
                         out.print("已通过审核");
                         }
                         else{
                         String beizhu=r.getString("beizhu");
                         r.last();
                         out.print("暂未通过审核，已知原因：");
                         out.print(beizhu);
                         }
                      %>
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='qiyeduan?action=preSave&qh=${currentUser.userName }&&comid=<%=comid%>'">进入企业修改</button>&nbsp;
			 <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='zi?action=l'">查看子账号</button>&nbsp;	 
                 <% 
                     
                     }}}
                     
                     
                     
                     
                     
                    
                     
                     
                    
                     con.close();
                     }
                     catch(SQLException e)
                     {
                     out.print(e);
                     }
                   
                %>
                
                </tbody>
</table>





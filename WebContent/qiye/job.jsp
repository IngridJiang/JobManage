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
<script type="text/javascript">
	$(document).ready(function(){
		$("ul li:eq(0)").addClass("active");
	});
        window.onload = function(){ 
	$("#DataTables_Table_0_wrapper .row-fluid").remove();
};
	function jobDelete(uuid) {
		if(confirm("您确定要删除这个职位吗？")) {
			window.location="jq?action=delete&uuid="+uuid;
		}
	}
</script>

 <form action="" method="post">
             <input type="hidden" id="un" name="un" value="${currentUser.userName }"/>
             <input type="submit" value="查看职位" />
         


    <table class="table table-bordered">
        

   

  <caption>职位管理</caption>
  <br>
  <thead>
    <tr>
      <th>职位ID</th>
      
      
      
      <th>职位名称</th>
      <th>城市</th>
      <th>描述</th>
      <th>薪资</th>
      <th>邮箱</th>
      
      <th>企业简称</th>
      
      <th>类别</th>
      <th>审核状态</th>
      <th>未通过原因</th>
     <th>操作</th>
    </tr>
  </thead>
  <tbody>
   
  <%    
                    Connection con;
                    Statement sql;
                     Statement sqlt;
                    ResultSet rs;
                    ResultSet r;
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
                       }else{
                           %>
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='ja?action=list'">发布职位</button>&nbsp;
				
                 <% }}}
                           
                       
                       rs.last();
                     r=sql.executeQuery("SELECT * FROM t_job where comid='"+comid+"'");
                        while(r.next()){
                      


                       out.print(" <tr>");
                       out.print("<td>"+r.getInt(1)+"</td>");
                      uuid=r.getString(1);
                       
                     
                      

                       out.print("<td>"+r.getString("name")+"</td>");
                       out.print("<td>"+r.getString("city")+"</td>");
                      
                           
                       out.print("<td>"+r.getString("des")+"</td>");
                       out.print("<td>"+r.getInt("money")+"</td>");
                       out.print("<td>"+r.getString("email")+"</td>");
                       
                       out.print("<td>"+r.getString("jiancheng")+"</td>");
                       out.print("<td>"+r.getString("leibie")+"</td>");
                       int shenhe=r.getInt("shenhe");
                       if(shenhe==1){
                       out.print("<td>");
                        out.print("已通过");
                        out.print("</td>");
                       }else{
                       out.print("<td>");
                        out.print("未通过");
                        out.print("</td>");
                       }
                       out.print("<td>"+r.getString("beizhu")+"</td>");
                       out.print("<td>");
                       
                %>
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='jq?action=preSave&uuid=<%=uuid%>'">修改</button>&nbsp;
				<button class="btn btn-mini btn-danger" type="button" onclick="jobDelete(<%=uuid%>)">删除</button>
                 <% 
                       out.print("</td>");
                       out.print(" </tr>");
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

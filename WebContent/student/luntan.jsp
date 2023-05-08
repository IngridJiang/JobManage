<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.lero.model.Luntan" %>
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
	function luntanDelete(id) {
		if(confirm("您确定要删除这个帖子吗？")) {
			window.location="luntan?action=delete&id="+id;
		}
	}
</script>
<form action="" method="post">
  <div class="form-group">
    <label>请选择论坛主题</label>
   
    <select class="form-control" name="zhuti" id="zhuti">
        
        <option value="bank">银行</option>
      <option value="IT">IT</option>
      <option value="jg">金融公司</option>
      <option value="zhengquan">证券</option>
      
    </select>
    <input type="hidden" id="student" name="student" value="${currentUser.userName }"/>
    <input type="submit" value="搜索" />
  </div> <button class="btn btn-success" type="button" style="margin-right: 50px;" onclick="javascript:window.location='luntan?action=preSave'">添加</button>
</form>

      

    <table class="table" style="word-break: keep-all">
        

   

  <caption>学生讨论论坛</caption>
  <br>
  <thead>
    <tr>
      <th>楼层</th>
      <th>学生名称</th>
      
      <th>内容</th>
     <th>操作</th>
    </tr>
  </thead>
  <tbody>
   
  <%    
                    
                    Connection con;
                    Statement sql;
                    ResultSet rs;
                    String zhuti=request.getParameter("zhuti");
                    String student=request.getParameter("student");
                    
                    try{  Class.forName("com.mysql.jdbc.Driver");
                    }
                    catch(Exception e)
                    {
                        
                    }
                    try {
                     String uri="jdbc:mysql://localhost:3306/db";
                     String user="root";
                     String password="root";
                     con=DriverManager.getConnection(uri,user,password);
                     sql=con.createStatement();
                     if(zhuti!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_luntan where zhuti='"+zhuti+"'");
                     
                     
                   
                     String id="";
                     String name="";
                     String z="";
                     String l="";
                     String n="";
                     int i=0;
                     while(rs.next()){
                      
                     id=rs.getString(1);
                      z= rs.getString(5);
                      
                      n=rs.getString(3);
                      name= rs.getString(2);
                       i=i+1;
                      out.print("<td>"+i+"</td>");
                       if(rs.getInt(3)==1){
                       out.print("<td>"+"匿名用户"+"</td>");
                    }else{
                       out.print("<td>"+rs.getString(2)+"</td>");
                       
                       }
                        
                      
                        out.print("<td>"+rs.getString(5)+"</td>");
                       out.print("<td>");
                      if(name.equals(student)){
                %>
                      <button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='luntan?action=preSave&id=<%=id%>&zhuti=<%=z%>&nimingornot=<%=n%>'">修改</button>&nbsp;
				<button class="btn btn-mini btn-danger" type="button" onclick="luntanDelete(<%=id%>)">删除</button>
                 <% }
                       out.print("</td>");
                       out.print(" </tr>");
                     }}
                      else{
                     out.print("请选择论坛主题");}
                     con.close();
                     }
                     catch(SQLException e)
                     {
                     out.print(e);
                     }
                   
                %>
                
                </tbody>
</table>




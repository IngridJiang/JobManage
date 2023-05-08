<%@ page contentType="text/html; charset=gbk" %> 
<%@ page import="java.io.*"%> 
<%@ page import="java.sql.*, javax.sql.*" %> 
<%@ page import="java.util.*"%> 
<%@ page import="java.math.*"%> 
<% 
String comid = request.getParameter("comid"); 
//mysql连接 
Class.forName("com.mysql.jdbc.Driver").newInstance(); 
String URL="jdbc:mysql://localhost:3306/job?user=root&password=root"; 
Connection con = DriverManager.getConnection(URL); 



try{ 
// 准备语句执行对象 
Statement stmt = con.createStatement(); 
String sql = " SELECT * FROM t_qiye WHERE comid = "+ comid +""; 
ResultSet rs = stmt.executeQuery(sql); 
if (rs.next()) { 
Blob b = rs.getBlob(5); 
long size = b.length(); 
//out.print(size); 
byte[] bs = b.getBytes(1, (int)size); 
response.setContentType("image/jpeg"); 
OutputStream outs = response.getOutputStream(); 
outs.write(bs); 
outs.flush(); 
rs.close(); 
} 
else { 
rs.close(); 
response.sendRedirect(""); 
} 
} 
finally{ 
con.close(); 
} 
%> 
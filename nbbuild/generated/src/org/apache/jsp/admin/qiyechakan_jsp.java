package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import com.lero.model.Qiye;

public final class qiyechakan_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function(){\n");
      out.write("\t\t$(\"ul li:eq(0)\").addClass(\"active\");\n");
      out.write("\t});\n");
      out.write("        window.onload = function(){ \n");
      out.write("\t$(\"#DataTables_Table_0_wrapper .row-fluid\").remove();\n");
      out.write("};\n");
      out.write("\tfunction luntanDelete(comid) {\n");
      out.write("\t\tif(confirm(\"您确定要删除这个企业吗？\")) {\n");
      out.write("\t\t\twindow.location=\"qiye?action=delete&comid=\"+comid;\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("         <form action=\"\" method=\"post\">\n");
      out.write("             全称:<input type=\"text\" name=\"quancheng\" id=\"quancheng\" />\n");
      out.write("             <input type=\"submit\" value=\"搜索\" />\n");
      out.write("         \n");
      out.write("</form>\n");
      out.write("\n");
      out.write("    <table class=\"table table-bordered\">\n");
      out.write("        \n");
      out.write("\n");
      out.write("   \n");
      out.write("\n");
      out.write("  <caption>企业管理</caption>\n");
      out.write("  <br>\n");
      out.write("  <thead>\n");
      out.write("    <tr>\n");
      out.write("      <th>企业ID</th>\n");
      out.write("      <th>全称</th>\n");
      out.write("      <th>简称</th>\n");
      out.write("      \n");
      out.write("      <th>信用代码</th>\n");
      out.write("      <th>LOGO</th>\n");
      out.write("      <th>描述</th>\n");
      out.write("      <th>邮箱</th>\n");
      out.write("      <th>在线职位数</th>\n");
      out.write("      <th>主账号</th>\n");
      out.write("      <th>城市</th>\n");
      out.write("     <th>操作</th>\n");
      out.write("    </tr>\n");
      out.write("  </thead>\n");
      out.write("  <tbody>\n");
      out.write("   \n");
      out.write("  ");
    
                    
                    Connection con;
                    Statement sql;
                    ResultSet rs;
                    String quancheng=request.getParameter("quancheng");
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
                     if(quancheng!=null) 
                     {
                       
                     rs=sql.executeQuery("SELECT * FROM t_qiye where quancheng='"+quancheng+"'&&shenhe=1");}
                     
                     
                    else{
                     rs=sql.executeQuery("SELECT * FROM t_qiye where shenhe=1");}
                     String comid="";
                     
                     while(rs.next()){
                      
                       out.print(" <tr>");
                       out.print("<td>"+rs.getInt(1)+"</td>");
                      comid=rs.getString(1);
                       out.print("<td>"+rs.getString(2)+"</td>");
                      Blob b = rs.getBlob(5); 
                      response.setContentType("logo/png"); 
                      OutputStream outs = response.getOutputStream(); 

                       out.print("<td>"+rs.getString(3)+"</td>");
                       out.print("<td>"+rs.getString(4)+"</td>");
                       out.print("<td>");
                       outs.flush(); 
                       out.print("</td>");
                             
                       out.print("<td>"+rs.getString(6)+"</td>");
                       out.print("<td>"+rs.getString(7)+"</td>");
                       out.print("<td>"+rs.getInt(10)+"</td>");
                       out.print("<td>"+rs.getString(11)+"</td>");
                       out.print("<td>"+rs.getString(12)+"</td>");
                       
                       out.print("<td>");
                       
                
      out.write("\n");
      out.write("                      \n");
      out.write("\t\t\t\t<button class=\"btn btn-mini btn-danger\" type=\"button\" onclick=\"luntanDelete(");
      out.print(comid);
      out.write(")\">删除</button>\n");
      out.write("                 ");
 
                       out.print("</td>");
                       out.print(" </tr>");
                     }
                     con.close();
                     }
                     catch(SQLException e)
                     {
                     out.print(e);
                     }
                   
                
      out.write("\n");
      out.write("                \n");
      out.write("                </tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

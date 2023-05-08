package org.apache.jsp.qiye;

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
import com.lero.model.Job;

public final class job_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\tfunction jobDelete(uuid) {\n");
      out.write("\t\tif(confirm(\"您确定要删除这个职位吗？\")) {\n");
      out.write("\t\t\twindow.location=\"jq?action=delete&uuid=\"+uuid;\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write(" <form action=\"\" method=\"post\">\n");
      out.write("             <input type=\"hidden\" id=\"un\" name=\"un\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentUser.userName }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("             <input type=\"submit\" value=\"查看职位\" />\n");
      out.write("         \n");
      out.write("\n");
      out.write("<button class=\"btn btn-success\" type=\"button\" style=\"margin-right: 50px;\" onclick=\"javascript:window.location='jq?action=preSave'\">添加</button>\n");
      out.write("    <table class=\"table table-bordered\">\n");
      out.write("        \n");
      out.write("\n");
      out.write("   \n");
      out.write("\n");
      out.write("  <caption>职位管理</caption>\n");
      out.write("  <br>\n");
      out.write("  <thead>\n");
      out.write("    <tr>\n");
      out.write("      <th>职位ID</th>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("      \n");
      out.write("      <th>职位名称</th>\n");
      out.write("      <th>城市</th>\n");
      out.write("      <th>描述</th>\n");
      out.write("      <th>薪资</th>\n");
      out.write("      <th>邮箱</th>\n");
      out.write("      \n");
      out.write("      <th>企业简称</th>\n");
      out.write("      \n");
      out.write("      <th>类别</th>\n");
      out.write("      <th>审核状态</th>\n");
      out.write("      <th>未通过原因</th>\n");
      out.write("     <th>操作</th>\n");
      out.write("    </tr>\n");
      out.write("  </thead>\n");
      out.write("  <tbody>\n");
      out.write("   \n");
      out.write("  ");
    
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
                           
      out.write("\n");
      out.write("                      <button class=\"btn btn-mini btn-info\" type=\"button\" onclick=\"javascript:window.location='jq?action=preSave&uuid=");
      out.print(uuid);
      out.write("'\">发布职位</button>&nbsp;\n");
      out.write("\t\t\t\t\n");
      out.write("                 ");
 
                           rs.last();
                     r=sql.executeQuery("SELECT * FROM t_job where comid='"+comid+"'");
                        while(r.next()){
                      


                       out.print(" <tr>");
                       out.print("<td>"+r.getInt(1)+"</td>");
                      uuid=rs.getString(1);
                       
                     
                      

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
                       
                
      out.write("\n");
      out.write("                      <button class=\"btn btn-mini btn-info\" type=\"button\" onclick=\"javascript:window.location='jq?action=preSave&uuid=");
      out.print(uuid);
      out.write("'\">修改</button>&nbsp;\n");
      out.write("\t\t\t\t<button class=\"btn btn-mini btn-danger\" type=\"button\" onclick=\"jobDelete(");
      out.print(uuid);
      out.write(")\">删除</button>\n");
      out.write("                 ");
 
                       out.print("</td>");
                       out.print(" </tr>");
                     }
                       
                       
                       }
                       }}
                     
                     
                    
                     
                    
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

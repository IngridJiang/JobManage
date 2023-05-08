package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import com.lero.model.Luntan;

public final class luntan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function(){\n");
      out.write("\t\t$(\"ul li:eq(0)\").addClass(\"active\");\n");
      out.write("\t});\n");
      out.write("        window.onload = function(){ \n");
      out.write("\t$(\"#DataTables_Table_0_wrapper .row-fluid\").remove();\n");
      out.write("};\n");
      out.write("\tfunction luntanDelete(id) {\n");
      out.write("\t\tif(confirm(\"您确定要删除这个帖子吗？\")) {\n");
      out.write("\t\t\twindow.location=\"luntan?action=delete&id=\"+id;\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("<form action=\"\" method=\"post\">\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label>请选择论坛主题</label>\n");
      out.write("   \n");
      out.write("    <select class=\"form-control\" name=\"zhuti\" id=\"zhuti\">\n");
      out.write("        \n");
      out.write("        <option value=\"bank\">银行</option>\n");
      out.write("      <option value=\"IT\">IT</option>\n");
      out.write("      <option value=\"jg\">金融公司</option>\n");
      out.write("      <option value=\"zhengquan\">证券</option>\n");
      out.write("      \n");
      out.write("    </select>\n");
      out.write("    <input type=\"hidden\" id=\"student\" name=\"student\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentUser.userName }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("    <input type=\"submit\" value=\"搜索\" />\n");
      out.write("  </div> <button class=\"btn btn-success\" type=\"button\" style=\"margin-right: 50px;\" onclick=\"javascript:window.location='luntan?action=preSave'\">添加</button>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("      \n");
      out.write("\n");
      out.write("    <table class=\"table\" style=\"word-break: keep-all\">\n");
      out.write("        \n");
      out.write("\n");
      out.write("   \n");
      out.write("\n");
      out.write("  <caption>学生讨论论坛</caption>\n");
      out.write("  <br>\n");
      out.write("  <thead>\n");
      out.write("    <tr>\n");
      out.write("      <th>编号</th>\n");
      out.write("      <th>学生名称</th>\n");
      out.write("      <th>楼层</th>\n");
      out.write("      <th>内容</th>\n");
      out.write("     <th>操作</th>\n");
      out.write("    </tr>\n");
      out.write("  </thead>\n");
      out.write("  <tbody>\n");
      out.write("   <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.count+(page-1)*pageSize }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("  ");
    
                    
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
                     while(rs.next()){
                      
                     id=rs.getString(1);
                      z= rs.getString(5);
                      l=rs.getString(4);
                      n=rs.getString(3);
                      name= rs.getString(2);
                       if(rs.getInt(3)==1){
                       out.print("<td>"+"匿名用户"+"</td>");
                    }else{
                       out.print("<td>"+rs.getString(2)+"</td>");
                       
                       }
                        out.print("<td>"+rs.getInt(4)+"</td>");
                      
                        out.print("<td>"+rs.getString(6)+"</td>");
                       out.print("<td>");
                      if(name.equals(student)){
                
      out.write("\n");
      out.write("                      <button class=\"btn btn-mini btn-info\" type=\"button\" onclick=\"javascript:window.location='luntan?action=preSave&id=");
      out.print(id);
      out.write("&zhuti=");
      out.print(z);
      out.write("&louceng=");
      out.print(l);
      out.write("&nimingornot=");
      out.print(n);
      out.write("'\">修改</button>&nbsp;\n");
      out.write("\t\t\t\t<button class=\"btn btn-mini btn-danger\" type=\"button\" onclick=\"luntanDelete(");
      out.print(id);
      out.write(")\">删除</button>\n");
      out.write("                 ");
 }
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
                   
                
      out.write("\n");
      out.write("                \n");
      out.write("                </tbody>\n");
      out.write("</table>\n");
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

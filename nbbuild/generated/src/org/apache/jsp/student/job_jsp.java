package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lero.util.StringUtil;
import com.mysql.jdbc.StringUtils;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import com.lero.model.Qiye;

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("         <form action=\"\" method=\"post\">\n");
      out.write("            城市：<input type=\"text\" id=\"city\" name=\"city\"  />\n");
      out.write("            类别：<input type=\"text\" id=\"leibie\" name=\"leibie\"  />\n");
      out.write("            公司简称：<input type=\"text\" id=\"jiancheng\" name=\"jiancheng\"  />\n");
      out.write("             <input type=\"submit\" value=\"搜索\" />\n");
      out.write("         \n");
      out.write("</form>\n");
      out.write("\n");
      out.write("    <table class=\"table table-bordered\">\n");
      out.write("        \n");
      out.write("<div data-spy=\"scroll\" data-target=\"#navbar-example\" data-offset=\"0\"\n");
      out.write("     style=\"height:200px;overflow:auto; position: relative;\">\n");
      out.write("\n");
    
                    
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
            
      out.write("         <h4>");

                       uuid=rs.getString("uuid");
                         String name=rs.getString("name");
                out.print(name);
                
                
      out.write("\n");
      out.write("                \n");
      out.write("            </h4>\n");
      out.write("    <p>城市：");

                      
                         String cityt=rs.getString("city");
                out.print(cityt);
                
                
      out.write("\n");
      out.write("        <br>薪资：\n");
      out.write("        ");

                      
                         String money=rs.getString("money");
                out.print(money);
                
                
      out.write("\n");
      out.write("        <br>企业：");

                      
                         String jianchengt=rs.getString("jiancheng");
                out.print(jianchengt);
                
                
      out.write("\n");
      out.write("        <br>类别：");

                      
                         String leibiet=rs.getString("leibie");
                out.print(leibiet);
                
                
      out.write("\n");
      out.write("         <br> <button class=\"btn btn-mini btn-info\" type=\"button\" onclick=\"javascript:window.location='jstu?action=preSave&uuid=");
      out.print(uuid);
      out.write("'\">查看</button>&nbsp;\n");
      out.write("          <button class=\"btn btn-mini btn-info\" type=\"button\" onclick=\"javascript:window.location='jstu?action=preSave&uuid=");
      out.print(uuid);
      out.write("'\">投递</button>&nbsp;\n");
      out.write("    </p>\n");
      out.write("\n");
      out.write("                 ");
        
                     
                        
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

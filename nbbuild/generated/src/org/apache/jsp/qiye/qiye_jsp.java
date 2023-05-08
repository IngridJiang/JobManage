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
import com.lero.model.Qiye;

public final class qiye_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         <form action=\"\" method=\"post\">\n");
      out.write("             :<input type=\"hidden\" id=\"qh\" name=\"qh\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentUser.userName }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("             <input type=\"submit\" value=\"查找自身账号绑定企业状态\" />\n");
      out.write("         \n");
      out.write("</form>\n");
      out.write("\n");
      out.write("    <table class=\"table table-bordered\">\n");
      out.write("        \n");
      out.write("\n");
    
                    
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
                      
      out.write("\n");
      out.write("                      \n");
      out.write("                      \n");
      out.write("                      <button class=\"btn btn-mini btn-info\" type=\"button\" onclick=\"javascript:window.location='qiyeduan?action=preSave'\">添加企业</button>&nbsp;\n");
      out.write("\t\t\t<button class=\"btn btn-mini btn-info\" type=\"button\" onclick=\"javascript:window.location='m?action=preSave&chaxun=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentUser.userName }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'\">添加后生成主账号，注：不要重复添加</button>&nbsp;\n");
      out.write("                      \n");
      out.write("                      \n");
      out.write("               \n");
      out.write("\n");
      out.write("                      \n");
      out.write("                      \n");
      out.write("                     \n");
      out.write("                 ");
 
                     }else{
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
                      
      out.write("\n");
      out.write("                      <button class=\"btn btn-mini btn-info\" type=\"button\" onclick=\"javascript:window.location='qiyeduan?action=preSave&qh=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentUser.userName }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&&comid=");
      out.print(comid);
      out.write("'\">进入企业修改</button>&nbsp;\n");
      out.write("\t\t\t\t \n");
      out.write("                 ");
 
                     
                     }}}
                     
                     
                     
                     
                     
                    
                     
                     
                    
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

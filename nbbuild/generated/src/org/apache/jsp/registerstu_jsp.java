package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registerstu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("   \n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>学生用户注册</title>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("\t  body {\n");
      out.write("        padding-top: 200px;\n");
      out.write("        padding-bottom: 40px;\n");
      out.write("        background-image: url('images/timg.jpg');\n");
      out.write("        background-position: center;\n");
      out.write("\t\tbackground-repeat: no-repeat;\n");
      out.write("\t\tbackground-attachment: fixed;\n");
      out.write("      }\n");
      out.write("      \n");
      out.write("      .radio {\n");
      out.write("      \tpadding-top: 10px;\n");
      out.write("       \tpadding-bottom:10px;\n");
      out.write("      }\n");
      out.write("      \n");
      out.write("      .form-signin-heading{\n");
      out.write("      \ttext-align: center;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      .form-signin {\n");
      out.write("        max-width: 300px;\n");
      out.write("        padding: 19px 29px 0px;\n");
      out.write("        margin: 0 auto 20px;\n");
      out.write("        background-color: #fff;\n");
      out.write("        border: 1px solid #e5e5e5;\n");
      out.write("        -webkit-border-radius: 5px;\n");
      out.write("           -moz-border-radius: 5px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);\n");
      out.write("           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);\n");
      out.write("                box-shadow: 0 1px 2px rgba(0,0,0,.05);\n");
      out.write("      }\n");
      out.write("      .form-signin .form-signin-heading,\n");
      out.write("      .form-signin .checkbox {\n");
      out.write("        margin-bottom: 10px;\n");
      out.write("      }\n");
      out.write("      .form-signin input[type=\"text\"],\n");
      out.write("      .form-signin input[type=\"password\"] {\n");
      out.write("        font-size: 16px;\n");
      out.write("        height: auto;\n");
      out.write("        margin-bottom: 15px;\n");
      out.write("        padding: 7px 9px;\n");
      out.write("      }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("      <form name=\"rs\" class=\"form-signin\" action=\"rss.jsp\" method=\"post\" onsubmit=\"return checkForm()\">\n");
      out.write("        <h2 class=\"form-signin-heading\"><font color=\"gray\">注册学生用户</font></h2>\n");
      out.write("        <input id=\"stuNum\" name=\"stuNum\" type=\"text\" class=\"input-block-level\" placeholder=\"学号...\">\n");
      out.write("        <input id=\"password\" name=\"password\" type=\"password\" class=\"input-block-level\" placeholder=\"密码...\" >\n");
      out.write("         <input id=\"name\" name=\"name\" type=\"text\" class=\"input-block-level\" placeholder=\"姓名...\" >\n");
      out.write("          <input id=\"tel\" name=\"tel\" type=\"text\" class=\"input-block-level\" placeholder=\"电话...\" >\n");
      out.write("           <input id=\"email\" name=\"email\" type=\"text\" class=\"input-block-level\" placeholder=\"邮箱...\" >\n");
      out.write("            <input id=\"city\" name=\"city\" type=\"text\" class=\"input-block-level\" placeholder=\"城市...\" >\n");
      out.write("            <br><label class=\"radio inline\">性别：\n");
      out.write("      \t  \t<input id=\"nan\" type=\"radio\" name=\"sex\" value=\"nan\"  checked/> 男\n");
      out.write("\t\t</label>\n");
      out.write("\t\t<label class=\"radio inline\">\n");
      out.write("\t\t\t<input id=\"nv\" type=\"radio\" name=\"sec\" value=\"nv\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userType==2?'checked':''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" /> 女\n");
      out.write("\t\t</label>\n");
      out.write("\t\t<br>\n");
      out.write("        <button class=\"btn btn-large btn-primary\" type=\"submit\">注册</button>\n");
      out.write("     \n");
      out.write("      \n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\n");
      out.write("      </form>\n");
      out.write("                <p align=\"center\">< a href=\"login.jsp\"  color=blue>Back  </a>\n");
      out.write("        \n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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

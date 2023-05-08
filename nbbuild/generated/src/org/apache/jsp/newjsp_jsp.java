package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1><table class=\"table table-striped table-bordered table-hover datatable\">\n");
      out.write("\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<!-- <th>编号</th> -->\n");
      out.write("\t\t\t\t\t<th>学号</th>\n");
      out.write("\t\t\t\t\t<th>姓名</th>\n");
      out.write("\t\t\t\t\t<th>性别</th>\n");
      out.write("\t\t\t\t\t<th>邮箱</th>\n");
      out.write("\t\t\t\t\t<th>城市</th>\n");
      out.write("\t\t\t\t\t<th>电话</th>\n");
      out.write("\t\t\t\t\t<th>操作</th>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t</thead>\n");
      out.write("\t\t\t\t<tbody>\n");
      out.write("\t\t\t\t<c:forEach  varStatus=\"i\" var=\"student\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${studentList }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t\t\tform name=\"myForm\" class=\"form-search\" method=\"post\" action=\"student?action=search\" style=\"padding-bottom: 0px\">\n");
      out.write("\t\t\t\t<button class=\"btn btn-success\" type=\"button\" style=\"margin-right: 50px;\" onclick=\"javascript:window.location='student?action=preSave'\">添加</button>\n");
      out.write("\t\t\t\t<span class=\"data_search\">\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<select id=\"searchType\" name=\"searchType\" style=\"width: 80px;\">\n");
      out.write("\t\t\t\t\t<option value=\"name\">姓名</option>\n");
      out.write("\t\t\t\t\t<option value=\"number\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${searchType eq \"number\"?'selected':'' }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">学号</option>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t&nbsp;<input id=\"s_studentText\" name=\"s_studentText\" type=\"text\"  style=\"width:120px;height: 30px;\" class=\"input-medium search-query\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s_studentText }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t\t&nbsp;<button type=\"submit\" class=\"btn btn-info\" onkeydown=\"if(event.keyCode==13) myForm.submit()\">搜索</button>\n");
      out.write("\t\t\t\t</span>\n");
      out.write("\t\t</form>\n");
      out.write("\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t</c:forEach>\n");
      out.write("\t\t\t\t</tbody>\n");
      out.write("\t\t\t</table></h1>\n");
      out.write("    </body>\n");
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

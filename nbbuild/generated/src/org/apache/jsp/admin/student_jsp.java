package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class student_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$(\"ul li:eq(2)\").addClass(\"active\");\r\n");
      out.write("\t$('.datatable').dataTable( {        \t\t\t\t\r\n");
      out.write("\t\t \"oLanguage\": {\r\n");
      out.write("\t\t\t\t\"sUrl\": \"/JobManage/media/zh_CN.json\"\r\n");
      out.write("\t\t },\r\n");
      out.write("\t\t\"bLengthChange\": false, //改变每页显示数据数量\r\n");
      out.write("\t\t\"bFilter\": false, //过滤功能\r\n");
      out.write("\t\t\"aoColumns\": [\r\n");
      out.write("\t\t\tnull,\r\n");
      out.write("\t\t\tnull,\r\n");
      out.write("\t\t\tnull,\r\n");
      out.write("\t\t\tnull,\r\n");
      out.write("\t\t\tnull,\r\n");
      out.write("\t\t\t{ \"asSorting\": [ ] },\r\n");
      out.write("\t\t\t{ \"asSorting\": [ ] }\r\n");
      out.write("\t\t]\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("window.onload = function(){ \r\n");
      out.write("\t$(\"#DataTables_Table_0_wrapper .row-fluid\").remove();\r\n");
      out.write("};\r\n");
      out.write("\tfunction studentDelete(studentId) {\r\n");
      out.write("\t\tif(confirm(\"您确定要删除这个学生吗？\")) {\r\n");
      out.write("\t\t\twindow.location=\"student?action=delete&studentId=\"+studentId;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t.span6 {\r\n");
      out.write("\t\twidth:0px;\r\n");
      out.write("\t\theight: 0px;\r\n");
      out.write("\t\tpadding-top: 0px;\r\n");
      out.write("\t\tpadding-bottom: 0px;\r\n");
      out.write("\t\tmargin-top: 0px;\r\n");
      out.write("\t\tmargin-bottom: 0px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<div class=\"data_list\">\r\n");
      out.write("\t\t<div class=\"data_list_title\">\r\n");
      out.write("\t\t\t学生用户管理\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form name=\"myForm\" class=\"form-search\" method=\"post\" action=\"student?action=search\" style=\"padding-bottom: 0px\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-success\" type=\"button\" style=\"margin-right: 50px;\" onclick=\"javascript:window.location='student?action=preSave'\">添加</button>\r\n");
      out.write("\t\t\t\t<span class=\"data_search\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<select id=\"searchType\" name=\"searchType\" style=\"width: 80px;\">\r\n");
      out.write("\t\t\t\t\t<option value=\"name\">姓名</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"number\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${searchType eq \"number\"?'selected':'' }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">学号</option>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t&nbsp;<input id=\"s_studentText\" name=\"s_studentText\" type=\"text\"  style=\"width:120px;height: 30px;\" class=\"input-medium search-query\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s_studentText }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t&nbsp;<button type=\"submit\" class=\"btn btn-info\" onkeydown=\"if(event.keyCode==13) myForm.submit()\">搜索</button>\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<table class=\"table table-striped table-bordered table-hover datatable\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<!-- <th>编号</th> -->\r\n");
      out.write("\t\t\t\t\t<th>学号</th>\r\n");
      out.write("\t\t\t\t\t<th>姓名</th>\r\n");
      out.write("\t\t\t\t\t<th>性别</th>\r\n");
      out.write("\t\t\t\t\t<th>邮箱</th>\r\n");
      out.write("\t\t\t\t\t<th>城市</th>\r\n");
      out.write("\t\t\t\t\t<th>电话</th>\r\n");
      out.write("\t\t\t\t\t<th>操作</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div align=\"center\"><font color=\"red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</font></div>\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("</div>");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVarStatus("i");
    _jspx_th_c_forEach_0.setVar("student");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${studentList }", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t");
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.stuNum }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.name }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.sex }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.email }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.city }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.tel }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t<td><button class=\"btn btn-mini btn-info\" type=\"button\" onclick=\"javascript:window.location='student?action=preSave&studentId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.studentId }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("'\">修改</button>&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t<button class=\"btn btn-mini btn-danger\" type=\"button\" onclick=\"studentDelete(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.studentId }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(")\">删除</button></td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}

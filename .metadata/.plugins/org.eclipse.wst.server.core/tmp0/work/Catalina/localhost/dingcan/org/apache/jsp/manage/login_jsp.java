/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.53
 * Generated at: 2021-01-10 18:46:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>网站管理员登陆</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("\tmargin-bottom: 0px;\r\n");
      out.write("\tbackground-color: #1D3647;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("function correctPNG()\r\n");
      out.write("{\r\n");
      out.write("    var arVersion = navigator.appVersion.split(\"MSIE\")\r\n");
      out.write("    var version = parseFloat(arVersion[1])\r\n");
      out.write("    if ((version >= 5.5) && (document.body.filters)) \r\n");
      out.write("    {\r\n");
      out.write("       for(var j=0; j<document.images.length; j++)\r\n");
      out.write("       {\r\n");
      out.write("          var img = document.images[j]\r\n");
      out.write("          var imgName = img.src.toUpperCase()\r\n");
      out.write("          if (imgName.substring(imgName.length-3, imgName.length) == \"PNG\")\r\n");
      out.write("          {\r\n");
      out.write("             var imgID = (img.id) ? \"id='\" + img.id + \"' \" : \"\"\r\n");
      out.write("             var imgClass = (img.className) ? \"class='\" + img.className + \"' \" : \"\"\r\n");
      out.write("             var imgTitle = (img.title) ? \"title='\" + img.title + \"' \" : \"title='\" + img.alt + \"' \"\r\n");
      out.write("             var imgStyle = \"display:inline-block;\" + img.style.cssText \r\n");
      out.write("             if (img.align == \"left\") imgStyle = \"float:left;\" + imgStyle\r\n");
      out.write("             if (img.align == \"right\") imgStyle = \"float:right;\" + imgStyle\r\n");
      out.write("             if (img.parentElement.href) imgStyle = \"cursor:hand;\" + imgStyle\r\n");
      out.write("             var strNewHTML = \"<span \" + imgID + imgClass + imgTitle\r\n");
      out.write("             + \" style=\\\"\" + \"width:\" + img.width + \"px; height:\" + img.height + \"px;\" + imgStyle + \";\"\r\n");
      out.write("             + \"filter:progid:DXImageTransform.Microsoft.AlphaImageLoader\"\r\n");
      out.write("             + \"(src=\\'\" + img.src + \"\\', sizingMethod='scale');\\\"></span>\" \r\n");
      out.write("             img.outerHTML = strNewHTML\r\n");
      out.write("             j = j-1\r\n");
      out.write("          }\r\n");
      out.write("       }\r\n");
      out.write("    }    \r\n");
      out.write("}\r\n");
      out.write("window.attachEvent(\"onload\", correctPNG);\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"images/skin.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"100%\" height=\"166\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td height=\"42\" valign=\"top\"><table width=\"100%\" height=\"42\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_top_bg\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"1%\" height=\"21\">&nbsp;</td>\r\n");
      out.write("        <td height=\"42\">&nbsp;</td>\r\n");
      out.write("        <td width=\"17%\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"top\"><table width=\"100%\" height=\"532\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_bg\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"49%\" align=\"right\"><table width=\"91%\" height=\"532\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_bg2\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td height=\"138\" valign=\"top\"><table width=\"89%\" height=\"427\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"149\">&nbsp;</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"80\" align=\"center\" valign=\"top\"><span style=\"font-size: 30px;color: blue;font-weight: bold;\">美食订餐管理后台</span></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"198\" align=\"right\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                    \r\n");
      out.write("                   \r\n");
      out.write("                  </table></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </table></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            \r\n");
      out.write("        </table></td>\r\n");
      out.write("        <td width=\"1%\" >&nbsp;</td>\r\n");
      out.write("        <td width=\"50%\" valign=\"bottom\"><table width=\"100%\" height=\"59\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"4%\">&nbsp;</td>\r\n");
      out.write("              <td width=\"96%\" height=\"38\"><span class=\"login_txt_bt\">用户登录</span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("              <td height=\"21\"><table cellSpacing=\"0\" cellPadding=\"0\" width=\"100%\" border=\"0\" id=\"table211\" height=\"328\">\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td height=\"164\" colspan=\"2\" align=\"middle\">\r\n");
      out.write("                    <form name=\"myform\" action=\"houtaimethod!login\" method=\"post\">\r\n");
      out.write("                        <table cellSpacing=\"0\" cellPadding=\"0\" width=\"100%\" border=\"0\" height=\"143\" id=\"table212\">\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"13%\" height=\"38\" class=\"top_hui_text\"><span class=\"login_txt\">用户名：&nbsp;&nbsp; </span></td>\r\n");
      out.write("                            <td height=\"38\" colspan=\"2\" class=\"top_hui_text\">\r\n");
      out.write("                            <input name=\"username\" class=\"editbox4\" value=\"\" style=\"width: 200px;\">                            \r\n");
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"13%\" height=\"35\" class=\"top_hui_text\"><span class=\"login_txt\"> 密 码： &nbsp;&nbsp; </span></td>\r\n");
      out.write("                            <td height=\"35\" colspan=\"2\" class=\"top_hui_text\">\r\n");
      out.write("                            <input class=\"editbox4\" type=\"password\" style=\"width: 200px;\" name=\"password\">\r\n");
      out.write("                              <img src=\"images/luck.gif\" width=\"19\" height=\"18\"> </td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          \r\n");
      out.write("                          \r\n");
      out.write("                         \r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td height=\"35\" >&nbsp;</td>\r\n");
      out.write("                            <td width=\"20%\" height=\"35\" ><input name=\"Submit\" type=\"submit\" class=\"button\" id=\"Submit\" value=\"登 录\"> </td>\r\n");
      out.write("                            <td width=\"67%\" class=\"top_hui_text\"><input name=\"cs\" type=\"button\" class=\"button\" id=\"cs\" value=\"取 消\" onClick=\"showConfirmMsg1()\"></td>\r\n");
      out.write("                            <td height=\"35\" ><a href=\"../\">返回首页</a></td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                        </table>\r\n");
      out.write("                        <br>\r\n");
      out.write("                    </form></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td width=\"433\" height=\"164\" align=\"right\" valign=\"bottom\"><img src=\"images/login-wel.gif\" width=\"242\" height=\"138\"></td>\r\n");
      out.write("                    <td width=\"57\" align=\"right\" valign=\"bottom\">&nbsp;</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("              </table></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("          </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td height=\"20\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"login-buttom-bg\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"center\"><span class=\"login-buttom-txt\"></span></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.19
 * Generated at: 2024-04-21 07:59:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.Views;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import Model.Utilisateur;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(1);
    _jspx_imports_classes.add("Model.Utilisateur");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("	<header>      \n");
      out.write("      <div class=\"navbar p-3 navbar-dark bg-dark box-shadow\">\n");
      out.write("        <div class=\"container d-flex justify-content-between\">\n");
      out.write("          <a href=\"cata\" class=\"navbar-brand d-flex align-items-center\">\n");
      out.write("            <strong>Catalogue des biens</strong>\n");
      out.write("          </a>\n");
      out.write("          <a href=\"affichecommande\" class=\"navbar-brand d-flex align-items-right\">\n");
      out.write("            <strong>Liste de Commande</strong>\n");
      out.write("          </a>\n");
      out.write("          <a href=\"profile\" class=\"navbar-brand d-flex align-items-right\">\n");
      out.write("            <strong>Gere profile</strong>\n");
      out.write("          </a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </header>\n");
      out.write("	");

		Utilisateur u = (Utilisateur)request.getAttribute("user");
	
      out.write("\n");
      out.write("	<div class=\"container mt-4\">\n");
      out.write("		<p class=\"fs-2 text-center mb-4\">Gérer votre profile</p>\n");
      out.write("		<center><img src=\"https://mdbcdn.b-cdn.net/img/new/avatars/2.webp\" class=\"rounded-circle\" style=\"width: 150px;\"\n");
      out.write("  				alt=\"Avatar\" /></center>\n");
      out.write("	\n");
      out.write("    	<form name=\"f2\" action=\"updateProfile\" method=\"post\">	\n");
      out.write("	        <div class=\"form-outline form-white mt-3 mb-4\">	              	\n");
      out.write("	          <input type=\"text\" name=\"nom\" value=\"");
      out.print(u.getNom() );
      out.write("\" class=\"form-control form-control-lg\" />	                \n");
      out.write("	        </div>\n");
      out.write("	        <div class=\"form-outline form-white mb-4\">	              	\n");
      out.write("	          <input type=\"text\" name=\"prenom\" value=\"");
      out.print(u.getPrenom() );
      out.write("\" class=\"form-control form-control-lg\" />	                \n");
      out.write("	        </div>\n");
      out.write("	        <div class=\"form-outline form-white mb-4\">	              	\n");
      out.write("	          <input type=\"text\" name=\"email\" value=\"");
      out.print(u.getEmail() );
      out.write("\" class=\"form-control form-control-lg\" />	                \n");
      out.write("	        </div>	        \n");
      out.write("		    <div class=\"form-outline form-white mb-4\">	              	\n");
      out.write("	          <input type=\"password\" name=\"mdp\" value=\"");
      out.print(u.getMdp() );
      out.write("\" class=\"form-control form-control-lg\" required/>	                \n");
      out.write("	        </div>  \n");
      out.write("	        <input type=\"hidden\" name=\"iduser\" value=\"");
      out.print(u.getId() );
      out.write("\">\n");
      out.write("	        \n");
      out.write("	        <div class=\"form-outline form-white mb-4\">	              	\n");
      out.write("	          <input type=\"submit\" name=\"btn\" value=\"Modifier\" class=\"form-control form-control-lg bg-warning\" />	                \n");
      out.write("	        </div>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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

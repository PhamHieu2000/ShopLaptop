/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.71
 * Generated at: 2023-12-11 09:47:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nevbar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1701851092221L));
    _jspx_dependants.put("jar:file:/C:/ITPLUS/ShopLaptop/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ShopLaptop/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
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

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("	<head>\r\n");
      out.write("		<meta charset=\"utf-8\">\r\n");
      out.write("		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\r\n");
      out.write("\r\n");
      out.write("		<title>Electro - HTML Ecommerce Template</title>\r\n");
      out.write("\r\n");
      out.write("		<!-- Google font -->\r\n");
      out.write("		<link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,500,700\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("		<!-- Bootstrap -->\r\n");
      out.write("		<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/bootstrap.min.css\"/>\r\n");
      out.write("\r\n");
      out.write("		<!-- Slick -->\r\n");
      out.write("		<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/slick.css\"/>\r\n");
      out.write("		<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/slick-theme.css\"/>\r\n");
      out.write("\r\n");
      out.write("		<!-- nouislider -->\r\n");
      out.write("		<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/nouislider.min.css\"/>\r\n");
      out.write("\r\n");
      out.write("		<!-- Font Awesome Icon -->\r\n");
      out.write("		<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("		<!-- Custom stlylesheet -->\r\n");
      out.write("		<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/style.css\"/>\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/052f2cbb8d.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("		<!--[if lt IE 9]>\r\n");
      out.write("		  <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\r\n");
      out.write("		  <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n");
      out.write("		<![endif]-->\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("	<body>\r\n");
      out.write("	\r\n");
      out.write("		<!-- HEADER -->\r\n");
      out.write("		<header>\r\n");
      out.write("			<!-- TOP HEADER -->\r\n");
      out.write("			<div id=\"top-header\">\r\n");
      out.write("				<div class=\"container\">\r\n");
      out.write("					<ul class=\"header-links pull-left\">\r\n");
      out.write("						<li><a href=\"#\"><i class=\"fa fa-phone\"></i> +021-95-51-84</a></li>\r\n");
      out.write("						<li><a href=\"#\"><i class=\"fa fa-envelope-o\"></i> email@email.com</a></li>\r\n");
      out.write("						<li><a href=\"#\"><i class=\"fa fa-map-marker\"></i> 1734 Stonecoal Road</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("					<ul class=\"header-links pull-right\">\r\n");
      out.write("						<li><a href=\"#\"><i class=\"fa fa-dollar\"></i> USD</a></li>\r\n");
      out.write("						<li><a href=\"#\"><i class=\"fa fa-user-o\"></i> My Account</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<!-- /TOP HEADER -->\r\n");
      out.write("\r\n");
      out.write("			<!-- MAIN HEADER -->\r\n");
      out.write("			<div id=\"header\">\r\n");
      out.write("				<!-- container -->\r\n");
      out.write("				<div class=\"container\">\r\n");
      out.write("					<!-- row -->\r\n");
      out.write("					<div class=\"row\">\r\n");
      out.write("						<!-- LOGO -->\r\n");
      out.write("						<div class=\"col-md-3\">\r\n");
      out.write("							<div class=\"header-logo\">\r\n");
      out.write("								<a href=\"#\" class=\"logo\">\r\n");
      out.write("									<img src=\"views/admin/img/logo.png\" alt=\"\">\r\n");
      out.write("								</a>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<!-- /LOGO -->\r\n");
      out.write("\r\n");
      out.write("						<!-- SEARCH BAR -->\r\n");
      out.write("						<div class=\"col-md-6\">\r\n");
      out.write("							<div class=\"header-search\">\r\n");
      out.write("								<form>\r\n");
      out.write("									<select class=\"input-select col-md-3\">\r\n");
      out.write("										<option value=\"0\">Tất cả</option>\r\n");
      out.write("										<option value=\"1\">Laptop Gaming</option>\r\n");
      out.write("										<option value=\"2\">Laptop Văn Phòng</option>\r\n");
      out.write("										<option value=\"3\">Phụ Kiện LapTop</option>\r\n");
      out.write("										\r\n");
      out.write("									</select>\r\n");
      out.write("									<input class=\"input col-md-7\" placeholder=\"Tìm Kiếm ...\">\r\n");
      out.write("									<label style=\"display: flex;justify-content: center;align-items: center;\" class=\"search-btn col-md-2\"><i style=\"cursor:pointer;\" class=\"fa-solid fa-magnifying-glass\"></i></label>\r\n");
      out.write("								</form>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<!-- /SEARCH BAR -->\r\n");
      out.write("\r\n");
      out.write("						<!-- ACCOUNT -->\r\n");
      out.write("						<div class=\"col-md-3 clearfix\">\r\n");
      out.write("							<div class=\"header-ctn\">\r\n");
      out.write("								<!-- Wishlist -->\r\n");
      out.write("								<div>\r\n");
      out.write("									<a href=\"#\">\r\n");
      out.write("										<i class=\"fa fa-heart-o\"></i>\r\n");
      out.write("										<span>Yêu Thích</span>\r\n");
      out.write("										<div class=\"qty\">2</div>\r\n");
      out.write("									</a>\r\n");
      out.write("								</div>\r\n");
      out.write("								<!-- /Wishlist -->\r\n");
      out.write("\r\n");
      out.write("								<!-- Cart -->\r\n");
      out.write("								<div class=\"dropdown\">\r\n");
      out.write("									<a class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"true\">\r\n");
      out.write("										<i class=\"fa fa-shopping-cart\"></i>\r\n");
      out.write("										<span>Giỏ Hàng</span>\r\n");
      out.write("										<div class=\"qty\">3</div>\r\n");
      out.write("									</a>\r\n");
      out.write("									<div class=\"cart-dropdown\">\r\n");
      out.write("										<div class=\"cart-list\">\r\n");
      out.write("											<div class=\"product-widget\">\r\n");
      out.write("												<div class=\"product-img\">\r\n");
      out.write("													<img src=\"views/admin/img/product01.png\" alt=\"\">\r\n");
      out.write("												</div>\r\n");
      out.write("												<div class=\"product-body\">\r\n");
      out.write("													<h3 class=\"product-name\"><a href=\"#\">product name goes here</a></h3>\r\n");
      out.write("													<h4 class=\"product-price\"><span class=\"qty\">1x</span>$980.00</h4>\r\n");
      out.write("												</div>\r\n");
      out.write("												<button class=\"delete\"><i class=\"fa fa-close\"></i></button>\r\n");
      out.write("											</div>\r\n");
      out.write("\r\n");
      out.write("											<div class=\"product-widget\">\r\n");
      out.write("												<div class=\"product-img\">\r\n");
      out.write("													<img src=\"views/admin/img/product02.png\" alt=\"\">\r\n");
      out.write("												</div>\r\n");
      out.write("												<div class=\"product-body\">\r\n");
      out.write("													<h3 class=\"product-name\"><a href=\"#\">product name goes here</a></h3>\r\n");
      out.write("													<h4 class=\"product-price\"><span class=\"qty\">3x</span>$980.00</h4>\r\n");
      out.write("												</div>\r\n");
      out.write("												<button class=\"delete\"><i class=\"fa fa-close\"></i></button>\r\n");
      out.write("											</div>\r\n");
      out.write("										</div>\r\n");
      out.write("										<div class=\"cart-summary\">\r\n");
      out.write("											<small>3 Item(s) selected</small>\r\n");
      out.write("											<h5>SUBTOTAL: $2940.00</h5>\r\n");
      out.write("										</div>\r\n");
      out.write("										<div class=\"cart-btns\">\r\n");
      out.write("											<a href=\"#\">View Cart</a>\r\n");
      out.write("											<a href=\"#\">Checkout  <i class=\"fa fa-arrow-circle-right\"></i></a>\r\n");
      out.write("										</div>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("								<!-- /Cart -->\r\n");
      out.write("\r\n");
      out.write("								<!-- Menu Toogle -->\r\n");
      out.write("								<div class=\"menu-toggle\">\r\n");
      out.write("									<a href=\"#\">\r\n");
      out.write("										<i class=\"fa fa-bars\"></i>\r\n");
      out.write("										<span>Menu</span>\r\n");
      out.write("									</a>\r\n");
      out.write("								</div>\r\n");
      out.write("								<!-- /Menu Toogle -->\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<!-- /ACCOUNT -->\r\n");
      out.write("					</div>\r\n");
      out.write("					<!-- row -->\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- container -->\r\n");
      out.write("			</div>\r\n");
      out.write("			<!-- /MAIN HEADER -->\r\n");
      out.write("		</header>\r\n");
      out.write("		<!-- /HEADER -->\r\n");
      out.write("\r\n");
      out.write("		<!-- NAVIGATION -->\r\n");
      out.write("		<nav id=\"navigation\">\r\n");
      out.write("			<!-- container -->\r\n");
      out.write("			<div class=\"container\">\r\n");
      out.write("				<!-- responsive-nav -->\r\n");
      out.write("				<div id=\"responsive-nav\">\r\n");
      out.write("					<!-- NAV -->\r\n");
      out.write("					<ul class=\"main-nav nav navbar-nav\">\r\n");
      out.write("						<li ><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/list-category\">Trang chủ</a></li>\r\n");
      out.write("						<li ><a href=\"#\">Laptop Gaming</a></li>\r\n");
      out.write("						<li ><a href=\"#\">Laptop Văn Phòng</a></li>\r\n");
      out.write("						<li ><a href=\"#\">Phụ Kiện</a></li>\r\n");
      out.write("						\r\n");
      out.write("						<li ><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/addproduct\">Thêm sản phẩm</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("					<!-- /NAV -->\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- /responsive-nav -->\r\n");
      out.write("			</div>\r\n");
      out.write("			<!-- /container -->\r\n");
      out.write("		</nav>\r\n");
      out.write("		<!-- /NAVIGATION -->\r\n");
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		<!-- jQuery Plugins -->\r\n");
      out.write("		<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/jquery.min.js\"></script>\r\n");
      out.write("		<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap.min.js\"></script>\r\n");
      out.write("		<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/slick.min.js\"></script>\r\n");
      out.write("		<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/nouislider.min.js\"></script>\r\n");
      out.write("		<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/jquery.zoom.min.js\"></script>\r\n");
      out.write("		<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	</body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /views/admin/nevbar.jsp(4,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/views/admin");
      // /views/admin/nevbar.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setVar("url");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }
}

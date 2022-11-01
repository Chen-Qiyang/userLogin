<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: chenqiyang
  Date: 2022/10/17
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>处理登录请求</title>
</head>
<body>
<jsp:useBean id="loginUser" class="org.csu.bean.UserInfo" scope="page"/>
<jsp:setProperty name="loginUser" property="*"/>
<%
  if(loginUser.login() == false){
    String msg = "用户名或密码错误，请重新登录";
    request.setAttribute("loginMsg",msg);
    request.getRequestDispatcher("index.jsp").forward(request,response);
  }
  else {
    session.setAttribute("loginUser",loginUser);
    response.sendRedirect("result.jsp");
  }
%>
</body>
</html>


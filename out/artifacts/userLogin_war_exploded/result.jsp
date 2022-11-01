<%@ page import="org.csu.bean.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: chenqiyang
  Date: 2022/10/17
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>网站主页面</title>
</head>
<body>
  <%! UserInfo loginUser; %>
  <%
    loginUser = (UserInfo) session.getAttribute("loginUser");
    if(loginUser == null) {
      out.print("您还没有登录，请重新<a href='index.jsp'>登录</a>");
    }
  %>
    ${sessionScope.loginUser.username}用户，您好！欢迎登录本网站
</body>
</html>

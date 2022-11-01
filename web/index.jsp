<%--
  Created by IntelliJ IDEA.
  User: chenqiyang
  Date: 2022/10/17
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>欢迎登录本网站</title>
</head>
<body>
<form action="login.jsp" method="post">
  <table align="center">
    <tr>
      <td colspan="2" align="center"><h2>欢迎登录</h2></td>
    </tr>
    <tr>
      <td>用户名：</td>
      <td><input type="text" name="username"/></td>
    </tr>
    <tr>
      <td>密&nbsp&nbsp&nbsp&nbsp码：</td>
      <td><input type="password" name="password"/></td>
    </tr>
    <tr>
      <td colspan="2" align="right">
        <%
          String loginMsg = (String)request.getAttribute("loginMsg");
          if(loginMsg != null)
          {
            out.print("<font color = 'red'>"+loginMsg+"</font>");
          }
        %>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="right"><input type="submit" value="登录"/></td>
    </tr>
  </table>
</form>
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-05-02
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
this is success!

WELCOME : <shiro:principal />
<br>
<shiro:hasRole name="admin">
    <a href="/ssm/admin">admin page</a>
    <br>
</shiro:hasRole>
<shiro:hasRole name="test">
    <a href="/ssm/user">user page</a>
    <br>
</shiro:hasRole>




<a href="/ssm/testShiroAnno">Test ShiroAnno</a>
<a href="/ssm/logout">Logout</a>
</body>
</html>

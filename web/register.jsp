<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/21
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/RegisterServlet" method="post" >
    <table cellspacing="0" cellpadding="10">
        <caption align="center">用户注册表单</caption>
        <therd></therd>
        <tbody>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" placeholder="请输入Email" name="email"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" placeholder="请输入你的真实姓名" name="name"></td>
        </tr>
        <tr>
            <td>手机号码</td>
            <td><input type="text" name="phone" placeholder="请输入手机号码"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                男<input type="radio" name="sex" value="男" checked>
                女<input type="radio" name="sex" value="女">
            </td>
        </tr>
        <tr>
            <td>出生日期</td>
            <td><input type="date" name="birthday"></td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="注册"></td>
        </tr>
        </tfoot>
    </table>
</form>
${pageContext.request.getAttribute("omg")}
</body>
</html>

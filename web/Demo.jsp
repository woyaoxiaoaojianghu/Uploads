<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action=${pageContext.request.contextPath}/ServletUploads method="post" enctype="multipart/form-data">
    <input type="file" value="选择图片"name="picture"><br>
    <input type="submit">
</form>
</body>
</html>

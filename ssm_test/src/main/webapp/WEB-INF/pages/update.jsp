<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>修改图书信息</h3>
<form action="update" method="post">
    <input type="hidden" name="id" value="${bookInfo.id}">
    图书名：<input type="text" name="bookname" value="${bookInfo.bookname}"><br/>
    作    者：<input type="text" name="author" value="${bookInfo.author}"><br/>
    简    介：<input type="text" name="intro" value="${bookInfo.intro}"><br/>
    <input type="submit" value="修改">
</form>
</body>
</html>

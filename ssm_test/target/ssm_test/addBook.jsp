<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>添加图书信息</h3>
    <form action="info/bookInfo/add" method="post">
        图书名：<input type="text" name="bookname"><br/>
        作    者：<input type="text" name="author"><br/>
        简    介：<input type="text" name="intro"><br/>
        <input type="submit" value="添加">
    </form>
</body>
</html>

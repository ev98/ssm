<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>登陆成功,欢迎${loginInfo.name}来到图书管理系统</h3><br/>
    <a href="../../addBook.jsp">添加图书信息</a>
    <form action="bookInfo/findAll" method="post">
        <table border="1" cellspacing="0">
            <tr>
                <th>序号</th>
                <th>书名</th>
                <th>作者</th>
                <th>简介</th>
                <th>管理</th>
            </tr>
            <c:forEach items="${bisAll}" var="bookInfo" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${bookInfo.bookname}</td>
                    <td>${bookInfo.author}</td>
                    <td>${bookInfo.intro}</td>
                    <td><a href="findById?id=${bookInfo.id}">修改</a><a href="delete?id=${bookInfo.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" value="查询">
    </form>

</body>
</html>

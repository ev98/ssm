<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--常用注解--%>

    <a href="anno/testRequestParam?name=ev">RequestParam</a>

    <form action="anno/testModelAttribute" method="post">
        用户姓名：<input type="text" name="name"><br>
        用户年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <a href="anno/testSessionAttributes">SessionAttributes</a><br/>

    <a href="anno/getSessionAttributes">getSessionAttributes</a><br/>
    
    <a href="anno/delSessionAttributes">delSessionAttributes</a>
</body>
</html>

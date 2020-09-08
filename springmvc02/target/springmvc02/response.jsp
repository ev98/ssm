<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                /*alert("hello btn");*/
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                   url:"user/testAjax",
                   contentType:"application/json;charset=UTF-8",
                   data:'{"username":"ev","password":"123","age":30}',
                   dataType:"json",
                   type:"post",
                   success:function (data) {
                        //data服务器端响应json的数据，进行解析
                       alert(data);
                       alert(data.username);
                       alert(data.password);
                       alert(data.age);
                   }
                });
            });
        });
    </script>
</head>
<body>

    <a href="user/testString">testString</a><br/>

    <a href="user/testVoid">testVoid</a><br/>

    <a href="user/testModelAndView">testModelAndView</a><br/>

    <button id="btn">发送ajax请求</button>

</body>
</html>

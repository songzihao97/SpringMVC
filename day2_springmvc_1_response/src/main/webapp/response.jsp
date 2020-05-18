<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>

        <script src="js/jquery.min.js"></script>
        
        <script>
            //页面加载绑定单机事件
            $(function () {
                $("#btn").click(function () {
                    //alert("hello btn!")
                    //发送ajax
                    $.ajax({
                        //编写json格式，设置属性值
                        url:"user/testAjax",
                        contentType:"application/json;charset=UTF-8",
                        data: '{"username":"haha","password":"123","age":23}',
                        dataType:"json",
                        type:"POST",
                        success:function (data) {
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
        <a href="user/testString">testString</a>

        <br>

        <a href="user/testVoid">testVoid</a>

        <br>

        <a href="user/testModelAndView">testModelAndView</a>

        <br>

        <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>

        <br>

        <button id="btn">发送ajax请求</button>

    </body>
</html>

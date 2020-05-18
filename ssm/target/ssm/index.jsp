<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h3>ssm测试</h3>

        <a href="account/findAll">测试查询</a>

        <h3>测试保存</h3>
        <form method="post" action="account/saveAccount">
            用户名：<input type="text" name="name"><br>
            钱数：<input type="text" name="money"><br>
            <input type="submit" value="提交">
        </form>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--请求参数绑定
    <a href="param/testParam?username=haha&password=123">请求参数绑定</a>
    --%>
    <%--封装bean对象
    <form action="param/savAccount" method="post">
        姓名:<input type="text" name="username">
        密码:<input type="password" name="password">
        money:<input type="text" name="money">
        <input type="submit" value="提交">
    </form>
    --%>
    <%--
    <form action="param/savAccount" method="post">
        姓名:<input type="text" name="username">
        密码:<input type="password" name="password">
        money:<input type="text" name="money">
        用户姓名:<input type="text" name="user.uname">
        年龄:<input type="text" name="user.age">
        生日:<input type="text" name="user.birthday">
        <input type="submit" value="提交">
    </form>
    --%>
    <%--
    <form action="param/savAccount" method="post">
        姓名:<input type="text" name="username">
        密码:<input type="password" name="password">
        money:<input type="text" name="money">

        用户姓名:<input type="text" name="list[0].uname">
        年龄:<input type="text" name="list[0].age">
        生日:<input type="text" name="list[0].birthday">

        用户姓名:<input type="text" name="map['test'].uname">
        年龄:<input type="text" name="map['test'].age">
        生日:<input type="text" name="map['test'].birthday">
        <input type="submit" value="提交">
    </form>
    --%>
    <%--
    <form action="param/savUser" method="post">
        用户姓名:<input type="text" name="uname">
        年龄:<input type="text" name="age">
        生日:<input type="text" name="birthday">
        <input type="submit" value="提交">
    </form>
    --%>

    <a href="param/testServlet">获取servlet原生api</a>
</body>
</html>

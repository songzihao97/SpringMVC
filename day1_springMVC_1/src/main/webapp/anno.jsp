<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--常用注解 --%>
    <a href="anno/testRequestParam?username=haha">RequestParam</a>

    <br>
    <form action="anno/testRequestBody" method="post">
        用户姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>
    <br>
    <a href="anno/testPathVariable//haha">PathVariable</a>
    <br>
    <a href="anno/testCookieValue">testCookieValue</a>

    <br>
    <form action="anno/testModelAttribute" method="post">
        用户姓名:<input type="text" name="uname"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>
    <br>
    <a href="anno/testSessionAttributes">SessionAttributes</a>
    <br>
    <a href="anno/getSessionAttributes">getSessionAttributes</a>
    <br>
    <a href="anno/delSessionAttributes">delSessionAttributes</a>
</body>
</html>

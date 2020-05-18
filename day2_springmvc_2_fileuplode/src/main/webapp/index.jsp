<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <h3>传统文件上传</h3>

        <form action="user/fileUpLode1" method="post" enctype="multipart/form-data">
            选择文件：<input type="file" name="upLode"><br>
            <input type="submit" value="上传">
        </form>

        <h3>springmvc文件上传</h3>

        <form action="user/fileUpLode2" method="post" enctype="multipart/form-data">
            选择文件：<input type="file" name="upLode"><br>
            <input type="submit" value="上传">
        </form>

        <h3>跨服务器文件上传</h3>

        <form action="user/fileUpLode3" method="post" enctype="multipart/form-data">
            选择文件：<input type="file" name="upLode"><br>
            <input type="submit" value="上传">
        </form>
    </body>
</html>
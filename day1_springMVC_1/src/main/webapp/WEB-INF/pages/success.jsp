<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h3>入门成功</h3>

    <%--${requestScope}--%>

    <br>

    ${requestScope.msg}

    <br>

    ${sessionScope}
</body>
</html>

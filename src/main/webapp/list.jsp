<%--
  Created by IntelliJ IDEA.
  User: yxq
  Date: 2020/7/25
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${list}" var="admin">
    ${admin.account}<br/>
</c:forEach>

</body>
</html>

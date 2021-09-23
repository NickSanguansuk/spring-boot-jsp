<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <%--<script type="text/javascript" src="js/script.js" defer></script>--%>
</head>
<body>
<h1>Login Page</h1>
<p>Please login here.</p>

<form method="post" action="login">
    <c:if test="${not empty loginMessage}">
        <span style='color:red'>${loginMessage}</span>
        <br>
    </c:if>
    UserName:
    <input type="text" name="username" required>
    <br>
    Password:
    <input type="password" name="password" required>
    <br>
    <input type="submit" name="login" value="Login">
</form>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login2 Login Page</title>
    <%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <%--<script type="text/javascript" src="js/script.js" defer></script>--%>
</head>
<body>
<header>

</header>
<main>
    <section>
        <h1>Login2 Login Page</h1>
        <p>Please login here.</p>
    </section>
    <section>
        <form method="post" action="login">
            <%--<form method="post" action="/login2/login">--%>

            <c:if test="${error}">
                <div style="color:red">Invalid email or password.</div>
            </c:if>

            <c:if test="${not empty loginMessage}">
                <span style='color:red'>${loginMessage}</span>
                <br>
            </c:if>

            <hr>

            <label>
                Username:
                <input type="text" name="username" value="" required>
            </label>
            <br>

            <label>
                Password:
                <input type="password" name="password" value="" required>
            </label>
            <br>

            <input type="submit" name="login" value="Login">
        </form>
    </section>
</main>
<footer>

</footer>
</body>
</html>

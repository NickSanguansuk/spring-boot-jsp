<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <%--<script type="text/javascript" src="js/script.js" defer></script>--%>
</head>
<body>
<header>

</header>
<main>
    <section>
        <h1>Spring_Boot_JSP - demo/index.jsp</h1>
        <h2>This is the index page for your case study. Where users come when they hit the / url</h2>
    </section>
    <section>
        url parameter
        <br>
        name = ${name}
        <br>
        id = ${id}
        <br>
        <form action="index.jsp">
            Name: <input type="text" name="name" value="${name}">
            <br>
            Id: <input type="text" name="id" value="${id}">
            <br>
            <input type="submit">
        </form>
        <br>
    </section>
    <section>
        <a href="login/login">---> Go to "login/login" Page</a>
        <br>
        <a href="login/create-user">---> Go to "login/create-user" Page</a>
        <br>
        <a href="search/search">---> Go to "search/search" Page</a>
        <br>
    </section>
</main>
<footer>

</footer>
</body>
</html>
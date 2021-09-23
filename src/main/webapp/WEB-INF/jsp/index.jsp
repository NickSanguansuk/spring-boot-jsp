<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <%--<script type="text/javascript" src="js/script.js" defer></script>--%>
</head>
<body>
<main>
    <h1>Spring_Boot_JSP - demo/index.jsp</h1>
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

</main>
</body>
</html>
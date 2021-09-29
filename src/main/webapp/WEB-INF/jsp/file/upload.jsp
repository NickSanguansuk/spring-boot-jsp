<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>File Upload Page</title>
    <%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <%--<script type="text/javascript" src="js/script.js" defer></script>--%>
</head>
<body>
<header>

</header>
<main>
    <section>
        <form method="post" action="upload" enctype="multipart/form-data">
            <label>
                Put file description here:
                <input type="text" name="text">
            </label>
            <br>
            <label>
                Select file to upload:
                <br>
                <input type="file" name="file">
                <br>
                <input type="submit" name="submit" value="Submit">
            </label>
        </form>
    </section>
</main>
<footer>

</footer>
</body>
</html>

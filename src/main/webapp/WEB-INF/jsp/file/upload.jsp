<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>File Upload Page</title>
    <%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles-file-upload.css">
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
                <%--<input type="file" name="file">--%>
                <%--<br>--%>
                <%--<input type="file" name="file">--%>
                <%--<br>--%>
                <input type="submit" name="submit" value="Submit">
            </label>
        </form>
        <br>
    </section>
    <section>
        <h2>Submitted File</h2>
        <table>
            <tr>
                <td>OriginalFileName:</td>
                <td>${fileSubmitted.originalFilename}</td>
            </tr>
            <tr>
                <td>Type:</td>
                <td>${fileSubmitted.contentType}</td>
            </tr>
        </table>
    </section>
    <section>
        <img class="uploaded-image" src="https://wasin-first-bucket.s3.us-east-2.amazonaws.com/images/${imageName}">
    </section>
</main>
<footer>

</footer>
</body>
</html>

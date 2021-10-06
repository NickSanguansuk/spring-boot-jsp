<%--
  Created by IntelliJ IDEA.
  User: Conea2020
  Date: 10/6/2021
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Time Demo</title>
</head>
<body>
<main>
    <section>
        <form action="timeSubmit" method="get">
            <label>
                Full Date:
                <input type="text" name="fullDate">
                <br>
                Start Time:
                <input type="text" name="startTime">
                <br>
                End Time:
                <input type="text" name="endTime">
                <br>
                <input type="submit" name="submit" value="Submit">
            </label>
        </form>
    </section>
</main>
</body>
</html>

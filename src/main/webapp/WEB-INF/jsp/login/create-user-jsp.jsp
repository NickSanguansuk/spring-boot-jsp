<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create User Page</title>
    <%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <%--<script type="text/javascript" src="js/script.js" defer></script>--%>
</head>
<body>
<h1>Create User Page</h1>
<p>Please create a new user here.</p>

<form method="post" action="create-user">

    <%--<c:if test="${not empty createUserMessage}">--%>
    <%--    <span style='color:red'>${createUserMessage}</span>--%>
    <%--    <br>--%>
    <%--</c:if>--%>

    <c:forEach items="${errorMessages}" var="errorMessage">
        <span style='color:red'>${errorMessage}</span>
        <br>
    </c:forEach>

    <hr>

    <label>
        Email:
        <%--<input type="email" name="email" value="${form.email}" required>--%>
        <input type="text" name="email" value="${form.email}">
        <c:forEach items="${errorFields}" var="errorField">
            <c:if test='${errorField.field == "email"}'>
                <br>
                <span style='color:red'>${errorField.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </label>
    <br>

    <label>
        Password:
        <%--<input type="password" name="password" value="${form.password}" required>--%>
        <input type="text" name="password" value="${form.password}">
        <c:forEach items="${errorFields}" var="errorField">
            <c:if test='${errorField.field == "password"}'>
                <br>
                <span style='color:red'>${errorField.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </label>
    <br>

    <label>
        Confirm Password:
        <%--<input type="password" name="confirmPassword" value="${form.confirmPassword}" required>--%>
        <input type="text" name="confirmPassword" value="${form.confirmPassword}">
        <c:forEach items="${errorFields}" var="errorField">
            <c:if test='${errorField.field == "confirmPassword"}'>
                <br>
                <span style='color:red'>${errorField.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </label>
    <br>

    <label>
        Full Name:
        <%--<input type="text" name="fullName" value="${form.fullName}" required>--%>
        <input type="text" name="fullName" value="${form.fullName}">
        <c:forEach items="${errorFields}" var="errorField">
            <c:if test='${errorField.field == "fullName"}'>
                <br>
                <span style='color:red'>${errorField.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </label>
    <br>

    <label>
        Phone Number:
        <input type="text" name="phone" value="${form.phone}">
        <c:forEach items="${errorFields}" var="errorField">
            <c:if test='${errorField.field == "phone"}'>
                <br>
                <span style='color:red'>${errorField.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </label>
    <br>

    <input type="submit" name="submit" value="Submit">
</form>

</body>
</html>

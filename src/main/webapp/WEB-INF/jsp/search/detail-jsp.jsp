<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Detail Page</title>
    <%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <%--<script type="text/javascript" src="js/script.js" defer></script>--%>
</head>
<body>
<header>

</header>
<main>
    <section>
        <h1>Search Detail Page</h1>
        <p>This page is displaying search details.</p>
        <br>
    </section>
    <section>
        <h3>Details of: ${user.email}</h3>
        <table>
            <tr>
                <td>ID</td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td>First Name</td>
                <td>${user.firstName}</td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td>${user.lastName}</td>
            </tr>
            <tr>
                <td>email</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Password</td>
                <td>${user.password}</td>
            </tr>
            <tr>
                <td>Phone</td>
                <td>${user.phone}</td>
            </tr>
            <tr>
                <td>Address</td>
                <td>${user.address}</td>
            </tr>

            <tr>
                <td>City</td>
                <td>${user.city}</td>
            </tr>
            <tr>
                <td>State</td>
                <td>${user.state}</td>
            </tr>
            <tr>
                <td>Zip Code</td>
                <td>${user.zipCode}</td>
            </tr>
            <tr>
                <td>Roles</td>
                <td>${user.userRoles}</td>
            </tr>
        </table>
    </section>
</main>
<footer>

</footer>
</body>
</html>

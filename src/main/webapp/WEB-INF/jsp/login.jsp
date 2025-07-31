<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <link href="<c:url value='/static/css/login.css' />" rel="stylesheet" type="text/css">
</head>
<body>
    <form action="/login" method="post">
        <h2>Auntetifica-te!</h2>
        <label>Username:</label><input type="text" name="username" />
        <label>Parola:</label><input type="password" name="password" />
        <button type="submit">Login</button>
    </form>
    <p>Daca nu ai deja un cont te poti inregistra <a href="/register">aici</a>.</p>
</body>

<%--
  Created by IntelliJ IDEA.
  User: mihne
  Date: 7/30/2025
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <link href="<c:url value='/static/css/register.css' />" rel="stylesheet" type="text/css">
</head>
<body>
    <form action="/register" method="post">
        <h2>Formular de inregistrare</h2>
        <label>Numele de Utilizator:</label>
        <input type="text" name="username" />
        <label>Parola:</label>
        <input type="password" name="password" />
        <button type="submit">Creeaza Contul</button>
    </form>
</body>

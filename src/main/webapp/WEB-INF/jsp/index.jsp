<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop4Hard</title>
    <link href="<c:url value='/static/css/common.css' />" rel="stylesheet" type="text/css">
</head>
<body>
<nav>
    <div class="logo">Shop4Hard</div>
    <ul>
        <li><a href="<c:url value='/' />">Acasă</a></li>
        <li><a href="<c:url value='/products/1' />">Electronice</a></li>
        <li><a href="<c:url value='/products/2' />">Hardware</a></li>
    </ul>
</nav>

<main id="main-content">
    <jsp:include page="${contentPage}" />
</main>

<footer>
    <p>© 2025 Shop4Hard M-I.G</p>
</footer>
<script type="text/javascript" src="<c:url value='/static/script/common.js' />"></script>
</body>
</html>
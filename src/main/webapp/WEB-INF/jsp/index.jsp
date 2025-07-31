<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop4Hard</title>
    <link href="<c:url value='/static/css/common.css' />" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/css/category-products.css' />" rel="stylesheet" type="text/css">

</head>
<body>
<nav id="category-nav">
    <div class="nav-left">
        <ul>
            <li><a href="<c:url value='/' />">Acasă</a></li>
            <li><a href="<c:url value='/products/1' />">Electronice</a></li>
            <li><a href="<c:url value='/products/2' />">Hardware</a></li>
            <li><a href="<c:url value='/products/3' />">Software</a></li>
        </ul>
    </div>

    <div class="nav-right">
        <a href="/cart" class="cart-icon">🛒</a>
        <div class="dropdown">
            <img src="<c:url value='/static/img/logo_transparent_bg.png' />" alt="Logo" class="logo" />
            <div class="dropdown-content">
                <c:choose>
                    <c:when test="${not empty sessionScope.loggedUser}">
                        <c:choose>
                            <c:when test="${sessionScope.loggedUser.roleNames == 'admin'}">
                                <span>Salut, ${sessionScope.loggedUser.username}</span>
                                <a href="/admin">Panou Admin</a>
                                <a href="/logout">Logout</a>
                            </c:when>
                            <c:otherwise>
                                <span>Salut, ${sessionScope.loggedUser.username}</span>
                                <a href="/logout">Logout</a>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <a href="/login">Login</a>
                        <a href="/register">Register</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</nav>
<main id="main-content">
    <c:choose>
        <c:when test="${not empty errorMsg}">
            <jsp:include page="noProductsInCategory.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="${contentPage}" />
        </c:otherwise>
    </c:choose>
</main>

<footer>
    <p>© 2025 Shop4Hard M-I.G & CreateQ</p>
</footer>
<script type="text/javascript" src="<c:url value='/static/script/common.js' />"></script>
</body>
</html>
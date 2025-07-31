<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Coș de cumpărături</title>
    <link rel="stylesheet" href="<c:url value='/static/css/cart.css' />">
</head>
<body>
<div class="cart-container">
    <h1>Coșul tău</h1>

    <c:if test="${empty cart}">
        <p class="empty-cart">Coșul este gol.</p>
    </c:if>

    <c:if test="${not empty cart}">
        <form method="post" action="/cart/update">
            <table class="cart-table">
                <thead>
                <tr>
                    <th>Produs</th>
                    <th>Preț/unitate</th>
                    <th>Cantitate</th>
                    <th>Subtotal</th>
                    <th>Acțiune</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${cart}">
                    <tr>
                        <td>${item.product.name}</td>
                        <td>${item.product.price} RON</td>
                        <td>
                            <input type="number" name="quantities[${item.product.id}]" value="${item.quantity}" min="1" max="${item.product.stock}" />
                        </td>
                        <td>${item.totalPrice} RON</td>
                        <td><a href="/cart/remove?id=${item.product.id}" class="remove-link">Elimină</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="cart-actions">
                <p><strong>Total de plată:</strong> ${totals} RON</p>
                <button type="submit" class="update-button">Actualizează cantitățile</button>
                <a href="/cart/clear" class="clear-button">Golește coșul</a>
            </div>
        </form>
    </c:if>

    <p class="back-link"><a href="/">Înapoi la produse</a></p>
</div>
</body>
</html>
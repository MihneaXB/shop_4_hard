<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Produse din categoria <span class="category-name">${categoryName}</span></h1>
<c:choose>
  <c:when test="${not empty productDTOList}">
    <div class="product-list">
      <c:forEach items="${productDTOList}" var="product">
        <div class="product">
          <img src="${product.imageURL}" alt="${product.title}" />
          <h3>${product.title}</h3>
          <p>${product.description}</p>
          <p><strong>${product.price} RON</strong></p>
        </div>
      </c:forEach>
    </div>
  </c:when>
  <c:otherwise>
    <p>Nu există produse în această categorie.</p>
  </c:otherwise>
</c:choose>
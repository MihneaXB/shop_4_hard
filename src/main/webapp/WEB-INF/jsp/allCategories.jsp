<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach items="${productsPerCategory}" var="category">
  <div class="category-section">
    <h2>${category.key}</h2>
    <div class="products-grid">
      <c:forEach items="${category.value}" var="product">
        <div class="product" data-id="${product.id}">
          <img src="${product.imageURL}" alt="${product.name}">
          <h3>${product.name}</h3>
          <p>${product.price} RON</p>
        </div>
      </c:forEach>
    </div>
  </div>
</c:forEach>
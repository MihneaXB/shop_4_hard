<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="entry" items="${productsPerCategory}">
  <section class="category">
    <h2>${entry.key}</h2>
    <div class="product-list">
      <c:forEach var="product" items="${entry.value}">
        <div class="product">
          <img src="${product.imageURL}" alt="${product.title}" />
          <h3>${product.title}</h3>
          <p>${product.description}</p>
          <p><strong>${product.price} RON</strong></p>
        </div>
      </c:forEach>
    </div>
  </section>
</c:forEach>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Produse din categoria <span class="category-name">${categoryName}</span></h1>

<form method="get">
  <label for="sortSelect">Sorteaza dupa pret:</label>
  <select name="sort" id="sortSelect" onchange="this.form.submit()">
    <option value="none"
            <c:if test="${param.sort == 'none' || empty param.sort}">selected</c:if>>
      Fara sortare
    </option>
    <option value="asc"
            <c:if test="${param.sort == 'asc'}">selected</c:if>>
      Crescator
    </option>
    <option value="desc"
            <c:if test="${param.sort == 'desc'}">selected</c:if>>
      Descrescator
    </option>
  </select>
</form>

<c:choose>
  <c:when test="${not empty productDTOList}">
    <div class="product-list">
      <c:forEach items="${productDTOList}" var="product">
        <div class="product" data-id="${product.id}">
          <img src="${product.imageURL}" alt="${product.name}" />
          <h3>${product.name}</h3>
          <p>${product.description}</p>
          <p><strong>${product.price} RON</strong></p>
        </div>
      </c:forEach>
    </div>
  </c:when>
  <c:otherwise>
    <p>Nu exista produse in aceasta categorie.</p>
  </c:otherwise>
</c:choose>

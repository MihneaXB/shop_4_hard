<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <link href="<c:url value='/static/css/product-details.css' />" rel="stylesheet" type="text/css">
  <script>
    function openTab(evt, tabName) {
      const tabcontents = document.getElementsByClassName("tabcontent");
      for(let i = 0; i < tabcontents.length; i++) {
        tabcontents[i].style.display = "none";
        tabcontents[i].classList.remove("active");
      }
      const tablinks = document.getElementsByClassName("tablinks");
      for(let i = 0; i < tablinks.length; i++) {
        tablinks[i].classList.remove("active");
      }
      document.getElementById(tabName).style.display = "block";
      document.getElementById(tabName).classList.add("active");
      evt.currentTarget.classList.add("active");
    }

    window.onload = function() {
      document.getElementsByClassName("tablinks")[0].click();
    }
  </script>
</head>


<body>
  <div class="product-details-container">
    <div class="product-image">
      <img src="${productDTO.imageURL}" alt="${productDTO.name}">
    </div>

    <div class="product-info">
      <h2>${productDTO.name}</h2>
      <p class="price">Pret: ${productDTO.price} RON</p>
      <c:choose>
        <c:when test="${productDTO.stock == 0}">
          <p class="noStock">Acest produs nu mai este pe stock!</p>
        </c:when>
        <c:when test="${productDTO.stock > 0}">
          <p class="stock">Stoc: ${productDTO.stock}</p>
        </c:when>
      </c:choose>

      <form action="/cart/add?id=${productDTO.id}" method="post">
        <input type="hidden" name="productId" value="${productDTO.id}" />
        <div class="product-buttons">
          <c:if test="${productDTO.stock > 0}">
            <button type="submit">Adauga in cos</button>
          </c:if>
          <a href="/">Continua cumparaturile</a>
        </div>
      </form>
    </div>
  </div>

  <div class="product-tabs">
    <div class="tab-buttons">
      <button class="tablinks" onclick="openTab(event, 'descriere')">Descriere</button>
      <button class="tablinks" onclick="openTab(event, 'specificatii')">Specificatii</button>
    </div>

    <div id="descriere" class="tabcontent">
      <p>${productDTO.description}</p>
    </div>

    <div id="specificatii" class="tabcontent">
      <table>
        <c:forEach var="entry" items="${productDTO.specifications}">
          <tr>
            <td colspan="2">${entry}</td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</body>

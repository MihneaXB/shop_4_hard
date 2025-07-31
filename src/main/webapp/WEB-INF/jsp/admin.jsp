<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Admin Dashboard</title>
    <link href="<c:url value='/static/css/admin-dashboard.css' />" rel="stylesheet" type="text/css">
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

<h2>Admin Dashboard</h2>

<div class="tab">
    <button class="tablinks" onclick="openTab(event, 'Users')">Tabul Utilizatori</button>
    <button class="tablinks" onclick="openTab(event, 'Products')">Tabul Produse</button>
    <button class="tablinks" onclick="location.href='/'">Pagina Principala</button>
</div>


<div id="Users" class="tabcontent">
    <h3>Creaza un nou utilizator</h3>
    <form action="${pageContext.request.contextPath}/admin/createUser" method="post">
        <input type="text" name="username" placeholder="Username" required />
        <input type="password" name="password" placeholder="Password" required />
        <input type="text" name="role" placeholder="Role (e.g., ADMIN, USER)" required />
        <button type="submit">Create User</button>
    </form>

    <h3>Utilizatori Existenti/h3>
    <table>
        <thead>
        <tr><th>ID</th><th>Username</th><th>Rol</th><th>Actiune</th></tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.roleNames}</td>
                <td>
                    <form style="display:inline" action="${pageContext.request.contextPath}/admin/deleteUser" method="post">
                        <input type="hidden" name="id" value="${user.id}" />
                        <button type="submit" onclick="return confirm('Delete user ${user.username}?')">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<div id="Products" class="tabcontent">
    <h3>Adauga un nou produs</h3>
    <form action="${pageContext.request.contextPath}/admin/addProduct" method="post">
        <input type="text" name="name" placeholder="Product Name" required />
        <input type="number" step="0.01" name="price" placeholder="Price" required />
        <textarea name="description" placeholder="Description" rows="3"></textarea>
        <textarea name="specifications" placeholder="Specificatii" rows="3"></textarea>
        <input type="number" name="categoryID" placeholder="Category ID" required/>
        <button type="submit">Add Product</button>
    </form>

    <h3>Produse Existente</h3>
    <table>
        <thead>
        <tr><th>ID</th><th>Nume</th><th>Pret</th><th>Descriere</th><th>Specificatii</th><th>Categorie</th><th>Actiune</th></tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.specification}</td>
                <td>${product.categoryName}</td>
                <td>
                    <form style="display:inline" action="${pageContext.request.contextPath}/admin/deleteProduct" method="post">
                        <input type="hidden" name="id" value="${product.id}" />
                        <button type="submit" onclick="return confirm('Delete product ${product.name}?')">Sterge</button>
                    </form>
                    <form style="display:inline" action="${pageContext.request.contextPath}/admin/editProductForm" method="get">
                        <input type="hidden" name="id" value="${product.id}" />
                        <button type="submit">Editeaza</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>

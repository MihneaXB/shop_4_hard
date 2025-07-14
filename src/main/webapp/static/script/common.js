document.addEventListener("DOMContentLoaded", function () {
    fetchCategories();

    function fetchCategories() {
        fetch("/categories")
            .then(res => res.json())
            .then(categories => {
                const nav = document.getElementById("category-nav");
                nav.innerHTML = "";
                categories.forEach((cat, index) => {
                    const btn = document.createElement("button");
                    btn.innerText = cat.name;
                    btn.onclick = () => loadProducts(cat.id);
                    nav.appendChild(btn);

                    if (index === 0) loadProducts(cat.id);
                });
            });
    }

    function loadProducts(categoryId) {
        fetch(`/products/${categoryId}`)
            .then(res => res.text())
            .then(html => {
                document.getElementById("main-content").innerHTML = html;
            });
    }
});

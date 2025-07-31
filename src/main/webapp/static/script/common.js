document.addEventListener("DOMContentLoaded", function() {
    initCategoryNavigation();

    if (window.location.pathname === '/') {
        loadAllProducts();
    } else if (window.location.pathname.startsWith('/products/')) {
        const categoryId = window.location.pathname.split('/')[2];
        loadProducts(categoryId, false);
    } else if (window.location.pathname.startsWith('/product/')) {
        const productId = window.location.pathname.split('/')[2];
        loadProductDetail(productId, false);
    }

    function initCategoryNavigation() {
        const navLinks = document.querySelectorAll("#category-nav ul li a");

        navLinks.forEach(link => {
            link.addEventListener("click", function(e) {
                const href = this.getAttribute("href");
                if (href.includes('/products/')) {
                    e.preventDefault();
                    const categoryId = href.split('/')[2];
                    loadProducts(categoryId, true);
                } else if (href === "/") {
                    e.preventDefault();
                    loadAllProducts(true);
                }
            });
        });
    }

    function loadAllProducts(push = true) {
        fetch('/')
            .then(res => res.text())
            .then(html => {
                const temp = document.createElement('div');
                temp.innerHTML = html;
                const content = temp.querySelector('#main-content');
                if (content) {
                    document.getElementById("main-content").innerHTML = content.innerHTML;
                    attachProductClickHandlers();
                    if (push) history.pushState(null, '', '/');
                }
            })
            .catch(error => console.error("Error loading all products:", error));
    }

    function loadProducts(categoryId, push = true) {
        fetch(`/products/${categoryId}`)
            .then(res => res.text())
            .then(html => {
                const temp = document.createElement('div');
                temp.innerHTML = html;
                const content = temp.querySelector('#main-content');
                if (content) {
                    document.getElementById("main-content").innerHTML = content.innerHTML;
                    attachProductClickHandlers();
                    if (push) history.pushState(null, '', `/products/${categoryId}`);
                }
            })
            .catch(error => console.error("Error loading products:", error));
    }

    function loadProductDetail(productId, push = true) {
        fetch(`/product/${productId}`)
            .then(res => res.text())
            .then(html => {
                const temp = document.createElement('div');
                temp.innerHTML = html;
                const content = temp.querySelector('#main-content');
                if (content) {
                    document.getElementById("main-content").innerHTML = content.innerHTML;
                    if (push) history.pushState(null, '', `/product/${productId}`);
                }
            })
            .catch(error => console.error("Error loading product detail:", error));
    }

    function attachProductClickHandlers() {
        const productCards = document.querySelectorAll(".product");
        productCards.forEach(card => {
            card.addEventListener("click", () => {
                const productId = card.getAttribute("data-id");
                if (productId) {
                    loadProductDetail(productId, true);
                }
            });
        });
    }

    window.addEventListener('popstate', function() {
        if (window.location.pathname === '/') {
            loadAllProducts(false);
        } else if (window.location.pathname.startsWith('/products/')) {
            const categoryId = window.location.pathname.split('/')[2];
            loadProducts(categoryId, false);
        } else if (window.location.pathname.startsWith('/product/')) {
            const productId = window.location.pathname.split('/')[2];
            loadProductDetail(productId, false);
        }
    });
});

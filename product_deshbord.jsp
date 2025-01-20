<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>## Institute Dashboard. ##</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
        <style>
            .nav_img {
                max-width: 100%;
                height: auto;
            }

            .card {
                cursor: pointer;
            }

            .cursor {
                cursor: pointer;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <%@ include file="header.jsp" %>
                </div>
            </div>

            <div class="row my-4 px-5">
                <div class="col">
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                            <li class="breadcrumb-item"><a href="category_deshbord.jsp">Categoryies(Deshbord page)</a></li>
                            <c:if test="${user.userType.userTypeId == 2}">
                                <li class="breadcrumb-item"><a href="seller_Product_deshbord.do">Seller_Product(Deshbord)</a></li>
                            </c:if>
                        </ol>
                    </nav>
                </div>
            </div>

            <div class="row mb-5 px-5">
                <div class="col">

                    <ul class="nav nav-tabs">
                        <li class="nav-item"><button data-bs-toggle="tab" data-bs-target="#product_pane"
                                class="nav-link active">Products</button></li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane show fade active" id="product_pane">
                            
                            <c:if test= "${user.userType.userTypeId == 1}">
                                <div class="text-end mt-4 pe-5">
                                    <a class="btn btn-primary" href="addProduct.jsp?category_id=${param.category_id}">&plus;
                                        New Product</a>
                                </div>    
                            </c:if>
    
                            <!---------------------------------------------------------------------------->

                            <c:forEach var="product" items="${products}" varStatus="recs">

                                <div class="top row border border-secondary mt-4" id="${product.productId}">

                                    <div class="col-3">
                                        <div class="col card" id="${product.productId}">
                                            <img src="product_pic_upload.do?product_id=${product.productId}"
                                                class="card-img-top" width="100%" height="200">
                                        </div>
                                    </div>

                                    <div class="col-9">

                                        <div class="row">
                                            <div class="col mt-4">
                                                <p class="fw-semibold d-inline fs-6">Brand Name</p> :
                                                ${product.brand_Name}
                                            </div>
                                            <div class="col mt-4">
                                                <p class="fw-semibold d-inline fs-6">Shelf Life</p> :
                                                ${product.name}
                                            </div>
                                            <c:choose>
                                                <c:when test="${user.userType.userTypeId == 1}">
                                                    <div class="col mt-4">
                                                        <p class="fw-semibold d-inline fs-6">dinomination : </p><img
                                                            id="add_dinominations" class="cursor"
                                                            src="static/media/images/add-icon.webp" height="25"
                                                            width="25">
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="col mt-4">
                                                        <p class="fw-semibold d-inline fs-6">Select Product : </p><img
                                                            id="add_product" class="cursor"
                                                            src="static/media/images/add-icon.webp" height="25"
                                                            width="25">
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>

                                        <div class="row">
                                            <div class="col mt-5">
                                                <p class="fw-semibold d-inline fs-6">Packaging</p> :
                                                ${product.packaging}
                                            </div>
                                            <div class="col mt-5">
                                                <p class="fw-semibold d-inline fs-6">Storage</p> :
                                                ${product.storage_Info}
                                            </div>
                                            <div class="col mt-5">
                                                <p class="fw-semibold d-inline fs-6">Others : </p> <img class="cursor" src="static/media/images/line.png" height="25" width="25">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                            <!---------------------------------------------------------------------------->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

        <script>
            const cards = document.querySelectorAll('.card');
            const add_dinominations = document.querySelectorAll('#add_dinominations');
            const add_product = document.querySelectorAll('#add_product');


            // ------------------- show courses -----------------------
            cards.forEach((card) => {
                card.addEventListener('click', (e) => {

                    window.location = 'product_pic.do?product_id=' + e.target.parentNode.id;

                });
            });

            add_dinominations.forEach((dinomination) => {

                dinomination.addEventListener('click', (e) => {

                    window.location = 'save_dinomination.do?product_id=' + e.target.parentNode.parentNode.parentNode.parentNode.id;
                });
            });

            add_product.forEach((product) => {

                product.addEventListener('click', (e) => {

                    window.location = 'fetch_dinomination_details.do?product_id=' + e.target.parentNode.parentNode.parentNode.parentNode.id;
                });
            });

        </script>
</body>
</html>
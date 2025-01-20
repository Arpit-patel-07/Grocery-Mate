<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>## Institute Dashboard. ##</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

        <style>
            .card {
                cursor: pointer;
            }

            .x {
                width: 100%;
                object-fit: contain;
                height: 100%;
            }

            .cursor {
                cursor: pointer;
            }
        </style>
    </head>

    <body>

        <div class="container">
            <div class="row mb-5 px-5">
                <div class="col">
                    <c:forEach var="cartItem" items="${cart_items}" varStatus="recs">

                        <div class="col-3">
                            <div class="card">
                                <img src="product_pic_upload.do?product_id=${cartItem.sellerProduct.dinomination.product.productId}" class="card-img-top" width="180" height="150">
            

                                <div class="card-body">
                                    <p class="card-title">
                                        <h6 class="d-inline">Prise :</h6> ${cartItem.sellerProduct.dinomination.product.productId}
                                    </p>

                                    <p class="card-title">
                                        <h6 class="d-inline">discount:</h6> ${cartItem.sellerProduct.discount}
                                    </p>
                                </div>

                                <div class="card-footer bg-transparent border-secondary">
                                    <a href="order.do" class="btn btn-primary d-block">Buy Product</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

        <script>

           /*  const cards = document.querySelectorAll('.card');

            // ------------------------------------------

            cards.forEach((card) => {

                card.addEventListener('click', (e) => {

                    console.log(e.target.parentNode.id);
                    window.location = 'fetch_product.do?product_id=' + e.target.parentNode.id;

                });
            }); 
            
            */

        </script>
    </body>
    </html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <style>
        .logo {
            height: 25px;
        }
    </style>
</head>
<body>

    <!--------------------------------------------- Modal -------------------------------------------------------->

    <div class="row justify-content-center">
        <div class="col">
            <div class="modal" id="modal">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                       <div class="modal-header">
                        <p>Hellow Duniya Wallo kesa Ho ?? </p>
                       </div>

                       <div class="modal-body">
                                <div class="row">
                                    <c:forEach var="cartItem" items="${cart_items}" varStatus="recs">
                                        <div class="col-4">
                                            <div class="card">

                                                <img src="product_pic_upload.do?product_id=${cartItem.sellerProduct.dinomination.product.productId}" class="card-img-top">
                            
                                                <div class="card-body">
                                                    <p class="card-title">
                                                        <h6 class="d-inline">Name :</h6>${cartItem.sellerProduct.dinomination.product.name}
                                                        <br><h6 class="d-inline">Total :</h6> ${cartItem.sellerProduct.dinomination.prise}
                                                        <br><h6 class="d-inline">quantity :</h6> ${cartItem.sellerProduct.quantity}                        
                                                    </p>
                                                </div>

                                                <div class="card-footer">
                                                    <p class="d-inline me-3">Remove :
                                                        <img src="static/media/images/Delete3.png" width="20" class=" border delete" id="${cartItem.sellerProduct.sellerProductId}">
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                       </div>

                       <div class="modal-footer">
                            <button class="btn btn-warning" data-bs-dismiss="modal" >Close</button>
                            <a href="order.do" class="btn btn-warning">Buy Products</a>
                       </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!------------------------------------------------------------------------------------------------------>

    <div class="container">
        <div class="row">
            <div class="col rounded border-secondary">
                <nav class="navbar navbar-expand-lg" style="background-color: rgba(205, 198, 198, 0.468)">
                    <div class="container-fluid">
                        <img src="static/media/images/handlogo.jpg" height="40">
                        <a class="navbar-brand" href="#"> <a href="index.jsp"></a>

                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">

                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                                </li>

                                <li class="nav-item"></li>
                                    <a class="nav-link " aria-current="page" href="index.jsp">About</a>
                                </li>

                                <li class="nav-item"></li>
                                    <a class="nav-link" aria-current="page" href="">Services</a>
                                </li>
                            </ul>

                            <form class="d-flex" role="search">
                                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                                <button class="btn btn-outline-success" type="submit">Search</button>
                            </form>

                            <c:if test="${user.userType.userTypeId == 3}">
                                <div>
                                    <a href data-bs-toggle="modal" data-bs-target="#modal"> <img class="p-1 ms-2" src="static/media/images/basket-cart.png" height="35"><span class="badge badge-secondary border border-secondary me-1">1</span></a>
                               </div>
                               <div>
                                   <a href="show_favourite.do"><img class="p-1 m-1" src="static/media/images/favorite-icon.png" height="35"></a>
                               </div>
                            </c:if>
                        </div>
                    </nav>
                </div>
            </div>
       </div> 
       
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

       <script>
            const deletes = document.querySelectorAll('.delete');

            deletes.forEach((next)=> {
                next.addEventListener('click',(e)=>{
                    let seller_product_id =  e.target.id;
                    window.location = 'delete_cartitem.do?seller_product_id='+seller_product_id;
                });
            });
       </script>
</body>
</html>
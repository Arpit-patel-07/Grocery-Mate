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
        .cursor{
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
                <nav >
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                        <li class="breadcrumb-item"><a href="category_deshbord.jsp">Category (DeshbordPage)</a></li>
                        <li class="breadcrumb-item">sellerProduct (DeshbordPage)</li>
                    </ol>
                </nav>
            </div>
        </div>

        <div class="row mb-5 px-5">
            <div class="col">
                        <!---------------------------------------------------------------------->

                        <c:forEach var="sellerProduct" items="${sellerProducts}" varStatus="recs">

                            <c:if test="${(recs.count-1)%4==0}">
                                <div class="row justify-content-around mt-3">                            
                            </c:if>    
                                <div class="col-3">
                                    <div class="card" id="${product}">


                                        <!-- ------------------------ -->
                                        <img src="product_pic_upload.do?product_id=${sellerProduct.dinomination.product.productId}" class="card-img-top" width="180" height="150">
                                        <!-- ------------------------ -->
                                        
                                        <div class="card-body">
                                            <p class="card-title"><h6 class="d-inline">Brand Name :</h6> ${sellerProduct.dinomination.product.brand_Name}</p> 
                                            <p class="card-title"><h6 class="d-inline">Quantity :</h6> ${sellerProduct.quantity}</p>
                                            <p class="card-title"><h6 class="d-inline">Prise : </h6> ${sellerProduct.dinomination.prise}</p> 
                                            <p class="card-title"><h6 class="d-inline">Discount : </h6>${sellerProduct.discount} %</p>                                          
                                        </div>
                                        <div class="card-footer bg-transparent border-secondary">
                                            <img class="cursor me-5" src="static/media/images/edit.jpeg" height="25" width="25">
                                            <img class="cursor me-4" src="static/media/images/delete1.png" height="25" width="25">
                                            <img class="cursor ms-4" src="static/media/images/update.jpeg" height="25" width="25">
                                        </div>
                                    </div>
                                </div>
                            <c:if test="${recs.count%4==0 || size == recs.count}">    
                                ~</div>
                            </c:if>
                        </c:forEach>       
                    <!---------------------------------------------------------------------------->
                </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <script>

       /* const cards = document.querySelectorAll('.card');
        const course_details_form = document.querySelector('#course_details_form');

        // ------------------- save new course --------------------
        course_details_form.addEventListener('submit', (e) => {
            // e.preventDefault();
            console.log('hello kaise ho');
            // course_details_form.submit();
        });

        // ------------------- show courses -----------------------
        cards.forEach((card) => {
            card.addEventListener('click', (e) => {
                window.location = 'course.do?course_id='+e.target.parentNode.id;
            });
        });*/

    </script>
</body>
</html>




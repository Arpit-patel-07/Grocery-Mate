<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>## Manufacturing Industry Dashboard. ##</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

    <style>
        .nav_img {
            max-width: 100%;
            height: auto;
        }

        .card {
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
                        <li class="breadcrumb-item">Categories(Dashboard Page)</li>
                    </ol>
                </nav>
            </div>
        </div>

        <div class="row mb-5 px-5">
            <div class="col">

                <ul class="nav nav-tabs">
                    <li class="nav-item"><button data-bs-toggle="tab" data-bs-target="#category_pane" class="nav-link active">Categoryies</button></li>
                                                          
                </ul>

                <div class="tab-content">

                    <div class="tab-pane show fade active" id="category_pane">
                        <div class="row mt-4">
                        <c:forEach var="category" items="${categories}" varStatus="recs">  
                                <div class="col-3">
                                    <div class="card" id="${category.categoryId}">
                                                                               
                                        <img src="static/media/images/${category.categoryId}.jpg" height="200" width="100%">
                                        
                                        <div class="card-body">
                                            <h4 class="card-title">${category.type}</h4>                                            
                                        </div>
                                    </div>
                                </div> 
                        </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        const cards = document.querySelectorAll('.card');

        // ------------------- show product-----------------------

        cards.forEach((card)=> {
            
            card.addEventListener('click', (e) => {

                window.location = 'products.do?category_id='+e.target.parentNode.id;

            });
        });
    </script>
</body>
</html>




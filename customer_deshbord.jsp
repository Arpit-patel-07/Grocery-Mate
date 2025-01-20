<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>## Customer Product Dashboard. ##</title>
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
        <!--------------------------MODAL-------------------------->

        <div class="modal" id="mymodal">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">

                    <div class="modal-header">
                        <p>Hellow Duniya Wallo</p>
                    </div>

                    <div class="modal-body">
                        <div class="card mb-3">
                            <div class="row">
                                <div class="col">
                                    <img class="card-img" id="pimg" src="" width="150" height="150">
                                </div>

                                <div class="col-md-9">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col">
                                                <p class="card-title">
                                                <span class="fw-3"> Product Name : <span id="product_name"></span></span>

                                                <p class="card-text mt-5">
                                                    <select id="select_box" class="p-1 rounded">
                                                        
                                                    </select>
                                                </p>

                                            </div>
                                            <div class="col">
                                                
                                                <div class="ms-5 text-end">
                                                    <img src="static/media/images/Delete3.png" class="ms-4 border border-secondary p-1" height="35">
                                                </div>

                                                <p class="card-text mt-5">
                                                    Quantity :
                                                       <img src="static/media/images/subtract.jpeg" class="border border-secondary p-1" id="subtract_img" height="25">
                                                        <span id="quantity" class="d-inline m-1">1</span>
                                                            
                                                        <img src="static/media/images/plus.jpeg" id="add_img" class="border border-secondary p-1" height="25">
                                                    
                                                        
                                                        <span class="ms-3">Total :
                                                            <span id="total_prise"></span>    
                                                        </span>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="ms-auto p-2 m-2">
                        <button id="save_btn" class="btn btn-warning">Save Product In Cart</button>
                    </div>
                </div>
            </div>
        </div>

        <!---------------------------------------------------------------------------------------->

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
                        </ol>
                    </nav>
                </div>
            </div>

            <div class="col-4">

                <form action="fetch_product.do" method="post" class=" ps-5 pb-4">

                    <div class="mb-2">

                        <div class="mb-3">

                            <label for="categorie_id" class="form-label fw-bold text-dark">Search Product According to
                                Categoryies !</label>

                            <select name="category_id" id="category_id" class="form-control ">

                                <option value="0" class="fw-1">Select Categories...</option>

                                <c:forEach var="category" items="${categories}">

                                    <option value="${category.categoryId}">${category.type}</option>

                                </c:forEach>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary" id="btn">Search</button>
                    </div>
                </form>
            </div>

            <div class="row mb-5 px-5">
                <div class="col">
                    <c:choose>
                        <c:when test="${param.value == 1}">

                            <c:if test="${param.start < 0}">
                                <div class="border d-inline">
                                    <p>No Record Found...</p>
                                </div>
                            </c:if>

                            <c:forEach var="sellerProduct" items="${sellerProducts}" varStatus="recs">

                                <c:if test="${(recs.count-1)%4==0}">
                                    <div class="row justify-content-around mt-3">
                                </c:if>

                                <div class="col-3">
                                    <div class="card" id="${sellerProduct.dinomination.product.productId}">
                                        <img src="product_pic_upload.do?product_id=${sellerProduct.dinomination.product.productId}"
                                            class="card-img-top" width="100%" height="100%">

                                        <div class="card-body">
                                            <p class="card-title">
                                                <h6 class="d-inline">Brand Name :</h6> ${sellerProduct.dinomination.product.brand_Name}
                                            </p>
                                            <p class="card-title">
                                                <h6 class="d-inline">Product Name :</h6> ${sellerProduct.dinomination.product.name}
                                            </p>
                                        </div>
                                        <div class="card-footer bg-transparent border-secondary">

                                            <span class="btn btn-primary atc" data-bs-toggle="modal" data-bs-target="#mymodal" id="${sellerProduct.dinomination.product.productId}">Add To Cart</span>

                                            <a href="Favourite.do?sellerProductId=${sellerProduct.sellerProductId}" class="fav btn btn-primary">Favourite</a>
                                        </div>
                                    </div>
                                </div>
                                <c:if test="${recs.count%4==0 || size == recs.count}"> </div> </c:if>
                            </c:forEach>
                            ${param.start}
                            <div class="mt-3 p-1">
                               
                                <a href="customer_deshbord.do?start=${param.start-4}" class="btn btn-info">Prev</a>
                                <a href="customer_deshbord.do?start=${param.start+4}" class="btn btn-info">Next</a>
                            </div>
                        </c:when>

                        <c:otherwise>
                            <c:forEach var="sellerProduct" items="${products}" varStatus="recs">

                                <c:if test="${(recs.count-1)%4==0}">
                                    <div class="row justify-content-around mt-3">
                                </c:if>

                                <div class="col-3">
                                    <div class="card" id="${sellerProduct.dinomination.product.productId}">

                                        <img src="product_pic_upload.do?product_id=${sellerProduct.dinomination.product.productId}"
                                        class="card-img-top" width="100%" height="100%">

                                        <div class="card-body">
                                            <p class="card-title">
                                                <h6 class="d-inline">Brand Name :</h6>${sellerProduct.dinomination.product.brand_Name}
                                            </p>
                                            <p class="card-title">
                                                <h6 class="d-inline">Product Name :</h6> ${sellerProduct.dinomination.product.name}
                                            </p>
                                        </div>
                
                                        <div class="card-footer bg-transparent border-secondary">

                                            <span class="btn btn-primary atc" data-bs-toggle="modal" data-bs-target="#mymodal" id="${sellerProduct.dinomination.product.productId}">Add To Cart</span>

                                            <a href="Favourite.do?sellerProductId=${sellerProduct.sellerProductId}" class="fav btn btn-primary">Favourite</a>
                                        </div>
                                    </div>
                                </div>

                                <c:if test="${recs.count%4==0 || size == recs.count}"></div></c:if>

                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

        <script>

            const atcs = document.querySelectorAll('.atc');
            const select_box = document.querySelector('#select_box');
            const subtract_img = document.querySelector('#subtract_img');
            const add_img = document.querySelector('#add_img');
            const total_prise = document.querySelector('#total_prise');
            const saveBtn = document.querySelector('#save_btn');
            const favs = document.querySelector('.fav');
            let flag = true;
            let flag1 = true;
            var product_id;
            var seller_product_id;
            var discount;
            var dinominationId;
            var holdPrise;


            // favs.forEach((fav)=>{
            //     fav.addEventListener('click' , (e)=>{
            //         console.log("favourites button is :")
            //     })
            // })

            atcs.forEach((next)=>{

                next.addEventListener('click',(e)=>{

                    product_id = e.target.id;
                    flag = true;
                    flag1 = true;
                   
                    let collectProductInformation = () => {

                        if (flag) {

                            flag = false;
                            let req = new XMLHttpRequest();
                            let para = 'product_id=' +product_id;
                            req.open('GET', 'fetch_product_information.do?' + para, true);
                            req.addEventListener('readystatechange', () => {

                                if (req.readyState == 4 && req.status == 200) {
                                    let resp = req.responseText;
                                    let arr = JSON.parse(resp);
                                    console.log(arr);

                                        seller_product_id = arr.sellerProductId;
                                        discount = arr.discount;
                                        dinominationId = arr.dinomination.dinominationId;
                                        const productId = arr.dinomination.product.productId;

                                         // ~~~~~~~~~~~~~~~~~~~~~~prise Assingnment~~~~~~~~~~~~~~~~~~~~
                                        const prise = arr.dinomination.prise;
                                        holdPrise = prise;
                                        const total_prise = document.querySelector('#total_prise');
                                        total_prise.innerText = prise;

                                        // ~~~~~~~~~~~~~~~~~~~~~~Name Assingnment~~~~~~~~~~~~~~~~~~~~
                                        const name = arr.dinomination.product.name;
                                        const product_name = document.querySelector('#product_name');
                                        product_name.innerText = name;                        
                                };
                            });
                            req.send();
                        }
                    };
                    collectProductInformation();
                    callAllFunctions();
                });
            });

            let collectdinominatins = () => {

                if (flag1) {

                    const select_box = document.querySelector('#select_box');
                    select_box.innerHTML="";

                    flag1 = false;
                    let req = new XMLHttpRequest();
                    let para = 'product_id='+product_id;
                    req.open('GET', 'fetch_dinomination.do?' + para, true);
                    req.addEventListener('readystatechange', () => {

                        if (req.readyState == 4 && req.status == 200) {
                            let resp = req.responseText;
                            let arr = JSON.parse(resp);
                            console.log(arr);

                            for (let obj of arr) {

                                let option = document.createElement('option');
                                option.value = obj.prise;
                                let type = (obj.weightType.weightTypeId === 1) ? "Kg" : (obj.weightType.weightTypeId === 2) ? "Ml" : (obj.weightType.weightTypeId === 3) ? "L" : "G";
                                let dinomination = "Prise :" + obj.prise + " " + "weight :" + obj.weight + " " + type;
                                option.innerText = dinomination;
                                select_box.append(option);
                            }
                        }
                    });
                    req.send();
                }
            };

            function setPic(){
                let pimg = document.querySelector('#pimg');
                pimg.src="product_pic_upload.do?product_id="+product_id;
            };

            select_box.addEventListener('change', (e) => {

                const quantity = document.querySelector('#quantity');
                const total_prise = document.querySelector('#total_prise');
                quantity.innerText = 1;
                let price = e.target.value;
                total_prise.innerText = price;
                holdPrise = price;
            });

            subtract_img.addEventListener('click', () => {
                let quantity = document.querySelector('#quantity');
                let total_prise = document.querySelector('#total_prise');

                if (parseInt(quantity.innerText) > 0) {
                    quantity.innerText = parseInt(quantity.innerText) - 1;
                    total_prise.innerText = parseInt(total_prise.innerText) - parseInt(holdPrise);
                }
            });

            add_img.addEventListener('click', () => {
                let quantity = document.querySelector('#quantity');
                let total_prise = document.querySelector('#total_prise');
                quantity.innerText = parseInt(quantity.innerText) + 1;
                total_prise.innerText = parseInt(total_prise.innerText) + parseInt(holdPrise);
            });

            function resetProductPrice(){
                let quantity = document.querySelector('#quantity');
                let total_prise = document.querySelector('#total_prise');
                quantity.innerText = 1;
                total_prise = holdPrise;
            };

            function callAllFunctions(){
                collectdinominatins();
                setPic()
                resetProductPrice();
            };

            saveBtn.addEventListener('click', () => {

                let quantity = document.querySelector('#quantity');
                let total_prise = document.querySelector('#total_prise');
                const name = document.querySelector('#product_name');
                let cart_count = 0;

                window.location = 'addTo_Cart.do?seller_product_id='+seller_product_id+'&discount='+discount+'&product_id='+product_id+'&name='+name.innerText+'&price='+parseInt(total_prise.innerText)+'&quantity='+parseInt(quantity.innerText)+'&dinomination_id='+dinominationId+'&cart_count='+0;
            });

            //  const cards = document.querySelectorAll('.card');

            //  cards.forEach((card) => {

            //      card.addEventListener('click', (e) => {

            //         window.location = 'fetch_product.do?product_id='+e.target.parentNode.id;
                    
            //      });
            //  });

        </script>
        
    </body>
    </html>
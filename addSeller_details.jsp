<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>## add Sellelr Details Form ##</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

    <style>
        .nav_img {
            max-width: 100%;
            height: auto;
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

        <div class="row justify-content-center">
            <div class="col-6 mt-5 border border-secondary rounded p-5 pb-4">
                <h3 class="text-secondary">
                    Product Details Form
                </h3>
                <small class="text-secondary">Please submit product details Before Adding a Product</small>

                <form action="seller_product_details.do" method="post" class="mt-4">
                    

                    <input type="hidden" value="${param.product_id}"  name="product_id">
                    
                    <div class="mb-4">
                        <label for="quantity" class="form-label fw-semibold text-primary">Quantity</label>
                        <input type="number" class="form-control" name="quantity" id="quantity">
                    </div>

                    <div class="mb-4">
                        <label for="discount" class="form-label fw-semibold text-primary">Discount</label>
                        <input type="number" class="form-control" name="discount" id="discount">
                    </div>

                    <div class="mb-4">
                        <label for="sold" class="form-label fw-semibold text-primary">Sold</label>
                        <input type="number" class="form-control" name="sold" id="sold">
                    </div>

                    <div class="mb-4">

                        <label for="dinomination_id" class="form-label fw-semibold text-primary">Dinominations</label>

                        <select name="dinominationId" id="dinominationId" class="form-control ">

                            <option value="0" class="fw-1">Select dinominnations ...</option>

                            <c:forEach  var="dinomination" items="${dinominations}">
                                <c:choose>
                                    <c:when test="${dinomination.weightType.weightTypeId == 1}">
                                        <option value="${dinomination.dinominationId}">Prise : ${dinomination.prise} weight : ${dinomination.weight} Killogram Packet</option>
                                    </c:when>
                                    
                                    <c:when test="${dinomination.weightType.weightTypeId == 2}">
                                        <option value="${dinomination.dinominationId}">Prise : ${dinomination.prise} weight : ${dinomination.weight} Milliliter Packet</option>
                                    </c:when>

                                    <c:when test="${dinomination.weightType.weightTypeId == 3}">
                                        <option value="${dinomination.dinominationId}">Prise : ${dinomination.prise} weight : ${dinomination.weight} Liter Packet</option>
                                    </c:when>
                                    <c:when test="${dinomination.weightType.weightTypeId == 4}">
                                        <option value="${dinomination.dinominationId}">Prise : ${dinomination.prise} weight : ${dinomination.weight} Gram packet</option>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="mb-4">
                        <label for="record_date" class="form-label fw-semibold text-primary">Record Date</label>
                        <input type="date" class="form-control" name="record_date" id="record_date">
                    </div>

                    <div>
                        <button type="submit" class="btn btn-primary btn-lg" id="btn">Save</button>
                    </div>

                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"> </script>

</body>
</html>
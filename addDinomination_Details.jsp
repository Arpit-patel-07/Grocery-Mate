<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>add Dinomination jsp page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row">

            <div class="fs-4 fw-semibold my-4 bg-info p-2 border border-secondary rounded  text-center">Add Dinomination Details</div>

            <div class="col-5  border border-secondary rounded justify-content-center m-auto">

                <form action="save_dinomination.do" method="post"> 
                    
                    <input type="hidden" id="product_id" name="product_id" value="${param.product_id}">

                    <div class="mb-3">

                        <label for="weight_type_id" class="form-label fw-bold text-dark">Weight Types...</label>

                        <select name="weightTypeId" id="weight_type_id" class="form-control">

                            <option value="0" class="fw-1">Select Weight Type ...</option>

                            <c:forEach  var="weight" items="${weights}">
                                <option value="${weight.weightTypeId}">${weight.type}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="price" class="form-label fw-bold text-dark">Prise</label>
                        <input type="number" name="prise" id="prise" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="weight" class="form-label fw-bold text-dark">Weight</label>
                        <input type="number" name="weight" id="weight" class="form-control">
                    </div>

                    <div class="mb-3">
                        <input type="submit" class="btn btn-primary btn-md m-2" value="Sumbit" class="form-control">
                    </div>

                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
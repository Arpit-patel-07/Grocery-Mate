<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>## gsms Pvt. Ltd. ##</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row">
            
            <div class="fs-4 fw-semibold my-4 bg-info p-2 border border-secondary rounded  text-center">Upload Product Pics</div>

            <div class="col-5  border border-secondary rounded justify-content-center m-auto">

                <form action="product_pic_upload.do" method="post" enctype="multipart/form-data"> 
                    
                    <input type="hidden" id="product_id" name="product_id" value="${param.product_id}">

                    <div class="mb-3">
                        <h4 for="picTypeId" class="form-label fw-bold text-dark m-2 p-1">Select And Upload Pics For Products.....</h4><hr><hr>

                        <select name="picTypeId" id="picTypeId" class="form-control m-2 ">

                            <option value="0" class="fw-1">Select Pic Type ...</option>

                            <c:forEach  var="pic" items="${pics}">
                                <option value="${pic.picTypeId}">${pic.type}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <input type="file" name="pic" class="form-control m-2">

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






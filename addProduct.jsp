<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>## Institute Details Form ##</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">

    <script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
    
    <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />

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
                    Products Details Form
                </h3>
                <small class="text-secondary">Please submit details Carefully</small>

                <form action="product_details.do" method="post" class="mt-4">

                    <input type="hidden" value="${param.category_id}"  name="category_id">
                    
                    <div class="mb-4">
                        <label for="Product_Name" class="form-label fw-semibold text-primary">Product Name</label>
                        <input type="text" class="form-control" name="product_Name" id="Product_Name">
                    </div>

                    <div class="mb-4">
                        <label for="Shelf_Life" class="form-label fw-semibold text-primary">Shelf_Life</label>
                        <input type="number" class="form-control" name="shelf_Life" id="Shelf_Life">
                    </div>

                    <div class="mb-4">
                        <label for="brand" class="form-label fw-semibold text-primary">Brand Name</label>
                        <input type="text" class="form-control" name="brand" id="brand">
                    </div>

                    <div class="mb-4">
                        <label for="storage_Info" class="form-label fw-semibold text-primary">Storage Info</label>
                        <input type="text" class="form-control" name="storage_Info" id="storage_Info">
                    </div>

                    <div class="mb-4">
                        <label for="Packaging" class="form-label fw-semibold text-primary">Packaging</label>
                        <input type="text" class="form-control" name="packaging" id="packaging">
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
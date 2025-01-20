<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/login.css">
    <style>
        #sigin_form {
            margin-top: 10px;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col">
                <%@ include file ="header.jsp"%>
            </div>
        </div>

        <div class="row">
            <div class="col-4 mx-auto">
                <div class="fs-4 fw-semibold my-4 p-2 border border-secondary rounded heading">
                    <c:choose>
                        <c:when test="${param.user_type_id == 1}">
                            Manufacturing Login Page
                        </c:when>
                        <c:when test="${param.user_type_id == 2}">
                            Grocery Store Login Page
                        </c:when>
                        <c:when test="${param.user_type_id == 3}">
                            Customers Login Page
                        </c:when>
                    </c:choose>
                </div>

                <form action="login.do" method="post">  

                    <input type="hidden" name="user_Type_Id" id="user_Type_Id" value="${param.user_type_id}">

                    <div class="mb-3">
                        <label for="email" class="form-label fw-bold text-dark">Email</label>
                        <input type="email" name="email" id="email" class="form-control">
                        <small>
                            ${param.email_incorrect_message}
                        </small>
                    </div>

                    <div class="mb-3">
                        <label for="password" class="form-label fw-bold text-dark">Password</label>
                        <input type="password" name="password" id="password" class="form-control">
                        <small>
                            ${param.pass_incorrect_message}
                        </small>
                    </div>

                    <div class="mb-3">

                        <input type="submit" class="btn btn-secondary btn-md" value="Login" class="form-control">

                        <a href="signup.do?user_type_id=${param.user_type_id}" class="btn btn-secondary btn-md">SignUp</a>

                        <a href="forget_password.do" class="btn btn-secondary btn-md" >Forget Password</a>
                    </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


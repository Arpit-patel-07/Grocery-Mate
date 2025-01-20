<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
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
                <div class="fs-4 fw-semibold my-4 bg-info p-2 border border-secondary rounded">SignUp Form</div>
                
                <form action="signup.do" method="post"> 
                    
                    <input type="hidden" id="user_type_id" name="user_type_id" value="${param.user_type_id}">

                    <div class="mb-3">
                        <label for="full_name" class="form-label fw-bold text-dark">Name</label>
                        <input type="text" name="name" id="name" class="form-control">
                    </div>
                
                    <div class="mb-3">
                        <label for="email" class="form-label fw-bold text-dark">Email</label>
                        <input type="email" name="email" id="email" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="password" class="form-label fw-bold text-dark">Password</label>
                        <input type="password" name="password" id="password" class="form-control">
                    </div>
                    
                   <c:if test="${param.user_type_id==3}">
                        <div class="mb-3">
                            <label for="DateOfBirth" class="form-label fw-bold text-dark">DateOfBirth</label>
                            <input type="date" name="DateOfBirth" id="DateOfBirth" class="form-control">
                        </div>

                        <label class="form-label fw-bold text-dark">Select Gender ..</label>

                        <div class="mb-3">
                            <label for="gender" class="form-label  text-dark">Male</label>
                            <input type="radio" name="gender" value="M"/><br>
                            <label for="gender" class="form-label  text-dark">Female</label>
                            <input type="radio" name="gender" value="F"/><br>
                            <label for="gender" class="form-label  text-dark">Other</label>
                            <input type="radio" name="gender" value="O"/>
                        </div>
                    </c:if>

                    <c:if test="${param.user_type_id != 3}">
                        <div class="mb-3">
                            <label for="registration_date" class="form-label fw-bold text-dark">Registration Date</label>
                            <input type="date" name="registration_date" id="registration_date" class="form-control">
                        </div>
                    </c:if>

                    <div class="mb-3">
                        <label for="textArea" class="form-label fw-bold text-dark">Address</label>
                        <textarea name="address" id="textArea" class="form-control" rows="5" cols="50"></textarea>
                    </div>

                    <div class="mb-3">
                        <label for="city_id" class="form-label fw-bold text-dark">City</label>
                        <select name="city_id" id="city_id" class="form-control ">

                            <option value="0" class="fw-1">Select City ...</option>

                            <c:forEach  var="city" items="${cities}">
                                <option value="${city.cityId}">${city.name}(${city.state.name})</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="contact" class="form-label fw-bold text-dark">Contact</label>
                        <input type="number" name="contact" id="contact" class="form-control">
                    </div>

                    <div class="mb-3">
                        <input type="submit" class="btn btn-primary btn-md" value="Signup" class="form-control">
                    </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>
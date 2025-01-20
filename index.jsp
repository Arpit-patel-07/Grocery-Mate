<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <link rel="stylesheet" href="static/css/indexpage.css">
</head>

<body>
    <div class="container">
        <div class="row ">
            <div class="col">
                <%@ include file="header.jsp" %>
            </div>
        </div>

        <div class="row ms-3 me-3">
            <div class="col mt-5 rounded  border border-secondary" style="height:400px;background-image:url(static/media/images/E-1.jpg)"></div>
        </div><hr>

        <!--##################### Thumbinal Images #####################-->

        <div class="row">
            <div class="col" class="head">
                <div class="card" style="width: 20rem;" data-bs-toggle="modal" data-bs-target="#login_form">
                    <a href="login.jsp?user_type_id=1"><img src="static/media/images/img1.jpg" class="thumbnail"></a>
                </div>
            </div>

            <div class="col" class="head">
                <div class="card" style="width: 20rem;" data-bs-toggle="modal" data-bs-target="#login_form">
                   <a href="login.jsp?user_type_id=2"><img src="static/media/images/img2.jpg" class="thumbnail"></a>
                </div>
            </div>
            
            <div class="col" class="head">
                <div class="card" style="width: 20rem;" data-bs-toggle="modal" data-bs-target="#login_form">
                   <a href="login.jsp?user_type_id=3"><img src="static/media/images/img3.png" class="thumbnail"></a>
                </div>
            </div>
        </div>
        <hr>
        <div class="footer">

            <div class="footerContainer">
                
                <div class="socialIcons">
                    <a href=""><li class="fab fa-facebook"></li></a>
                    <a href=""><li class="fab fa-instagram"></li></a>
                    <a href=""><li class="fab fa-twitter"></li></a>
                    <a href=""><li class="fab fa-google-plus"></li></a>
                    <a href=""><li class="fab fa-youtube"></li></a>
                    <a href=""><li class="fab fa-linkedin"></li></a>
                </div>
    
                <div class="footerNav">
                    <ul>
                        <li><a href="">Home</a></li>
                        <li><a href="">Contanct Us</a></li>
                        <li><a href="">About</a></li>
                        <li><a href="">Out Team</a></li>
                        <li><a href="">Future</a></li>
                    </ul>
                </div>
    
                <div class="footerbottom">
                    <p>Copyright &copy;2025 Designd By The <span class="deginer">Arpit</span></p>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"> </script>
</body>
</html>
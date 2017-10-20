<%-- 
    Document   : 404
    Created on : 13/09/2017, 03:27:10
    Author     : Vinicius Ferreira Batista
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="robots" content="all,follow">
        <meta name="googlebot" content="index,follow,snippet,archive">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="DVL e-Commerce">
        <meta name="author" content="DVL Developers">
        <meta name="keywords" content="">

        <title>
            VIP Modas e-Commerce
        </title>

        <meta name="keywords" content="">

        <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

        <!-- styles -->
        <link href="css/font-awesome.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/owl.carousel.css" rel="stylesheet">
        <link href="css/owl.theme.css" rel="stylesheet">

        <!-- theme stylesheet -->
        <link href="css/style.blue.css" rel="stylesheet" id="theme-stylesheet">

        <!-- your stylesheet with modifications -->
        <link href="css/custom.css" rel="stylesheet">

        <script src="js/respond.min.js"></script>

        <link rel="shortcut icon" href="favicon.png">



    </head>

    <body>

        <jsp:include page="WEB-INF/jsp/cabecalho.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Início</a>
                            </li>
                            <li>Verificação</li>
                        </ul>


                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <div class="box" id="acn">

                                    <p class="text-center">
                                        <img src="img/vip.png" alt="Obaju template">
                                    </p>

                                    <h3>Para comprar, você precisa de uma conta!</h3>
                                    <div id="btns">
                                        <a href="#" id="btn2" data-toggle="modal" class="btn btn-primary" data-target="#login-modal"> 
                                            <i class="fa fa-sign-in"></i>
                                            Já tenho uma conta</a>
                                        <a href="registro" id="btn1" class="btn btn-primary"><img src="img/reg.png" alt=""/> Sou novo</a>
                                    </div>

                                </div>
                            </div>
                        </div>


                    </div>
                    <!-- /.col-md-9 -->
                </div>
                <!-- /.container -->
            </div>
            <!--<br> &nbsp;-->

            <jsp:include page="WEB-INF/jsp/rodape.jsp"/>

        </div>
        <!-- /#all -->

        <!-- *** SCRIPTS TO INCLUDE ***
     _________________________________________________________ -->
        <script src="js/jquery-1.11.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.cookie.js"></script>
        <script src="js/waypoints.min.js"></script>
        <script src="js/modernizr.js"></script>
        <script src="js/bootstrap-hover-dropdown.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/front.js"></script>




    </body>

</html>
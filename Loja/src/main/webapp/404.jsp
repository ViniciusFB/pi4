<%-- 
    Document   : 404
    Created on : 13/09/2017, 03:27:10
    Author     : Vinicius Ferreira Batista
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"
        isErrorPage="true"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
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

        <jsp:include page="WEB-INF/jsp/cabecalho.jsp"/>

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Home</a>
                            </li>
                            <li>Página não encontrada</li>
                        </ul>


                        <div class="row" id="error-page">
                            <div class="col-sm-6 col-sm-offset-3">
                                <div class="box">

                                    <p class="text-center">
                                        <img src="img/vip.png" alt="Vip logo">
                                    </p>

                                    <h3>Desculpe, a página solicitada não foi encontrada.</h3>
                                    <h4 class="text-muted">Error 404 - Page not found</h4>

                                    <p class="buttons"><a href="index" class="btn btn-primary"><i class="fa fa-home"></i> Voltar para a página inicial</a>
                                    </p>
                                </div>
                            </div>
                        </div>


                    </div>
                    <!-- /.col-md-9 -->
                </div>
                <!-- /.container -->
            </div>
            <!--            <br> &nbsp; <br><br>&nbsp;
                        <br> &nbsp; <br><br>&nbsp;
                        <br> &nbsp; <br><br>&nbsp;-->

            <%--<jsp:include page="WEB-INF/jsp/rodape.jsp"/>--%>

        </div>
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
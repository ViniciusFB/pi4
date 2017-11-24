<%-- 
    Document   : index
    Created on : 05/09/2017, 02:54:09
    Author     : Vinicius Ferreira Batista
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta name="robots" content="all,follow">
        <meta name="googlebot" content="index,follow,snippet,archive">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="DVL e-Commerce">
        <meta name="author" content="DVL Developers">
        <meta name="keywords" content="">

        <title>
            VIP | Acessórios
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
                        <div id="main-slider">
                            <div class="item">
                                <img src="img/imagemxx.jpg" alt="Imagem 1" class="img-responsive">
                            </div>
                            <div class="item">
                                <img class="img-responsive" src="img/acessorios13.png" alt="Imagem 2">
                            </div>
                            <div class="item">
                                <img class="img-responsive" src="img/acessorios2.jpg" alt="Imagem 3">
                            </div>
                            <div class="item">
                                <img class="img-responsive" src="img/acessorios4.jpg" alt="Imagem 4">
                            </div>
                        </div>
                        <!-- /#main-slider -->
                    </div>
                </div>

                <div id="hot">

                    <div class="box">
                        <div class="container">
                            <div class="col-md-12">
                                <h2>Produtos Recentes</h2>
                            </div>
                        </div>
                    </div>

                    <div class="container">
                        <div class="product-slider">

                            <c:forEach items="${listaProdutos}" var="produto">

                                <div class="item">
                                    <div class="product">
                                        <div class="flip-container">
                                            <div class="flipper">
                                                <div class="front">

                                                    <a href="detalhes?c=${produto.codigo}">
                                                        <img src="${produto.imagem}" alt="Imagem Produto" class="img-responsive">
                                                    </a>
                                                </div>
                                                <div class="back">
                                                    <a href="detalhes?c=${produto.codigo}">
                                                        <img src="${produto.imagem}" alt="Imagem Produto" class="img-responsive">
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="detalhes?c=${produto.codigo}" class="invisible">
                                            <img src="${produto.imagem}" alt="Imagem Produto" class="img-responsive">
                                        </a>
                                        <div class="text">
                                            <h3><a href="detalhes?c=${produto.codigo}">${produto.nome}</a></h3>
                                            <p class="price">R$ ${produto.valor}</p>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>


                            <!-- /.col-md-4 -->

                        </div>
                        <!-- /.product-slider -->
                    </div>
                    <!-- /.container -->

                </div>



            </div>

            <!-- *** COPYRIGHT ***
     _________________________________________________________ -->
            <jsp:include page="WEB-INF/jsp/rodape.jsp" />

            <!-- *** COPYRIGHT END *** -->

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

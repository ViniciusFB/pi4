<%-- 
    Document   : detalhes
    Created on : 16/09/2017, 04:23:26
    Author     : Vinicius Ferreira Batista
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta name="robots" content="all,follow">
        <meta name="googlebot" content="index,follow,snippet,archive">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Obaju e-commerce template">
        <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
        <meta name="keywords" content="">

        <title>
            Vip Modas e-Commerce
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
                            <li><a href="#">Acessórios</a>
                            </li>
                            <li><a href="#">${categorias}</a>
                            </li>
                            <li>${nomeProduto}</li>
                        </ul>

                    </div>

                    <div class="col-md-3">
                        <!-- *** MENUS AND FILTERS ***
     _________________________________________________________ -->
                        <div class="panel panel-default sidebar-menu">

                            <div class="panel-heading">
                                <h3 class="panel-title">Categorias</h3>
                            </div>

                            <div class="panel-body">
                                <ul class="nav nav-pills nav-stacked category-menu">
                                    <li>
                                        <a href="category.html">Acessórios</a>
                                        <ul>
                                            <li><a href="category.html">Bolsas</a>
                                            </li>
                                            <li><a href="category.html">Mochilas</a>
                                            </li>
                                            <li><a href="category.html">Óculos</a>
                                            </li>
                                            <li><a href="category.html">Relógios</a>
                                            </li>
                                            <li><a href="category.html">Bonés</a>
                                            </li>
                                            <li><a href="category.html">Gorros</a>
                                            </li>
                                            <li><a href="category.html">Pulseiras</a>
                                            </li>
                                            <li><a href="category.html">Brincos</a>
                                            </li>
                                            <li><a href="category.html">Carteiras</a>
                                            </li>
                                        </ul>
                                    </li>

                                </ul>

                            </div>
                        </div>


                    </div>

                    <div class="col-md-9">

                        <div class="row" id="productMain">
                            <div class="col-sm-6">
                                <div id="mainImage">
                                    <img src="${imagem}" alt="Imagem Principal" class="img-responsive">
                                </div>

                            </div>
                            <div class="col-sm-6">
                                <div class="box">
                                    <form action="carrinho" method="post">
                                        <h1 class="text-center">${nomeProduto}</h1>
                                        <p class="goToDescription"><a href="#details" class="scroll-to">Ver os detalhes do produto</a>
                                        </p>
                                        <p class="price">R$ ${valorProduto}</p>

                                        <p class="text-center buttons">
                                            <!--<a href="ControleCarrinho?acao=addProduto&idProduto=${produto.id}&idCliente=${idCliente}" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> Adicionar ao carrinho</a>--> 
                                            <input type="hidden" name="idProduto" value="${idProduto}">
                                            <button type="submit" name="acao" value="addProduto" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> Adicionar ao carrinho</button> 
                                        </p>
                                    </form>

                                </div>

                                <div class="row" id="thumbs">
                                    <div class="col-xs-4">
                                        <!--imagem com resolução maior-->
                                        <a href="${imagem}" class="thumb"> 
                                            <!--imagem da thumb-->
                                            <img src="${imagem}" alt="Imagem 1" class="img-responsive">
                                        </a>
                                    </div>
                                    <div class="col-xs-4">
                                        <a href="img/notAvaiable.jpg" class="thumb">
                                            <img src="img/noImage.jpg" alt="Imagem 2" class="img-responsive">
                                        </a>
                                    </div>
                                    <div class="col-xs-4">
                                        <a href="img/notAvaiable.jpg" class="thumb">
                                            <img src="img/noImage.jpg" alt="Imagem 3" class="img-responsive">
                                        </a>
                                    </div>
                                </div>
                            </div>

                        </div>


                        <div class="box" id="details">
                            <p>
                            <h4>Descrição</h4>
                            <p>${descricao}</p>

                        </div>

                    </div>
                    <!-- /.col-md-9 -->
                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->


            <!-- *** FOOTER ***
     _________________________________________________________ -->

            <!-- /#footer -->

            <!-- *** FOOTER END *** -->




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
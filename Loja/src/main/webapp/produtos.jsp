<%-- 
    Document   : produtos
    Created on : 16/09/2017, 06:22:59
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
                            <li><a href="index">Início</a>
                            </li>
                            <li>Produtos</li>
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

                        <!-- *** MENUS AND FILTERS END *** -->
                    </div>

                    <div class="col-md-9">
                        <div class="box">
                            <h1>Produtos</h1>
                            <p>Nossa loja oferece uma ampla seleção dos melhores produtos que encontramos e cuidadosamente selecionamos por todo o mundo.  </p>
                        </div>

                        <div class="box info-bar">
                            <div class="row">
                                <div class="col-sm-12 col-md-4 products-showing">
                                    Mostrando <strong>12</strong> de <strong>25</strong> produtos
                                </div>

                                <div class="col-sm-12 col-md-8  products-number-sort">
                                    <div class="row">
                                        <form class="form-inline">
                                            <div class="col-md-6 col-sm-6">
                                                <div class="products-number">
                                                    <strong>Mostrar</strong>  <a href="#" class="btn btn-default btn-sm btn-primary">12</a>  <a href="#" class="btn btn-default btn-sm">24</a>  <a href="#" class="btn btn-default btn-sm">Todos</a>
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-sm-6">
                                                <div class="products-sort-by">
                                                    <strong>Filtrar por</strong>
                                                    <select name="sort-by" class="form-control">
                                                        <option>Preço</option>
                                                        <option>Nome</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row products">


                            <c:forEach items="${listaProd}" var="produto">
                                <div class="col-md-4 col-sm-6">
                                    <div class="product">
                                        <div class="flip-container">
                                            <div class="flipper">
                                                <div class="front">
                                                    <a href="detalhes?c=${produto.codigo}">
                                                        <img src="${produto.imagem}" alt="" class="img-responsive">
                                                    </a>
                                                </div>
                                                <div class="back">
                                                    <a href="detalhes?c=${produto.codigo}">
                                                        <img src="${produto.imagem}" alt="" class="img-responsive">
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="detalhes?c=${produto.codigo}" class="invisible">
                                            <img src="${produto.imagem}" alt="" class="img-responsive">
                                        </a>
                                        <div class="text">
                                            <h3><a href="detalhes?c=${produto.codigo}">${produto.nome}</a></h3>
                                            <p class="price">R$ ${produto.valor}</p>
                                            <p class="buttons">
                                                <a href="detalhes?c=${produto.codigo}" class="btn btn-default">Ver detalhes</a>
                                                <input type="hidden" name="idProduto" class="idProd" value="${produto.id}">
                                                <a type="#" value="${produto.id}" class="addCarrinho btn btn-primary"><i class="fa fa-shopping-cart"></i> Adicionar ao carrinho</a> 
                                            </p>
                                        </div>
                                        <!-- /.text -->
                                    </div>
                                    <!-- /.product -->
                                </div>
                            </c:forEach>
                        </div>
                        <!-- /.products -->

                        <div class="pages">

                            <p class="loadMore">
                                <a href="#" class="btn btn-primary btn-lg"><i class="fa fa-chevron-down"></i> Carregar mais</a>
                            </p>

                            <ul class="pagination">
                                <li><a href="#">&laquo;</a>
                                </li>
                                <li class="active"><a href="#">1</a>
                                </li>
                                <li><a href="#">2</a>
                                </li>
                                <li><a href="#">3</a>
                                </li>
                                <li><a href="#">4</a>
                                </li>
                                <li><a href="#">5</a>
                                </li>
                                <li><a href="#">&raquo;</a>
                                </li>
                            </ul>
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
        <script src="js/addCarrinho.js"></script>

    </body>

</html>
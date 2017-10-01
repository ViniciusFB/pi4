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

        <input type="hidden" name="quantidadePagina" value="${quantidadePagina}">
        <input type="hidden" name="numeroPagina" value="${numeroPagina}">

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
                                <form action="filtrar" method="post">
                                    <ul class="nav nav-pills nav-stacked category-menu">
                                        <li>
                                            <a>Acessórios</a>
                                            <ul>
                                                <li><a class="categorias" name="categoria" href="#">Bolsa</a>
                                                </li>
                                                <li><a class="categorias" name="categoria" href="#">Mochila</a>
                                                </li>
                                                <li><a class="categorias" name="categoria" href="#">Oculos</a>
                                                </li>
                                                <li><a class="categorias" name="categoria" href="#">Relogio</a>
                                                </li>
                                                <li><a class="categorias" name="categoria" href="#">Bone</a>
                                                </li>
                                                <li><a class="categorias" name="categoria" href="#">Touca</a>
                                                </li>
                                                <li><a class="categorias" name="categoria" href="#">Pulseira</a>
                                                </li>
                                                <li><a class="categorias" name="categoria" href="#">Colar</a>
                                                </li>
                                                <li><a class="categorias" name="categoria" href="#">Brinco</a>
                                                </li>
                                                <li><a class="categorias" name="categoria" href="#">Cinto</a>
                                                </li>
                                                <li><a class="categorias" name="categoria" href="#">Carteira</a>
                                                </li>
                                                <input id="category" type="hidden" name="category" value="">
                                            </ul>
                                        </li>

                                    </ul>
                                </form>

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

                        <div class="row products" id="produtos1">


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
                                                <a type="#" value="${produto.id}" class="addCarrinho btn btn-primary"><i class="fa fa-shopping-cart"><span style="display: none">${produto.nome}</span></i> Adicionar ao carrinho</a> 
                                            </p>
                                        </div>
                                        <!-- /.text -->
                                    </div>
                                    <!-- /.product -->
                                </div>
                                <div class="alert alert-success" id="mensagem" style="display: none; position: fixed; bottom: 50px; left: 0; z-index: 2; color: black; background-color: rgba(98, 203, 55, 0.6);">

                                </div>
                            </c:forEach>
                        </div>
                        <!-- /.products -->

                        <div class="pages">

                            <ul class="pagination">
                                ${laquo}
                                    <!--<li><a class="${active}" href=produtos?numeroPagina=${pagina}> ${pagina}</a></li>-->
                                ${pagina}
                                ${raquo}

                            </ul>
                        </div>


                    </div>
                    <!-- /.col-md-9 -->
                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->

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
        <script src="js/filtroCategoria.js"></script>


    </body>

</html>
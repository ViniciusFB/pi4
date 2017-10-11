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

        <!--Cabecalho-->
        <jsp:include page="WEB-INF/jsp/cabecalho.jsp" />
        <!--Fim cabecalho-->

        <!--Controladores de Paginacao-->
        <input type="hidden" id="quantidadePagina" name="quantidadePagina" value="${quantidadePagina}">
        <input type="hidden" id="numPagina" name="numeroPagina" value="${numeroPagina}">
        <!--Fim Controladores de Paginacao-->

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
                        <!--Filtros de Categoria-->
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
                        <!--Fim Filtros de Categoria-->
                    </div>

                    <div class="col-md-9">
                        <div class="box">
                            <h1>Produtos</h1>
                            <p>Nossa loja oferece uma ampla seleção dos melhores produtos que encontramos e cuidadosamente selecionamos por todo o mundo.  </p>
                        </div>

                        <div id="principal">
                            <!--                            <div class="box info-bar" id="infos">
                                                            
                                                        </div>-->

                            <!--Listagem de Produtos-->
                            <!--<div class="row products" id="produtos1">-->

                            <jsp:include page="WEB-INF/jsp/filtroProdutos.jsp" />

                            <!--</div>-->
                        </div>

                        <!--Fim Listagem de Produtos-->

                    </div>
                    <!-- /.col-md-9 -->
                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->

            <!--Rodape-->

            <jsp:include page="WEB-INF/jsp/rodape.jsp" />

            <!--Fim Rodape-->

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

        <script>
            //Script para adicionar a classe "active" na página atual.
            $(document).ready(function () {
                var numPagina = parseInt($("#numPagina").val(), 10);
                var quantidadePagina = parseInt($("#quantidadePagina").val(), 10);

                for (var i = 1; i <= quantidadePagina; i++) {

                    if (i === numPagina) {
                        $(".nPagina").eq(i - 1).attr("class", "nPagina active");
                    }
                }


            });
        </script>

    </body>

</html>
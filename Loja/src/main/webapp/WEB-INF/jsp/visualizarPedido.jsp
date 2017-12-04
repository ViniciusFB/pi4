<%-- 
    Document   : usuario
    Created on : 05/09/2017, 06:07:13
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
        <!--<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">-->

        <!-- theme stylesheet -->
        <link href="css/style.blue.css" rel="stylesheet" id="theme-stylesheet">

        <!-- your stylesheet with modifications -->
        <link href="css/custom.css" rel="stylesheet">

        <script src="js/respond.min.js"></script>
        <script src="js/cpf.js" type="text/javascript"></script>
        <script src="js/telefone.js" type="text/javascript"></script>
        <link rel="shortcut icon" href="favicon.png">


        <!-- Adicionando JQuery -->
        <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>


    </head>

    <body>

        <jsp:include page="cabecalho.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Inicio</a>
                            </li>
                            <li>Minha conta</li>
                        </ul>

                    </div>

                    <div class="col-md-3">
                        <!-- *** CUSTOMER MENU ***
     _________________________________________________________ -->
                        <div class="panel panel-default sidebar-menu">

                            <div class="panel-heading">
                                <h3 class="panel-title">Sessão do Usuário</h3>
                            </div>

                            <div class="panel-body">

                                <ul class="nav nav-pills nav-stacked">
                                    <li>
                                        <a href="usuario"><i class="fa fa-user"></i> Minha conta</a>
                                    </li>
                                    <li>
                                        <a href="EnderecoServlet01"><i class="fa fa-home"></i> Meus enderecos</a>
                                    </li>
                                    <li class="active">
                                        <a href="pedidos"><i class="fa fa-shopping-cart"></i> Meus pedidos</a>
                                    </li>
                                    <li>
                                        <a href="logout"><i class="fa fa-sign-out"></i> Logout</a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                        <!-- /.col-md-3 -->

                        <!-- *** CUSTOMER MENU END *** -->
                    </div>

                    <!--<div class="col-md-9" id="customer-orders">-->
                    <div class="col-md-9" id="basket">
                        <div class="box">
                            <h1>Meus pedidos</h1>

                            <hr>

                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th colspan="2">Produto</th>
                                            <th>Quantidade</th>
                                            <th>Preço Unitário</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>

                                    <c:forEach items="${listaProdutos}" var="item">
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <a href="detalhes?c=${item.codigo}">
                                                        <img src="${item.imagem}" alt="Imagem Produto">
                                                    </a>
                                                </td>
                                                <td><a href="detalhes?c=${item.codigo}">${item.nome}</a></td>
                                                <td>${item.quantidade}</td>
                                                <td>R$ ${item.valorUni}</td>
                                                <td>R$ ${item.valorTotal}</td>
                                            </tr>
                                        </tbody>

                                    </c:forEach>

                                    <tfoot>
                                        <tr>
                                            <th colspan="4">Total + Frete</th>
                                            <th colspan="2">R$ ${valorCompra}</th>
                                        </tr>
                                    </tfoot>
                                </table>
                                <div class="row">
                                    <div class="col-sm-6" style="background-color: hsl(0, 0%, 95%)">
                                        <h4>Pagamento: Cartão de Crédito</h4>
                                        <h5>Número do Cartão: ${numeroCartao}</h5>
                                        <h5>Número de Parcelas: ${numeroParcelas}x de ${valorCompra/numeroParcelas} sem juros</h5>
                                    </div>
                                    <div class="col-sm-6" style="background-color: hsl(0, 0%, 95%)">
                                        <h4>Endereço de Entrega</h4>
                                        <h5>CEP: </h5>
                                        <h5>Rua: </h5>
                                    </div>
                                </div>

                                <br>

                            </div>
                            <a href="pedidos" class="btn btn-default"><i class="fa fa-chevron-left"></i> Meus pedidos</a>

                        </div>
                    </div>

                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->

            <!-- *** COPYRIGHT ***
     _________________________________________________________ -->
            <jsp:include page="rodape.jsp" />

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

        <script src="js/bootstrapValidator.js" type="text/javascript"></script>
        <script src="js/validar.js" type="text/javascript"></script>


    </body>
</html>

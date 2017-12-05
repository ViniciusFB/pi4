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
                    <div class="col-md-9">
                        <div class="box">
                            <!--<h1>Meus pedidos</h1>-->
                            <h3>Pedido ${protocolo}</h3>
                            <!--<div class="row zeroMarginPadding paddingB25 hidden-xs row-eq-height">-->
                            <div class="row zeroMarginPadding paddingB25 hidden-xs row-eq-height">
                                <div class="col-xs-12 col-md-4 boxOption zeroBoxOptionR paddingB15" style="background-color: hsl(0, 0%, 95%)">
                                    <div class="row zeroMarginPadding paddingBT15">
                                        <div class="col-md-12 h5 zeroMarginPadding titles titlesSize"> Forma de pagamento </div>

                                    </div>
                                    <div class="row zeroMarginPadding paddingT15">
                                        <div class="col-md-4 zeroMarginPadding">
                                            <img src="img/cartaoCredito.png" width="70" height="70" alt=""/>
                                            <!--<img src="img/cartaoCredito2.png" width="70" height="70" alt=""/>-->
                                        </div>
                                        <div class="col-md-8 zeroMarginPadding paddingR15">
                                            <strong>Cartão de Crédito</strong>
                                            <br>
                                            <span class="text-capitalize">${numeroCartao}</span>
                                            <span style="color: #40cd28">
                                                Aprovado
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-md-4 boxOption zeroBoxOptionR paddingBT15" style="background-color: hsl(0, 0%, 95%)">
                                    <div class="row zeroMarginPadding">
                                        <div class="col-md-12 zeroMarginPadding">
                                            <div class="h5 zeroMarginPadding titles titlesSize paddingB15">Total pago</div>
                                            <div class="priceOrder"> 
                                                <div class="row zeroMarginPadding">
                                                    <div class="col-md-6 zeroMarginPadding">
                                                        <p class="pStyle">Subtotal</p>
                                                        <p class="pStyle">Desconto</p>
                                                        Frete 
                                                    </div>
                                                    <div class="col-md-6 text-right zeroMarginPadding">
                                                        <p class="pStyle">R$ 0,00</p>
                                                        <p class="pStyle">R$ 0,00</p>
                                                        R$ 0,00 
                                                    </div>
                                                </div> <div class="row zeroMarginPadding">
                                                    <div class="col-md-12 zeroMarginPadding">
                                                        <p class="paddingT10"></p>
                                                        <hr class="zeroMarginPadding">
                                                        <p></p>
                                                    </div>
                                                </div>
                                                <div class="row zeroMarginPadding total featured"> 
                                                    <div class="col-md-6 zeroMarginPadding"> Total </div>
                                                    <div class="col-md-6 text-right zeroMarginPadding"> R$ ${valorCompra} </div>
                                                </div>
                                            </div> 
                                        </div>
                                    </div>
                                    <!--                                    <p>Pagamento: Cartão de Crédito</p>
                                                                        <p>Número do Cartão: ${numeroCartao}</p>
                                                                        <p>Número de Parcelas: ${numeroParcelas}x de ${valorCompra/numeroParcelas} sem juros</p>-->
                                </div>
                                <div class="col-xs-12 col-md-4 boxOption paddingBT15" style="background-color: hsl(0, 0%, 95%)">
                                    <div class="row zeroMarginPadding">
                                        <div class="col-md-12 zeroMarginPadding"> 
                                            <div class="h5 zeroMarginPadding titles titlesSize paddingB15">Endereço de entrega</div>
                                            <div>
                                                <p> <span class="featured">Nome e Sobrenome</span>
                                                    <br> Endereço </p>
                                                Rua, numero,  (Complemento) - CEP XXXX, BAIRRO - CIDADE, UF
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <!--<hr>-->

                            <div>
                                <div class="row">
                                    <!--                                    <div class="col-xs-0 col-md-1">
                                                                        </div>-->
                                    <div class="col-xs-6 col-md-6">
                                        <label> <strong>Produto </strong></label>
                                    </div>
                                    <div class="col-xs-2 col-md-2">
                                        <label> <strong>Qtde</strong> </label>
                                    </div>
                                    <div class="col-xs-2 col-md-2">
                                        <label><strong> Valor Uni.</strong> </label>
                                    </div>
                                    <div class="col-xs-2 col-md-2">
                                        <label><strong> Valor Total</strong></label>
                                    </div>


                                </div>
                                <hr style="margin-top: 5px; margin-bottom: 4px; border: 0;
                                    border-top: 1px solid #eeeeee;">

                                <c:forEach items="${listaProdutos}" var="item">
                                    <!--<tbody>-->
                                    <div class="row">
                                        <div class="col-xs-3 col-md-1">
                                            <a href="detalhes?c=${item.codigo}">
                                                <img src="${item.imagem}" height="50" width="50" alt="Imagem Produto">
                                            </a>
                                        </div>
                                        <div class="col-xs-3 col-md-5">
                                            <br>
                                            <a href="detalhes?c=${item.codigo}">${item.nome}</a>
                                        </div>
                                        <div class="col-xs-2 col-md-2">
                                            <br>
                                            ${item.quantidade}
                                        </div>
                                        <div class="col-xs-2 col-md-2">
                                            <br>
                                            ${item.valorUni}
                                        </div>
                                        <div class="col-xs-2 col-md-2">
                                            <br>
                                            ${item.valorTotal}
                                        </div>

                                    </div>
                                    <hr style="margin-top: 5px; margin-bottom: 4px; border: 0;
                                        border-top: 1px solid #eeeeee;">

                                </c:forEach>
                                <div class="row">
                                    <div class="col-xs-9 col-md-10">
                                        <p><strong>    Total + Frete</strong></p>
                                    </div>
                                    <div class="col-xs-3 col-md-2">
                                        <p><strong> R$${valorCompra} </strong></p>
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

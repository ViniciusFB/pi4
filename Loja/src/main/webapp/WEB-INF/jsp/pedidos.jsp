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
                    <!--<input name="sucesso" id="sucesso" type="hidden" value="${sucesso}">-->
                    <!--                    <div class="modal fade" id="myModal" role="dialog">
                                            <div class="modal-dialog modal-sm">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title">Aviso</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p id="mensagem"><strong>${msg}</strong></p>
                                                        <p><strong>Protocolo: ${protocolo}</strong></p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>-->
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

                    <div class="col-md-9" id="customer-orders">
                        <div class="box">
                            <h1>Meus pedidos</h1>
                            <h4 style="color: green">${msg}</h4>
                            <h4 style="color: orangered" class="text-muted">${protocolo}</h4>

                            <form action="pedidos" accept-charset="iso-8859-1,utf-8" method="post">
                                <div class="row">
                                    <div class="col-xs-12 col-md-3">
                                        <label for="nProtocolo">N° Protocolo</label>
                                        <input id="nProtocolo" type="text" value="" class="form-control">
                                    </div>

                                    <div class="col-xs-12 col-md-3">
                                        <label for="dataInicial">Data Inicial</label>
                                        <input id="dataInicial" type="date" value="" name="dataInicial" class="form-control">
                                    </div>

                                    <div class="col-xs-12 col-md-3">
                                        <label for="dataFinal">Data Final</label>
                                        <input id="dataFinal" type="date" value="" name="dataFinal" class="form-control">
                                    </div>
                                    <div class="col-xs-12 col-md-3">
                                        <label for="filtrar"></label>
                                        <input type="submit" value="Filtrar" name="Filtrar" class="btn btn-primary form-control" id="filtrar">
                                    </div>
                                </div>
                            </form>

                            <hr>

                            <div id="listaDePedidos">
                                <c:choose>
                                    <c:when test="${not empty listaCompras}">
                                        <c:forEach items="${listaCompras}" var="compra">
                                            <input type="hidden" name="idVenda" value="${compra.id}">
                                            <div class="row">
                                                <div class="col-xs-12 marginB25">
                                                    <div class="col-md-12 card-order card-panel paid">

                                                        <div class="row">
                                                            <div class="col-md-4 card-photos">
                                                                <p id="dataFormatada">Realizado em ${compra.dataFormatada}</p>
                                                                <div>
                                                                    <h3>Protocolo</h3>
                                                                    <h3>${compra.protocolo}</h3>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-8 card-info">
                                                                <div class="col-xs-12 col-md-7 date-status st-${compra.status}">
                                                                    <div class="date col-xs-5 col-md-5">
                                                                        <span> Previsão Entrega </span>

                                                                        <div>
                                                                            <p> ${compra.diaPrevisao} <span class="ng-binding"> ${compra.mesAnoPrevisao} </span> </p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="status col-xs-7 col-md-7 st-${compra.status}"> 
                                                                        <span>Status do Pedido</span>
                                                                        <c:choose>
                                                                            <c:when test="${compra.status == 0}">
                                                                                <h3 class="titles">Aguardando Pagamento</h3>
                                                                            </c:when>
                                                                            <c:when test="${compra.status == 1}">
                                                                                <h3 class="titles">Pedido em Processamento</h3>
                                                                            </c:when>
                                                                            <c:when test="${compra.status == 2}">
                                                                                <h3 class="titles">Faturamento</h3>
                                                                            </c:when>
                                                                            <c:when test="${compra.status == 3}">
                                                                                <h3 class="titles">Em Transporte</h3>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <h3 class="titles">Entregue</h3>
                                                                            </c:otherwise>

                                                                        </c:choose>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-12 col-md-5 payment stP-${compra.status}">
                                                                    <div class="info col-md-12 col-xs-7">
                                                                        <span>Forma de Pagamento</span>
                                                                        <p>Cartão de Crédito</p>
                                                                    </div>
                                                                    <div class="info col-md-12 col-xs-5 ng-binding">
                                                                        Valor total
                                                                        <p class="toUppercase ng-binding">R$ ${compra.valorFinal}</p> 
                                                                    </div>
                                                                </div>
                                                            </div>

                                                        </div>
                                                        <div class="row">
                                                            <div class="card-menu card-panel-footer col-xs-12">
                                                                <div class="zeroMarginPadding">
                                                                    <div class="col-xs-4 col-md-8 zeroMarginPadding">
                                                                        <a class="btn btn-default btn-xs hidden-xs hidden-sm" href="visualizarPedido?idVenda=${compra.id}">
                                                                            Ver Detalhes
                                                                        </a>
                                                                        <a class="btn-link hidden-md hidden-lg" href="visualizarPedido?idVenda=${compra.id}">Ver detalhes</a>

                                                                    </div>
                                                                </div>

                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <p class="text-large text-center"> Não há pedidos${msg}!</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->

            <!-- *** COPYRIGHT ***
     _________________________________________________________ -->
            <%--<jsp:include page="rodape.jsp" />--%>

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
        <script type="text/javascript">
            $(document).ready(function () {

                var campoProtocolo = $("#nProtocolo");

                campoProtocolo.keyup(function () {
                    delay(function () {
                        $.ajax({
                            type: "POST",
                            url: 'pedidos',
                            data: {acao: 'procuraProtocolo', nProtocolo: $("#nProtocolo").val()},
                            success: function (response)
                            {
                                $("#listaDePedidos").hide().html($(response).find("#listaDePedidos")).hide().fadeIn();
                            }
                        });

                        return false;
                    }, 500);

                });

                var delay = (function () {
                    var timer = 0;
                    return function (callback, ms) {
                        clearTimeout(timer);
                        timer = setTimeout(callback, ms);
                    };
                })();
            })

        </script>

    </body>
</html>

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


    <style>

        @media only screen and (max-width: 360px) and (min-width: 300px) {
            hr {
                margin-top: 150px;
            }
            #dataFinal {
                margin-bottom: 10px;
            }
            #dataInicial, #dataFinal {
                margin-left: 50px;
            }
            label {
                text-align: center;
                margin-left: 80px;
            }
            #filtrar {
                margin-left: 50px;
                width: 150px;
            }
        }
        @media only screen and (max-width: 430px) and (min-width: 361px) {
            hr {
                margin-top: 150px;
            }
            #dataFinal {
                margin-bottom: 10px;
            }
            #dataInicial, #dataFinal {
                margin-left: 80px;
            }
            label {
                text-align: center;
                margin-left: 80px;
            }
            #filtrar {
                margin-left: 80px;
                width: 150px;
            }
        }
        @media only screen and (max-width: 499px) and (min-width: 431px) {
            hr {
                margin-top: 80px;
            }
            #filtrar {
                margin-left: 20px;
                width: 250px;
            }
        }
        @media only screen and (max-width: 700px) and (min-width: 500px) {
            #filtrar {
                margin-left: -15px;
            }
        }
        @media only screen and (max-width: 900px) and (min-width: 700px) {
            #filtrar {
                width: 200px;
            }
        }
    </style>
    <body>

        <jsp:include page="WEB-INF/jsp/cabecalho.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">
                    <input name="sucesso" id="sucesso" type="hidden" value="${sucesso}">
                    <div class="modal fade" id="myModal" role="dialog">
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
                    </div>
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
                                <h3 class="panel-title">Menu do Funcionário</h3>
                            </div>

                            <div class="panel-body">

                                <ul class="nav nav-pills nav-stacked">
                                    <li>
                                        <a href=""><i class="fa fa-user"></i> Minha conta</a>
                                    </li>
                                    <li class="active">
                                        <a href="pedidosBackoffice"><i class="fa fa-home"></i> Pedidos de Clientes</a>
                                    </li>
                                    <li>
                                        <a href="mensagens"><i class="fa fa-shopping-cart"></i> Mensagens de Clientes</a>
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
                            <form action="pedidos" method="post">
                                <div style="float:left;margin-right:20px; margin-top: 5px">
                                    <label for="dataInicial">Data Inicial</label>
                                    <input id="dataInicial" type="date" value="" name="dataInicial" class="form-inline" required style="display: block">
                                </div>

                                <div style="float:left;margin-right:20px; margin-top: 5px;">
                                    <label for="dataFinal">Data Final</label>
                                    <input id="dataFinal" type="date" value="" name="dataFinal" class="form-inline" required style="display: block">
                                </div>

                                <br>
                                <div style="float:left;margin-right:20px;">
                                    <input type="submit" value="Filtrar" name="Filtrar" class="btn btn-primary" id="filtrar" style="margin-top: 15px">
                                </div>
                            </form>

                            <br><br>

                            <hr>

                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Protocolo</th>
                                            <th>Data</th>
                                            <th>Última Atualização</th>
                                            <th>Total</th>
                                            <th>Status</th>
                                            <th>Ação</th>
                                        </tr>
                                    </thead>

                                    <c:forEach items="${listaCompras}" var="compra">
                                        <tbody>
                                            <tr>
                                                <input type="hidden" name="idVenda2" value="${compra.id}">
                                                <th>${compra.protocolo}</th>
                                                <td>${compra.dataFormatada}</td>
                                                <td>${compra.dataFormatada2}</td>
                                                <td>R$ ${compra.valorFinal}</td>

                                                <c:choose>
                                                    <c:when test="${compra.status == 0}">
                                                        <td><span class="label label-danger">Aguardando pagamento</span>
                                                        </td>
                                                    </c:when>
                                                    <c:when test="${compra.status == 1}">
                                                        <td><span class="label label-warning">Pedido em Processamento</span>
                                                        </td>
                                                    </c:when>
                                                    <c:when test="${compra.status == 2}">
                                                        <td><span class="label label-default">Faturamento</span>
                                                        </td>
                                                    </c:when>
                                                    <c:when test="${compra.status == 3}">
                                                        <td><span class="label label-primary">Em transporte</span>
                                                        </td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td><span class="label label-success">Entregue</span>
                                                        </td>
                                                    </c:otherwise>

                                                </c:choose>



                                                <td><a href="visualizarPedidoBackoffice?idVenda=${compra.id}" class="btn btn-primary btn-sm">Visualizar</a>
                                                </td>
                                            </tr>                                        
                                        </tbody>
                                    </c:forEach>
                                </table>
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
            $(window).on('load', function () {
                var verify = $("#sucesso").val();
                if (verify === '') {

                } else {
                    $('#myModal').modal('show');
                }


            });
        </script>

    </body>
</html>

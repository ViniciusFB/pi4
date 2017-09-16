<%-- 
    Document   : enderecos
    Created on : 15/09/2017, 06:33:33
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
            VIP e-Commerce
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
        <!--<script src="js/cpf.js" type="text/javascript"></script>-->
        <link rel="shortcut icon" href="favicon.png">

        <!-- Adicionando JQuery -->
        <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="js/consultaCep.js" type="text/javascript"></script>

    </head>

    <body>
        <!-- *** TOPBAR ***
     _________________________________________________________ -->
        <div id="top" style="z-index: 10; position: relative;">
            <div class="container">
                <div class="col-md-6 offer" data-animate="fadeInDown">

                </div>
                <div class="col-md-6" data-animate="fadeInDown">
                    <ul class="menu">


                        <c:choose>
                            <c:when test="${not empty sessionScope.usuario}">
                                <li class="dropdown yamm-fw">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">
                                        <span style="margin-right: 5px; color: white;" class="glyphicon glyphicon-user"></span>
                                        <c:out value="${sessionScope.usuario}"/><b style="margin-left: 5px" class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <div  class="yamm-content">
                                                <ul>
                                                    <a style="color: #555555" href="customer-account.html">Minha conta</a>
                                                    <a style="color: #555555" href="logout">Logout</a>

                                                </ul>

                                            </div>
                                        </li>
                                    </ul>
                                </li>

                                <li><a href="contact.html">Contato</a>
                                </li>
                                <li><a href="#">Visto Recentemente</a>
                                </li>

                            </c:when>
                            <c:otherwise>
                                <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                                </li>
                                <li><a href="registro.jsp">Cadastro</a>
                                </li>
                                <li><a href="contact.html">Contato</a>
                                </li>
                                <li><a href="#">Visto Recentemente</a>
                                </li>
                            </c:otherwise>
                        </c:choose>




                    </ul> 
                </div>
                <!-- /.yamm-content -->
            </div>
        </div>
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
            <div class="modal-dialog modal-sm">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="Login">Login do Cliente</h4>
                    </div>
                    <div class="modal-body">
                        <form action="login" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" id="email-modal" placeholder="e-mail" name="usuario">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="password-modal" placeholder="senha" name="senha">
                            </div>

                            <p class="text-center">
                                <button class="btn btn-primary"><i class="fa fa-sign-in"></i> Entrar</button>
                            </p>

                        </form>

                        <p class="text-center text-muted">Não registrado ainda?</p>
                        <p class="text-center text-muted"><a href="register.html"><strong>Registre-se Agora</strong></a>! É fácil e rápido, menos de um minuto!</p>

                    </div>
                </div>
            </div>
        </div>

        <!-- *** TOP BAR END *** -->

        <!-- *** NAVBAR ***
     _________________________________________________________ -->
        <jsp:include page="cabecalho.jsp" />
        <!-- /#navbar -->

        <!-- *** NAVBAR END *** -->

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="index">Início</a>
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
                                    <li class="active">
                                        <a href="customer-orders.html"><i class="fa fa-list"></i> Meus pedidos</a>
                                    </li>
                                    <li>
                                        <a href="customer-wishlist.html"><i class="fa fa-heart"></i> Lista de Desejos</a>
                                    </li>
                                    <li>
                                        <a href="customer-account.html"><i class="fa fa-user"></i> Minha conta</a>
                                    </li>
                                    <li>
                                        <a href="index.html"><i class="fa fa-sign-out"></i> Logout</a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                        <!-- /.col-md-3 -->

                        <!-- *** CUSTOMER MENU END *** -->
                    </div>

                    <div class="col-md-9">
                        <div class="box">
                            <h1>Endereços</h1>
                            <p class="lead">Aqui você poderá visualizar seus endereços de entrega ou adicionar um novo.</p>


                            <h3>Meus Endereços</h3>

                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <!--<label for="enderecos">Endereço X</label>-->
                                        <!--<input type="radio">-->
                                        <c:forEach items="${listaEnderecos}" var="endereco">
                                            <input type="radio" nome="endereco" id="endereco" value="${endereco.rua}"><span style="margin-right: 15px;">${endereco.rua}, ${endereco.numeroCasa}</span>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>

                            <!-- /.row -->


                            <hr>

                            <h3>Novo Endereço</h3>

                            <form action="adicionarEndereco" method="post" id="formCadastro">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="cep">CEP: </label>
                                            <input type="text" class="form-control" maxlength="9" name="cep" id="cep" onkeypress="javascript: mascara(this, cep_mask)">
                                            <input type="hidden" class="form-control" name="idCliente" value="${idCliente}">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="rua">Rua: </label>
                                            <input type="text" readonly class="form-control" name="rua" id="rua">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="bairro">Bairro: </label>
                                            <input type="text" readonly class="form-control" name="bairro" id="bairro">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="cidade">Cidade: </label>
                                            <input type="text" readonly class="form-control" name="cidade" id="cidade">
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3">
                                        <div class="form-group">
                                            <label for="uf">UF: </label>
                                            <input type="text" readonly class="form-control" maxlength="2" name="uf" id="uf">
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3">
                                        <div class="form-group">
                                            <label for="numero">Número: </label>
                                            <input type="text" class="form-control" name="numero" id="numero">
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->

                                <div class="row">

                                    <div class="col-sm-6 col-md-3">
                                        <div class="form-group">
                                            <label for="complemento">Complemento: </label>
                                            <input type="text" class="form-control" name="complemento" id="complemento">
                                        </div>
                                    </div>

                                    <div class="col-sm-12 text-center">
                                        <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar endereço</button>

                                    </div>
                                </div>


                            </form>

                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->


        <!-- *** FOOTER ***
 _________________________________________________________ -->

        <!-- *** FOOTER END *** -->




        <!-- *** COPYRIGHT ***
 _________________________________________________________ -->
        <jsp:include page="rodape.jsp"/>
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


    <script src="js/bootstrapValidator.js" type="text/javascript"></script>
    <script src="js/validar.js" type="text/javascript"></script>

</body>

</html>

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
                                    <input type="hidden" name="idCliente" value="${idCliente}">
                                    <ul class="dropdown-menu">
                                        <li>
                                            <div  class="yamm-content">
                                                <ul>
                                                    <a style="color: #555555" href="usuario">Minha conta</a>
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

        <jsp:include page="WEB-INF/jsp/cabecalho.jsp" />
        <!-- /#navbar -->

        <!-- *** NAVBAR END *** -->



        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="index.jsp">Home</a>
                            </li>
                            <li>Nova conta / Registre-se</li>
                        </ul>

                    </div>


                    <form action="cadastrado" method="post" id="formCadastro">

                        <div class="col-md-6">
                            <div class="box">
                                <h1>Nova conta</h1>

                                <p class="lead">Ainda não é um cliente registrado?</p>

                                <hr>

                                <div class="form-group">
                                    <label for="name">Nome</label>
                                    <input type="text" class="form-control" name="nome" id="name">
                                </div>
                                <div class="form-group">
                                    <label for="name">Sobrenome</label>
                                    <input type="text" class="form-control" name="sobrenome" id="sobrenome">
                                </div>
                                <div class="form-group">
                                    <label for="name">Data de Nascimento</label>
                                    <input type="date" class="form-control" name="dataNasc" id="dataNasc">
                                </div>
                                <div class="form-group">
                                    <label for="name">CPF</label>
                                    <input type="text" class="form-control" name="cpf" id="cpf" maxlength="14" type="text" onkeypress="javascript: mascara(this, cpf_mask)">
                                </div>
                                <div class="form-group">
                                    <label for="name">Telefone</label>
                                    <input type="text" class="form-control" name="telefone" maxlength="15" id="telefone">
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" name="email" id="email">
                                </div>
                                <div class="form-group">
                                    <label for="password">Senha</label>
                                    <input type="password" class="form-control" name="senha" id="password">
                                </div>
                                <div class="form-group">
                                    <label for="password">Confirme a senha</label>
                                    <input type="password" class="form-control" name="confirmarSenha" id="confirmarSenha">
                                </div>

                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="box">
                                <h1>Endereço</h1>

                                <p class="lead">Você poderá adicionar novos endereços de entrega após se registrar</p>

                                <hr>

                                <!--                                <div class="form-group">
                                                                    <label for="name">Identificação: </label>
                                                                    <select name="" class="formstyle selects" id="identificacao" tabindex="8">
                                                                        <option value="Casa">Casa</option>
                                                                        <option value="Trabalho">Trabalho</option>
                                                                        <option value="Outro">Outro</option>
                                                                    </select>
                                                                </div>-->
                                <div class="form-group">
                                    <label for="cep">CEP: </label>
                                    <input type="text" class="form-control" maxlength="9" name="cep" id="cep" onkeypress="javascript: mascara(this, cep_mask)">
                                </div>
                                <div class="form-group">
                                    <label for="rua">Rua: </label>
                                    <input type="text" readonly="true" class="form-control" name="rua" id="rua">
                                </div>
                                <div class="form-group">
                                    <label for="bairro">Bairro: </label>
                                    <input type="text" readonly="true" class="form-control" name="bairro" id="bairro">
                                </div>
                                <div class="form-group">
                                    <label for="cidade">Cidade: </label>
                                    <input type="text" readonly="true" class="form-control" name="cidade" id="cidade">
                                </div>
                                <div class="form-group">
                                    <label for="uf">UF: </label>
                                    <input type="text" readonly="true" class="form-control" maxlength="2" name="uf" id="uf">
                                </div>
                                <div class="form-group">
                                    <label for="numero">Número: </label>
                                    <input type="text" class="form-control" name="numero" id="numero">
                                </div>
                                <div class="form-group">
                                    <label for="complemento">Complemento: </label>
                                    <input type="text" class="form-control" name="complemento" id="complemento">
                                </div>

                            </div>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary"><i class="fa fa-user-md"></i> Registrar</button>
                        </div>
                        <br>
                    </form>

                </div>
                <!-- /.container -->
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

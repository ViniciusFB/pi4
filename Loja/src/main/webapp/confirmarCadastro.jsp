<%-- 
    Document   : 404
    Created on : 13/09/2017, 03:27:10
    Author     : Vinicius Ferreira Batista
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
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
            Vip e-Commerce
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
                        <li><a href="#">Início</a>
                        </li>
                        <li>Verificação</li>
                    </ul>


                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                            <div class="box" id="acn">

                                <p class="text-center">
                                    <img src="img/vip.png" alt="Obaju template">
                                </p>

                                <h3>Para comprar, você precisa de uma conta!</h3>
                                <div id="btns">
                                    <a href="#" id="btn2" data-toggle="modal" class="btn btn-primary" data-target="#login-modal"> 
                                        <i class="fa fa-sign-in"></i>
                                        Já tenho uma conta</a>
                                    <a href="registro" id="btn1" class="btn btn-primary"><img src="img/reg.png" alt=""/> Sou novo</a>
                                </div>

                            </div>
                        </div>
                    </div>


                </div>
                <!-- /.col-md-9 -->
            </div>
            <!-- /.container -->
        </div>
        <br> &nbsp;

        <!-- /#content -->


        <!-- *** FOOTER ***
 _________________________________________________________ -->

        <!-- /#footer -->

        <!-- *** FOOTER END *** -->




        <!-- *** COPYRIGHT ***
 _________________________________________________________ -->
        <jsp:include page="WEB-INF/jsp/rodape.jsp"/>
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
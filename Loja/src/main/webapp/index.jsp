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
            Vip Modas : e-commerce template
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

        <!--</div>-->

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
                        <div id="main-slider">
                            <div class="item">
                                <img src="img/imagemxx.jpg" alt="" class="img-responsive">
                            </div>
                            <div class="item">
                                <img class="img-responsive" src="img/acessorios13.png" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive" src="img/acessorios2.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive" src="img/acessorios4.jpg" alt="">
                            </div>
                        </div>
                        <!-- /#main-slider -->
                    </div>
                </div>

                <!-- *** ADVANTAGES HOMEPAGE ***
     _________________________________________________________ -->
                <div id="advantages">

                    <div class="container">
                        <div class="same-height-row">
                            <div class="col-sm-4">
                                <div class="box same-height clickable">
                                    <div class="icon"><i class="fa fa-heart"></i>
                                    </div>

                                    <h3><a href="#">Nossos clientes em primeiro lugar</a></h3>
                                    <p>Somos conhecidos por oferecer o melhor serviço</p>
                                </div>
                            </div>

                            <div class="col-sm-4">
                                <div class="box same-height clickable">
                                    <div class="icon"><i class="fa fa-tags"></i>
                                    </div>

                                    <h3><a href="#">Melhores Preços</a></h3>
                                    <p>Os melhores preços do mercado, não deixe de conferir.</p>
                                </div>
                            </div>

                            <div class="col-sm-4">
                                <div class="box same-height clickable">
                                    <div class="icon"><i class="fa fa-thumbs-up"></i>
                                    </div>

                                    <h3><a href="#">100% de Satisfação Garantida</a></h3>
                                    <p>3 meses de garantia.</p>
                                </div>
                            </div>
                        </div>
                        <!-- /.row -->

                    </div>
                    <!-- /.container -->

                </div>
                <!-- /#advantages -->

                <!-- *** ADVANTAGES END *** -->

                <!-- *** HOT PRODUCT SLIDESHOW ***
     _________________________________________________________ -->
                <div id="hot">

                    <div class="box">
                        <div class="container">
                            <div class="col-md-12">
                                <h2>Novidades</h2>
                            </div>
                        </div>
                    </div>

                    <div class="container">
                        <div class="product-slider">

                            <c:forEach items="${listaProdutos}" var="produto">

                                <div class="item">
                                    <div class="product">
                                        <div class="flip-container">
                                            <div class="flipper">
                                                <div class="front">
                                                    <a href="detail.html">
                                                        <img src="${produto.imagem}" alt="" class="img-responsive">
                                                    </a>
                                                </div>
                                                <!--                                                <div class="back">
                                                                                                    <a href="detail.html">
                                                                                                        <img src="img/product1_2.jpg" alt="" class="img-responsive">
                                                                                                    </a>
                                                                                                </div>-->
                                            </div>
                                        </div>
                                        <a href="detail.html" class="invisible">
                                            <img src="${produto.imagem}" alt="" class="img-responsive">
                                        </a>
                                        <div class="text">
                                            <h3><a href="detail.html">${produto.nome}</a></h3>
                                            <p class="price">R$ ${produto.valor}</p>
                                        </div>
                                        <!-- /.text -->
                                    </div>
                                    <!-- /.product -->
                                </div>

                            </c:forEach>


                            <!-- /.col-md-4 -->



                        </div>
                        <!-- /.product-slider -->
                    </div>
                    <!-- /.container -->

                </div>



            </div>


            <!-- *** COPYRIGHT ***
     _________________________________________________________ -->
            <div id="copyright">
                <div class="container">
                    <div class="col-md-6">
                        <p class="pull-left">© 2015 todos os direitos reservados - VipModas.</p>

                    </div>
                    <div class="col-md-6">
                        <p class="pull-right">Desenvolvimento <a href="https://vldDesign.com">vlpDesign.com</a>
                            <!-- Not removing these links is part of the license conditions of the template. Thanks for understanding :) If you want to use the template without the attribution links, you can do so after supporting further themes development at https://bootstrapious.com/donate  -->
                        </p>
                    </div>
                </div>
            </div>
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

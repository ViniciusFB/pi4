<%-- 
    Document   : index
    Created on : 05/09/2017, 02:54:09
    Author     : Vinicius Ferreira Batista
--%>

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
        <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

        <!-- your stylesheet with modifications -->
        <link href="css/custom.css" rel="stylesheet">

        <script src="js/respond.min.js"></script>

        <link rel="shortcut icon" href="favicon.png">



    </head>

    <body>

        <!-- *** TOPBAR ***
     _________________________________________________________ -->
        <div id="top">
            <div class="container">
                <div class="col-md-6 offer" data-animate="fadeInDown">
                    <a href="#" class="btn btn-success btn-sm" data-animate-hover="shake">Oferta do dia</a>  <a href="#">Na compra de R$ 1.500,00, ganhe 30% de desconto !</a>
                </div>
                <div class="col-md-6" data-animate="fadeInDown">
                    <ul class="menu">
                        <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                        </li>
<!--                        <li><a href="/Loja/Registro">Registro</a>
                        </li>-->
                        <li><a href="/Loja/Registro">Cadastro</a>
                        </li>
                        <li><a href="contact.html">Contato</a>
                        </li>
                        <li><a href="#">Visto Recentemente</a>
                        </li>
                    </ul>
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

        <div class="navbar navbar-default yamm" role="navigation" id="navbar">
            <div class="container">
                <div class="navbar-header">

                    <a class="navbar-brand home" href="index.jsp" data-animate-hover="bounce">
                        <img src="img/vip.png" alt="Obaju logo" class="hidden-xs">
                        <img src="img/logo-small.png" alt="Obaju logo" class="visible-xs"><span class="sr-only">Obaju - go to homepage</span>
                    </a>
                    <div class="navbar-buttons">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation">
                            <span class="sr-only">Toggle navigation</span>
                            <i class="fa fa-align-justify"></i>
                        </button>
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#procurar">
                            <span class="sr-only">Toggle search</span>
                            <i class="fa fa-search"></i>
                        </button>
                        <a class="btn btn-default navbar-toggle" href="basket.html">
                            <i class="fa fa-shopping-cart"></i>  <span class="hidden-xs">3 items in cart</span>
                        </a>
                    </div>
                </div>
                <!--/.navbar-header -->

                <div class="navbar-collapse collapse" id="navigation">

                    <ul class="nav navbar-nav navbar-left">
                        <li class="active"><a href="index.html">Inicio</a>
                        </li>
                        <li class="dropdown yamm-fw">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">Homem <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <div class="yamm-content">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h5>Roupas</h5>
                                                <ul>
                                                    <li><a href="category.html">Camisetas</a>
                                                    </li>
                                                    <li><a href="category.html">Camisas</a>
                                                    </li>
                                                    <li><a href="category.html">Calças</a>
                                                    </li>
                                                    <li><a href="category.html">Accessorios</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <h5>Sapatos</h5>
                                                <ul>
                                                    <li><a href="category.html">Treinadores</a>
                                                    </li>
                                                    <li><a href="category.html">Sandálias</a>
                                                    </li>
                                                    <li><a href="category.html">Tenis</a>
                                                    </li>
                                                    <li><a href="category.html">Casual</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <h5>Accessorios</h5>
                                                <ul>
                                                    <li><a href="category.html">Treinadores</a>
                                                    </li>
                                                    <li><a href="category.html">Sandálias</a>
                                                    </li>
                                                    <li><a href="category.html">Tenis</a>
                                                    </li>
                                                    <li><a href="category.html">Casual</a>
                                                    </li>
                                                    <li><a href="category.html">Tenis</a>
                                                    </li>
                                                    <li><a href="category.html">Casual</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <h5>Destaque</h5>
                                                <ul>
                                                    <li><a href="category.html">Treinadores</a>
                                                    </li>
                                                    <li><a href="category.html">Sandálias</a>
                                                    </li>
                                                    <li><a href="category.html">Tenis</a>
                                                    </li>
                                                </ul>
                                                <h5>Looks e Tendências</h5>
                                                <ul>
                                                    <li><a href="category.html">Treinadores</a>
                                                    </li>
                                                    <li><a href="category.html">Sandálias</a>
                                                    </li>
                                                    <li><a href="category.html">Tenis</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.yamm-content -->
                                </li>
                            </ul>
                        </li>

                        <li class="dropdown yamm-fw">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">Mulher <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <div class="yamm-content">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h5>Roupas</h5>
                                                <ul>
                                                    <li><a href="category.html">Camisetas</a>
                                                    </li>
                                                    <li><a href="category.html">Camisas</a>
                                                    </li>
                                                    <li><a href="category.html">Calças</a>
                                                    </li>
                                                    <li><a href="category.html">Accessorios</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <h5>Sapatos</h5>
                                                <ul>
                                                    <li><a href="category.html">Treinadores</a>
                                                    </li>
                                                    <li><a href="category.html">Sandálias</a>
                                                    </li>
                                                    <li><a href="category.html">Tênis</a>
                                                    </li>
                                                    <li><a href="category.html">Casual</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <h5>Accessorios</h5>
                                                <ul>
                                                    <li><a href="category.html">Treinadores</a>
                                                    </li>
                                                    <li><a href="category.html">Sandálias</a>
                                                    </li>
                                                    <li><a href="category.html">Tênis</a>
                                                    </li>
                                                    <li><a href="category.html">Casual</a>
                                                    </li>
                                                    <li><a href="category.html">Tênis</a>
                                                    </li>
                                                    <li><a href="category.html">Casual</a>
                                                    </li>
                                                </ul>
                                                <h5>Looks and Tendências</h5>
                                                <ul>
                                                    <li><a href="category.html">Treinadores</a>
                                                    </li>
                                                    <li><a href="category.html">Sandálias</a>
                                                    </li>
                                                    <li><a href="category.html">Tênis</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <div class="banner">
                                                    <a href="#">
                                                        <img src="img/banner.jpg" class="img img-responsive" alt="">
                                                    </a>
                                                </div>
                                                <div class="banner">
                                                    <a href="#">
                                                        <img src="img/banner2.jpg" class="img img-responsive" alt="">
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.yamm-content -->
                                </li>
                            </ul>
                        </li>

                        <li class="dropdown yamm-fw">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">Outros <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <div class="yamm-content">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h5>Shop</h5>
                                                <ul>
                                                    <li><a href="index.html">Homepage</a>
                                                    </li>
                                                    <li><a href="category.html">Category - sidebar left</a>
                                                    </li>
                                                    <li><a href="category-right.html">Category - sidebar right</a>
                                                    </li>
                                                    <li><a href="category-full.html">Category - full width</a>
                                                    </li>
                                                    <li><a href="detail.html">Product detail</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <h5>User</h5>
                                                <ul>
                                                    <li><a href="/Loja/Registro">Register / login</a>
                                                    </li>
                                                    <li><a href="customer-orders.html">Orders history</a>
                                                    </li>
                                                    <li><a href="customer-order.html">Order history detail</a>
                                                    </li>
                                                    <li><a href="customer-wishlist.html">Wishlist</a>
                                                    </li>
                                                    <li><a href="customer-account.html">Customer account / change password</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <h5>Order process</h5>
                                                <ul>
                                                    <li><a href="basket.html">Shopping cart</a>
                                                    </li>
                                                    <li><a href="checkout1.html">Checkout - step 1</a>
                                                    </li>
                                                    <li><a href="checkout2.html">Checkout - step 2</a>
                                                    </li>
                                                    <li><a href="checkout3.html">Checkout - step 3</a>
                                                    </li>
                                                    <li><a href="checkout4.html">Checkout - step 4</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <h5>Pages and blog</h5>
                                                <ul>
                                                    <li><a href="blog.html">Blog listing</a>
                                                    </li>
                                                    <li><a href="post.html">Blog Post</a>
                                                    </li>
                                                    <li><a href="faq.html">FAQ</a>
                                                    </li>
                                                    <li><a href="text.html">Text page</a>
                                                    </li>
                                                    <li><a href="text-right.html">Text page - right sidebar</a>
                                                    </li>
                                                    <li><a href="404.html">404 page</a>
                                                    </li>
                                                    <li><a href="contact.html">Contact</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.yamm-content -->
                                </li>
                            </ul>
                        </li>
                    </ul>

                </div>
                <!--/.nav-collapse -->

                <div class="navbar-buttons">

                    <div class="navbar-collapse collapse right" id="basket-overview">
                        <a href="basket.html" class="btn btn-primary navbar-btn"><i class="fa fa-shopping-cart"></i><span class="hidden-sm">3 itens no carrinho</span></a>
                    </div>
                    <!--/.nav-collapse -->

                    <div class="navbar-collapse collapse right" id="search-not-mobile">
                        <button type="button" class="btn navbar-btn btn-primary" data-toggle="collapse" data-target="#search">
                            <span class="sr-only">Toggle search</span>
                            <i class="fa fa-search"></i>
                        </button>
                    </div>

                </div>

                <div class="collapse clearfix" id="search">

                    <form class="navbar-form" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search">
                            <span class="input-group-btn">

                                <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>

                            </span>
                        </div>
                    </form>

                </div>
                <!--/.nav-collapse -->

            </div>
            <!-- /.container -->
        </div>
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
                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="img/product1.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="img/product1_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="img/product1.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Casaco de Pele</a></h3>
                                        <p class="price">R$143.00</p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="img/product2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="img/product2_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="img/product2.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Blusa Branca</a></h3>
                                        <p class="price"><del>R$280</del> R$143.00</p>
                                    </div>
                                    <!-- /.text -->

                                    <div class="ribbon sale">
                                        <div class="theribbon">Venda</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->

                                    <div class="ribbon new">
                                        <div class="theribbon">Novo</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->

                                    <div class="ribbon gift">
                                        <div class="theribbon">Presente</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="img/product3.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="img/product3_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="img/product3.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Blusa Versaze</a></h3>
                                        <p class="price">R$143.00</p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="img/product3.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="img/product3_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="img/product3.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Blusa Branca</a></h3>
                                        <p class="price">R$143.00</p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="img/product2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="img/product2_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="img/product2.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Camisola de Renda</a></h3>
                                        <p class="price">R$143.00</p>
                                    </div>
                                    <!-- /.text -->

                                    <div class="ribbon new">
                                        <div class="theribbon">Novo</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="img/product1.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="img/product1_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="img/product1.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Casaco de Pele</a></h3>
                                        <p class="price">$143.00</p>
                                    </div>
                                    <!-- /.text -->

                                    <div class="ribbon gift">
                                        <div class="theribbon">Presente</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->

                                </div>
                                <!-- /.product -->
                            </div>
                            <!-- /.col-md-4 -->

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="img/product2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="img/product2_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="img/product2.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Blusa Armani</a></h3>
                                        <p class="price"><del>R$280</del> R$135.00</p>
                                    </div>
                                    <!-- /.text -->

                                    <div class="ribbon sale">
                                        <div class="theribbon">Venda</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->

                                    <div class="ribbon new">
                                        <div class="theribbon">Novo</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->

                                    <div class="ribbon gift">
                                        <div class="theribbon">Presente</div>
                                        <div class="ribbon-background"></div>
                                    </div>
                                    <!-- /.ribbon -->
                                </div>
                                <!-- /.product -->
                            </div>

                            <div class="item">
                                <div class="product">
                                    <div class="flip-container">
                                        <div class="flipper">
                                            <div class="front">
                                                <a href="detail.html">
                                                    <img src="img/product3.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                            <div class="back">
                                                <a href="detail.html">
                                                    <img src="img/product3_2.jpg" alt="" class="img-responsive">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="detail.html" class="invisible">
                                        <img src="img/product3.jpg" alt="" class="img-responsive">
                                    </a>
                                    <div class="text">
                                        <h3><a href="detail.html">Blusa Branca</a></h3>
                                        <p class="price">R$543.00</p>
                                    </div>
                                    <!-- /.text -->
                                </div>
                                <!-- /.product -->
                            </div>

                        </div>
                        <!-- /.product-slider -->
                    </div>
                    <!-- /.container -->

                </div>
                <!-- /#hot -->

                <!-- *** HOT END *** -->

                <!-- *** GET INSPIRED ***
     _________________________________________________________ -->
                <div class="container" data-animate="fadeInUpBig">
                    <div class="col-md-12">
                        <div class="box slideshow">
                            <h3>Inspire-se</h3>
                            <div id="get-inspired" class="owl-carousel owl-theme">
                                <div class="item">
                                    <a href="#">
                                        <img src="img/getinspired1.jpg" alt="Get inspired" class="img-responsive">
                                    </a>
                                </div>
                                <div class="item">
                                    <a href="#">
                                        <img src="img/getinspired2.jpg" alt="Get inspired" class="img-responsive">
                                    </a>
                                </div>
                                <div class="item">
                                    <a href="#">
                                        <img src="img/getinspired3.jpg" alt="Get inspired" class="img-responsive">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- *** GET INSPIRED END *** -->

                <!-- *** BLOG HOMEPAGE ***
     _________________________________________________________ -->
                <!-- /.container -->

                <!-- *** BLOG HOMEPAGE END *** -->


            </div>
            <!-- /#content -->

            <!-- *** FOOTER ***
     _________________________________________________________ -->
            <div id="footer" data-animate="fadeInUp">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <h4>Páginas</h4>

                            <ul>
                                <li><a href="text.html">Sobre Nós</a>
                                </li>
                                <li><a href="text.html">Termos e Condições</a>
                                </li>
                                <li><a href="faq.html">Perguntas Frequentes</a>
                                </li>
                                <li><a href="contact.html">Contato</a>
                                </li>
                            </ul>

                            <hr>

                            <h4>Sessão do Usuário</h4>

                            <ul>
                                <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                                </li>
                                <li><a href="register.html">Registro</a>
                                </li>
                            </ul>

                            <hr class="hidden-md hidden-lg hidden-sm">

                        </div>
                        <!-- /.col-md-3 -->

                        <div class="col-md-3 col-sm-6">

                            <h4>Principais Categorias</h4>

                            <h5>Homem</h5>

                            <ul>
                                <li><a href="category.html">Camisas</a>
                                </li>
                                <li><a href="category.html">Camisetas</a>
                                </li>
                                <li><a href="category.html">Accessórios</a>
                                </li>
                            </ul>

                            <h5>Mulher</h5>
                            <ul>
                                <li><a href="category.html">Camisas</a>
                                </li>
                                <li><a href="category.html">Camisetas</a>
                                </li>
                                <li><a href="category.html">Sapatos</a>
                                </li>
                                <li><a href="category.html">Accessorios</a>
                                </li>
                            </ul>

                            <hr class="hidden-md hidden-lg">

                        </div>
                        <!-- /.col-md-3 -->

                        <div class="col-md-3 col-sm-6">

                            <h4>Onde nos encontrar</h4>

                            <p><strong>Vip Modas.</strong>
                                <br>Rua dos Sentenários, 25
                                <br>São Paulo
                                <br>SP
                                <br>
                                <strong>Brasil</strong>
                            </p>

                            <a href="contact.html">Ir para página de Contato</a>

                            <hr class="hidden-md hidden-lg">

                        </div>
                        <!-- /.col-md-3 -->



                        <div class="col-md-3 col-sm-6">

                            <h4>Manter Contato</h4>

                            <p class="social">
                                <a href="#" class="facebook external" data-animate-hover="shake"><i class="fa fa-facebook"></i></a>
                                <a href="#" class="twitter external" data-animate-hover="shake"><i class="fa fa-twitter"></i></a>
                                <a href="#" class="instagram external" data-animate-hover="shake"><i class="fa fa-instagram"></i></a>
                                <a href="#" class="gplus external" data-animate-hover="shake"><i class="fa fa-google-plus"></i></a>
                                <a href="#" class="email external" data-animate-hover="shake"><i class="fa fa-envelope"></i></a>
                            </p>

                        </div>
                        <!-- /.col-md-3 -->

                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.container -->
            </div>
            <!-- /#footer -->

            <!-- *** FOOTER END *** -->




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

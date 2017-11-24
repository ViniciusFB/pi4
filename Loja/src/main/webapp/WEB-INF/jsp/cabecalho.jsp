<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- *** TOPBAR ***
_________________________________________________________ -->
<div id="top" style="z-index: 10; position: relative;">
    <div class="container">
        <div class="col-md-6 offer" data-animate="fadeInDown">

        </div>
        <div class="col-md-6" data-animate="fadeInDown">
            <ul class="menu">

                <input type="hidden" name="urlPage" value="${urlPage}">
                <c:choose>
                    <c:when test="${not empty sessionScope.usuario}">
                        <li class="dropdown yamm-fw">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">
                                <span style="margin-right: 5px; color: white;" class="glyphicon glyphicon-user"></span>
                                <c:out value="${sessionScope.usuario}"/><b style="margin-left: 5px" class="caret"></b></a>
                            <input type="hidden" name="idCliente" value="${idCliente}">
                            <input type="hidden" name="idEndereco" value="${idEndereco}">
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

                    </c:when>
                    <c:otherwise>
                        <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                        </li>
                        <li><a href="registro.jsp">Cadastro</a>
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
                <h4 class="modal-title" id="Login">Login</h4>
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
                <p class="text-center text-muted"><a href="registro.jsp"><strong>Registre-se Agora</strong></a>! É fácil e rápido, menos de um minuto!</p>

            </div>
        </div>
    </div>
</div>

<!--</div>-->

<!-- *** TOP BAR END *** -->


<!-- *** NAVBAR ***
    _________________________________________________________ -->

<div class="navbar navbar-default yamm" role="navigation" id="navbar">
    <div class="container">
        <div class="navbar-header">

            <a class="navbar-brand home" href="index" data-animate-hover="bounce">
                <img src="img/vip.png" alt="logo" class="hidden-xs">
                <img src="img/vip.png" alt="logo" class="visible-xs img-responsive"><span class="sr-only">VIP - Vá para a página inicial</span>
            </a>
            <div class="navbar-buttons">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation">
                    <span class="sr-only">Toggle Navegação</span>
                    <i class="fa fa-align-justify"></i>
                </button>
                <a class="btn btn-default navbar-toggle" id="btnCarrinho" href="carrinho">
                    <i class="fa fa-shopping-cart"></i>  <span class="hidden-xs">${numItens} itens no carrinho</span>
                </a>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#search">
                    <span class="sr-only">Toggle Buscar</span>
                    <i class="fa fa-search"></i>
                </button>
            </div>
        </div>
        <!--/.navbar-header -->

        <div class="navbar-collapse collapse" id="navigation">

            <ul class="nav navbar-nav navbar-left">
                <li class="active"><a href="index">Inicio</a>
                </li>
                <li class="dropdown yamm-fw">
                    <a href="produtos?numeroPagina=1" class="dropdown-toggle" data-hover="dropdown" data-delay="200">Produtos</a>

                </li>
                <li class="dropdown yamm-fw">
                    <a href="contato.jsp" class="dropdown-toggle" data-hover="dropdown" data-delay="200">Contato</a>

                </li>
            </ul>

        </div>
        <!--/.nav-collapse -->

        <div class="navbar-buttons">

            <div class="navbar-collapse collapse right" id="basket-overview">
                <a href="carrinho" class="btn btn-primary navbar-btn"><i class="fa fa-shopping-cart"></i><span class="hidden-sm">${numItens} itens no carrinho</span></a>
            </div>
            <!--/.nav-collapse -->
            <form class="navbar-form" role="search" action="pesquisar" method="post" id="formBusca">
                <div class="navbar-collapse collapse right" id="search-not-mobile">
                    <div class="input-group">
                        <input type="text" name="nomeProduto"  style="width: 235px" class="form-control navbar-btn" placeholder="Pesquise um produto...">
                        <span class="input-group-btn">

                            <button type="submit" name="acao" value="pesquisarProduto" class="btn btn-primary navbar-btn"><i class="fa fa-search"></i></button>

                        </span>
                    </div>
                </div>
            </form>
            <div class="collapse clearfix" id="search">

                <form class="navbar-form" role="search" action="produtos" method="post">
                    <div class="input-group">
                        <input type="text" name="nomeProduto" class="form-control" placeholder="Pesquise um produto...">
                        <span class="input-group-btn">

                            <button type="submit" name="acao" value="pesquisarProduto" class="btn btn-primary"><i class="fa fa-search"></i></button>

                        </span>
                    </div>
                </form>

            </div>

        </div>
        <!--/.nav-collapse -->

    </div>
    <!-- /.container -->
</div>

<!-- /#navbar -->

<!-- *** NAVBAR END *** -->

<%@page import="br.senac.tads.pi4.models.CarrinhoDeCompra"%>
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

    <jsp:include page="WEB-INF/jsp/cabecalho.jsp" />

    <div id="all">

        <div id="content">
            <div class="container">

                <div class="col-md-12">
                    <ul class="breadcrumb">
                        <li><a href="index">Início</a>
                        </li>
                        <li>Carrinho de Compras</li>
                    </ul>
                </div>

                <div class="col-md-9" id="basket">

                    <div class="box">

                        <!--<form method="post" action="confirmarCadastro.jsp">-->

                        <h1>Carrinho de Compras</h1>
                        <p class="text-muted">Você possui atualmente <span>${numItens}</span> itens no seu carrrinho</p>
                        <div class="table-responsive">
                            <form method="post" action="carrinho">

                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th colspan="2">Produto</th>
                                            <th colspan="2">Quantidade</th>
                                            <th>Preço Unitário</th>
                                            <!--<th>Desconto</th>-->
                                            <th colspan="2">Total</th>
                                        </tr>
                                    </thead>


                                    <c:forEach items="${carrinho.itens}" var="item">
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <a href="detalhes?c=${item.codigo}">
                                                        <img src="${item.imagem}" alt="White Blouse Armani">
                                                    </a>
                                                </td>
                                                <td><a href="detalhes?c=${item.codigo}">${item.nome}</a>
                                                </td>
                                                <td id="iQtd" style="width: 5px">
                                                    <input type="hidden" id="qtd" value="${item.quantidade}" min="1" max="${item.quantidadeEstoque}" style="width: 70px" name="quantidade" class="form-control qtd">
                                                    ${item.quantidade}
                                                </td>
                                                <td>
                                                    <a id="btnAdd" href="carrinho?acao=addProduto&idProduto=${item.id}"><i class="fa fa-plus"></i></a>
                                                    <a id="btnRem" href="carrinho?acao=delUnidade&idProduto=${item.id}"><i class="fa fa-minus"></i></a>
                                                </td>
                                                <td>R$ ${item.valor}</td> <input type="hidden" name="valorUni" id="valorUni" class="valorUni" value="${item.valor}">

                                        <td class="vTotal" id="vTotal">R$ ${item.total}</td> <input type="hidden" name="valorTotal" id="valorTotal">
                                        <td><a href="carrinho?acao=removeProduto&idProduto=${item.id}" id="refreshA" onclick="return onclickFunction(${item.id})"><i class="fa fa-trash-o"></i></a>
                                            <!--<td><button type="submit" name="acao" id="addEnd" value="removeProduto"><i class="fa fa-trash-o"></i></button>-->
                                        </td>
                                        </tr>
                                        </tbody>

                                    </c:forEach>
                                    <tfoot>
                                        <tr>
                                            <th colspan="5">Total</th>
                                            <th colspan="2">R$446.00</th>
                                        </tr>
                                    </tfoot>
                                </table>            
                            </form>


                        </div>
                        <!-- /.table-responsive -->

                        <div class="box-footer">
                            <div class="pull-left">
                                <a href="category.html" class="btn btn-default"><i class="fa fa-chevron-left"></i> Continuar comprando</a>
                            </div>
                            <div class="pull-right">
                                <!--<button class="btn btn-default"><i class="fa fa-refresh"></i> Atualizar carrinho</button>-->

                                <c:choose>
                                    <c:when test="${not empty sessionScope.usuario}">
                                        <!--                                            <a href="checkout1.html" class="btn btn-primary">Finalizar Compra <i class="fa fa-chevron-right"></i>
                                                                                    </a>-->
                                        <form method="post" action="checkout1.html">
                                            <button type="submit" class="btn btn-primary">Finalizar Compra <i class="fa fa-chevron-right"></i>
                                            </button>
                                        </form>
                                    </c:when>
                                    <c:otherwise>
                                        <!--                                            <a href="confirmarCadastro.jsp" class="btn btn-primary">Finalizar Compra <i class="fa fa-chevron-right"></i>
                                                                                    </a>-->
                                        <form method="post" action="confirmarCadastro.jsp">

                                            <button type="submit" class="btn btn-primary">Finalizar Compra <i class="fa fa-chevron-right"></i>
                                            </button>
                                        </form>
                                    </c:otherwise>
                                </c:choose>


                            </div>
                        </div>

                        <!--</form>-->

                    </div>
                    <!-- /.box -->


                    <div class="row same-height-row">
                        <div class="col-md-3 col-sm-6">
                            <div class="box same-height">
                                <h3>Você também pode gostar desses produtos</h3>
                            </div>
                        </div>

                        <div class="col-md-3 col-sm-6">
                            <div class="product same-height">
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
                                    <h3>Fur coat</h3>
                                    <p class="price">$143</p>
                                </div>
                            </div>
                            <!-- /.product -->
                        </div>

                        <div class="col-md-3 col-sm-6">
                            <div class="product same-height">
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
                                    <h3>Fur coat</h3>
                                    <p class="price">$143</p>
                                </div>
                            </div>
                            <!-- /.product -->
                        </div>


                        <div class="col-md-3 col-sm-6">
                            <div class="product same-height">
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
                                    <h3>Fur coat</h3>
                                    <p class="price">$143</p>

                                </div>
                            </div>
                            <!-- /.product -->
                        </div>

                    </div>


                </div>
                <!-- /.col-md-9 -->

                <div class="col-md-3">
                    <div class="box" id="order-summary">
                        <div class="box-header">
                            <h3>Order summary</h3>
                        </div>
                        <p class="text-muted">Shipping and additional costs are calculated based on the values you have entered.</p>

                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td>Order subtotal</td>
                                        <th>$446.00</th>
                                    </tr>
                                    <tr>
                                        <td>Shipping and handling</td>
                                        <th>$10.00</th>
                                    </tr>
                                    <tr>
                                        <td>Tax</td>
                                        <th>$0.00</th>
                                    </tr>
                                    <tr class="total">
                                        <td>Total</td>
                                        <th>$456.00</th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>


                    <div class="box">
                        <div class="box-header">
                            <h4>Coupon code</h4>
                        </div>
                        <p class="text-muted">If you have a coupon code, please enter it in the box below.</p>
                        <form>
                            <div class="input-group">

                                <input type="text" class="form-control">

                                <span class="input-group-btn">

                                    <button class="btn btn-primary" type="button"><i class="fa fa-gift"></i></button>

                                </span>
                            </div>
                            <!-- /input-group -->
                        </form>
                    </div>

                </div>
                <!-- /.col-md-3 -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

        <jsp:include page="WEB-INF/jsp/rodape.jsp" />


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

    <!--    <script>
            function maxLengthCheck(object) {
                if (object.value.length > object.maxLength)
                    object.value = object.value.slice(0, object.maxLength)
            }
    
     
    
        </script>-->

    <script>
                                            $("[type='number']").keypress(function (evt) {
                                                evt.preventDefault();
                                            });

                                            $(document).ready(function () {
                                                var qtd = $("#qtd");
                                                var btnAdd = $("#btnAdd");
                                                var btnRem = $("#btnRem");

                                                if (qtd.val() == qtd.attr("max")) {
                                                    btnAdd.css("display", "none")
                                                }
                                                if (qtd.val() == qtd.attr("min")) {
                                                    btnRem.css("display", "none")
                                                }

                                            })


//s


    </script>

</body>

</html>
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

        <!-- theme stylesheet -->
        <link href="css/style.blue.css" rel="stylesheet" id="theme-stylesheet">

        <!-- your stylesheet with modifications -->
        <link href="css/custom.css" rel="stylesheet">

        <script src="js/respond.min.js"></script>
        <link rel="shortcut icon" href="favicon.png">



    </head>


    <body>

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

                    <div class="col-md-9">

                        <div class="box">

                            <!--<form method="post" action="confirmarCadastro.jsp">-->
                            <input type="hidden" class="form-control" name="idUsuario" value="${idUsuario}">
                            <h1>Carrinho de Compras</h1>
                            <c:choose>
                                <c:when test="${not empty carrinho.itens}">
                                    <span style="color: red"> ${erro} </span>
                                    <p class="text-muted">Você possui atualmente <span>${numItens}</span> itens no seu carrrinho</p>
                                    <div>
                                        <form method="post" action="carrinho" accept-charset="iso-8859-1,utf-8">
                                            <div class="row">
                                                <!--<div class="col-xs-0 col-md-1">-->
                                                <!--</div>-->
                                                <div class="col-xs-4 col-md-6">
                                                    <label> <strong>Produto </strong></label>
                                                </div>
                                                <div class="col-xs-2 col-md-2">
                                                    <label> <strong>Qtde</strong> </label>
                                                </div>
                                                <div class="col-xs-2 col-md-2">
                                                    <label><strong> Valor Uni.</strong> </label>
                                                </div>
                                                <div class="col-xs-2 col-md-2">
                                                    <label><strong> Total</strong></label>
                                                </div>
                                                <div class="col-xs-2 col-md-0">
                                                </div>


                                            </div>
                                            <hr style="margin-top: 5px; margin-bottom: 4px; border: 0;
                                                border-top: 1px solid #eeeeee;">
                                            <c:forEach items="${carrinho.itens}" var="item">

                                                <div class="row">
                                                    <div class="col-xs-2 col-md-1">
                                                        <a href="detalhes?c=${item.codigo}">
                                                            <img src="${item.imagem}" height="50" width="50" alt="Imagem Produto">
                                                        </a>
                                                    </div>
                                                    <div class="col-xs-2 col-md-5">
                                                        <br>
                                                        <a href="detalhes?c=${item.codigo}">${item.nome}</a>
                                                    </div>
                                                    <div class="col-xs-2 col-md-2">
                                                        <br>
                                                        <a class="btnRem" href="carrinho?acao=delUnidade&idProduto=${item.id}"><i class="fa fa-minus"></i></a>
                                                        ${item.quantidade}
                                                        <input type="hidden" id="qtd" value="${item.quantidade}" min="1" max="${item.quantidadeEstoque}" style="width: 70px" name="quantidade" class="qtd form-control">
                                                        <a class="btnAdd" href="carrinho?acao=addProduto&idProduto=${item.id}"><i class="fa fa-plus"></i></a>
                                                    </div>
                                                    <div class="col-xs-2 col-md-2">
                                                        <br>
                                                        ${item.valor}
                                                        <input type="hidden" name="valorUni" id="valorUni" class="valorUni" value="${item.valor}">
                                                        <input type="hidden" name="idProduto" value="${item.id}">
                                                    </div>
                                                    <div class="col-xs-2 col-md-1">
                                                        <br>
                                                        ${item.total}
                                                        <input type="hidden" name="valorTotal" id="valorTotal">
                                                    </div>
                                                    <div class="col-xs-2 col-md-1">
                                                        <br>
                                                        <a href="carrinho?acao=removeProduto&idProduto=${item.id}" id="refreshA" onclick="return onclickFunction(${item.id})"><i class="fa fa-trash-o"></i></a>
                                                    </div>

                                                </div>
                                                <hr style="margin-top: 5px; margin-bottom: 4px; border: 0;
                                                    border-top: 1px solid #eeeeee;">
                                            </c:forEach>
                                            <div class="row">
                                                <div class="col-xs-9 col-md-10">
                                                    <p><strong> Total </strong></p>
                                                </div>
                                                <div class="col-xs-3 col-md-2">
                                                    <p><strong> R$${valorTotal} </strong></p>
                                                </div>

                                            </div>
                                        </form>


                                    </div>
                                    <!-- /.table-responsive -->
                                    <input type="hidden" name="valorFinal" value="${valorTotal}">
                                </c:when>
                                <c:otherwise>
                                    <p class="text-large"> Seu carrinho está vazio!</p>
                                </c:otherwise>
                            </c:choose>

                            <div class="box-footer">
                                <div class="pull-left">
                                    <a href="produtos?numeroPagina=1" class="btn btn-default"><i class="fa fa-chevron-left"></i> Continuar comprando</a>
                                </div>
                                <div class="pull-right">
                                    <!--<button class="btn btn-default"><i class="fa fa-refresh"></i> Atualizar carrinho</button>-->

                                    <c:choose>
                                        <c:when test="${not empty sessionScope.usuario}">

                                            <c:choose>
                                                <c:when test="${not empty carrinho.itens}">
                                                    <form method="post" action="checkout1" accept-charset="iso-8859-1,utf-8">
                                                        <button type="submit" class="btn btn-primary">Finalizar Compra <i class="fa fa-chevron-right"></i>
                                                        </button>
                                                    </form>
                                                </c:when>
                                                <c:otherwise>
                                                    <!--Carrinho Vazio. Botão de finalizar a compra não é mostrado-->
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <form method="post" action="confirmarCadastro.jsp" accept-charset="iso-8859-1,utf-8">

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

                    </div>
                    <!-- /.col-md-9 -->

                    <div class="col-md-3">
                        <div class="box" id="order-summary">
                            <div class="box-header">
                                <h3>Resumo do Pedido</h3>
                            </div>

                            <div class="table-responsive">
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <td>Subtotal do pedido </td>
                                            <th>R$${valorTotal}</th>
                                        </tr>
                                        <tr>
                                            <td>Desconto total</td>
                                            <th>R$ 0.00</th>
                                        </tr>
                                        <tr>
                                            <td>Frete</td>
                                            <th>R$ 0.00</th>
                                        </tr>

                                        <tr class="total">
                                            <td>Total</td>
                                            <th>R$${valorTotal}</th>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>

                    </div>
                    <!-- /.col-md-3 -->

                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->
            <br><br> &nbsp;
            <br><br> &nbsp; 
            <br><br> &nbsp; 
            <br><br> &nbsp; 
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
                                                                var qtd = $(".qtd");
                                                                var btnAdd = $(".btnAdd");
                                                                var btnRem = $(".btnRem");

                                                                if (qtd.val() == qtd.attr("max")) {
                                                                    btnAdd.css("display", "none")
                                                                }
                                                                if (qtd.val() == qtd.attr("min")) {
                                                                    btnRem.css("display", "none")
                                                                }

                                                            })




        </script>

    </body>

</html>
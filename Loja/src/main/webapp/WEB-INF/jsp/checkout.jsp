<%-- 
    Document   : checkout
    Created on : 18/09/2017, 07:54:01
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

        <!-- theme stylesheet -->
        <link href="css/style.blue.css" rel="stylesheet" id="theme-stylesheet">

        <!-- your stylesheet with modifications -->
        <link href="css/custom.css" rel="stylesheet">

        <script src="js/respond.min.js"></script>



        <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="js/consultaCep.js" type="text/javascript"></script>


        <link rel="shortcut icon" href="favicon.png">

    </head>

    <body>

        <jsp:include page="cabecalho.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">
                        <ul class="breadcrumb">
                            <li><a href="#">Home</a>
                            </li>
                            <li>Checkout - Endereço</li>
                        </ul>
                    </div>

                    <div class="col-md-9" id="checkout">

                        <div class="box">
                            <form method="post" class="preencherDados" id="preencherDados" action="checkout01">
                                <h1>Checkout</h1>
                                <ul class="nav nav-pills nav-justified">
                                    <li class="active"><a href="#"><i class="fa fa-map-marker"></i><br>Endereço</a>
                                    </li>
                                    <li class="disabled"><a href="#"><i class="fa fa-truck"></i><br>Forma de entrega</a>
                                    </li>
                                    <li class="disabled"><a href="#"><i class="fa fa-money"></i><br>Forma de pagamento</a>
                                    </li>
                                    <li class="disabled"><a href="#"><i class="fa fa-eye"></i><br>Revisão do pedido</a>
                                    </li>
                                </ul>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <input type="hidden" class="idCliente" id="idCliente" name="idCliente" value="${idCliente}">
                                            <c:forEach items="${listaEnderecos}" var="endereco">
                                                <input type="radio" name="endSelecionado" id="endereco" class="enderecos" value="${endereco.cep}" onClick="this.form.submit()"><span style="margin-right: 15px;">${endereco.rua}, ${endereco.numeroCasa}</span></a>
                                            </c:forEach>

                                        </div>
                                    </div>
                                </div>
                            </form>


                            <div class="content">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="cep">CEP: </label>
                                            <input type="text" class="form-control" maxlength="9" name="cep" id="cep" value="${cep}" onkeypress="javascript: mascara(this, cep_mask)">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="rua">Rua: </label>
                                            <input type="text" readonly class="form-control" value="${rua}" name="rua" id="rua">
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="bairro">Bairro: </label>
                                            <input type="text" readonly class="form-control" value="${bairro}" name="bairro" id="bairro">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="cidade">Cidade: </label>
                                            <input type="text" readonly class="form-control" name="cidade" value="${cidade}" id="cidade">
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->

                                <div class="row">
                                    <div class="col-sm-6 col-md-3">
                                        <div class="form-group">
                                            <label for="uf">UF: </label>
                                            <input type="text" readonly class="form-control" maxlength="2" value="${uf}" name="uf" id="uf">
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3">
                                        <div class="form-group">
                                            <label for="numero">Número: </label>
                                            <input type="text" class="form-control" value="${numero}" name="numero" id="numero">
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3">
                                        <div class="form-group">
                                            <label for="complemento">Complemento: </label>
                                            <input type="text" class="form-control" value="${complemento}" name="complemento" id="complemento">
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3"> &nbsp;
                                        <div class="form-group">
                                            <br><input type="checkbox" class="form-check-input" name="novoEndereco" checked value="checked"><span style="color: #069;"> Salvar esse endereço</span>
                                            <!--<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar endereço</button>-->
                                        </div>
                                    </div>


                                </div>
                                <!-- /.row -->
                            </div>

                            <div class="box-footer">
                                <div class="pull-left">
                                    <a href="basket.html" class="btn btn-default"><i class="fa fa-chevron-left"></i>Continuar comprando</a>
                                </div>
                                <div class="pull-right">
                                    <button type="submit" class="btn btn-primary">Seguir para formas de entrega<i class="fa fa-chevron-right"></i>
                                    </button>
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
                                            <th>R$ 446.00</th>
                                        </tr>
                                        <tr>
                                            <td>Desconto total</td>
                                            <th>R$ 0.00</th>
                                        </tr>

                                        <tr class="total">
                                            <td>Total</td>
                                            <th>R$456.00</th>
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

            <jsp:include page="rodape.jsp" />

        </div>

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

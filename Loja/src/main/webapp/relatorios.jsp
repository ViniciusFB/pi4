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

    <body>

        <jsp:include page="WEB-INF/jsp/cabecalho.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

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
                                    <li>
                                        <a href="cadastroProduto.jsp"><i class="fa fa-plus"></i> Cadastrar Produto</a>
                                    </li>
                                    <li>
                                        <a href="cadastrarFuncionario.jsp"><i class="fa fa-user"></i> Cadastrar Funcionário</a>
                                    </li>
                                    <li>
                                        <a href="pedidosBackoffice"><i class="fa fa-shopping-cart"></i> Pedidos de Clientes</a>
                                    </li>
                                    <li>
                                        <a href="mensagens"><i class="fa fa-envelope"></i> Mensagens de Clientes</a>
                                    </li>
                                    <li class="active">
                                        <a href="relatorios"><i class="fa fa-book"></i> Relatórios</a>
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

                    <div class="col-md-9" id="basket">
                        <div class="box">

                            <h1> Relatórios </h1>
                            <hr>

                            <div class="row">
                                <select name="tipo" class="form-control">
                                    <option value="" disabled selected>Selecione um tipo de relatório...</option>
                                    <option value="vendas">Vendas</option>
                                    <option value="estoque">Produtos</option>
                                </select>

                            </div>
                            <br><hr>

                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th colspan="2">Produto</th>
                                            <th>Codigo</th>
                                            <th>Quantidade</th>
                                            <th>Status</th>
                                            <th>Ação</th>
                                        </tr>
                                    </thead>

                                    <c:forEach items="${listaProdutos}" var="produto">
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <a href="detalhes?c=${produto.codigo}">
                                                        <img src="${produto.imagem}" alt="Imagem Produto">
                                                    </a>
                                                </td>
                                                <td><a href="detalhes?c=${produto.codigo}">${produto.nome}</a></td>
                                                <td>${produto.codigo}</td>
                                                <td>${produto.quantidade}</td>
                                                <c:choose>
                                                    <c:when test="${produto.statusProduto == 1}">
                                                        <td><span class="label label-warning">Acabando</span>
                                                        </td>
                                                    </c:when>
                                                    <c:when test="${produto.statusProduto == 2}">
                                                        <td><span class="label label-danger">Esgotado</span>
                                                        </td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td><span class="label label-success">Disponível</span>
                                                        </td>
                                                    </c:otherwise>

                                                </c:choose>
                                                <td><a href="?codigo=${produto.codigo}" class="btn btn-primary btn-sm">Editar</a>
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
            <%--<jsp:include page="WEB-INF/jsp/rodape.jsp" />--%>

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

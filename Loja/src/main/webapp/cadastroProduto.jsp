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
        <script src="js/consultaCep.js" type="text/javascript"></script>
        <script src="js/readURL.js" type="text/javascript"></script>
        <script src="js/mostrarImagem.js" type="text/javascript"></script>
    </head>

    <body>

        <jsp:include page="WEB-INF/jsp/cabecalho.jsp" />

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="index">Inicio</a>
                            </li>
                            <li>Cadastrar Novo Produto</li>
                        </ul>

                    </div>


                    <form action="CadastrarProduto" method="post" id="formCadastro">

                        <div class="col-md-6">
                            <div class="box">
                                <h1>Novo Produto</h1>

                                <p class="lead">Insira um novo produto no estoque</p>
                                <span style="font-weight: bold">${mensagem}</span>

                                <hr>

                                <div class="form-group">
                                    <label for="name">Nome</label>
                                    <input type="text" class="form-control" name="nome" id="name" placeholder="Informe o nome do produto">
                                </div>
                                <div class="form-group">
                                    <label for="codigo">Código</label>
                                    <input type="text" class="form-control" name="codigo" placeholder="Informe o codigo do produto">
                                </div>
                                <div class="form-group">
                                    <label for="quantidade">Quantidade</label>
                                    <input type="number" class="form-control" name="quantidade" placeholder="Informe a quantidade do produto">
                                </div>
                                <div class="form-group">
                                    <label for="valor">Valor</label>
                                    <input type="text" class="form-control" name="valor" type="text" placeholder="Informe o valor do produto">
                                </div>
                                <div class="form-group">
                                    <label for="categorias"> Categoria</label>
                                    <select name="categorias" class="form-control">
                                        <option value="" disabled selected>Selecione uma categoria...</option>
                                        <option value="Bolsa">Bolsa</option>
                                        <option value="Mochila">Mochila</option>
                                        <option value="Oculos">Oculos</option>
                                        <option value="Relogio">Relogio</option>
                                        <option value="Bone">Bone</option>
                                        <option value="Touca">Touca</option>
                                        <option value="Pulseira">Pulseira</option>
                                        <option value="Colar">Colar</option>
                                        <option value="Brinco">Brinco</option>
                                        <option value="Cinto">Cinto</option>
                                        <option value="Carteira">Carteira</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="name">Descrição</label>
                                    <textarea name="descricao" class="form-control" rows="4" maxlength="255"></textarea>
                                </div>

                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="box">
                                <h1>Imagem</h1>

                                <p class="lead">Adicione imagens para o produto</p>

                                <hr>

                                <div class="form-group">
                                    <label for="imagem">Imagem: </label>
                                    <input type="url" name="imglink" id="imglink" class="form-control" placeholder="Coloque a URL da imagem aqui" />
                                    <section id="imagem" class="imagemm"></section>

                                </div>


                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-user-md"></i> Registrar</button>
                                </div>
                            </div>

                        </div>

                        <br>
                    </form>


                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->

            <!-- *** FOOTER ***
     _________________________________________________________ -->
            <jsp:include page="WEB-INF/jsp/rodape.jsp" />

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

            <!--<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>-->
            <script src="js/bootstrapValidator.js" type="text/javascript"></script>
            <script src="js/validar.js" type="text/javascript"></script>


    </body>
</html>

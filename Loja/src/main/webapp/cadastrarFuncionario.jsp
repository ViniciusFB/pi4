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


    </head>

    <body>

        <jsp:include page="WEB-INF/jsp/cabecalho.jsp" />

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


                    <form action="cadastrarFuncionario" method="post" id="formCadastro">

                        <div class="col-md-6">
                            <div class="box">
                                <h1>Nova conta</h1>

                                <p class="lead">Ainda não é um funcionário registrado?</p>

                                <hr>
                                <!--                                <div class="form-group">
                                                                    <input type="radio" name="tipo" id="tipo" value="fisica"><label for="tipo"> &nbsp;
                                                                        Pessoa Física</label>
                                                                    &nbsp;
                                                                    &nbsp;
                                                                    <input type="radio" name="tipo" id="tipo" value="juridica"><label for="tipo">&nbsp; Pessoa Jurídica</label>
                                                                </div>-->
                                <div class="form-group">
                                    <label for="name">Nome</label>
                                    <input type="text" class="form-control" name="nome" id="name" placeholder="Digite seu primeiro nome">
                                </div>
                                <div class="form-group">
                                    <label for="name">Sobrenome</label>
                                    <input type="text" class="form-control" name="sobrenome" id="sobrenome" placeholder="Digite seu sobrenome">
                                </div>
                                <div class="form-group">
                                    <label for="name">Data de Nascimento</label>
                                    <input type="date" class="form-control" name="dataNasc" id="dataNasc">
                                </div>
                                <div class="form-group">
                                    <!--<label for="name">CPF/CNPJ</label>-->
                                    <label for="name">CPF</label>
                                    <input type="text" class="form-control" name="cpf" id="cpf" maxlength="14" type="text" onkeypress="javascript: mascara(this, cpf_mask)" placeholder="000.000.000-00">
                                </div>
                                <div class="form-group">
                                    <label for="name">Telefone</label>
                                    <input type="text" class="form-control" name="telefone" maxlength="15" id="telefone" placeholder="(00) 00000-0000">
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" name="email" id="email" placeholder="exemplo@email.com">
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
                                <h1>Permissões</h1>

                                <p class="lead">As permissões são definidas pelo cargo do funcionário. </p>

                                <hr>

                                <div class="form-group">
                                    <label for="cep">Cargo: </label>
                                    <select name="nivel" id="cargo" class="form-control">
                                        <option value="" disabled selected>Selecione um cargo...</option>
                                        <option value="1">Gerente</option>
                                        <option value="2">Estoquista</option>
                                        <option value="3">Administrador</option>
                                    </select>
                                    <br>
                                    <div id="gerente" style="display: none;">
                                        <label> Permissões </label>
                                        <ul>
                                            <li> Ver Relatórios </li>
                                            <li> Enviar Relatórios </li>
                                            <li> Atualizar Status dos Pedidos </li>
                                        </ul>
                                    </div>
                                    <div id="estoquista" style="display: none;">
                                        <label> Permissões </label>
                                        <ul>
                                            <li> Ver Relatórios de Produtos </li>
                                            <li> Cadastrar Produtos no Estoque </li>
                                            <li> Remover Produtos do Estoque </li>
                                            <li> Atualizar Produtos do Estoque </li>
                                        </ul>
                                    </div>
                                    <div id="administrador" style="display: none;">
                                        <label> Permissões </label>
                                        <ul>
                                            <li> Cadastrar Novos Funcionários </li>
                                            <li> Gerenciamento de Funcionários </li>
                                            <li> Atribuir Permissões </li>
                                            <li> Ver Relatórios </li>
                                            <li> Enviar Relatórios </li>
                                            <li> Atualizar Status dos Pedidos </li>
                                            <li> Cadastrar Produtos no Estoque </li>
                                            <li> Remover Produtos do Estoque </li>
                                            <li> Atualizar Produtos do Estoque </li>
                                        </ul>
                                    </div>
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

        <!--<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>-->
        <script src="js/bootstrapValidator.js" type="text/javascript"></script>
        <script src="js/validar.js" type="text/javascript"></script>
        <script src="//oss.maxcdn.com/momentjs/2.8.2/moment.min.js"></script>

        <script>

                                        $(document).ready(function () {

                                            $("#cargo").on('change', function () {
                                                var cargo = $(this).val();
                                                if (cargo === 'gerente') {
                                                    $("#gerente").css('display', '');
                                                    $("#estoquista").css('display', 'none');
                                                    $("#administrador").css('display', 'none');

                                                } else if (cargo === 'estoquista') {
                                                    $("#gerente").css('display', 'none');
                                                    $("#estoquista").css('display', '');
                                                    $("#administrador").css('display', 'none');
                                                } else if (cargo === 'administrador') {
                                                    $("#gerente").css('display', 'none');
                                                    $("#estoquista").css('display', 'none');
                                                    $("#administrador").css('display', '');
                                                }
                                            })


                                        })

        </script>

    </body>
</html>

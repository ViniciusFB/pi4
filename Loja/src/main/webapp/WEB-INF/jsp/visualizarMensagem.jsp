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

        <style>
            #mensagem { 
                border-style: none; 
                border-color: Transparent; 
                overflow: auto;        
                background-color:white;
                resize: vertical;
                cursor: default;
            }
            /*            textarea.expandable {
                            height:40px;
                            -webkit-transition: all 0.5s ease-in-out;
                        }
            
                        textarea.expandable:hover, textarea.expandable:focus {
                            height:calc(100% - 100px);      
                            -webkit-transition: all 0.8s ease-in-out;
                        }
            
                        .panel-300:hover, .panel-300 {
                            height:300px;    
                        }
            
                        textarea.expandable + textarea.expandable:hover, textarea.expandable + textarea.expandable:focus {
                            height:calc(100% - 90px)	
                        }*/
        </style>

    </head>

    <body>

        <jsp:include page="cabecalho.jsp" />

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
                                <h3 class="panel-title">Sessão do Usuário</h3>
                            </div>

                            <div class="panel-body">

                                <ul class="nav nav-pills nav-stacked">
                                    <li>
                                        <a href=""><i class="fa fa-user"></i> Minha conta</a>
                                    </li>
                                    <li>
                                        <a href=""><i class="fa fa-home"></i> Pedidos de Clientes</a>
                                    </li>
                                    <li class="active">
                                        <a href="mensagens"><i class="fa fa-shopping-cart"></i> Mensagens de Clientes</a>
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

                    <!--<div class="col-md-9" id="customer-orders">-->
                    <div class="col-md-9" id="basket">
                        <div class="box">
                            <h1>Mensagem</h1>

                            <hr>

                            <form action="visualizarMensagem" method="post" id="formResposta">
                                <div class="col-md-12">

                                    <div class="row">

                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="nome">Nome:</label>
                                                <input type="text" class="form-control" readonly value="${nome}">
                                                <!--<span class="form-control"> ${nome} </span>-->
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="email">Email:</label>
                                                <input class="form-control" type="text" readonly value="${email}">
                                                <!--<span class="form-control"> ${email} </span>-->
                                            </div>
                                        </div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="motivo">Motivo: </label>
                                                <input class="form-control" type="text" readonly value="${motivo}">
                                                <!--<span class="form-control"> ${motivo} </span>-->
                                            </div>
                                        </div>
                                        <br><hr>
                                        <label> Mensagem: </label>
                                        <textarea id="mensagem" class="form-control" name="mensagem" readonly rows="5" maxlength="4000">${mensagem}</textarea>
                                        <hr>

                                        <div class="panel-body panel-300" id="resposta" style="display: none;">
                                            <input type="hidden" name="protocolo" value="${protocolo}">
                                            <br>
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <div class="form-group">
                                                        <label for="nome">Nome</label>
                                                        <input type="text" class="form-control" id="nome" name="nome" required>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <div class="form-group">
                                                        <label for="email">Email</label>
                                                        <input type="email" class="form-control" id="email" name="email" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <label> Resposta: </label>
                                            <textarea id="mensagem2" class="form-control expandable" name="resposta" rows="4" maxlength="4000" required></textarea>
                                            <!--<span style="font-size: 9px"> Máximo de 4000 caracteres </span>-->
                                            <br>
                                            <!--<input type="submit" id="btnEnviar" value="Responder" class="btn-success pull-right" style="display: none;">-->
                                        </div>
                                    </div>
                                    <br>


                                </div>


                                <a href="mensagens" class="btn btn-default"><i class="fa fa-chevron-left"></i> Voltar</a>
                                <a id="btnResponder" class=" btn btn-primary pull-right"> Responder </a>
                                <input type="submit" id="btnEnviar" value="Responder" class="btn-success pull-right" style="display: none;">
                            </form>

                        </div>
                    </div>

                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->

            <!-- *** COPYRIGHT ***
     _________________________________________________________ -->
            <jsp:include page="rodape.jsp" />

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

        <script>

            $(document).ready(function () {

                $("#btnResponder").click(function () {
                    $("#resposta").css("display", "");
                    $(this).css("display", "none");
                    $("#btnEnviar").css("display", "");
                })

                //                $("#btnEnviar").click(function () {
                //                    var form = $("#formResposta");
                //                    form.submit();
                //
                //                })

            })

        </script>

    </body>
</html>

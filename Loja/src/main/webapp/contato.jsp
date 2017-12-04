<%-- 
    Document   : Contato
    Created on : 21/11/2017, 23:13:07
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
    <jsp:include page="WEB-INF/jsp/cabecalho.jsp" />

    <div id="all">

        <div id="content">
            <div class="container">

                <input name="sucesso" id="sucesso" type="hidden" value="${sucesso}">
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Aviso</h4>
                            </div>
                            <div class="modal-body">
                                <p id="mensagem"><strong>${msg}</strong></p>
                                <p><strong>Protocolo: ${protocolo}</strong></p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-12">
                    <ul class="breadcrumb">
                        <li><a href="index">Início</a>
                        </li>
                        <li>Contato</li>
                    </ul>

                </div>

                <div class="col-md-3">
                    <!-- *** PAGES MENU ***
 _________________________________________________________ -->
                    <div class="panel panel-default sidebar-menu">

                        <div class="panel-heading">
                            <h3 class="panel-title">Páginas</h3>
                        </div>

                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li>
                                    <a href="index">Início</a>
                                </li>
                                <li>
                                    <a href="produtos?numeroPagina=1">Produtos</a>
                                </li>
                                <li class="active">
                                    <a href="contato.jsp">Contato</a>
                                </li>

                            </ul>

                        </div>
                    </div>

                    <!-- *** PAGES MENU END *** -->
                </div>

                <div class="col-md-9">


                    <div class="box" id="contact">
                        <h1>Contato</h1>

                        <p class="lead">Você tem dúvidas ou sugestões? Você tem algum tipo de problema com nossos produtos?</p>
                        <p>Sinta-se livre para falar conosco.</p>

                        <hr>
                        <h2>Formulário de Contato</h2>

                        <form action="contato" method="post" accept-charset="iso-8859-1,utf-8">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label for="nome">Nome</label>
                                        <input type="text" class="form-control" id="nome" name="nome">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label for="sobrenome">Sobrenome</label>
                                        <input type="text" class="form-control" id="sobrenome" name="sobrenome">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="text" class="form-control" id="email" name="email">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label for="motivo">Principal motivo da mensagem</label>
                                        <select name="motivo" class="form-control">
                                            <option value="" disabled selected>Selecione uma opção</option>
                                            <option value="duvida">Dúvida</option>
                                            <option value="sugestao">Sugestão</option>
                                            <option value="reclamacao">Reclamação</option>
                                            <option value="critica">Crítica</option>
                                            <option value="elogio">Elogio</option>
                                            <option value="outros">Outros</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label for="mensagem">Mensagem</label>
                                        <textarea id="mensagem" class="form-control" name="mensagem" rows="4" maxlength="4000"></textarea>
                                    </div>
                                </div>

                                <div class="col-sm-12 text-center">
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-envelope-o"></i> Enviar mensagem</button>

                                </div>
                            </div>
                            <!-- /.row -->
                        </form>


                        <hr>
                        <div class="row">
                            <div class="col-sm-4">
                                <h3><i class="fa fa-map-marker"></i> Endereço</h3>
                                <p> Av. Eng. Eusébio Stevaux, 823
                                    <br>Santo Amaro
                                    <br>São Paulo - SP
                                    <br>04696-000
                                </p>
                            </div>
                            <!-- /.col-sm-4 -->
                            <div class="col-sm-4">
                                <h3><i class="fa fa-phone"></i> Central de Atendimento</h3>
                                <p class="text-muted"> Use o número abaixo para comunicação. Se estiver fora de São Paulo, recomendamos nosso Suporte Eletrônico. </p>
                                <p><strong>(11) 5682-7300</strong>
                                </p>
                            </div>
                            <!-- /.col-sm-4 -->
                            <div class="col-sm-4">
                                <h3><i class="fa fa-envelope"></i> Suporte Eletrônico</h3>
                                <p class="text-muted">Por favor, sinta-se livre para nos escrever um e-mail.</p>
                                <ul>
                                    <li><strong><a href="mailto:">dvl@email.com</a></strong>
                                    </li>
                                </ul>
                            </div>
                            <!-- /.col-sm-4 -->

                        </div>
                        <!-- /.row -->


                    </div>


                </div>
                <!-- /.col-md-9 -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

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
    <script type="text/javascript">
        $(window).on('load', function () {
            var verify = $("#sucesso").val();
            if (verify === '') {

            } else {
                $('#myModal').modal('show');
            }


        });
    </script>

</body>
</html>

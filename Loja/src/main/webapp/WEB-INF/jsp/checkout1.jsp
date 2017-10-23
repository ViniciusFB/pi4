<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box">
    <form method="post" class="preencherDados" id="preencherDados" action="checkout01">
        <h1>Checkout</h1>
        <ul class="nav nav-pills nav-justified">
            <li class="active"><a href="#"><i class="fa fa-map-marker"></i><br>Endere�o</a>
            </li>
            <li class="disabled"><a href="#"><i class="fa fa-truck"></i><br>Forma de entrega</a>
            </li>
            <li class="disabled"><a href="#"><i class="fa fa-money"></i><br>Forma de pagamento</a>
            </li>
            <li class="disabled"><a href="#"><i class="fa fa-eye"></i><br>Revis�o do pedido</a>
            </li>
        </ul>
        <div class="row">
            <div class="col-sm-12">
                <div class="form-group">
                    <input type="hidden" class="idCliente" id="idCliente" name="idCliente" value="${idCliente}">
                    <c:forEach items="${listaEnderecos}" var="endereco">
                        <input type="radio" name="endSelecionado" id="endereco" class="enderecos" value="${endereco.cep}"><span style="margin-right: 15px;">${endereco.rua}, ${endereco.numeroCasa}</span></a>
                    </c:forEach>

                </div>
            </div>
        </div>
    </form>



    <form action="checkout2" method="post">
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
                        <label for="numero">N�mero: </label>
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
                        <br><input type="checkbox" class="form-check-input" name="novoEndereco" checked value="checked"><span style="color: #069;"> Salvar esse endere�o</span>
                        <!--<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar endere�o</button>-->
                    </div>
                </div>


            </div>
            <!-- /.row -->
        </div>

        <div class="box-footer">
            <div class="pull-left">
                <a href="carrinho" class="btn btn-default"><i class="fa fa-chevron-left"></i>Voltar</a>
            </div>
            <div class="pull-right">
                <button type="submit" class="btn btnProx btn-primary">Seguir para formas de entrega<i class="fa fa-chevron-right"></i>
                </button>
            </div>
        </div>
    </form>
    <!--</form>-->
</div>
<!-- /.box -->
<script src="js/checkout.js"></script>
<script>
                            $(document).ready(function () {

                                $(".enderecos").click(function () {
//                                                            var cepEnd = $(this).attr("value");
                                    var form = $(this).closest("form");
                                    $.ajax({
                                        type: "POST",
                                        url: "checkout01",
                                        data: form.serialize(),
                                        success: function (data)
                                        {
                                            $("#checkout").html(data);
                                        }
                                    });

                                    return false;
                                });

                            });
</script>
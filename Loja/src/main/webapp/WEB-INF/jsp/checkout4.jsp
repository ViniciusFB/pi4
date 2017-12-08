<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="hidden" class="etapa" value="4">

<div class="container">

    <div class="col-md-12">
        <ul class="breadcrumb">
            <li><a href="index">Início</a>
            </li>
            <li><a href="carrinho">Carrinho</a></li>
            <li>Checkout</li>
        </ul>
    </div>

    <div class="col-md-9" id="checkout">

        <div class="box">
            <form method="post" accept-charset="iso-8859-1,utf-8" id="formFinaliza" action="finalizarCompra">
                <h1>Checkout</h1>
                <ul class="nav nav-pills nav-justified">
                    <li><a href="checkout1"><i class="fa fa-map-marker"></i><br>Endereço</a>
                    </li>
                    <li><a href="checkout2"><i class="fa fa-truck"></i><br>Forma de entrega</a>
                    </li>
                    <li><a href="checkout3" class="btnVoltar"><i class="fa fa-money"></i><br>Forma de pagamento</a>
                    </li>
                    <li class="active"><a href="#"><i class="fa fa-eye"></i><br>Revisão do pedido</a>
                    </li>
                </ul>

                <div class="content">
                    <div>
                        <div class="row">
                            <div class="col-xs-0 col-md-1">
                            </div>
                            <div class="col-xs-6 col-md-5">
                                <label> <strong>Produto </strong></label>
                            </div>
                            <div class="col-xs-2 col-md-2">
                                <label> <strong>Qtde</strong> </label>
                            </div>
                            <div class="col-xs-2 col-md-2">
                                <label><strong> Valor Uni.</strong> </label>
                            </div>
                            <div class="col-xs-2 col-md-2">
                                <label><strong> Valor Total</strong></label>
                            </div>


                        </div>

                        <hr style="margin-top: 5px; margin-bottom: 4px; border: 0;
                            border-top: 1px solid #eeeeee;">

                        <c:forEach items="${carrinho.itens}" var="item">
                            <div class="row">
                                <div class="col-xs-3 col-md-1">
                                    <a href="detalhes?c=${item.codigo}">
                                        <img src="${item.imagem}" height="50" width="50" alt="Imagem Produto">
                                    </a>
                                </div>
                                <div class="col-xs-3 col-md-5">
                                    <br>
                                    <a href="detalhes?c=${item.codigo}">${item.nome}</a>
                                </div>
                                <div class="col-xs-2 col-md-2">
                                    <br>
                                    ${item.quantidade}
                                </div>
                                <div class="col-xs-2 col-md-2">
                                    <br>
                                    R$${item.valor}
                                </div>
                                <div class="col-xs-2 col-md-2">
                                    <br>
                                    R$${item.total}
                                </div>

                            </div>
                            <hr style="margin-top: 5px; margin-bottom: 4px; border: 0;
                                border-top: 1px solid #eeeeee;">

                        </c:forEach>

                        <div class="row">
                            <div class="col-xs-9 col-md-10">
                                <p><strong> Valor da Compra </strong></p>
                            </div>
                            <div class="col-xs-3 col-md-2">
                                <p><strong> R$${valorTotal}</strong></p>
                            </div>
                        </div>
                        <hr style="margin-top: 5px; margin-bottom: 4px; border: 0;
                            border-top: 1px solid #eeeeee;">
                        <div class="row">
                            <div class="col-xs-9 col-md-10">
                                <p><strong> Frete </strong></p>
                            </div>
                            <div class="col-xs-3 col-md-2">
                                <p><strong> R$${frete}</strong></p>
                            </div>
                        </div>
                        <hr style="margin-top: 5px; margin-bottom: 4px; border: 0;
                            border-top: 1px solid #eeeeee;">
                        <div class="row">
                            <div class="col-xs-9 col-md-10">
                                <p><strong> Total </strong></p>
                            </div>
                            <div class="col-xs-3 col-md-2">
                                <p><strong> R$${valorTotalFrete}</strong></p>
                            </div>
                        </div>
                        <!--                        <hr style="margin-top: 5px; margin-bottom: 4px; border: 0;
                                                    border-top: 1px solid #eeeeee;">-->
                        <div class="row">
                            <div class="col-sm-6" style="background-color: hsl(0, 0%, 95%)">
                                <h4>Pagamento: Cartão de Crédito</h4>
                                <strong><span>Número de Parcelas: </span></strong>
                                <span id="parcelas2"></span><br>
                                <span id="parcelas" style="display: none"></span>
                                <strong>Número do Cartão: </strong><span id="ccNumero"></span>
                            </div>
                            <div class="col-sm-6" style="background-color: hsl(0, 0%, 95%)">
                                <h4>Endereço de Entrega</h4>
                                <span id="rua"></span>, <span id="numero"></span>
                                <br>
                                <span> Entrega em ${diasUteis} dias úteis</span>
                            </div>
                        </div>

                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.content -->

                <div class="box-footer">
                    <div class="pull-left">
                        <a href="checkout3" class="btn btnVoltar btn-default"><i class="fa fa-chevron-left"></i>Voltar para formas de pagamento</a>
                    </div>
                    <div class="pull-right">
                        <button type="submit" id="finalizar" class="btn btn-primary">Finalizar Compra<i class="fa fa-chevron-right"></i>
                        </button>
                    </div>
                </div>
                <input type="hidden" id="numeroCartao" name="numeroCartao">
                <input type="hidden" id="numeroParcelas" name="numeroParcelas">
            </form>
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
                            <th>R$ ${frete}</th>
                        </tr>

                        <tr class="total">
                            <td>Total</td>
                            <th>R$${valorTotalFrete}</th>
                        </tr>
                    </tbody>
                </table>
            </div>

        </div>

    </div>
    <!-- /.col-md-3 -->

</div>
<!-- /.container -->

<script src="js/checkout.js"></script>
<script>
    $(document).ready(function () {
        var rua = $("#rua");
        rua.text(sessionStorage.getItem("rua"));
        var numero = $("#numero");
        numero.text(sessionStorage.getItem("numero"));
        var parcelas = $("#parcelas");
        var parcelas2 = $("#parcelas2");
        parcelas.text(sessionStorage.getItem("parcelas"));
        parcelas2.text(sessionStorage.getItem("parcelasValor"));
        var ccNumero = $("#ccNumero");
        ccNumero.text(sessionStorage.getItem("ccNumero"));

        $("#numeroCartao").attr("value", ccNumero.text());
        $("#numeroParcelas").attr("value", parcelas.text());

        var btn = $("#finalizar");
        btn.click(function () {
            sessionStorage.clear();

        })

    }) // Form on submit executa função que remove os atributos da sessionStorage do JavaScript
</script>

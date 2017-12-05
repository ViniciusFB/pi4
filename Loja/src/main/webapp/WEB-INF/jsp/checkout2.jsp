<!--<div id="content" class="contentc">-->
<input type="hidden" class="etapa" value="2">
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
            <!--<form method="post" action="checkout3">-->
            <h1>Checkout</h1>
            <ul class="nav nav-pills nav-justified">
                <li><a href="checkout1"><i class="fa fa-map-marker"></i><br>Endereço</a>
                </li>
                <li class="active"><a href="#"><i class="fa fa-truck"></i><br>Forma de entrega</a>
                </li>
                <li class="disabled"><a href="#"><i class="fa fa-money"></i><br>Forma de pagamento</a>
                </li>
                <li class="disabled"><a href="#"><i class="fa fa-eye"></i><br>Revisão do pedido</a>
                </li>
            </ul>

            <form action="Frete" id="formFrete" accept-charset="iso-8859-1,utf-8" method="post">
                <div class="content">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="box shipping-method">

                                <h4 style="text-align: center">SEDEX</h4>

                                <!--<p>Get it right on next day - fastest option possible.</p>-->

                                <div class="box-footer text-center">

                                    <input type="radio" id="sedex" class="entrega" name="entrega" value="1">
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="box shipping-method">

                                <h4 style="text-align: center">SEDEX 10</h4>

                                <!--<p>Get it right on next day - fastest option possible.</p>-->

                                <div class="box-footer text-center">

                                    <input type="radio" id="sedex10" class="entrega" name="entrega" value="2">
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-4">
                            <div class="box shipping-method">

                                <h4 style="text-align: center">PAC</h4>

                                <!--<p>Get it right on next day - fastest option possible.</p>-->

                                <div class="box-footer text-center">

                                    <input type="radio" id="pac" name="entrega" class="entrega" value="3">
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="cepOrigem" value="22041080">
                        <input type="hidden" name="cepDestino" value="${cepDestino}">
<!--                        <div class="col-sm-4">
#e6e6e6
                        </div>-->
                        <div class="col-sm-12">
                            <div id="inform" class="box shipping-method" style="display: none; text-align: center;
                                 background-color: #F7F7F7">

                                <h4> Valor: R$${valorFrete} </h4>
                                <h4> Prazo: ${diasUteis} dias úteis</h4>
                            </div>
                        </div>

                        <!--<input id="calcFrete" style="margin-left: 20px" type="submit" value="Calcular Frete">-->
                        <input type="hidden" id="sel" value="">
                    </div>
                    <!-- /.row -->

                </div>
            </form>

            <!-- /.content -->

            <div class="box-footer">
                <div class="pull-left">
                    <a href="checkout1" class="btn btn-default"><i class="fa fa-chevron-left"></i>Voltar para endereços</a>
                </div>
                <div class="pull-right">
                    <button type="submit" class="btn btnProx btn-primary" disabled id="btnNext">Seguir para formas de pagamento<i class="fa fa-chevron-right"></i>
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
<!--</div>-->
<script src="js/checkout.js"></script>
<script>
    $(document).ready(function () {
        var selected = sessionStorage.getItem("frete");
        $(".entrega").click(function () {
            var selecionado = $('input[class=entrega]:checked', '#formFrete').val();
            sessionStorage.setItem("frete", selecionado);
        })
        if (selected === '1') {
            $("#sedex").prop("checked", true);
        } else if (selected === '2') {
            $("#sedex10").prop("checked", true);
        } else if (selected === '3') {
            $("#pac").prop("checked", true);
//            $("#inform").css("display", "");
//            $("#btnNext").removeAttr("disabled");
        }
    })
</script>
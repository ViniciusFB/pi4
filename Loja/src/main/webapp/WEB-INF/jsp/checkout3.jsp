<!--<div id="content" class="contentc">-->
<input type="hidden" class="etapa" value="3">
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
            <form method="post" action="checkout4">
                <h1>Checkout</h1>
                <ul class="nav nav-pills nav-justified">
                    <li><a href="checkout1"><i class="fa fa-map-marker"></i><br>Endereço</a>
                    </li>
                    <li><a href="checkout2" class="btnVoltar"><i class="fa fa-truck"></i><br>Forma de entrega</a>
                    </li>
                    <li class="active"><a href="#"><i class="fa fa-money"></i><br>Forma de pagamento</a>
                    </li>
                    <li class="disabled"><a href="#"><i class="fa fa-eye"></i><br>Revisão do pedido</a>
                    </li>
                </ul>

                <div class="content">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="box payment-method">

                                <h4>Paypal</h4>

                                <p>We like it all.</p>

                                <div class="box-footer text-center">

                                    <input type="radio" name="payment" value="payment1">
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="box payment-method">

                                <h4>Payment gateway</h4>

                                <p>VISA and Mastercard only.</p>

                                <div class="box-footer text-center">

                                    <input type="radio" name="payment" value="payment2">
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="box payment-method">

                                <h4>Cash on delivery</h4>

                                <p>You pay when you get it.</p>

                                <div class="box-footer text-center">

                                    <input type="radio" name="payment" value="payment3">
                                </div>
                            </div>
                        </div>
                        <!--<input type="text" name="frete" value="${frete}">-->
                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.content -->

                <div class="box-footer">
                    <div class="pull-left">
                        <a href="checkout2" class="btn btnVoltar btn-default"><i class="fa fa-chevron-left"></i>Voltar para formas de entrega</a>
                    </div>
                    <div class="pull-right">
                        <button type="submit" class="btn btnProx btn-primary">Seguir para revisão do pedido<i class="fa fa-chevron-right"></i>
                        </button>
                    </div>
                </div>
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

<script src="js/checkout.js"></script>

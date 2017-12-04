<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="hidden" class="etapa" value="4">

<div class="container">

    <div class="col-md-12">
        <ul class="breadcrumb">
            <li><a href="index">In�cio</a>
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
                    <li><a href="checkout1"><i class="fa fa-map-marker"></i><br>Endere�o</a>
                    </li>
                    <li><a href="checkout2"><i class="fa fa-truck"></i><br>Forma de entrega</a>
                    </li>
                    <li><a href="checkout3" class="btnVoltar"><i class="fa fa-money"></i><br>Forma de pagamento</a>
                    </li>
                    <li class="active"><a href="#"><i class="fa fa-eye"></i><br>Revis�o do pedido</a>
                    </li>
                </ul>

                <div class="content">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th colspan="2">Produto</th>
                                    <th>Qtde</th>
                                    <th>Pre�o Unit�rio</th>
                                    <th>Total</th>
                                </tr>
                            </thead>

                            <c:forEach items="${carrinho.itens}" var="item">
                                <tbody>
                                    <tr>
                                        <td>
                                            <a href="detalhes?c=${item.codigo}">
                                                <img src="${item.imagem}" alt="Imagem Produto">
                                            </a>
                                        </td>
                                        <td><a href="detalhes?c=${item.codigo}">${item.nome}</a>
                                        </td>
                                        <td id="iQtd" style="width: 5px">
                                            <input type="hidden" id="qtd" value="${item.quantidade}" min="1" max="${item.quantidadeEstoque}" style="width: 70px" name="quantidade" class="qtd form-control">
                                            ${item.quantidade}
                                        </td>
                                        <td>R$ ${item.valor}</td> 
                                        <td class="vTotal" id="vTotal">R$ ${item.total}</td>
                                </tbody>

                            </c:forEach>

                            <tfoot>
                                <tr>
                                    <th colspan="4">Valor da Compra</th>
                                    <th colspan="2">R$ ${valorTotal}</th>
                                </tr>
                                <tr>
                                    <th colspan="4">Frete</th>
                                    <th colspan="2">R$ ${frete}</th>
                                </tr>
                                <tr>
                                    <th colspan="4">Total</th>
                                    <th colspan="2">R$ ${frete+valorTotal}</th>
                                </tr>
                            </tfoot>
                        </table>
                        <strong><span>Endere�o de Entrega: </span></strong>
                        <span id="rua"></span>, <span id="numero"></span>
                        <br>
                        <strong><span>N�mero de Parcelas: </span></strong>
                        <span id="parcelas"></span><br>
                        <strong>N�mero do Cart�o: </strong><span id="ccNumero"></span>
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
                            <th>R$${valorTotal + frete}</th>
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
        parcelas.text(sessionStorage.getItem("parcelas"));
        var ccNumero = $("#ccNumero");
        ccNumero.text(sessionStorage.getItem("ccNumero"));

        $("#numeroCartao").attr("value", ccNumero.text());
        $("#numeroParcelas").attr("value", parcelas.text());

        var btn = $("#finalizar");
        btn.click(function () {
            sessionStorage.clear();

        })

    }) // Form on submit executa fun��o que remove os atributos da sessionStorage do JavaScript
</script>

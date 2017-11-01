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
            <form method="post" action="finalizarCompra">
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
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th colspan="2">Produto</th>
                                    <th>Quantidade</th>
                                    <th>Preço Unitário</th>
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
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.content -->

                <div class="box-footer">
                    <div class="pull-left">
                        <a href="checkout3" class="btn btnVoltar btn-default"><i class="fa fa-chevron-left"></i>Voltar para formas de pagamento</a>
                    </div>
                    <div class="pull-right">
                        <button type="submit" class="btn btn-primary">Finalizar Compra<i class="fa fa-chevron-right"></i>
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

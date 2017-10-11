<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--Controladores de Paginacao-->
<input type="hidden" id="quantidadePagina" name="quantidadePagina" value="${quantidadePagina}">
<input type="hidden" id="numPagina" name="numeroPagina" value="${numeroPagina}">
<!--Fim Controladores de Paginacao-->

<div style="background-color: #c4e3f3; font-weight: bold; width: 100%; margin-bottom: 35px; text-align: center">${mensagem}</div>

<div class="box info-bar" id="infos">
    <div class="row">
        <div class="col-sm-12 col-md-4 products-showing">
            Mostrando <strong>${qtdProdutos}</strong> de <strong>${totalProdutos}</strong> produtos
        </div>

        <div class="col-sm-12 col-md-8  products-number-sort">
            <div class="row">
                <form class="form-inline">
                    <div class="col-md-6 col-sm-6">
                        <div class="products-number">
                            <strong>Mostrar</strong>  <a href="#" class="btn btn-default btn-sm btn-primary">12</a>  <a href="#" class="btn btn-default btn-sm">24</a>  <a href="#" class="btn btn-default btn-sm">Todos</a>
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-6">
                        <div class="products-sort-by">
                            <strong>Filtrar por</strong>
                            <select name="sort-by" class="form-control">
                                <option>Preço</option>
                                <option>Nome</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="row products">
    <c:forEach items="${listaProd}" var="produto">
        <div class="col-md-4 col-sm-6">
            <div class="product">
                <div class="flip-container">
                    <div class="flipper">
                        <div class="front">
                            <a href="detalhes?c=${produto.codigo}">
                                <img src="${produto.imagem}" alt="" class="img-responsive">
                            </a>
                        </div>
                        <div class="back">
                            <a href="detalhes?c=${produto.codigo}">
                                <img src="${produto.imagem}" alt="" class="img-responsive">
                            </a>
                        </div>
                    </div>
                </div>
                <a href="detalhes?c=${produto.codigo}" class="invisible">
                    <img src="${produto.imagem}" alt="" class="img-responsive">
                </a>
                <div class="text">
                    <h3><a href="detalhes?c=${produto.codigo}">${produto.nome}</a></h3>
                    <p class="price">R$ ${produto.valor}</p>
                    <p class="buttons">
                        <a href="detalhes?c=${produto.codigo}" class="btn btn-default">Ver detalhes</a>
                        <input type="hidden" name="idProduto" class="idProd" value="${produto.id}">
                        <a type="#" value="${produto.id}" class="addCarrinho btn btn-primary"><i class="fa fa-shopping-cart"><span style="display: none">${produto.nome}</span></i> Adicionar ao carrinho</a> 
                    </p>
                </div>
                <!-- /.text -->
            </div>
            <!-- /.product -->

        </div>
    </c:forEach>
</div>

<div class="alert alert-success" id="mensagem" style="display: none; position: fixed; bottom: 0; left: 0; z-index: 2; color: black; background-color: rgba(98, 203, 55, 0.6);">

</div>
<div class="pages">

    <!--Lista de paginas-->
    <ul class="pagination">
        <!--paginas (numeração)-->
        ${laquo}
        <c:forEach begin="1" end="${quantidadePagina}" varStatus="status">
            <li class="nPagina"><a href=produtos?numeroPagina=${status.count}&category=${category}> ${status.count}</a></li>
            </c:forEach> 
            ${raquo}
        <!--Fim paginas (numeração)-->


    </ul>
    <!--Fim lista de paginas-->
</div>

<script src="js/addCarrinho.js"></script>

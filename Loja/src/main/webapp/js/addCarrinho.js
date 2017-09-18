$(document).ready(function () {

    $(".addCarrinho").click(function (id) {
        id = $(this).attr("value");

        var url = "carrinho?acao=addProduto&idProduto=" + id;

        $.ajax({
            type: "POST",
            url: url,
            data: $(".addCarrinho").serialize(),
            success: function ()
            {
                alert("Produto adicionado ao carrinho");
            }
        });

        return false;
    });

});
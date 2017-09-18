$(document).ready(function () {

    $(".addCarinho").click(function (id) {
        id = $(this).attr("value");

        var url = "carrinho?acao=addProduto&idProduto=" + id;

        $.ajax({
            type: "POST",
            url: url,
            data: $(".addCarinho").serialize(),
            success: function ()
            {
                alert("Produto adicionado ao carrinho");
            }
        });

        return false;
    });

});
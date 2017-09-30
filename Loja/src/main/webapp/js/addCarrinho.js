$(document).ready(function () {

    $(".addCarrinho").click(function (id) {
        id = $(this).attr("value");
        var mensagem = $("#mensagem");
        var nome = $("span", this).text();
        mensagem.text(nome+" adicionado ao carrinho com sucesso!");

        var url = "carrinho?acao=addProduto&idProduto=" + id;

        $.ajax({
            type: "POST",
            url: url,
            data: $(".addCarrinho").serialize(),
            success: function ()
            {
                mensagem.fadeIn(500).fadeOut(8000);
            }
        });

        return false;
    });

});
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
            success: function (response)
            {
//                mensagem.fadeIn(500).fadeOut(8000);
            $("#myModal").modal({backdrop: true});
            $("#carrin1").html($(response).find("#carrin1"));
            $("#carrin2").html($(response).find("#carrin2"));
            }
        });

        return false;
    });

});
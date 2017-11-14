$(document).ready(function () {

    $(".btnProx").click(function () {
        var etapa = $(".etapa").attr("value");
        var form = $(this).closest("form");
        if (etapa === '1') {
            var url = "checkout2";
        }
        if (etapa === '2') {
            var url = "checkout3";
        }
        if (etapa === '3') {
            var url = "checkout4";
        }

        $.ajax({
            type: "POST",
            url: url,
            data: form.serialize(),
            success: function (data)
            {
                $(".contentc").html(data);
            }
        });

        return false;
    });
    $(".btnVoltar").click(function () {
        var etapa = $(".etapa").attr("value");
        var form = $(this).closest("form");
//        if (etapa === '2') {
//            var url = "checkout1";
//        }
        if (etapa === '3') {
            var url = "checkout2";
        }
        if (etapa === '4') {
            var url = "checkout3";
        }

        $.ajax({
            type: "POST",
            url: url,
            data: form.serialize(),
            success: function (data)
            {
                $(".contentc").html(data);
            }
        });

        return false;
    });
    $("ul > a").click(function () {
        var href = $(this).attr("href");
        var form = $(this).closest("form");
        if (href === "checkout2") {
            var url = "checkout2";
        }
        if (href === "checkout3") {
            var url = "checkout3";
        }

        $.ajax({
            type: "POST",
            url: url,
            data: form.serialize(),
            success: function (data)
            {
                $(".contentc").html(data);
            }
        });

        if (href === "checkout1") {
            return true;
        }
        return false;
    });
    $(".entrega").click(function () {
        var form = $(this).closest("form");
        var selecionado = $('input[class=entrega]:checked', '#formFrete').val();

        $.ajax({
            type: "POST",
            url: "Frete",
            data: form.serialize(),
            success: function (data)
            {
                $(".contentc").html(data);
                $("#inform").css("display", "");
                var sel = $("#sel").val();
                sel = selecionado;

                if (sel === '1') {
//                    alert("Sedex selecionado");
                    $("#sedex").prop("checked", true);
                } else if (selecionado === '2') {
//                    alert("Sedex10 selecionado");
                    $("#sedex10").prop("checked", true);
                } else if (selecionado === '3') {
//                    alert("Pac selecionado");
                    $("#pac").prop("checked", true);
                }

            }
        });

        return false;
    });
});
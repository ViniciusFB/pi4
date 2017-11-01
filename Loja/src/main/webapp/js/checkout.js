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
    $("#calcFrete").click(function () {
        var form = $(this).closest("form");
        $.ajax({
            type: "POST",
            url: "Frete",
            data: form.serialize(),
            success: function (data)
            {
                $(".contentc").html(data);
                $("h5").css("display", "");

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
});
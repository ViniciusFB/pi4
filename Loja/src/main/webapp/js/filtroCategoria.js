$(document).ready(function () {

    $(".categorias").click(function () {
        var form = $(this).closest("form");
        var categoria = $(this).text();
        $("#category").attr("value", categoria);

        $.ajax({
            type: "POST",
            url: "filtrar",
            data: $(form).serialize(),
            success: function (data)
            {
                $("#produtos1").html(data);
            }
        });

        return false;
    });

});
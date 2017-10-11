$(document).ready(function () {

    $(".categorias").click(function () {
        var form = $(this).closest("form");
        var categoria = $(this).text();
        $("#category").attr("value", categoria);

        $.ajax({
            type: "POST",
            url: "produtos",
            data: form.serialize(),
            success: function (data)
            {
                $("#principal").html(data);
            }
        });

        return false;
    });

});
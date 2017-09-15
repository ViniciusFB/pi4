$(document).ready(function () {



    $("#imglink").on('input', function () {
        document.getElementById('imagem').innerHTML = '<img width="350" height="350" src="' + document.getElementById('imglink').value + '" alt="Image" />';
    });
});


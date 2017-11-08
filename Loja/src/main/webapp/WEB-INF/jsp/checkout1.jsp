<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label for="cep">CEP: </label>
                <input type="text" class="form-control" maxlength="9" name="cep" id="cep" value="${cep}" onkeypress="javascript: mascara(this, cep_mask)">
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="rua">Rua: </label>
                <input type="text" readonly class="form-control" value="${rua}" name="rua" id="rua">
            </div>
        </div>
    </div>
    <!-- /.row -->

    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label for="bairro">Bairro: </label>
                <input type="text" readonly class="form-control" value="${bairro}" name="bairro" id="bairro">
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="cidade">Cidade: </label>
                <input type="text" readonly class="form-control" name="cidade" value="${cidade}" id="cidade">
            </div>
        </div>
    </div>
    <!-- /.row -->

    <div class="row">
        <div class="col-sm-6 col-md-3">
            <div class="form-group">
                <label for="uf">UF: </label>
                <input type="text" readonly class="form-control" maxlength="2" value="${uf}" name="uf" id="uf">
            </div>
        </div>
        <div class="col-sm-6 col-md-3">
            <div class="form-group">
                <label for="numero">Número: </label>
                <input type="text" class="form-control" value="${numero}" name="numero" id="numero">
            </div>
        </div>
        <div class="col-sm-6 col-md-3">
            <div class="form-group">
                <label for="complemento">Complemento: </label>
                <input type="text" class="form-control" value="${complemento}" name="complemento" id="complemento">
            </div>
        </div>
        <div class="col-sm-6 col-md-3"> &nbsp;
            <div class="form-group">
                <br><input type="checkbox" class="form-check-input" name="novoEndereco" checked value="checked"><span style="color: #069;"> Salvar esse endereço</span>
                <!--<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar endereço</button>-->
            </div>
        </div>


    </div>
    <!-- /.row -->
</div>

<div class="box-footer">
    <div class="pull-left">
        <a href="carrinho" class="btn btn-default"><i class="fa fa-chevron-left"></i>Voltar</a>
    </div>
    <div class="pull-right">
        <button type="submit" class="btn btnProx btn-primary">Seguir para formas de entrega<i class="fa fa-chevron-right"></i>
        </button>
    </div>
</div>
</form>
<!--</form>-->
<script src="js/checkout.js"></script>
<script>
                    $(document).ready(function () {

                        $(".enderecos").on("change", function () {
//                                                            var cepEnd = $(this).attr("value");
                            var form = $(this).closest("form");
                            $.ajax({
                                type: "POST",
                                url: "checkout01",
                                data: form.serialize(),
                                success: function (data)
                                {
                                    $("#formCheck2").html(data);
                                }
                            });

                            return false;
                        });

                    });
</script>
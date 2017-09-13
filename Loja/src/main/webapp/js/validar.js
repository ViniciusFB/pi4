$(document).ready(function () {
    $('#formCadastro').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            nome: {
                validators: {
                    stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Por favor digite seu primeiro nome'
                    }
                }
            },
            sobrenome: {
                validators: {
                    stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Por favor digite seu sobrenome'
                    }
                }
            },
            cpf: {
                validators: {
                    stringLength: {
                        min: 14,
                    },
                    notEmpty: {
                        message: 'Por favor digite um CPF válido'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Por favor digite seu email'
                    },
                    emailAddress: {
                        message: 'Por favor digite um email válido'
                    }
                }
            },
            telefone: {
                validators: {
                    stringLength: {
                        min: 14,
                    },
                    notEmpty: {
                        message: 'Por favor digite um telefone válido'
                    }
                }
            },
            cep: {
                validators: {
                    stringLength: {
                        min: 9,
                    },
                    notEmpty: {
                        message: 'Por favor digite um cep válido'
                    }
                }
            },
            senha: {
                validators: {
                    stringLength: {
                        min: 6,
                    },
                    notEmpty: {
                        message: 'Por favor digite uma senha com no mínimo 6 caracteres'
                    },
                    identical: {
                        field: 'confirmarSenha',
                        message: 'Confirme sua senha abaixo. As senhas digitadas devem ser iguais'
                    }
                }
            },
            confirmarSenha: {
                validators: {
                    stringLength: {
                        min: 6,
                    },
                    notEmpty: {
                        message: 'As senhas digitadas devem ter no mínimo 6 caracteres e serem idênticas'
                    },
                    identical: {
                        field: 'senha',
                        message: 'As senhas digitadas são diferentes'
                    }
                }
            },

        }
    })


            .on('success.form.bv', function (e) {
                $('#success_message').slideDown({opacity: "show"}, "slow") // Do something ...
                $('#formCadastro').data('bootstrapValidator').resetForm();

                // Prevent form submission
                e.preventDefault();

                // Get the form instance
                var $form = $(e.target);

                // Get the BootstrapValidator instance
                var bv = $form.data('bootstrapValidator');

                // Use Ajax to submit form data
                $.post($form.attr('action'), $form.serialize(), function (result) {
                    console.log(result);
                }, 'json');
            });
});
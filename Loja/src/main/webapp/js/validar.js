$(document).ready(function () {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0!
    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }

    today = yyyy + '-' + mm + '-' + dd;
//    document.getElementById("dataNasc").setAttribute("max", today);

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
            dataNasc: {
                validators: {
                    date: {
                        message: 'A data digitada não é válida',
                        format: 'YYYY-MM-DD'
                    },
                    callback: {
                        message: 'Data inválida',
                        callback: function (value, validator) {
                            var m = new moment(value, 'YYYY-MM-DD', true);
                            if (!m.isValid()) {
                                return false;
                            }
                            return m.isAfter('1900-01-01') && m.isBefore(today);
                        }
                    }
                }
            },
            numero: {
                validators: {
                    integer: {
                        message: 'Por favor digite apenas números'
                    }
                }
            },
            codigo: {
                validators: {
                    integer: {
                        message: 'Por favor digite apenas números'
                    },
                    notEmpty: {
                        message: 'Por favor digite um código válido'
                    }
                }
            },
            quantidade: {
                validators: {
                    integer: {
                        message: 'Por favor escolha a quantidade'
                    },
                    notEmpty: {
                        message: 'Por favor escolha a quantidade'
                    }
                }
            },
            valor: {
                validators: {
                    numeric: {
                        message: 'Por favor digite um valor válido',
                        separator: ","
                    },
                    notEmpty: {
                        message: 'Por favor digite um valor válido'
                    }
                }
            },
            imgLink: {
                validators: {
                    stringLength: {
                        max: 2083,
                    },
                    notEmpty: {
                        message: 'Por favor cole a URL da imagem nesse campo'
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
function cep_mask(v) {
    v = v.replace(/\D/g, "")                 //Remove tudo o que não é dígito
    v = v.replace(/(\d{5})(\d)/, "$1-$2")    //Coloca ponto entre o quinto e sexto dígito
    return v
}
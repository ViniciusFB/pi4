/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.models;

import java.sql.Date;

/**
 *
 * @author vinicius.fbatista1
 */
public class Cliente extends Usuario {

    //Construtor da classe
    public Cliente(int id, String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String senha) {
        //Ira passar os valores do parametro do construtor para a classe Mae
//        super(id, nome, sobrenome, dataNasc, cpf, email, telefone, senha);
        super(id, nome, sobrenome, dataNasc, cpf, email, telefone, senha);
    }

    public Cliente(String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, int id) {
        super(nome, sobrenome, dataNasc, cpf, email, telefone, id);

    }

    public Cliente(String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String senha) {
        super(nome, sobrenome, dataNasc, cpf, email, telefone, senha);

    }

    public Cliente(Cliente cliente) {
        super(cliente);
    }

}

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
public class Funcionario extends Usuario {

    //Construtor da classe
    public Funcionario(int id, String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String senha, int nivel) {
        //Ira passar os valores do parametro do construtor para a classe Mae
        super(id, nome, sobrenome, dataNasc, cpf, email, telefone, senha, nivel);
    }

    public Funcionario(String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String senha, int nivel) {
        super(nome, sobrenome, dataNasc, cpf, email, telefone, senha, nivel);

    }

}

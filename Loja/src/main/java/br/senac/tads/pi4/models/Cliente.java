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
public class Cliente {

    private int id;

    private String nome;
    private String sobrenome;
    private Date dataNasc;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;

    public Cliente() {

    }

    public Cliente(Cliente cliente) {
        this.id = cliente.id;
        this.nome = cliente.nome;
        this.sobrenome = cliente.sobrenome;
        this.dataNasc = cliente.dataNasc;
        this.cpf = cliente.cpf;
        this.email = cliente.email;
        this.telefone = cliente.telefone;
        this.senha = cliente.senha;
    }

    public Cliente(int id, String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Cliente(String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}

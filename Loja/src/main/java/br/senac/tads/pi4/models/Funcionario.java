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
public class Funcionario {

    private int id;

    private String nome;
    private String sobrenome;
    private Date dataNasc;
    private String cpf;
    private String email;
    private String telefone;
    private String cargo;
    private String senha;

    public Funcionario() {

    }

    public Funcionario(Funcionario funcionario) {
        this.id = funcionario.id;
        this.nome = funcionario.nome;
        this.sobrenome = funcionario.sobrenome;
        this.dataNasc = funcionario.dataNasc;
        this.cpf = funcionario.cpf;
        this.email = funcionario.email;
        this.telefone = funcionario.telefone;
        this.senha = funcionario.senha;
    }

    public Funcionario(int id, String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String cargo, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.senha = senha;
    }

    public Funcionario(String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String cargo, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.senha = senha;
    }

    public Funcionario(String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String cargo, int id) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.id = id;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}

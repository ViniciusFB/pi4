/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.models;

import java.sql.Date;

/**
 *
 * @author Vinicius Ferreira Batista
 */
public class Usuario {

    private int id;

    private String nome;
    private String sobrenome;
    private Date dataNasc;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;
    private int nivel;

    public Usuario() {

    }

    public Usuario(Usuario usuario) {
        this.id = usuario.id;
        this.nome = usuario.nome;
        this.sobrenome = usuario.sobrenome;
        this.dataNasc = usuario.dataNasc;
        this.cpf = usuario.cpf;
        this.email = usuario.email;
        this.telefone = usuario.telefone;
        this.senha = usuario.senha;
        this.nivel = usuario.nivel;
    }

    public Usuario(int id, String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String senha, int nivel) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.nivel = nivel;
    }

    public Usuario(int id, String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Usuario(String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String senha, int nivel) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.nivel = nivel;
    }
    public Usuario(String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Usuario(String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, int id, int nivel) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.id = id;
        this.nivel = nivel;
    }
    public Usuario(String nome, String sobrenome, Date dataNasc, String cpf, String email, String telefone, int id) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}

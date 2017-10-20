/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.models;

/**
 *
 * @author vinicius.fbatista1
 */
public class Endereco {

    private int id;
    private int idCliente;
    private String cep;
    private String rua;
    private int numeroCasa;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco() {

    }

    public Endereco(Endereco endereco) {
        this.id = endereco.id;
        this.idCliente = endereco.idCliente;
        this.cep = endereco.cep;
        this.rua = endereco.rua;
        this.numeroCasa = endereco.numeroCasa;
        this.complemento = endereco.complemento;
        this.bairro = endereco.bairro;
        this.cidade = endereco.cidade;
        this.uf = endereco.uf;
    }

    public Endereco(int idCliente, String cep, String rua, int numeroCasa, String complemento, String bairro, String cidade, String uf) {
        this.idCliente = idCliente;
        this.cep = cep;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }
    public Endereco(int id, int idCliente, String cep, String rua, int numeroCasa, String complemento, String bairro, String cidade, String uf) {
        this.id = id;
        this.idCliente = idCliente;
        this.cep = cep;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}

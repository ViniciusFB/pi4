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
public class Produto {

    private int id;
    private String nome;
    private int codigo;
    private String categorias;
    private int quantidade;
    private String descricao;
    private double valor;
    private String imagem;

    public Produto() {

    }

    public Produto(Produto produto) {
        this.id = produto.id;
        this.nome = produto.nome;
        this.codigo = produto.codigo;
        this.categorias = produto.categorias;
        this.quantidade = produto.quantidade;
        this.descricao = produto.descricao;
        this.valor = produto.valor;
        this.imagem = produto.imagem;
    }

    public Produto(int id, String nome, int codigo, String categorias, int quantidade, String descricao, double valor, String imagem) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.categorias = categorias;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
    }

    public Produto(String nome, int codigo, String categorias, int quantidade, String descricao, double valor, String imagem) {
        this.nome = nome;
        this.codigo = codigo;
        this.categorias = categorias;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}

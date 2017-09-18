/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.models;

/**
 *
 * @author Vinicius Ferreira Batista
 */
public class ItemDeCompra {

    private Integer id;
    private Integer codigo;
    private Produto produto;
    private String nome;
    private double valor;
    private int quantidade;
    private int quantidadeEstoque;
    private String imagem;
    private double total;

    public Integer getId() {
        this.id = this.produto.getId();
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        this.total = this.quantidade * this.produto.getValor();
        return total;
    }

    public String getImagem() {
        this.imagem = this.produto.getImagem();
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        this.nome = this.produto.getNome();
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        this.valor = this.produto.getValor();
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadeEstoque() {
        this.quantidadeEstoque = this.produto.getQuantidade();
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Integer getCodigo() {
        this.codigo = this.produto.getCodigo();
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    

}

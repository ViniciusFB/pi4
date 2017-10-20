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
public class VendaProd {

    private int id;
    private int idVenda;
    private int idProduto;
    private int idCliente;
    private String nome;
    private int codigo;
    private String categorias;
    private int quantidade;
    private String descricao;
    private double valorUni;
    private double valorTotal;
    private String imagem;
    private Date dataProd;

    public VendaProd() {

    }

    public VendaProd(int idVenda, int idProduto, int idCliente, Date dataProd, String nome, int codigo, int quantidade, double valorUni, double valorTotal, String imagem) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.dataProd = dataProd;
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valorUni = valorUni;
        this.valorTotal = valorTotal;
        this.imagem = imagem;
    }

    public VendaProd(int id, int idVenda, int idProduto, int idCliente, Date dataProd, String nome, int codigo, int quantidade, double valorUni, double valorTotal, String imagem) {
        this.id = id;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.dataProd = dataProd;
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valorUni = valorUni;
        this.valorTotal = valorTotal;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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

    public double getValorUni() {
        return valorUni;
    }

    public void setValorUni(double valorUni) {
        this.valorUni = valorUni;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Date getDataProd() {
        return dataProd;
    }

    public void setDataProd(Date dataProd) {
        this.dataProd = dataProd;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author vinicius.fbatista1
 */
public class Venda {

    private int id;
    private Long protocolo;
    private int idCliente;
    private Date dataVenda;
    private String dataFormatada;
    private Double valorFinal;

    public Venda() {

    }

    public Venda(int id, long protocolo, int idCliente, Date dataVenda, Double valorFinal) {
        this.id = id;
        this.protocolo = protocolo;
        this.idCliente = idCliente;
        this.dataVenda = dataVenda;
        this.valorFinal = valorFinal;
    }

    public Venda(int id, long protocolo, int idCliente, String dataFormatada, Double valorFinal) {
        this.id = id;
        this.protocolo = protocolo;
        this.idCliente = idCliente;
        this.dataFormatada = dataFormatada;
        this.valorFinal = valorFinal;
    }

    public Venda(int idCliente, long protocolo, Date dataVenda, Double valorFinal) {
        this.idCliente = idCliente;
        this.protocolo = protocolo;
        this.dataVenda = dataVenda;
        this.valorFinal = valorFinal;
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

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public void setDataFormatada(String dataFormatada) {
        this.dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(getDataVenda());
    }

    public String getDataFormatada() {
        return dataFormatada;
    }

    public Long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Long protocolo) {
        this.protocolo = protocolo;
    }

    
}

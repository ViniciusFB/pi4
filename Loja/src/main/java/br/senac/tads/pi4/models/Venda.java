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
    private String dataFormatada2;
    private Double valorFinal;
    private int status;
    private Date ultimaAtt;

//    Status:
// 0 - Aguardando pagamento
// 1 - Pedido em Processamento
// 2 - Faturamento
// 3 - Em Transporte
// 4 - Entregue
    public Venda() {

    }

    public Venda(Venda venda) {
        this.id = venda.id;
        this.protocolo = venda.protocolo;
        this.dataVenda = venda.dataVenda;
        this.valorFinal = venda.valorFinal;
        this.status = venda.status;
        this.ultimaAtt = venda.ultimaAtt;

    }

    public Venda(int id, long protocolo, int idCliente, Date dataVenda, Double valorFinal, int status, Date ultimaAtt) {
        this.id = id;
        this.protocolo = protocolo;
        this.idCliente = idCliente;
        this.dataVenda = dataVenda;
        this.valorFinal = valorFinal;
        this.status = status;
        this.ultimaAtt = ultimaAtt;
    }

    public Venda(int id, long protocolo, int idCliente, String dataFormatada, Double valorFinal, int status, String dataFormatada2) {
        this.id = id;
        this.protocolo = protocolo;
        this.idCliente = idCliente;
        this.dataFormatada = dataFormatada;
        this.valorFinal = valorFinal;
        this.status = status;
        this.dataFormatada2 = dataFormatada2;
    }

    public Venda(int idCliente, long protocolo, Date dataVenda, Double valorFinal, int status, Date ultimaAtt) {
        this.idCliente = idCliente;
        this.protocolo = protocolo;
        this.dataVenda = dataVenda;
        this.valorFinal = valorFinal;
        this.status = status;
        this.ultimaAtt = ultimaAtt;
    }

    public Venda(Long protocolo, Double valorFinal, int status, Date ultimaAtt, int id) {
        this.protocolo = protocolo;
        this.valorFinal = valorFinal;
        this.status = status;
        this.ultimaAtt = ultimaAtt;
        this.id = id;

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

    public void setDataFormatada2(String dataFormatada2) {
        this.dataFormatada2 = new SimpleDateFormat("dd/MM/yyyy").format(getUltimaAtt());
    }

    public String getDataFormatada2() {
        return dataFormatada2;
    }

    public Long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Long protocolo) {
        this.protocolo = protocolo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUltimaAtt() {
        return ultimaAtt;
    }

    public void setUltimaAtt(Date ultimaAtt) {
        this.ultimaAtt = ultimaAtt;
    }

}

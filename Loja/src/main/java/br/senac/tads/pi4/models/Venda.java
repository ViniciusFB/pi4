/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.models;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author vinicius.fbatista1
 */
public class Venda {

    private int id;
    private Long protocolo;
    private int idUsuario;
    private int idEndereco;
    private Timestamp dataVenda;
    private Date previsaoEntrega;
    private String dataFormatada;
    private String dataFormatada2;
    private String previsaoEntregaFormatada;
    private Double valorFinal;
    private Double valorFrete;
    private int diasUteis;
    private int status;
    private Timestamp ultimaAtt;
    private long numeroCartao;
    private int numeroParcelas;
    private Double valorParcelas;

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
        this.valorFrete = venda.valorFrete;
        this.diasUteis = venda.diasUteis;
        this.status = venda.status;
        this.ultimaAtt = venda.ultimaAtt;
        this.numeroCartao = venda.numeroCartao;
        this.numeroParcelas = venda.numeroParcelas;
        this.valorParcelas = venda.valorParcelas;

    }

    public Venda(int id, long protocolo, int idUsuario, int idEndereco, Timestamp dataVenda, Double valorFinal, Double valorFrete,
            int diasUteis, int status, Timestamp ultimaAtt, long numeroCartao, int numeroParcelas, Double valorParcelas) {
        this.id = id;
        this.protocolo = protocolo;
        this.idUsuario = idUsuario;
        this.idEndereco = idEndereco;
        this.dataVenda = dataVenda;
        this.valorFinal = valorFinal;
        this.valorFrete = valorFrete;
        this.diasUteis = diasUteis;
        this.status = status;
        this.ultimaAtt = ultimaAtt;
        this.numeroCartao = numeroCartao;
        this.numeroParcelas = numeroParcelas;
        this.valorParcelas = valorParcelas;
    }

    public Venda(int id, long protocolo, int idUsuario, int idEndereco, String dataFormatada, Double valorFinal, Double valorFrete,
            int diasUteis, int status, String dataFormatada2, long numeroCartao, int numeroParcelas, Double valorParcelas) {
        this.id = id;
        this.protocolo = protocolo;
        this.idUsuario = idUsuario;
        this.idEndereco = idEndereco;
        this.dataFormatada = dataFormatada;
        this.valorFinal = valorFinal;
        this.valorFrete = valorFrete;
        this.diasUteis = diasUteis;
        this.status = status;
        this.dataFormatada2 = dataFormatada2;
        this.numeroCartao = numeroCartao;
        this.numeroParcelas = numeroParcelas;
        this.valorParcelas = valorParcelas;
    }

    public Venda(long protocolo, int idUsuario, int idEndereco, Timestamp dataVenda, Double valorFinal, Double valorFrete,
            int diasUteis, int status, Timestamp ultimaAtt, long numeroCartao, int numeroParcelas, Double valorParcelas) {
        this.protocolo = protocolo;
        this.idUsuario = idUsuario;
        this.idEndereco = idEndereco;
        this.dataVenda = dataVenda;
        this.valorFinal = valorFinal;
        this.valorFrete = valorFrete;
        this.diasUteis = diasUteis;
        this.status = status;
        this.ultimaAtt = ultimaAtt;
        this.numeroCartao = numeroCartao;
        this.numeroParcelas = numeroParcelas;
        this.valorParcelas = valorParcelas;
    }

    public Venda(Long protocolo, Double valorFinal, int status, Timestamp ultimaAtt, int id) {
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
        return idUsuario;
    }

    public void setIdCliente(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Timestamp getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Timestamp dataVenda) {
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

    public Timestamp getUltimaAtt() {
        return ultimaAtt;
    }

    public void setUltimaAtt(Timestamp ultimaAtt) {
        this.ultimaAtt = ultimaAtt;
    }

    public long getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(Double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public int getDiasUteis() {
        return diasUteis;
    }

    public void setDiasUteis(int diasUteis) {
        this.diasUteis = diasUteis;
    }

    public Date getPrevisaoEntrega() {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, getDiasUteis());
        dt = c.getTime();
        return dt;
    }
    public String getPrevisaoEntregaFormatada() {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, getDiasUteis());
        dt = c.getTime();
        String entregaFormatada = dateFormat.format(dt);
        return entregaFormatada;
    }

}

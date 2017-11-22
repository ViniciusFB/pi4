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
 * @author Vinicius Ferreira Batista
 */
public class Contato {

//    private int id;
    private Long protocolo;
    private String nome;
    private String sobrenome;
    private String email;
    private String motivo;
    private String mensagem;
    private Date dataMensagem;
    private String dataFormatada;
    private boolean respondida;

    public Contato() {

    }

    public Contato(Contato contato) {
        this.protocolo = contato.protocolo;
        this.nome = contato.nome;
        this.sobrenome = contato.sobrenome;
        this.email = contato.email;
        this.motivo = contato.motivo;
        this.mensagem = contato.mensagem;
        this.dataMensagem = contato.dataMensagem;
        this.respondida = contato.respondida;
    }

    public Contato(Long protocolo, String nome, String sobrenome, String email, String motivo, String mensagem, Date dataMensagem, boolean respondida) {
        this.protocolo = protocolo;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.motivo = motivo;
        this.mensagem = mensagem;
        this.dataMensagem = dataMensagem;
        this.respondida = respondida;
    }

    public Contato(String nome, String sobrenome, String email, String motivo, String mensagem, Date dataMensagem, boolean respondida) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.motivo = motivo;
        this.mensagem = mensagem;
        this.dataMensagem = dataMensagem;
        this.respondida = respondida;
    }

    public Contato(Long protocolo, String nome, String sobrenome, String email, String motivo, String mensagem, String dataFormatada, boolean respondida) {
        this.protocolo = protocolo;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.motivo = motivo;
        this.mensagem = mensagem;
        this.dataFormatada = dataFormatada;
        this.respondida = respondida;
    }

    public Long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Long protocolo) {
        this.protocolo = protocolo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDataMensagem() {
        return dataMensagem;
    }

    public void setDataMensagem(Date dataMensagem) {
        this.dataMensagem = dataMensagem;
    }

    public String getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(String dataFormatada) {
        this.dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(getDataMensagem());

    }

    public boolean isRespondida() {
        return respondida;
    }

    public void setRespondida(boolean respondida) {
        this.respondida = respondida;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.dao;

import br.senac.tads.pi4.models.Cliente;
import br.senac.tads.pi4.models.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius Ferreira Batista
 */
public class EnderecoDAO extends ConexaoBD {
    
    Cliente cliente;
    
    public void incluirComTransacao(Endereco endereco) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO Endereco "
                + "(cep, rua, numero, complemento, bairro, municipio, uf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, endereco.getIdCliente());
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setInt(3, endereco.getNumeroCasa());
            stmt.setString(4, endereco.getComplemento());
            stmt.setString(5, endereco.getBairro());
            stmt.setString(6, endereco.getMunicipio());
            stmt.setString(7, endereco.getUf());

            stmt.executeUpdate();

           
            conn.commit();
        } catch (SQLException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

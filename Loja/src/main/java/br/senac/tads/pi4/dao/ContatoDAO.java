/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.dao;

import br.senac.tads.pi4.models.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius.fbatista1
 */
public class ContatoDAO extends ConexaoBD {

    public void incluirComTransacao(Contato contato) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Long protocoloNovo = (long) 1;
        long protocolo = 0;

        String sql = "INSERT INTO Contato "
                + "(protocolo, nome, sobrenome, email, motivo, mensagem, dataMensagem, respondida) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            stmt.setLong(1, contato.getProtocolo());
//            stmt.setString(2, "" + venda.getProtocolo());
            stmt.setLong(1, protocolo);
            stmt.setString(2, contato.getNome());
            stmt.setString(3, contato.getSobrenome());
            stmt.setString(4, contato.getEmail());
            stmt.setString(5, contato.getMotivo());
            stmt.setString(6, contato.getMensagem());
            stmt.setDate(7, contato.getDataMensagem());
            stmt.setBoolean(8, false);
//            stmt.executeUpdate();

            // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
            // Neste exemplo, o ID é gerado automaticamente.
            if (protocolo == 0) {
                protocolo = (long) (1000000000 + Math.random() * 999999999);
                protocoloNovo = protocoloNovo + protocolo;
                contato.setProtocolo(protocoloNovo);
                stmt.setLong(1, protocoloNovo);
                stmt.executeUpdate();
                System.out.println("***** PROTOCOLO CADASTRADO: " + String.valueOf(protocoloNovo));

                // Executar próximos INSERTs USANDO O ID novo.
            }
            conn.commit();
        } catch (SQLException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<Contato> listar() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM CONTATO ORDER BY dataMensagem DESC";

        List<Contato> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();

            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                long protocolo = Long.parseLong(resultados.getString("protocolo"));
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                String email = resultados.getString("email");
                String motivo = resultados.getString("motivo");
                String mensagem = resultados.getString("mensagem");
                Date dataVenda = resultados.getDate("dataMensagem");
                SimpleDateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = formatBR.format(dataVenda);
                boolean respondida = resultados.getBoolean("respondida");

                Contato contato = new Contato(protocolo, nome, sobrenome, email, motivo, mensagem, dataFormatada, respondida);

                lista.add(contato);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    public Contato obterMensagem(Long protocolo) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Contato c = null;

        String sql = "SELECT * FROM CONTATO WHERE protocolo = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, protocolo);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                long protoc = Long.parseLong(resultados.getString("protocolo"));
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                String email = resultados.getString("email");
                String motivo = resultados.getString("motivo");
                String mensagem = resultados.getString("mensagem");
                Date dataMensagem = resultados.getDate("dataMensagem");
                SimpleDateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = formatBR.format(dataMensagem);
                boolean respondida = resultados.getBoolean("respondida");

                c = new Contato(protoc, nome, sobrenome, email, motivo, mensagem, dataFormatada, respondida);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return c;

    }

    public void atualizarResposta(Long protocolo) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE Contato SET respondida=? WHERE (protocolo=?)";

        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setBoolean(1, true);
            stmt.setLong(2, protocolo);

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}

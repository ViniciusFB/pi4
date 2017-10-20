/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.dao;

import br.senac.tads.pi4.models.VendaProd;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius.fbatista1
 */
public class VendaProdDAO extends ConexaoBD {

    public void incluirComTransacao(VendaProd vp) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO VendaProd "
                + "(idVenda, idProduto, idCliente, dataProd, nomeProduto, codigo, quantidade, valorUni, valorTotal, imagem) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, vp.getIdVenda());
            stmt.setInt(2, vp.getIdProduto());
            stmt.setInt(3, vp.getIdCliente());
            stmt.setDate(4, (Date) vp.getDataProd());
            stmt.setString(5, vp.getNome());
            stmt.setInt(6, vp.getCodigo());
            stmt.setInt(7, vp.getQuantidade());
            stmt.setDouble(8, vp.getValorUni());
            stmt.setDouble(9, vp.getValorTotal());
            stmt.setString(10, vp.getImagem());
            stmt.executeUpdate();

            // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
            // Neste exemplo, o ID é gerado automaticamente.
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idNovo = generatedKeys.getInt(1);
                vp.setId(idNovo);
                System.out.println("***** ID NOVO CADASTRADO: " + String.valueOf(idNovo));

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
                Logger.getLogger(VendaProdDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(VendaProdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(VendaProdDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(VendaProdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaProdDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaProdDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<VendaProd> listar(int idVenda) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM VendaProd WHERE idVenda = "+idVenda;

        List<VendaProd> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();

//            stmt.setMaxRows(6); // Limitar o número de itens exibidos
//            System.out.println("Realizando uma consulta limitada a "
//                    + stmt.getMaxRows() + " linhas.");
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("idVendaProd");
                int idVenda2 = resultados.getInt("idVenda");
                int idProduto = resultados.getInt("idProduto");
                int idCliente = resultados.getInt("idCliente");
                Date dataProd = resultados.getDate("dataProd");
                String nome = resultados.getString("nomeProduto");
                int codigo = resultados.getInt("codigo");
                int quantidade = resultados.getInt("quantidade");
                double valorUni = resultados.getDouble("valorUni");
                double valorTotal = resultados.getDouble("valorTotal");
                String imagem = resultados.getString("imagem");

                VendaProd vp = new VendaProd(id, idVenda2, idProduto, idCliente, dataProd, nome,
                        codigo, quantidade, valorUni, valorTotal, imagem);

                lista.add(vp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }
}

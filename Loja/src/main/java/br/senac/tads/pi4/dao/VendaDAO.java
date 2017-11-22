/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.dao;

import br.senac.tads.pi4.models.Venda;
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
public class VendaDAO extends ConexaoBD {

    public void incluirComTransacao(Venda venda) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO Venda "
                + "(idCliente, protocolo, dataVenda, valorFinal, status, ultimaAtt) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, venda.getIdCliente());
            stmt.setString(2, "" + venda.getProtocolo());
            stmt.setDate(3, venda.getDataVenda());
            stmt.setDouble(4, venda.getValorFinal());
            stmt.setInt(5, venda.getStatus());
            stmt.setDate(6, venda.getUltimaAtt());

            stmt.executeUpdate();

            // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
            // Neste exemplo, o ID é gerado automaticamente.
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idNovo = generatedKeys.getInt(1);
                venda.setId(idNovo);
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
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<Venda> listar(int idCliente) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM Venda WHERE idCliente = " + idCliente;

        List<Venda> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();

            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("idVenda");
                long protocolo = Long.parseLong(resultados.getString("protocolo"));
                int idCli = resultados.getInt("idCliente");
                Date dataVenda = resultados.getDate("dataVenda");
                SimpleDateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = formatBR.format(dataVenda);
                double valor = resultados.getDouble("valorFinal");
                int status = resultados.getInt("status");
                Date ultimaAtt = resultados.getDate("ultimaAtt");
                String dataFormatada2 = formatBR.format(ultimaAtt);

                Venda venda = new Venda(id, protocolo, idCli, dataFormatada, valor, status, dataFormatada2);

                lista.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    public List<Venda> listarPedidosBackoffice() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM Venda";

        List<Venda> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();

            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("idVenda");
                long protocolo = Long.parseLong(resultados.getString("protocolo"));
                int idCli = resultados.getInt("idCliente");
                Date dataVenda = resultados.getDate("dataVenda");
                SimpleDateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = formatBR.format(dataVenda);
                double valor = resultados.getDouble("valorFinal");
                int status = resultados.getInt("status");
                Date ultimaAtt = resultados.getDate("ultimaAtt");
                SimpleDateFormat formatBR2 = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada2 = formatBR2.format(ultimaAtt);

                Venda venda = new Venda(id, protocolo, idCli, dataFormatada, valor, status, dataFormatada2);

                lista.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    public List<Venda> filtrar(int idCliente, Date dataInicial, Date dataFinal) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM Venda WHERE idCliente = " + idCliente + " AND dataVenda BETWEEN '" + dataInicial + " 00:00:00.0' AND '"
                + dataFinal + " 00:00:00.0'";

        List<Venda> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();

            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("idVenda");
                long protocolo = Long.parseLong(resultados.getString("protocolo"));
                int idCli = resultados.getInt("idCliente");
                Date dataVenda = resultados.getDate("dataVenda");
                SimpleDateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = formatBR.format(dataVenda);
                double valor = resultados.getDouble("valorFinal");
                int status = resultados.getInt("status");
                Date ultimaAtt = resultados.getDate("ultimaAtt");
                String dataFormatada2 = formatBR.format(ultimaAtt);

                Venda venda = new Venda(id, protocolo, idCli, dataFormatada, valor, status, dataFormatada2);

                lista.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    public double obterValorFinal(int idVenda) {
        Statement stmt = null;
        Connection conn = null;
        double valorFinal = 0;
        String sql = "SELECT valorFinal FROM VENDA WHERE idVenda = " + idVenda;

        try {
            conn = obterConexao();
            stmt = conn.createStatement();

            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                valorFinal = resultados.getDouble("valorFinal");
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valorFinal;
    }

    public void atualizarStatus(Venda venda) {

        PreparedStatement stmt = null;
        Connection conn = null;

//        String sql = "UPDATE Cliente SET nomeCliente=?, sobrenomeCliente=?, dataNasc=?, cpfCliente=?, emailCliente=?, "
//                + "telefoneCliente=?, estadoCliente=?, cidadeCliente=?, enderecoCliente=? WHERE (idCliente=?)";
        String sql = "UPDATE Venda SET protocolo=?, valorFinal=?, status=?, ultimaAtt=? WHERE (idVenda=?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "" + venda.getProtocolo());
            stmt.setDouble(2, venda.getValorFinal());
            stmt.setInt(3, venda.getStatus());
            stmt.setDate(4, venda.getUltimaAtt());
            stmt.setInt(5, venda.getId());

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
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
    }

    public Venda obterInfoVenda(int idVenda) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Venda v = null;

        String sql = "SELECT * FROM Venda WHERE idVenda = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idVenda);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                int id = resultados.getInt("idVenda");
                long protocolo = Long.parseLong(resultados.getString("protocolo"));
                int idCli = resultados.getInt("idCliente");
                Date dataVenda = resultados.getDate("dataVenda");
                SimpleDateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = formatBR.format(dataVenda);
                double valor = resultados.getDouble("valorFinal");
                int status = resultados.getInt("status");
                Date ultimaAtt = resultados.getDate("ultimaAtt");
                String dataFormatada2 = formatBR.format(ultimaAtt);

                v = new Venda(id, protocolo, idCli, dataFormatada, valor, status, dataFormatada2);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return v;

    }
}

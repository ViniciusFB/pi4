/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.dao;

import br.senac.tads.pi4.models.Cliente;
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
public class ClienteDAO extends ConexaoBD {

    public Cliente obterCliente(int idCliente) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Cliente c = null;

//        String sql = "SELECT idCliente, nomeCliente, sobrenomeCliente, dataNasc, cpfCliente, emailCliente, telefoneCliente, estadoCliente, cidadeCliente, enderecoCliente, "
//                + "generoCliente "
//                + "FROM Cliente WHERE idCliente = ?";
        String sql = "SELECT idCliente, nomeCliente, sobrenomeCliente, dataNasc, cpfCliente, emailCliente, telefoneCliente, senha "
                + "FROM Cliente WHERE idCliente = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                int id = resultados.getInt("idCliente");
                String nome = resultados.getString("nomeCliente");
                String sobrenome = resultados.getString("sobrenomeCliente");
                Date dataNasc = resultados.getDate("dataNasc");
                String cpf = resultados.getString("cpfCliente");
                String email = resultados.getString("emailCliente");
                String telefone = resultados.getString("telefoneCliente");
                String senha = resultados.getString("senha");
                c = new Cliente(id, nome, sobrenome, dataNasc, cpf, email, telefone, senha);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return c;

    }

    public List<Cliente> listar() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT idCliente, nomeCliente, sobrenomeCliente, dataNasc, cpfCliente, emailCliente, telefoneCliente "
                + "FROM Cliente ";

        List<Cliente> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            //     DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
            while (resultados.next()) {
                int id = resultados.getInt("idCliente");
                String nome = resultados.getString("nomeCliente");
                String sobrenome = resultados.getString("sobrenomeCliente");
                Date dataNasc = resultados.getDate("dataNasc");
                String cpf = resultados.getString("cpfCliente");
                String email = resultados.getString("emailCliente");
                String telefone = resultados.getString("telefoneCliente");
                String senha = resultados.getString("senha");
                Cliente cliente = new Cliente(id, nome, sobrenome, dataNasc, cpf, email, telefone, senha);

                lista.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    public void incluirComTransacao(Cliente cliente) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO Cliente "
                + "(nomeCliente, sobrenomeCliente, dataNasc, cpfCliente, emailCliente, telefoneCliente, senha, cep, "
                + "rua, numero, complemento, bairro, municipio, uf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setDate(3, cliente.getDataNasc());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getTelefone());
            stmt.setString(7, cliente.getSenha());
            stmt.setString(8, cliente.getCep());
            stmt.setString(9, cliente.getRua());
            stmt.setInt(10, cliente.getNumeroCasa());
            stmt.setString(11, cliente.getComplemento());
            stmt.setString(12, cliente.getBairro());
            stmt.setString(13, cliente.getMunicipio());
            stmt.setString(14, cliente.getUf());

            stmt.executeUpdate();

            // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
            // Neste exemplo, o ID é gerado automaticamente.
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idNovo = generatedKeys.getInt(1);
                cliente.setId(idNovo);
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
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void incluir(Cliente cliente) {
        PreparedStatement stmt = null;
        Connection conn = null;

//        String sql = "INSERT INTO Cliente "
//                + "(nomeCliente, sobrenomeCliente, dataNasc, cpfCliente, emailCliente, telefoneCliente, estadoCliente, cidadeCliente, enderecoCliente, "
//                + "generoCliente) "
//                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql = "INSERT INTO Cliente "
                + "(nomeCliente, sobrenomeCliente, dataNasc, cpfCliente, emailCliente, telefoneCliente, senha) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setDate(3, cliente.getDataNasc());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getTelefone());
            stmt.setString(7, cliente.getSenha());
            stmt.executeUpdate();
            //System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void atualizarCliente(Cliente cliente) {

        PreparedStatement stmt = null;
        Connection conn = null;

//        String sql = "UPDATE Cliente SET nomeCliente=?, sobrenomeCliente=?, dataNasc=?, cpfCliente=?, emailCliente=?, "
//                + "telefoneCliente=?, estadoCliente=?, cidadeCliente=?, enderecoCliente=? WHERE (idCliente=?)";
        String sql = "UPDATE Cliente SET nomeCliente=?, sobrenomeCliente=?, dataNasc=?, cpf=?, emailCliente=?, telefoneCliente=?, senha WHERE (idCliente=?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
             stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setDate(3, cliente.getDataNasc());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getTelefone());
            stmt.setString(7, cliente.getSenha());
            stmt.setInt(8, cliente.getId());

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void excluirCliente(int id) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "DELETE FROM Cliente WHERE (idCliente=?)";

        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public String selecionaNomeByEmailSenha(String email, String senha) throws SQLException {
        String nome = null;
        ResultSet resultSet;
        String sql = null;
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = obterConexao();
            sql = "SELECT nomeCliente FROM Cliente WHERE Cliente.emailCliente = '" + email
                    + "' and Cliente.senha = '" + senha + "'";
            stmt = conn.prepareStatement(sql);

            resultSet = stmt.executeQuery();
            resultSet.next();
            nome = resultSet.getString(1);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return nome;
    }

    public Cliente obterClientePorEmail(String email) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Cliente c = null;

        String sql = "SELECT idCliente, nomeCliente, sobrenomeCliente, dataNasc, cpfCliente, emailCliente, telefoneCliente, senha "
                + "FROM Cliente WHERE emailCliente = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                int id = resultados.getInt("idCliente");
                String nome = resultados.getString("nomeCliente");
                String sobrenome = resultados.getString("sobrenomeCliente");
                Date dataNasc = resultados.getDate("dataNasc");
                String cpf = resultados.getString("cpfCliente");
                String emailc = resultados.getString("emailCliente");
                String telefone = resultados.getString("telefoneCliente");
                String senha = resultados.getString("senha");
                c = new Cliente(id, nome, sobrenome, dataNasc, cpf, emailc, telefone, senha);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return c;

    }

    public String selecionaHashSenha(String email) throws SQLException {
        String senha = null;
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = null;
        ResultSet resultSet;
        Cliente cliente = null;
        try {
            conn = obterConexao();
            sql = "SELECT * FROM Cliente WHERE Cliente.emailCliente = '" + email + "'";

            stmt = conn.prepareStatement(sql);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                senha = resultSet.getString(8);
            }
        } catch (Exception e) {
            System.out.println("\nErro ao selecionar senha do cliente: " + e);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return senha;
    }
}

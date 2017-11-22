/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.dao;

import br.senac.tads.pi4.models.Cliente;
import br.senac.tads.pi4.models.Endereco;
import br.senac.tads.pi4.models.Funcionario;
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
public class FuncionarioDAO extends ConexaoBD {

    public Funcionario obterFuncionario(int idFuncionario) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Funcionario f = null;

//        String sql = "SELECT idCliente, nomeCliente, sobrenomeCliente, dataNasc, cpfCliente, emailCliente, telefoneCliente, estadoCliente, cidadeCliente, enderecoCliente, "
//                + "generoCliente "
//                + "FROM Cliente WHERE idCliente = ?";
        String sql = "SELECT idCliente, nomeCliente, sobrenomeCliente, dataNasc, cpfCliente, emailCliente, telefoneCliente, cargo, senha "
                + "FROM Funcionario WHERE idFuncionario = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idFuncionario);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                int id = resultados.getInt("idFuncionario");
                String nome = resultados.getString("nomeFuncionario");
                String sobrenome = resultados.getString("sobrenomeFuncionario");
                Date dataNasc = resultados.getDate("dataNasc");
                String cpf = resultados.getString("cpfFuncionario");
                String email = resultados.getString("emailFuncionario");
                String telefone = resultados.getString("telefoneFuncionario");
                String cargo = resultados.getString("cargo");
                String senha = resultados.getString("senha");
                f = new Funcionario(id, nome, sobrenome, dataNasc, cpf, email, telefone, cargo, senha);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return f;

    }

    public List<Funcionario> listar() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT idFuncionario, nomeFuncionario, sobrenomeFuncionario, dataNasc, cpfFuncionario, emailFuncionario, telefoneFuncionario, cargo "
                + "FROM Funcionario ";

        List<Funcionario> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            //     DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
            while (resultados.next()) {
                int id = resultados.getInt("idFuncionario");
                String nome = resultados.getString("nomeFuncionario");
                String sobrenome = resultados.getString("sobrenomeFuncionario");
                Date dataNasc = resultados.getDate("dataNasc");
                String cpf = resultados.getString("cpfFuncionario");
                String email = resultados.getString("emailFuncionario");
                String telefone = resultados.getString("telefoneFuncionario");
                String cargo = resultados.getString("cargo");
                String senha = resultados.getString("senha");
                Funcionario funcionario = new Funcionario(id, nome, sobrenome, dataNasc, cpf, email, telefone, cargo, senha);

                lista.add(funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    public void incluirComTransacao(Funcionario funcionario) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO Funcionario "
                + "(nomeFuncionario, sobrenomeFuncionario, dataNasc, cpfFuncionario, emailFuncionario, telefoneFuncionario, cargo, senha) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getSobrenome());
            stmt.setDate(3, funcionario.getDataNasc());
            stmt.setString(4, funcionario.getCpf());
            stmt.setString(5, funcionario.getEmail());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getCargo());
            stmt.setString(8, funcionario.getSenha());

            stmt.executeUpdate();

            // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
            // Neste exemplo, o ID é gerado automaticamente.
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idNovo = generatedKeys.getInt(1);
                funcionario.setId(idNovo);
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
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void incluir(Funcionario funcionario) {
        PreparedStatement stmt = null;
        Connection conn = null;

//        String sql = "INSERT INTO Cliente "
//                + "(nomeCliente, sobrenomeCliente, dataNasc, cpfCliente, emailCliente, telefoneCliente, estadoCliente, cidadeCliente, enderecoCliente, "
//                + "generoCliente) "
//                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql = "INSERT INTO Cliente "
                + "(nomeFuncionario, sobrenomeFuncionario, dataNasc, cpfFuncionario, emailFuncionario, telefoneFuncionario, cargo, senha) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getSobrenome());
            stmt.setDate(3, funcionario.getDataNasc());
            stmt.setString(4, funcionario.getCpf());
            stmt.setString(5, funcionario.getEmail());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getCargo());
            stmt.setString(8, funcionario.getSenha());
            stmt.executeUpdate();
            //System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void atualizarFuncionario(Funcionario funcionario) {

        PreparedStatement stmt = null;
        Connection conn = null;

//        String sql = "UPDATE Cliente SET nomeCliente=?, sobrenomeCliente=?, dataNasc=?, cpfCliente=?, emailCliente=?, "
//                + "telefoneCliente=?, estadoCliente=?, cidadeCliente=?, enderecoCliente=? WHERE (idCliente=?)";
        String sql = "UPDATE Funcionario SET nomeFuncionario=?, sobrenomeFuncionario=?, dataNasc=?, cpfFuncionario=?, emailFuncionario=?, telefoneFuncionario=?, cargo=? WHERE (idFuncionario=?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getSobrenome());
            stmt.setDate(3, funcionario.getDataNasc());
            stmt.setString(4, funcionario.getCpf());
            stmt.setString(5, funcionario.getEmail());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getCargo());
            stmt.setInt(8, funcionario.getId());

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void excluirFuncionario(int id) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "DELETE FROM Funcionario WHERE (idFuncionario=?)";

        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            sql = "SELECT nomeFuncionario FROM Funcionario WHERE Funcionario.emailFuncionario = '" + email
                    + "' and Funcionario.senha = '" + senha + "'";
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
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return nome;
    }
    public int selecionaIdByEmailSenha(String email, String senha) throws SQLException {
        int id = 0;
        ResultSet resultSet;
        String sql = null;
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = obterConexao();
            sql = "SELECT idFuncionario FROM Funcionario WHERE Funcionario.emailFuncionario = '" + email
                    + "' and Funcionario.senha = '" + senha + "'";
            stmt = conn.prepareStatement(sql);

            resultSet = stmt.executeQuery();
            resultSet.next();
            id = resultSet.getInt(1);
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
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return id;
    }

    public Funcionario obterFuncionarioPorEmail(String email) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Funcionario f = null;

        String sql = "SELECT idFuncionario, nomeFuncionario, sobrenomeFuncionario, dataNasc, cpfFuncionario, emailFuncionario, telefoneFuncionario, cargo, senha "
                + "FROM Funcionario WHERE emailFuncionario = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                int id = resultados.getInt("idFuncionario");
                String nome = resultados.getString("nomeFuncionario");
                String sobrenome = resultados.getString("sobrenomeFuncionario");
                Date dataNasc = resultados.getDate("dataNasc");
                String cpf = resultados.getString("cpfFuncionario");
                String emailc = resultados.getString("emailFuncionario");
                String telefone = resultados.getString("telefoneFuncionario");
                String cargo = resultados.getString("cargo");
                String senha = resultados.getString("senha");
                f = new Funcionario(id, nome, sobrenome, dataNasc, cpf, emailc, telefone, cargo, senha);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return f;

    }

    public String selecionaHashSenha(String email) throws SQLException {
        String senha = null;
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = null;
        ResultSet resultSet;
//        Cliente funcionario = null;
        try {
            conn = obterConexao();
            sql = "SELECT * FROM Funcionario WHERE Funcionario.emailFuncionario = '" + email + "'";

            stmt = conn.prepareStatement(sql);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                senha = resultSet.getString(8);
            }
        } catch (Exception e) {
            System.out.println("\nErro ao selecionar senha do funcionario: " + e);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return senha;
    }

    public void adicionarEndereco(Endereco endereco) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Cliente cliente = null;

        String sql = "INSERT INTO Endereco "
                + "(idCliente, cep, rua, numero, complemento, bairro, cidade, uf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, endereco.getIdCliente());
            stmt.setString(2, endereco.getCep());
            stmt.setString(3, endereco.getRua());
            stmt.setInt(4, endereco.getNumeroCasa());
            stmt.setString(5, endereco.getComplemento());
            stmt.setString(6, endereco.getBairro());
            stmt.setString(7, endereco.getCidade());
            stmt.setString(8, endereco.getUf());

            stmt.executeUpdate();

            conn.commit();
        } catch (SQLException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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

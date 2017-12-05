/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.dao;

import br.senac.tads.pi4.models.Cliente;
import br.senac.tads.pi4.models.Usuario;
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
public class UsuarioDAO extends ConexaoBD {

    public Usuario obterUsuario(int idUsuario) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Usuario u = null;

        String sql = "SELECT id, nome, sobrenome, dataNasc, cpf, email, telefone, senha, nivel "
                + "FROM Usuario WHERE id = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                Date dataNasc = resultados.getDate("dataNasc");
                String cpf = resultados.getString("cpf");
                String email = resultados.getString("email");
                String telefone = resultados.getString("telefone");
                String senha = resultados.getString("senha");
                int nivel = resultados.getInt("nivel");

                u = new Usuario(id, nome, sobrenome, dataNasc, cpf, email, telefone, senha, nivel);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return u;

    }

    public List<Cliente> listarClientes() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT id, nome, sobrenome, dataNasc, cpf, email, telefone "
                + "FROM Usuario WHERE nivel = 0 ";

        List<Cliente> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            //     DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                Date dataNasc = resultados.getDate("dataNasc");
                String cpf = resultados.getString("cpf");
                String email = resultados.getString("email");
                String telefone = resultados.getString("telefone");
                String senha = resultados.getString("senha");
                int nivel = resultados.getInt("nivel");

                Cliente cliente = new Cliente(id, nome, sobrenome, dataNasc, cpf, email, telefone, senha);

                lista.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    public List<Funcionario> listarFuncionarios() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT id, nome, sobrenome, dataNasc, cpf, email, telefone "
                + "FROM Usuario WHERE nivel != 0 ";

        List<Funcionario> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            //     DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                Date dataNasc = resultados.getDate("dataNasc");
                String cpf = resultados.getString("cpf");
                String email = resultados.getString("email");
                String telefone = resultados.getString("telefone");
                String senha = resultados.getString("senha");
                int nivel = resultados.getInt("nivel");

                Funcionario funcionario = new Funcionario(id, nome, sobrenome, dataNasc, cpf, email, telefone, senha, nivel);

                lista.add(funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    public void incluirComTransacao(Usuario usuario) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO Usuario "
                + "(nome, sobrenome, dataNasc, cpf, email, telefone, senha, nivel) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setDate(3, usuario.getDataNasc());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTelefone());
            stmt.setString(7, usuario.getSenha());
            stmt.setInt(8, usuario.getNivel());

            stmt.executeUpdate();

            // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
            // Neste exemplo, o ID é gerado automaticamente.
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idNovo = generatedKeys.getInt(1);
                usuario.setId(idNovo);
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
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void incluir(Usuario usuario) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO Usuario "
                + "(nome, sobrenome, dataNasc, cpf, email, telefone, senha) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setDate(3, usuario.getDataNasc());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTelefone());
            stmt.setString(7, usuario.getSenha());
            stmt.executeUpdate();
            //System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void atualizarUsuario(Usuario usuario) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE Usuario SET nome=?, sobrenome=?, dataNasc=?, cpf=?, email=?, telefone=? WHERE (id=?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setDate(3, usuario.getDataNasc());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTelefone());
            stmt.setInt(7, usuario.getId());

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void excluirUsuario(int id) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "DELETE FROM Usuario WHERE (id=?)";

        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            sql = "SELECT nome FROM Usuario WHERE Usuario.email = '" + email
                    + "' and Usuario.senha = '" + senha + "'";
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
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            sql = "SELECT id FROM Usuario WHERE Usuario.email= '" + email
                    + "' and Usuario.senha = '" + senha + "'";
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
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return id;
    }

    public Usuario obterUsuarioPorEmail(String email) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Usuario u = null;

        String sql = "SELECT id, nome, sobrenome, dataNasc, cpf, email, telefone, senha, nivel "
                + "FROM Usuario WHERE email = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                int id = resultados.getInt("id");
                String nome = resultados.getString("nome");
                String sobrenome = resultados.getString("sobrenome");
                Date dataNasc = resultados.getDate("dataNasc");
                String cpf = resultados.getString("cpf");
                String emailc = resultados.getString("email");
                String telefone = resultados.getString("telefone");
                String senha = resultados.getString("senha");
                int nivel = resultados.getInt("nivel");

                u = new Usuario(id, nome, sobrenome, dataNasc, cpf, emailc, telefone, senha, nivel);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return u;

    }

    public String selecionaHashSenha(String email) throws SQLException {
        String senha = null;
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = null;
        ResultSet resultSet;
        Usuario usuario = null;
        try {
            conn = obterConexao();
            sql = "SELECT * FROM Usuario WHERE Usuario.email = '" + email + "'";

            stmt = conn.prepareStatement(sql);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                senha = resultSet.getString(8);
            }
        } catch (Exception e) {
            System.out.println("\nErro ao selecionar senha do usuario: " + e);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return senha;
    }

    public void adicionarEndereco(Endereco endereco) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Usuario usuario = null;

        String sql = "INSERT INTO Endereco "
                + "(idUsuario, cep, rua, numero, complemento, bairro, cidade, uf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, endereco.getIdUsuario());
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
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean verificaEmail(String email) throws Exception {
        boolean existe = false;
        try {
            Connection conn = obterConexao();
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet res = st.executeQuery("SELECT * FROM Usuario WHERE email = '" + email + "'");
            existe = res.first();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        System.out.println("Email " + email + " existe = " + existe);
        return existe;
    }

    public boolean verificaCpf(String cpf) throws Exception {
        boolean existe = false;
        try {
            Connection conn = obterConexao();
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet res = st.executeQuery("SELECT * FROM Usuario WHERE cpf = '" + cpf + "'");
            existe = res.first();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        System.out.println("CPF: " + cpf + " existe = " + existe);
        return existe;
    }
}

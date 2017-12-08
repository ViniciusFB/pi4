/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.dao;

import br.senac.tads.pi4.models.Cliente;
import br.senac.tads.pi4.models.Produto;
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
public class ProdutoDAO extends ConexaoBD {

    public Produto obterProduto(int idProduto) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Produto p = null;

        String sql = "SELECT * FROM Produto WHERE idProduto = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                int id = resultados.getInt("idProduto");
                String nome = resultados.getString("nomeProduto");
                int codigo = resultados.getInt("codigo");
                String categorias = resultados.getString("categorias");
                int quantidade = resultados.getInt("quantidade");
                String descricao = resultados.getString("descricao");
                double valor = resultados.getDouble("valorProduto");
                String imagem = resultados.getString("imagem");
                int statusProduto = resultados.getInt("statusProduto");
                boolean disponivel = resultados.getBoolean("disponivel");
                
                p = new Produto(id, nome, codigo, categorias, quantidade, descricao, valor, imagem, statusProduto, disponivel);
                break;
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
        return p;

    }

    public Produto obterProdutoByCod(int codigo) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Produto p = null;

        String sql = "SELECT * FROM Produto WHERE codigo = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                int id = resultados.getInt("idProduto");
                String nome = resultados.getString("nomeProduto");
                int codigoProduto = resultados.getInt("codigo");
                String categorias = resultados.getString("categorias");
                int quantidade = resultados.getInt("quantidade");
                String descricao = resultados.getString("descricao");
                double valor = resultados.getDouble("valorProduto");
                String imagem = resultados.getString("imagem");
                int statusProduto = resultados.getInt("statusProduto");
                boolean disponivel = resultados.getBoolean("disponivel");
                
                p = new Produto(id, nome, codigoProduto, categorias, quantidade, descricao, valor, imagem, statusProduto, disponivel);
                break;
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
        return p;

    }

    public List<Produto> listar() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM Produto";

        List<Produto> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();

//            stmt.setMaxRows(6); // Limitar o número de itens exibidos
//            System.out.println("Realizando uma consulta limitada a "
//                    + stmt.getMaxRows() + " linhas.");
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("idProduto");
                String nome = resultados.getString("nomeProduto");
                int codigo = resultados.getInt("codigo");
                String categorias = resultados.getString("categorias");
                int quantidade = resultados.getInt("quantidade");
                String descricao = resultados.getString("descricao");
                double valor = resultados.getDouble("valorProduto");
                String imagem = resultados.getString("imagem");
                int statusProduto = resultados.getInt("statusProduto");
                boolean disponivel = resultados.getBoolean("disponivel");

                Produto produto = new Produto(id, nome, codigo, categorias, quantidade, descricao, valor, imagem, statusProduto, disponivel);

                lista.add(produto);
            }
//            System.out.println("ULTIMA = " + resultados.getRow());
//            stmt.setFetchDirection(resultados.getRow());

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
    public List<Produto> listarFaltaDeProdutos() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM Produto WHERE statusProduto = 1 OR statusProduto = 2 ORDER BY statusProduto DESC";

        List<Produto> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();

            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("idProduto");
                String nome = resultados.getString("nomeProduto");
                int codigo = resultados.getInt("codigo");
                String categorias = resultados.getString("categorias");
                int quantidade = resultados.getInt("quantidade");
                String descricao = resultados.getString("descricao");
                double valor = resultados.getDouble("valorProduto");
                String imagem = resultados.getString("imagem");
                int statusProduto = resultados.getInt("statusProduto");
                boolean disponivel = resultados.getBoolean("disponivel");

                Produto produto = new Produto(id, nome, codigo, categorias, quantidade, descricao, valor, imagem, statusProduto, disponivel);

                lista.add(produto);
            }
//            System.out.println("ULTIMA = " + resultados.getRow());
//            stmt.setFetchDirection(resultados.getRow());

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

    public List<Produto> listarUltimos(int numero) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM Produto ORDER BY idProduto DESC FETCH FIRST " + numero + " ROWS ONLY ";

        List<Produto> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();

            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("idProduto");
                String nome = resultados.getString("nomeProduto");
                int codigo = resultados.getInt("codigo");
                String categorias = resultados.getString("categorias");
                int quantidade = resultados.getInt("quantidade");
                String descricao = resultados.getString("descricao");
                double valor = resultados.getDouble("valorProduto");
                String imagem = resultados.getString("imagem");
                int statusProduto = resultados.getInt("statusProduto");
                boolean disponivel = resultados.getBoolean("disponivel");

                Produto produto = new Produto(id, nome, codigo, categorias, quantidade, descricao, valor, imagem, statusProduto,
                        disponivel);

                lista.add(produto);
            }
//            System.out.println("ULTIMA = " + resultados.getRow());
//            stmt.setFetchDirection(resultados.getRow());

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

    public void incluirComTransacao(Produto produto) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO Produto "
                + "(nomeProduto, codigo, categorias, quantidade, descricao, valorProduto, imagem, statusProduto, disponivel) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getCodigo());
            stmt.setString(3, produto.getCategorias());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setString(5, produto.getDescricao());
            stmt.setDouble(6, produto.getValor());
            stmt.setString(7, produto.getImagem());
            stmt.setInt(8, produto.getStatusProduto());
            stmt.setBoolean(9, produto.isDisponivel());
            
            stmt.executeUpdate();

            // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
            // Neste exemplo, o ID é gerado automaticamente.
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idNovo = generatedKeys.getInt(1);
                produto.setId(idNovo);
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
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
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

    public void incluir(Produto produto) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO Produto "
                + "(nomeProduto, codigo, categorias, quantidade, descricao, valorProduto, imagem, statusProduto, disponivel) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getCodigo());
            stmt.setString(3, produto.getCategorias());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setString(5, produto.getDescricao());
            stmt.setDouble(6, produto.getValor());
            stmt.setString(7, produto.getImagem());
            stmt.setInt(8, produto.getStatusProduto());
            stmt.setBoolean(9, produto.isDisponivel());
            stmt.executeUpdate();
            //System.out.println("Registro incluido com sucesso.");

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

    public void atualizarProduto(Produto produto) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE Produto SET nomeProduto=?, codigo=?, quantidade=?, valorProduto=? WHERE (idProduto=?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getCodigo());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getValor());
            stmt.setInt(5, produto.getId());

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

    public void excluirProduto(int id) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "DELETE FROM Produto WHERE (idProduto=?)";

        try {

            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

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

    public Produto consultarPorId(int idProduto) {
        Produto produto = new Produto();
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM Produto WHERE idProduto = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produto.setId(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nomeProduto"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setCategorias(rs.getString("categorias"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getDouble("valorProduto"));
                produto.setImagem(rs.getString("imagem"));
                produto.setStatusProduto(rs.getInt("statusProduto"));
                produto.setDisponivel(rs.getBoolean("disponivel"));

            }
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex2) {
                throw new RuntimeException(ex2);
            }

        }
        return produto;
    }

    public List<Produto> pesquisarProduto(String nome) throws SQLException, ClassNotFoundException {

        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "SELECT idProduto, nomeProduto, codigo, categorias, quantidade, descricao, valorProduto, imagem, statusProduto, disponivel "
                + "FROM Produto WHERE UPPER(nomeProduto) LIKE UPPER(?) ";

        List<Produto> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");

            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {

                int id = resultados.getInt("idProduto");
                String nomeP = resultados.getString("nomeProduto");
                int codigo = resultados.getInt("codigo");
                String categorias = resultados.getString("categorias");
                int quantidade = resultados.getInt("quantidade");
                String descricao = resultados.getString("descricao");
                double valor = resultados.getDouble("valorProduto");
                String imagem = resultados.getString("imagem");
                int statusProduto = resultados.getInt("statusProduto");
                boolean disponivel = resultados.getBoolean("disponivel");

                lista.add(new Produto(id, nomeP, codigo, categorias, quantidade, descricao, valor, imagem, statusProduto, disponivel));
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e);
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
        return lista;
    }

    public List<Produto> filtrarPorCategoria(String categoria, String numeroPagina) throws SQLException, ClassNotFoundException {

        PreparedStatement stmt = null;
        Connection conn = null;
        int totalProdutosPagina = 9;
        if (numeroPagina == null || (numeroPagina != null && numeroPagina.trim().isEmpty())) {
            numeroPagina = "0";
        }
        int from = (Integer.parseInt(numeroPagina) * totalProdutosPagina) - totalProdutosPagina;

        if (from < 0) {
            from = 0;
        }
        String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER() AS rownum, Produto.* FROM Produto WHERE Categorias = '" + categoria + "') AS tmp "
                + " WHERE rownum > " + from + " AND rownum <= " + (totalProdutosPagina + from) + " AND UPPER(categorias) LIKE UPPER(?)";

        List<Produto> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + categoria + "%");
            stmt.setMaxRows(9);

            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {

                int id = resultados.getInt("idProduto");
                String nomeP = resultados.getString("nomeProduto");
                int codigo = resultados.getInt("codigo");
                String categorias = resultados.getString("categorias");
                int quantidade = resultados.getInt("quantidade");
                String descricao = resultados.getString("descricao");
                double valor = resultados.getDouble("valorProduto");
                String imagem = resultados.getString("imagem");
                int statusProduto = resultados.getInt("statusProduto");
                boolean disponivel = resultados.getBoolean("disponivel");

                lista.add(new Produto(id, nomeP, codigo, categorias, quantidade, descricao, valor, imagem, statusProduto, disponivel));
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e);
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
        return lista;
    }

    public List<Produto> consultaPaginada(String numeroPagina) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        int totalProdutosPagina = 9;
        if (numeroPagina == null || (numeroPagina != null && numeroPagina.trim().isEmpty())) {
            numeroPagina = "0";
        }
        int from = (Integer.parseInt(numeroPagina) * totalProdutosPagina) - totalProdutosPagina;

        if (from < 0) {
            from = 0;
        }

        List<Produto> retorno = new ArrayList<Produto>();
        String sql = "SELECT * FROM ( "
                + "    SELECT ROW_NUMBER() OVER() AS rownum, Produto.* "
                + "    FROM Produto "
                + ") AS tmp "
                + "WHERE rownum > " + from + " AND rownum <= " + (totalProdutosPagina + from) + " ORDER BY disponivel DESC";

        conn = obterConexao();
        stmt = conn.prepareStatement(sql);
        stmt.setMaxRows(9); // Limitar o número de itens exibidos

        ResultSet resultados = stmt.executeQuery();

        while (resultados.next()) {
            int id = resultados.getInt("idProduto");
            String nomeP = resultados.getString("nomeProduto");
            int codigo = resultados.getInt("codigo");
            String categorias = resultados.getString("categorias");
            int quantidade = resultados.getInt("quantidade");
            String descricao = resultados.getString("descricao");
            double valor = resultados.getDouble("valorProduto");
            String imagem = resultados.getString("imagem");
            int statusProduto = resultados.getInt("statusProduto");
            boolean disponivel = resultados.getBoolean("disponivel");

            retorno.add(new Produto(id, nomeP, codigo, categorias, quantidade, descricao, valor, imagem, statusProduto, disponivel));
        }
        return retorno;

    }

    public int quantidadePagina() throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "SELECT COUNT(1) as totalProdutos FROM PRODUTO";
        int quantidadePagina = 1;
        double totalProdutosPagina = 9.0;

        conn = obterConexao();
        stmt = conn.prepareStatement(sql);

        ResultSet resultados = stmt.executeQuery();

        if (resultados.next()) {
            double totalProdutos = resultados.getDouble("totalProdutos");

            if (totalProdutos > totalProdutosPagina) {
                double quantidadePaginaTemp = Float.parseFloat("" + (totalProdutos / totalProdutosPagina));

                if (!(quantidadePaginaTemp % 3 == 0)) {
//                    quantidadePagina = new Double(quantidadePaginaTemp).intValue() + 1;
                    quantidadePagina = new Double(quantidadePaginaTemp).intValue() + 1;
                } else {
                    quantidadePagina = new Double(quantidadePaginaTemp).intValue();

                }
            } else {
                quantidadePagina = 1;
            }

        }
        return quantidadePagina;
    }

    public int quantidadeProdutos() throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "SELECT COUNT(*) as totalProdutos FROM PRODUTO";
        int totalProdutos = 0;
        conn = obterConexao();
        stmt = conn.prepareStatement(sql);
//        stmt.setString(1, "%" + categoria + "%");
        ResultSet resultados = stmt.executeQuery();

        if (resultados.next()) {
            totalProdutos = resultados.getInt("totalProdutos");

        }
        return totalProdutos;
    }

    public int quantidadeProdutosCategoria(String categoria) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "SELECT COUNT(*) as totalProdutos FROM PRODUTO WHERE Produto.CATEGORIAS = '" + categoria + "'";
        int totalProdutos = 0;
        conn = obterConexao();
        stmt = conn.prepareStatement(sql);
//        stmt.setString(1, "%" + categoria + "%");
        ResultSet resultados = stmt.executeQuery();

        if (resultados.next()) {
            totalProdutos = resultados.getInt("totalProdutos");

        }
        return totalProdutos;
    }

    public int quantidadePaginaCategoria(String categoria) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "SELECT COUNT(1) as totalProdutos FROM PRODUTO WHERE UPPER(categorias) LIKE UPPER(?)";
        int quantidadePagina = 1;
        double totalProdutosPagina = 9.0;

        conn = obterConexao();
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + categoria + "%");

        ResultSet resultados = stmt.executeQuery();

        if (resultados.next()) {
            double totalProdutos = resultados.getDouble("totalProdutos");

            if (totalProdutos > totalProdutosPagina) {
                double quantidadePaginaTemp = Float.parseFloat("" + (totalProdutos / totalProdutosPagina));

                if (!(quantidadePaginaTemp % 3 == 0)) {
//                    quantidadePagina = new Double(quantidadePaginaTemp).intValue() + 1;
                    quantidadePagina = new Double(quantidadePaginaTemp).intValue() + 1;
                } else {
                    quantidadePagina = new Double(quantidadePaginaTemp).intValue();

                }
            } else {
                quantidadePagina = 1;
            }

        }
        return quantidadePagina;
    }

    public void updateQuantidade(int id, int qtd, int qtdAtual, String tipoOperacao) throws SQLException {
        Statement stmt = null;
        Connection conn = null;
        String sql;
        try {
            int valorAtual = 0;//Variavel local somente para este metodo
            conn = obterConexao();
            if (tipoOperacao.equals("Venda")) {//Se for venda é subtraído a quantidade em estoque
                valorAtual = qtdAtual - qtd;
            } else {
                valorAtual = qtdAtual + qtd;//Se for entrada é incrementada a quantidade em estoque
            }
            sql = "UPDATE Produto SET quantidade = " + valorAtual + " WHERE idProduto = " + id;
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao alterar quantidade do produto: " + e);
        } finally {
//            Conexao.fechaConexao(this.conn);
            conn.close();
        }
    }
    
    public void updateProdutoAcabando(int idProduto) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE Produto SET statusProduto=? WHERE (idProduto=?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1);
            stmt.setInt(2, idProduto);

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
    public void updateProdutoEsgotado(int idProduto) {

        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE Produto SET statusProduto=?, disponivel=? WHERE (idProduto=?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            stmt.setBoolean(2, false);
            stmt.setInt(3, idProduto);

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
}

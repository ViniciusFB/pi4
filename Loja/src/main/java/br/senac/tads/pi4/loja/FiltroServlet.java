/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.ProdutoDAO;
import br.senac.tads.pi4.models.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ProjetoX
 */
@WebServlet(name = "filtrar", urlPatterns = {"/filtrar"})
public class FiltroServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

        List<Produto> produtos;
        ProdutoDAO dao = new ProdutoDAO();

        try {
            String acao = request.getParameter("acao");
            String categoria = request.getParameter("category");
            String numeroPagina = request.getParameter("numeroPagina");
            int numPagina = 0;

            if (acao.equals("pesquisarProduto")) {
                String nome = request.getParameter("nomeProduto");
                if (nome != null) {
                    produtos = dao.pesquisarProduto(nome);
                    request.setAttribute("listaProd", produtos);
                } else if (nome == null) {
                    request.setAttribute("listaProd", dao.listar());
                }

            } else if (acao.equals(null) || acao == null) {
                request.setAttribute("listaProd", dao.listar());
            } else if (acao.equals("categoria")) {

                produtos = dao.filtrarPorCategoria(categoria, numeroPagina);
                if (produtos.isEmpty()) {
                    numeroPagina = "" + (Integer.parseInt(numeroPagina) - 1);
                    numPagina = Integer.parseInt(numeroPagina);

                }
                request.setAttribute("listaProd", produtos);
                request.setAttribute("numeroPagina", (numeroPagina != null ? numeroPagina : 1));
                request.setAttribute("category", categoria);

                int quantidadePagina = dao.quantidadePaginaCategoria(categoria);
                request.setAttribute("quantidadePagina", quantidadePagina);
                if (quantidadePagina > 0) {
                    if (numPagina <= quantidadePagina && (numPagina - 1) > 0) {
                        request.setAttribute("laquo", "<li><a href=produtos?numeroPagina=" + (numPagina - 1) + ">&laquo</a></li>");
                    }
                }
                if (quantidadePagina > numPagina) {

                    request.setAttribute("raquo", "<li><a href=produtos?numeroPagina=" + (numPagina + 1) + ">&raquo</a></li>");
                }

                request.setAttribute("listaProd", produtos);
                request.setAttribute("qtdProdutos", produtos.size());
                request.setAttribute("totalProdutos", dao.quantidadeProdutosCategoria(categoria));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(FiltroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Comando que ira chamar a JSP passada no parametro
        request.getRequestDispatcher("/produtos.jsp").forward(request, response);
        //Comando que ira chamar a JSP passada no parametro
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

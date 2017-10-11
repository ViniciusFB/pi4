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
@WebServlet(name = "pesquisar", urlPatterns = {"/pesquisar"})
public class PesquisarProdutoServlet extends HttpServlet {

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
        request.setAttribute("idCliente", sessao.getAttribute("idCliente"));
        ProdutoDAO dao = new ProdutoDAO();

        request.setAttribute("listaProd", dao.listar());
        request.getRequestDispatcher("/produtos.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idCliente", sessao.getAttribute("idCliente"));

        List<Produto> produtos;
        ProdutoDAO dao = new ProdutoDAO();

        try {
            String acao = request.getParameter("acao");
            if (acao.equals("pesquisarProduto")) {
                String nome = request.getParameter("nomeProduto");
                if (nome != null) {
                    produtos = dao.pesquisarProduto(nome);
                    request.setAttribute("listaProd", produtos);
                    request.getRequestDispatcher("/produtos.jsp").forward(request, response);

                } else if (nome == null) {
                    request.setAttribute("listaProd", dao.listar());
                    request.getRequestDispatcher("/produtos.jsp").forward(request, response);

                }

            } else if (acao.equals(null) || acao == null) {
                request.setAttribute("listaProd", dao.listar());
                request.getRequestDispatcher("/produtos.jsp").forward(request, response);

            } else if (acao.equals("categoria")) {
                String categoria = request.getParameter("category");

                produtos = dao.filtrarPorCategoria(categoria, "n");
                request.setAttribute("listaProd", produtos);
                request.getRequestDispatcher("/produtos.jsp").forward(request, response);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        }

        //Comando que ira chamar a JSP passada no parametro
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

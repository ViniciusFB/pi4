/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.servlets;

import br.senac.tads.pi4.dao.ProdutoDAO;
import br.senac.tads.pi4.dao.VendaDAO;
import br.senac.tads.pi4.models.Produto;
import br.senac.tads.pi4.models.Venda;
import java.io.IOException;
import java.sql.Date;
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
@WebServlet(name = "RelatorioServlet", urlPatterns = {"/relatorios"})
public class RelatorioServlet extends HttpServlet {

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

        try {
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> produtos = dao.listarFaltaDeProdutos();
            request.setAttribute("listaProdutos", produtos);

            request.getRequestDispatcher("/relatorios.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

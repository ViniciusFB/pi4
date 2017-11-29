/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.ContatoDAO;
import br.senac.tads.pi4.dao.VendaDAO;
import br.senac.tads.pi4.models.Contato;
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
@WebServlet(name = "mensagens", urlPatterns = {"/mensagens"})
public class MensagemServlet extends HttpServlet {

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
            ContatoDAO dao = new ContatoDAO();
            List<Contato> mensagens = dao.listar();
            request.setAttribute("listaMensagens", mensagens);

            request.getRequestDispatcher("/mensagens.jsp").forward(request, response);

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

        VendaDAO dao = new VendaDAO();
        int idUsuario = (int) sessao.getAttribute("idUsuario");
        String dataI = request.getParameter("dataInicial");
        String dataF = request.getParameter("dataFinal");

        if (dataI == null || dataF == null || dataI.equals("") || dataF.equals("")) {
            List<Venda> vendas = dao.listar(idUsuario);
            request.setAttribute("listaCompras", vendas);
        } else {
            Date dataInicial = Date.valueOf(dataI);
            Date dataFinal = Date.valueOf(dataF);
            List<Venda> vendas = dao.filtrar(idUsuario, dataInicial, dataFinal);
            request.setAttribute("listaCompras", vendas);
        }

        request.getRequestDispatcher("/WEB-INF/jsp/pedidos.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

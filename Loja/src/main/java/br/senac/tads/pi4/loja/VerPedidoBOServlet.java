/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.VendaDAO;
import br.senac.tads.pi4.dao.VendaProdDAO;
import br.senac.tads.pi4.models.Venda;
import br.senac.tads.pi4.models.VendaProd;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
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
@WebServlet(name = "VerPedidoBOServlet", urlPatterns = {"/visualizarPedidoBackoffice"})
public class VerPedidoBOServlet extends HttpServlet {

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
            int idV = Integer.parseInt(request.getParameter("idVenda"));
            VendaDAO daov = new VendaDAO();
            Venda v = null;

            try {
                v = new Venda((Venda) daov.obterInfoVenda(idV));
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println(e);
                request.setAttribute("erro", "Nenhuma venda foi encontrada com o id informado!");

            }

            int idVenda = Integer.parseInt(request.getParameter("idVenda"));
            VendaProdDAO dao = new VendaProdDAO();
            VendaDAO dao2 = new VendaDAO();
            List<VendaProd> vp = dao.listar(idVenda);
            request.setAttribute("listaProdutos", vp);
            request.setAttribute("idVenda2", v.getId());
            request.setAttribute("valorCompra", dao2.obterValorFinal(idVenda));

            request.getRequestDispatcher("/visualizarPedidoBackoffice.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Venda venda = null;
        VendaDAO dao = new VendaDAO();
        HttpSession sessao = request.getSession();

        request.setAttribute("usuario", sessao.getAttribute("usuario"));

        int idVenda = Integer.parseInt(request.getParameter("idVenda2"));
        int status = Integer.parseInt(request.getParameter("status"));
        Timestamp ultimaAtt = new Timestamp(System.currentTimeMillis());
        Venda v = null;

        try {
            v = new Venda((Venda) dao.obterInfoVenda(idVenda));
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println(e);
            request.setAttribute("erro", "Nenhuma venda foi encontrada com o id informado!");

        }
        Long protocolo = v.getProtocolo();
        int idUsuario = v.getIdCliente();
        Timestamp dataVenda = new Timestamp(System.currentTimeMillis());
        double valorFinal = v.getValorFinal();

        venda = new Venda(protocolo, valorFinal, status, ultimaAtt, idVenda);

        dao.atualizarStatus(venda);
        response.sendRedirect(request.getContextPath() + "/pedidosBackoffice");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

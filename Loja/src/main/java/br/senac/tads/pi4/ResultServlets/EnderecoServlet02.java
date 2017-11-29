/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.ResultServlets;

import br.senac.tads.pi4.dao.UsuarioDAO;
import br.senac.tads.pi4.models.Cliente;
import br.senac.tads.pi4.models.Endereco;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "EnderecoServlet02", urlPatterns = {"/adicionarEndereco"})
public class EnderecoServlet02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/jsp/enderecos.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean erro = false;
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

        UsuarioDAO dao = new UsuarioDAO();

        // Endereços
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");

        if (!erro) {
            // Os dados foram preenchidos corretamente
            Endereco novo = new Endereco(id, cep, rua, numero,
                    complemento, bairro, cidade, uf);

            dao.adicionarEndereco(novo);

//            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/usuario.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/EnderecoServlet01");
        } else {
            // Tem erro no preenchimento dos dados.
            // Reapresenta o formulário para o usuário indicando os erros.
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/404.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

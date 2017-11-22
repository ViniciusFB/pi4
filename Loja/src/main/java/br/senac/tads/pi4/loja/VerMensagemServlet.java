/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.ContatoDAO;
import br.senac.tads.pi4.models.Contato;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
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
@WebServlet(name = "visualizarMensagem", urlPatterns = {"/visualizarMensagem"})
public class VerMensagemServlet extends HttpServlet {

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

        try {
            Long protocolo = Long.parseLong(request.getParameter("protocolo"));
            ContatoDAO dao = new ContatoDAO();
            Contato c = null;

            try {
                c = new Contato((Contato) dao.obterMensagem(protocolo));
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println(e);
                request.setAttribute("erro", "Nenhuma mensagem foi encontrada com o protocolo informado!");

            }

            request.setAttribute("protocolo", c.getProtocolo());
            request.setAttribute("nome", c.getNome());
            request.setAttribute("email", c.getEmail());
            request.setAttribute("motivo", c.getMotivo());
            request.setAttribute("mensagem", c.getMensagem());

            request.getRequestDispatcher("/WEB-INF/jsp/visualizarMensagem.jsp").forward(request, response);

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
        request.setAttribute("idCliente", sessao.getAttribute("idCliente"));
        boolean erro = false;

        // Dados pessoais
        String nome = request.getParameter("nome");
        nome = nome.trim(); // Corta os espaços e garante que um campo em branco não seja cadastrado
        if (nome == null || nome.length() < 3 || nome.equals("")) {
            erro = true;
            request.setAttribute("cliente", "Não foi possível cadastrar o cliente!");
        }
//        Date dataMensagem = new Date(System.currentTimeMillis());
        long protocolo = Long.parseLong(request.getParameter("protocolo"));
        String email = request.getParameter("email");
//        String mensagem = request.getParameter("mensagem");

        if (!erro) {
            // Os dados foram preenchidos corretamente
            ContatoDAO dao = new ContatoDAO();
            dao.atualizarResposta(protocolo);
            request.setAttribute("msg", "Mensagem respondida com sucesso!");
//            this.getServletContext().getRequestDispatcher("/mensagens.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/mensagens");

        } else {
            // Tem erro no preenchimento dos dados.
            // Reapresenta o formulário para o usuário indicando os erros.
            request.setAttribute("msg", "Houve um erro ao enviar sua mensagem");
            RequestDispatcher dispatcher = request.getRequestDispatcher("mensagens.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

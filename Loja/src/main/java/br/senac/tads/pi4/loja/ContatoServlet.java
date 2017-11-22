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
@WebServlet(name = "ContatoServlet", urlPatterns = {"/contato"})
public class ContatoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean erro = false;
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));

        // Dados pessoais
        String nome = request.getParameter("nome");
        nome = nome.trim(); // Corta os espaços e garante que um campo em branco não seja cadastrado
        if (nome == null || nome.length() < 3 || nome.equals("")) {
            erro = true;
            request.setAttribute("cliente", "Não foi possível cadastrar o cliente!");
        }
        String sobrenome = request.getParameter("sobrenome");
        sobrenome = sobrenome.trim();
        if (sobrenome == null || sobrenome.length() < 1 || sobrenome.equals("")) {
            erro = true;
            request.setAttribute("cliente", "Não foi possível cadastrar o cliente!");
        }
        Date dataMensagem = new Date(System.currentTimeMillis());
//        long protocolo = (long) (1000000000 + Math.random() * 999999999);
        String email = request.getParameter("email");
        String motivo = request.getParameter("motivo");
        String mensagem = request.getParameter("mensagem");

        if (!erro) {
            // Os dados foram preenchidos corretamente
            Contato novo = new Contato(nome, sobrenome, email, motivo, mensagem, dataMensagem, false);
            ContatoDAO dao = new ContatoDAO();
            dao.incluirComTransacao(novo);
            long protocol = novo.getProtocolo();
            request.setAttribute("sucesso", 1);
            request.setAttribute("msg", "Mensagem enviada com sucesso!");
            request.setAttribute("protocolo", protocol);
            this.getServletContext().getRequestDispatcher("/contato.jsp").forward(request, response);
        } else {
            // Tem erro no preenchimento dos dados.
            // Reapresenta o formulário para o usuário indicando os erros.
            request.setAttribute("msg", "Houve um erro ao enviar sua mensagem");
            RequestDispatcher dispatcher = request.getRequestDispatcher("contato.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

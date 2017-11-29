/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.ResultServlets;

import br.senac.tads.pi4.dao.UsuarioDAO;
import br.senac.tads.pi4.models.Funcionario;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
@WebServlet(name = "CadastrarFuncServlet02", urlPatterns = {"/cadastrarFuncionario"})
public class CadastrarFuncServlet02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/jsp/cadastroRealizado.jsp");
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
        Date dataNasc = Date.valueOf(request.getParameter("dataNasc"));
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        int nivel = Integer.parseInt(request.getParameter("nivel"));

        if (!erro) {
            // Os dados foram preenchidos corretamente
            Funcionario novo = new Funcionario(nome, sobrenome, dataNasc, cpf, email, telefone, md5(senha), 1);
            UsuarioDAO dao = new UsuarioDAO();
            dao.incluirComTransacao(novo);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/cadastroRealizado.jsp").forward(request, response);
        } else {
            // Tem erro no preenchimento dos dados.
            // Reapresenta o formulário para o usuário indicando os erros.
            RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarFuncionario.jsp");
            dispatcher.forward(request, response);
        }
    }

    // Md5 gera senha criptografada 
    public static String md5(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.ResultServlets;

import br.senac.tads.pi4.dao.ClienteDAO;
import br.senac.tads.pi4.dao.EnderecoDAO;
import br.senac.tads.pi4.models.Cliente;
import br.senac.tads.pi4.models.Endereco;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Statement;
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
@WebServlet(name = "CadastrarCliServlet02", urlPatterns = {"/CadastrarCliServlet02"})
public class CadastrarCliServlet02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/jsp/registro.jsp");
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

        // Endereços
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");

        if (!erro) {
            // Os dados foram preenchidos corretamente
            Cliente novo = new Cliente(nome, sobrenome, dataNasc, cpf, email, telefone, md5(senha), cep, rua, numero,
            complemento, bairro, cidade, uf);

//            Endereco end = new Endereco(cep, rua, numero, complemento, bairro, municipio, uf); fail

            ClienteDAO dao = new ClienteDAO();
//            EnderecoDAO daoEnd = new EnderecoDAO(); fail
            dao.incluirComTransacao(novo);
//            daoEnd.incluirComTransacao(end); fail

//            request.setAttribute("cliente", "Cliente: ''" + nome + "'' foi cadastrado com sucesso!!");
//            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/cadastrarCliente.jsp").forward(request, response);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/registro.jsp").forward(request, response);
        } else {
            // Tem erro no preenchimento dos dados.
            // Reapresenta o formulário para o usuário indicando os erros.
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registro.jsp");
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

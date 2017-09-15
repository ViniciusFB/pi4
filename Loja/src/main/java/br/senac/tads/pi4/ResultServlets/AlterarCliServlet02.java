/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.ResultServlets;

import br.senac.tads.pi4.dao.ClienteDAO;
import br.senac.tads.pi4.models.Cliente;
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
 * @author vinicius.fbatista1
 */
@WebServlet(name = "DadosAlterados", urlPatterns = {"/DadosAlterados"})
public class AlterarCliServlet02 extends HttpServlet {

    /**
     * Neste exemplo, somente apresenta a tela do formulário
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        RequestDispatcher dispatcher
//                = request.getRequestDispatcher("alterarProd.jsp");
//        dispatcher.forward(request, response);
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
        Cliente cliente = null;
        ClienteDAO dao = new ClienteDAO();
        HttpSession sessao = request.getSession();

        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idCliente", sessao.getAttribute("idCliente"));

        int id = Integer.parseInt(request.getParameter("idCliente"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        Date dataNasc = Date.valueOf(request.getParameter("dataNasc"));
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

        cliente = new Cliente(nome, sobrenome, dataNasc, cpf, email, telefone, id);

        dao.atualizarCliente(cliente);


        request.setAttribute("mensagem", "Dados alterados com sucesso. Faça o login novamente para confirmar as mudanças.");

        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/usuario.jsp");
        dispatcher.forward(request, response);

    }
}

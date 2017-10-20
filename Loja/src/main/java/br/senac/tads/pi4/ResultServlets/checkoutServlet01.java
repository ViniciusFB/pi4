/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.ResultServlets;

import br.senac.tads.pi4.dao.EnderecoDAO;
import br.senac.tads.pi4.models.Endereco;
import java.io.IOException;
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
@WebServlet(name = "checkout1", urlPatterns = {"/checkout1"})
public class checkoutServlet01 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idCliente", sessao.getAttribute("idCliente"));
        request.setAttribute("idEndereco", sessao.getAttribute("idEndereco"));

        String idEnd = "" + sessao.getAttribute("idEndereco");
        if (idEnd == null) {
            request.getRequestDispatcher("WEB-INF/jsp/checkout.jsp").forward(request, response);

        } else {

            Endereco endereco = null;
            EnderecoDAO dao = new EnderecoDAO();
            int idEndereco = Integer.parseInt(idEnd);

            try {
                endereco = new Endereco((Endereco) dao.obterEndereco(idEndereco));
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println(e);

            }
//            request.setAttribute("idEndereco", endereco.getId());
            request.setAttribute("cep", endereco.getCep());
            request.setAttribute("rua", endereco.getRua());
            request.setAttribute("bairro", endereco.getBairro());
            request.setAttribute("cidade", endereco.getCidade());
            request.setAttribute("uf", endereco.getUf());
            request.setAttribute("numero", endereco.getNumeroCasa());
            request.setAttribute("complemento", endereco.getComplemento());
            request.setAttribute("listaEnderecos", dao.listar(Integer.parseInt(sessao.getAttribute("idCliente").toString())));
            request.getRequestDispatcher("WEB-INF/jsp/checkout.jsp").forward(request, response);

        }

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

//        Cliente cliente = null;
//        ClienteDAO dao = new ClienteDAO();
//        try {
//            cliente = new Cliente((Cliente) dao.obterCliente(Integer.parseInt(request.getParameter("idCliente"))));
//        } catch (NullPointerException | NumberFormatException e) {
//            System.out.println(e);
//            request.setAttribute("erro", "Nenhum cliente foi encontrado com o ID informado!");
//
//        }
        request.setAttribute("idCliente", sessao.getAttribute("idCliente"));
        EnderecoDAO dao = new EnderecoDAO();

        request.setAttribute("listaEnderecos", dao.listar(Integer.parseInt(sessao.getAttribute("idCliente").toString())));

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/checkout.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

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
@WebServlet(name = "checkout01", urlPatterns = {"/checkout01"})
public class EnderecoServlet03 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idCliente", sessao.getAttribute("idCliente"));

        int id = Integer.parseInt(request.getParameter("idCliente"));
        EnderecoDAO dao = new EnderecoDAO();
        String endSelecionado = request.getParameter("endSelecionado");

//        String cep = request.getParameter("cep");
        try {

            if (!endSelecionado.equals("")) {
                Endereco endereco = new Endereco((Endereco) dao.obterEnderecoIdCliCep(id, endSelecionado));
                sessao.setAttribute("idEndereco", endereco.getId());
                request.setAttribute("cep", endereco.getCep());
                request.setAttribute("rua", endereco.getRua());
                request.setAttribute("bairro", endereco.getBairro());
                request.setAttribute("cidade", endereco.getCidade());
                request.setAttribute("uf", endereco.getUf());
                request.setAttribute("numero", endereco.getNumeroCasa());
                request.setAttribute("complemento", endereco.getComplemento());

            }
            request.setAttribute("listaEnderecos", dao.listar(Integer.parseInt(sessao.getAttribute("idCliente").toString())));
            request.getRequestDispatcher("/WEB-INF/jsp/checkout1.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Erro ao encontrar endereço " + e);
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idCliente", sessao.getAttribute("idCliente"));

//        int id = Integer.parseInt(request.getParameter("idCliente"));
        int id = (int) sessao.getAttribute("idCliente");
        EnderecoDAO dao = new EnderecoDAO();
        String endSelecionado = request.getParameter("endSelecionado");

//        String cep = request.getParameter("cep");
        try {

            if (!endSelecionado.equals("")) {
                Endereco endereco = new Endereco((Endereco) dao.obterEnderecoIdCliCep(id, endSelecionado));
//                request.setAttribute("idEndereco", endereco.getId());
                sessao.setAttribute("idEndereco", endereco.getId());
                request.setAttribute("cep", endereco.getCep());
                request.setAttribute("rua", endereco.getRua());
                request.setAttribute("bairro", endereco.getBairro());
                request.setAttribute("cidade", endereco.getCidade());
                request.setAttribute("uf", endereco.getUf());
                request.setAttribute("numero", endereco.getNumeroCasa());
                request.setAttribute("complemento", endereco.getComplemento());

            }
            request.setAttribute("listaEnderecos", dao.listar(Integer.parseInt(sessao.getAttribute("idCliente").toString())));
            request.getRequestDispatcher("/WEB-INF/jsp/checkout1.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Erro ao encontrar endereço " + e);
            request.getRequestDispatcher("/404.jsp").forward(request, response);
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
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

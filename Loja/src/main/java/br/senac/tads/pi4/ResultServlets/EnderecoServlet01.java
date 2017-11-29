/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.ResultServlets;

import br.senac.tads.pi4.dao.UsuarioDAO;
import br.senac.tads.pi4.dao.EnderecoDAO;
import br.senac.tads.pi4.models.Cliente;
import br.senac.tads.pi4.models.Endereco;
import br.senac.tads.pi4.models.Usuario;
import java.io.IOException;
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
@WebServlet(name = "EnderecoServlet01", urlPatterns = {"/EnderecoServlet01"})
public class EnderecoServlet01 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

        String acao = request.getParameter("acao");
        if (acao == null) {

            Usuario usuario = null;
            UsuarioDAO daoC = new UsuarioDAO();
            try {
                usuario = new Usuario((Usuario) daoC.obterUsuario(Integer.parseInt(sessao.getAttribute("idUsuario").toString())));
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println(e);
                request.setAttribute("erro", "Nenhum cliente foi encontrado com o ID informado!");

            }

            EnderecoDAO daoE = new EnderecoDAO();
            List<Endereco> enderecos = null;
            enderecos = daoE.listar(Integer.parseInt(sessao.getAttribute("idUsuario").toString()));

            request.setAttribute("nome", usuario.getNome());
            request.setAttribute("sobrenome", usuario.getSobrenome());
            request.setAttribute("listaEnderecos", enderecos);
            request.getRequestDispatcher("WEB-INF/jsp/enderecos.jsp").forward(request, response);
        } else if (acao.equals("removerEndereco")) {
            EnderecoDAO daoE = new EnderecoDAO();
            int idEndereco = Integer.parseInt(request.getParameter("idEndereco"));
            daoE.excluirEndereco(idEndereco);
            List<Endereco> enderecos = null;
            enderecos = daoE.listar(Integer.parseInt(sessao.getAttribute("idUsuario").toString()));
            request.setAttribute("listaEnderecos", enderecos);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/enderecos.jsp").forward(request, response);
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

        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));
        EnderecoDAO dao = new EnderecoDAO();
        List<Endereco> enderecos = null;
        enderecos = dao.listar(Integer.parseInt(sessao.getAttribute("idUsuario").toString()));

        request.setAttribute("listaEnderecos", enderecos);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/enderecos.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

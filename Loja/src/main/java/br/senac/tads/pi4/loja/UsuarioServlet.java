/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.UsuarioDAO;
import br.senac.tads.pi4.models.Cliente;
import br.senac.tads.pi4.models.Usuario;
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
@WebServlet(name = "usuario", urlPatterns = {"/usuario"})
public class UsuarioServlet extends HttpServlet {

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

        Usuario usuario = null;
        UsuarioDAO dao = new UsuarioDAO();
        try {
            usuario = new Usuario((Usuario) dao.obterUsuario(Integer.parseInt(sessao.getAttribute("idUsuario").toString())));
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println(e);
            request.setAttribute("erro", "Nenhum cliente foi encontrado com o ID informado!");

        }

        request.setAttribute("nome", usuario.getNome());
        request.setAttribute("sobrenome", usuario.getSobrenome());
        request.setAttribute("dataNasc", usuario.getDataNasc());
        request.setAttribute("cpf", usuario.getCpf());
        request.setAttribute("email", usuario.getEmail());
        request.setAttribute("telefone", usuario.getTelefone());

        request.getRequestDispatcher("WEB-INF/jsp/usuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

        //Comando que ira chamar a JSP passada no parametro
        request.getRequestDispatcher("WEB-INF/jsp/usuario.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

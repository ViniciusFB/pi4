/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.ClienteDAO;
import br.senac.tads.pi4.models.Cliente;
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
 * @author Vinicius Ferreira Batista
 */
@WebServlet(name = "ClienteServlet01", urlPatterns = {"/ClienteServlet01"})
public class ClienteServlet01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> cliente = dao.listar();

        request.setAttribute("listaClientes", cliente);

        //Comando que ira chamar a JSP passada no parametro
        request.getRequestDispatcher("WEB-INF/jsp/clientes.jsp").forward(request, response);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.ProdutoDAO;
import br.senac.tads.pi4.models.Produto;
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
@WebServlet(name = "detalhes", urlPatterns = {"/detalhes"})
public class DetalheServlet extends HttpServlet {

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

        Produto produto = null;
        ProdutoDAO dao = new ProdutoDAO();

//        request.setAttribute("listaProdutos", dao.listar());
        //Comando que ira chamar a JSP passada no parametro
        try {
            produto = new Produto((Produto) dao.obterProdutoByCod(Integer.parseInt(request.getParameter("c"))));
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println(e);
            request.setAttribute("erro", "Nenhum produto foi encontrado com o codigo informado!");

        }
        
        request.setAttribute("c", produto.getCodigo());
        request.setAttribute("nomeProduto", produto.getNome());
        request.setAttribute("valorProduto", produto.getValor());
        request.setAttribute("descricao", produto.getDescricao());
        request.setAttribute("imagem", produto.getImagem());
        
        request.getRequestDispatcher("/detalhes.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idCliente", sessao.getAttribute("idCliente"));

        //Comando que ira chamar a JSP passada no parametro
        request.getRequestDispatcher("WEB-INF/jsp/usuario.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

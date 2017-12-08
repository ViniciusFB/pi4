/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.ResultServlets;

import br.senac.tads.pi4.dao.ProdutoDAO;
import br.senac.tads.pi4.models.Produto;
import br.senac.tads.pi4.models.Usuario;
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
@WebServlet(name = "AlterarProdutoServlet", urlPatterns = {"/editarProduto"})
public class AlterarProdutoServlet extends HttpServlet {

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
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            ProdutoDAO dao = new ProdutoDAO();
            Produto p = null;

            try {
                p = new Produto((Produto) dao.obterProdutoByCod(codigo));
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println(e);
                request.setAttribute("erro", "Nenhuma mensagem foi encontrada com o codigo informado!");

            }

            request.setAttribute("idProduto", p.getId());
            request.setAttribute("nomeProduto", p.getNome());
            request.setAttribute("codigo", p.getCodigo());
            request.setAttribute("quantidade", p.getQuantidade());
            request.setAttribute("valorProduto", p.getValor());

            request.getRequestDispatcher("/WEB-INF/jsp/editarProduto.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
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
        boolean erro = false;
        Produto produto = null;
        ProdutoDAO dao = new ProdutoDAO();
        HttpSession sessao = request.getSession();

        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

        int id = Integer.parseInt(request.getParameter("idProduto"));
        String nome = request.getParameter("nomeProduto");
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double valor = Double.parseDouble(request.getParameter("valorProduto"));

        produto = new Produto(nome, codigo, quantidade, valor, id);

        dao.atualizarProduto(produto);

        request.setAttribute("mensagem", "Dados alterados com sucesso.");

//        RequestDispatcher dispatcher
//                = request.getRequestDispatcher("/relatorios");
//        dispatcher.forward(request, response);
        response.sendRedirect(request.getContextPath() + "/estoque");

    }
}

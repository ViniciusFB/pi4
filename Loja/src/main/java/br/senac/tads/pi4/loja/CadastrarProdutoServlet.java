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
 * @author Vinicius Ferreira Batista
 */
@WebServlet("/CadastrarProduto")
public class CadastrarProdutoServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        String nome = request.getParameter("nome");
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String categorias = request.getParameter("categorias");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String descricao = request.getParameter("descricao");
        double valor = Double.parseDouble(request.getParameter("valor"));
        String imagem = request.getParameter("imglink");

        Produto novo = new Produto(nome, codigo, categorias, quantidade, descricao, valor, imagem);

        ProdutoDAO dao = new ProdutoDAO();

        dao.incluirComTransacao(novo);

        request.setAttribute("mensagem", "Produto " +nome+ " inserido no estoque com sucesso" );
        
        this.getServletContext().getRequestDispatcher("/cadastroProduto.jsp").forward(request, response);

    }
}

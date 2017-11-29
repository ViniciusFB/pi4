/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.ResultServlets;

import br.senac.tads.pi4.dao.EnderecoDAO;
import br.senac.tads.pi4.loja.LoginServlet;
import br.senac.tads.pi4.models.CarrinhoDeCompra;
import br.senac.tads.pi4.models.Endereco;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));
        CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");

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
            request.setAttribute("listaEnderecos", dao.listar(Integer.parseInt(sessao.getAttribute("idUsuario").toString())));
            sessao.setAttribute("cepDestino", endereco.getCep());
//            sessao.setAttribute("valorTotal", carrinho.calculaTotal());
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
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));
        request.setAttribute("idEndereco", sessao.getAttribute("idEndereco"));
        request.setAttribute("urlPage", sessao.getAttribute("urlPage"));

        CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
        URI uri;
        String pagina = "";
        String urlPage = (String) sessao.getAttribute("urlPage");

        try {
            uri = new URI(urlPage);
            pagina = new File(uri.getPath()).getName();
        } catch (URISyntaxException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (pagina.equals("carrinho")) {
            pagina = "carrinho";
        }
        if (carrinho == null) {
            request.setAttribute("erro", "Você não pode finalizar uma compra sem itens no carrinho");
            this.getServletContext().getRequestDispatcher("/carrinho.jsp").forward(request, response);
        }
        if (!carrinho.getItens().isEmpty()) {

            request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));
            EnderecoDAO dao = new EnderecoDAO();
//            sessao.setAttribute("valorTotal", carrinho.calculaTotal());

            request.setAttribute("listaEnderecos", dao.listar(Integer.parseInt(sessao.getAttribute("idUsuario").toString())));

            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/checkout.jsp").forward(request, response);
        } else {
            request.setAttribute("erro", "Você não pode finalizar uma compra sem itens no carrinho");
            this.getServletContext().getRequestDispatcher("/carrinho.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

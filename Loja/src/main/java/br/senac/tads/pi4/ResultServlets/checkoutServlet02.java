/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.ResultServlets;

import br.senac.tads.pi4.models.CarrinhoDeCompra;
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
@WebServlet(name = "checkout2", urlPatterns = {"/checkout2"})
public class checkoutServlet02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));
        request.setAttribute("idEndereco", sessao.getAttribute("idEndereco"));
        request.setAttribute("cepDestino", sessao.getAttribute("cepDestino"));
        request.setAttribute("frete", sessao.getAttribute("valorFrete"));

        CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
//        sessao.setAttribute("carrinho", carrinho);

        double vaTotal = round(carrinho.calculaTotal(), 2);
        sessao.setAttribute("valorTotalFrete", vaTotal);

        request.getRequestDispatcher("WEB-INF/jsp/checkout2.jsp").forward(request, response);
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
        request.setAttribute("cepDestino", sessao.getAttribute("cepDestino"));
        request.setAttribute("frete", sessao.getAttribute("valorFrete"));

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/checkout2.jsp").forward(request, response);

    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

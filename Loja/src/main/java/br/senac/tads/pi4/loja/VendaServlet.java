/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.ProdutoDAO;
import br.senac.tads.pi4.dao.VendaDAO;
import br.senac.tads.pi4.dao.VendaProdDAO;
import br.senac.tads.pi4.models.CarrinhoDeCompra;
import br.senac.tads.pi4.models.ItemDeCompra;
import br.senac.tads.pi4.models.Venda;
import br.senac.tads.pi4.models.VendaProd;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "finalizarCompra", urlPatterns = {"/finalizarCompra"})
public class VendaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/jsp/carrinho.jsp");
        dispatcher.forward(request, response);
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
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));
        VendaProdDAO dao = new VendaProdDAO();
        VendaDAO vDao = new VendaDAO();
        ProdutoDAO pDao = new ProdutoDAO();

        CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");

        if (carrinho.getItens().size() < 1) {
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        } else {
            int idUsuario = (int) sessao.getAttribute("idUsuario");
            int idEndereco = (int) sessao.getAttribute("idEndereco"); //Somente quando é escolhido um endereço já existente
            Timestamp dataVenda = new Timestamp(System.currentTimeMillis());
            double valorCompra = carrinho.calculaTotal();
            double valorFrete = Double.parseDouble(sessao.getAttribute("frete").toString());
            double valorTotal = valorCompra + valorFrete;
            long protocolo = (long) (1000000000 + Math.random() * 999999999);
            Timestamp ultimaAtt = new Timestamp(System.currentTimeMillis());
            long numeroCartao = Long.parseLong(request.getParameter("numeroCartao"));
            int numeroParcelas = Integer.parseInt(request.getParameter("numeroParcelas"));
            double calculoParcelas = (valorTotal / numeroParcelas);
            double valorParcelas = round(calculoParcelas, 2);

            Venda venda = new Venda(protocolo, idUsuario, idEndereco, dataVenda, valorTotal, valorFrete, 0, ultimaAtt,
                    numeroCartao, numeroParcelas, valorParcelas);
            vDao.incluirComTransacao(venda);
            int idVenda = venda.getId();
            System.out.println("idVenda = " + idVenda);

            for (ItemDeCompra item : carrinho.getItens()) {
                int idProduto = item.getId();
                Date dataProd = new Date(System.currentTimeMillis());
                String nomeProduto = item.getNome();
                int codigo = item.getCodigo();
                int quantidade = item.getQuantidade();
                int qtdeEstoque = item.getQuantidadeEstoque();
                double valor = item.getValor();
                double total = item.getTotal();
                String imagem = item.getImagem();
                VendaProd vp = new VendaProd(idVenda, idProduto, idUsuario, dataProd, nomeProduto,
                        codigo, quantidade, valor, total, imagem);
                dao.incluirComTransacao(vp);
                if ((qtdeEstoque - quantidade) <= 5 && (qtdeEstoque - quantidade) > 0) {
                    pDao.updateProdutoAcabando(idProduto);
                } else if ((qtdeEstoque - quantidade) == 0) {
                    pDao.updateProdutoEsgotado(idProduto);
                }
                try {
                    pDao.updateQuantidade(idProduto, quantidade, qtdeEstoque, "Venda");
                } catch (SQLException ex) {
                    Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

//        sessao.invalidate();
            sessao.removeAttribute("carrinho");
            sessao.removeAttribute("valorTotal");
            sessao.removeAttribute("numItens");
            sessao.removeAttribute("idEndereco");
            sessao.removeAttribute("cepDestino");
            sessao.removeAttribute("frete");
            sessao.removeAttribute("diasUteis");
//            request.setAttribute("sucesso", 1);
            request.setAttribute("msg", "Compra finalizada com sucesso. Verifique o protocolo e acompanhe seu pedido!");
            request.setAttribute("protocolo", "Protocolo: " + venda.getProtocolo());
//            response.sendRedirect(request.getContextPath() + "/pedidos");
            getServletContext().getRequestDispatcher("/pedidos").forward(request, response);

        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.ProdutoDAO;
import br.senac.tads.pi4.models.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "produtos", urlPatterns = {"/produtos"})
public class ProdutoServlet extends HttpServlet {

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

        try {
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> produtos = null;
            String numeroPagina = request.getParameter("numeroPagina");
            int numPagina = Integer.parseInt(request.getParameter("numeroPagina"));
            String categoria = request.getParameter("category");

//            produtos = dao.consultaPaginada(numeroPagina);
            if (categoria == null || categoria.equals("")) {
                produtos = dao.consultaPaginada(numeroPagina);
            } else {
                produtos = dao.filtrarPorCategoria(categoria, numeroPagina);
            }
            if (produtos.isEmpty()) {
                numeroPagina = "" + (Integer.parseInt(numeroPagina) - 1);
            }
            //Comando que ira chamar a JSP passada no parametro
            request.setAttribute("listaProd", produtos);
            request.setAttribute("numeroPagina", (numeroPagina != null ? numeroPagina : 1));

            int quantidadePagina = dao.quantidadePagina();
            request.setAttribute("quantidadePagina", quantidadePagina);
            if (quantidadePagina > 0) {
                if (numPagina <= quantidadePagina && (numPagina - 1) > 0) {
                    request.setAttribute("laquo", "<li><a href=produtos?numeroPagina=" + (numPagina - 1) + ">&laquo</a></li>");
                }
            }
            if (quantidadePagina > numPagina) {

                request.setAttribute("raquo", "<li><a href=produtos?numeroPagina=" + (numPagina + 1) + ">&raquo</a></li>");
            }
            System.out.println("Quantidade de Páginas = " + quantidadePagina);
            System.out.println("Página Atual = " + numPagina);
//            System.out.println("Qtde Produtos na página: " + produtos.size());
            request.setAttribute("qtdProdutos", produtos.size());
            request.setAttribute("totalProdutos", dao.quantidadeProdutos());

            request.getRequestDispatcher("/produtos.jsp?quantidadePagina=" + quantidadePagina
                    + "&numeroPagina=" + numeroPagina + "&category=" + categoria).forward(request, response);

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            request.getRequestDispatcher("/produtos.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        request.setAttribute("idCliente", sessao.getAttribute("idCliente"));

        List<Produto> produtos = null;
        ProdutoDAO dao = new ProdutoDAO();

        try {
            String categoria = request.getParameter("category");
            String numeroPagina = request.getParameter("numeroPagina");
            int numPagina = 0;

            produtos = dao.filtrarPorCategoria(categoria, numeroPagina);
            if (produtos.isEmpty()) {
                numeroPagina = "" + (Integer.parseInt(numeroPagina) - 1);
                numPagina = Integer.parseInt(numeroPagina);
            }
            //Comando que ira chamar a JSP passada no parametro
            request.setAttribute("listaProd", produtos);
            request.setAttribute("numeroPagina", (numeroPagina != null ? numeroPagina : 1));
            request.setAttribute("category", categoria);
            System.out.println("CATEGORIA: " + categoria);

            int quantidadePagina = dao.quantidadePaginaCategoria(categoria);
            request.setAttribute("quantidadePagina", quantidadePagina);
            if (quantidadePagina > 0) {
                if (numPagina <= quantidadePagina && (numPagina - 1) > 0) {
                    request.setAttribute("laquo", "<li><a href=produtos?numeroPagina=" + (numPagina - 1) + ">&laquo</a></li>");
                }
            }
            if (quantidadePagina > numPagina) {

                request.setAttribute("raquo", "<li><a href=produtos?numeroPagina=" + (numPagina + 1) + ">&raquo</a></li>");
            }
            System.out.println("Quantidade de Páginas = " + quantidadePagina);
            System.out.println("Página Atual = " + numeroPagina);

//            produtos = dao.filtrarPorCategoria(categoria, numeroPagina);
            request.setAttribute("listaProd", produtos);
//            System.out.println("Qtde Produtos na página: " + produtos.size());
            request.setAttribute("qtdProdutos", produtos.size());
            request.setAttribute("totalProdutos", dao.quantidadeProdutosCategoria(categoria));

            request.getRequestDispatcher("/WEB-INF/jsp/filtroProdutos.jsp?category=" + categoria + "&quantidadePagina=" + quantidadePagina
                    + "&numeroPagina=" + numeroPagina).forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

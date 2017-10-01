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

            produtos = dao.consultaPaginada(numeroPagina);
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
//                int i = 1;
                for (int i = 1; i <= quantidadePagina; i++) {

                    if (i == numPagina) {
                        request.setAttribute("pagina", "<li><a class=${active} href=produtos?numeroPagina=" + i + ">" + i + "</a></li>");
                        request.setAttribute("active", "active");
//                        i++;
                    } else {
                        request.setAttribute("pagina", "<li><a href=produtos?numeroPagina=" + i + ">" + i + "</a></li>");
//                        i++;
                    }
                }
            } else {
                request.setAttribute("pagina", "<a href=produtos?numeroPagina=1>" + 1 + "</a>");
            }
            if (quantidadePagina > numPagina) {

                request.setAttribute("raquo", "<li><a href=produtos?numeroPagina=" + (numPagina + 1) + ">&raquo</a></li>");
            }
            System.out.println("Quantidade de Páginas = " + quantidadePagina);
            System.out.println("Página Atual = " + numeroPagina);
            request.getRequestDispatcher("/produtos.jsp?quantidadePagina=" + quantidadePagina
                    + "&numeroPagina=" + numeroPagina).forward(request, response);

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

        List<Produto> produtos;
        ProdutoDAO dao = new ProdutoDAO();

        try {
            String acao = request.getParameter("acao");
            if (acao.equals("pesquisarProduto")) {
                String nome = request.getParameter("nomeProduto");
                if (nome != null) {
                    produtos = dao.pesquisarProduto(nome);
                    request.setAttribute("listaProd", produtos);
                } else if (nome == null) {
                    request.setAttribute("listaProd", dao.listar());
                }

            } else if (acao.equals(null) || acao == null) {
                request.setAttribute("listaProd", dao.listar());
            } else if (acao.equals("categoria")) {
                String categoria = request.getParameter("category");

                produtos = dao.filtrarPorCategoria(categoria);
                request.setAttribute("listaProd", produtos);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        }

        //Comando que ira chamar a JSP passada no parametro
        request.getRequestDispatcher("/produtos.jsp").forward(request, response);
        //Comando que ira chamar a JSP passada no parametro
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

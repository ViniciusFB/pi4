package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.ClienteDAO;
import br.senac.tads.pi4.dao.ProdutoDAO;
import br.senac.tads.pi4.models.CarrinhoDeCompra;
import br.senac.tads.pi4.models.Cliente;
import br.senac.tads.pi4.models.ItemDeCompra;
import br.senac.tads.pi4.models.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "carrinho", urlPatterns = {"/carrinho"})
public class ControleCarrinho extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        Cliente cliente = null;
//        ClienteDAO dao = new ClienteDAO();
//        try {
//            cliente = new Cliente((Cliente) dao.obterCliente(Integer.parseInt(request.getParameter("idCliente"))));
//        } catch (NullPointerException | NumberFormatException e) {
//            System.out.println(e);
//            request.setAttribute("erro", "Nenhum cliente foi encontrado com o ID informado!");
//            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/vendas.jsp").forward(request, response);
//
//        }
//        HttpSession sessao = request.getSession();

        try {
            String acao = request.getParameter("acao");

            if (acao.equals("addProduto")) {
                //recupera o id do produto que deve ser add no carrinho
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                //flag para controle de inserção de novos produtos no carrinho
                boolean existe = false;
                //recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();
                //recupera um carrinho de produtos da sessão
                //se não exite um carrinho na sessão o valor será igual a null
                CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
                request.setAttribute("usuario", sessao.getAttribute("usuario"));
                request.setAttribute("idCliente", sessao.getAttribute("idCliente"));

                //verifica se já exista um carrinho na sessao
                if (carrinho == null) {
//cria um carrinho

                    carrinho = new CarrinhoDeCompra();
                    sessao.setAttribute("carrinho", carrinho);
                }
                //verifica se o produto existe no carrinho
                if (carrinho.getItens() != null) {
                    for (ItemDeCompra item : carrinho.getItens()) {
                        if (item.getProduto().getId() == idProduto) {
                            //incrementa a quantidade
                            item.setQuantidade(item.getQuantidade() + 1);
                            existe = true;
                        }
                    }
                }
                //se não existe o item ou produto, cria um novo
                if (existe == false) {
                    //encontra o produto no banco
                    Produto produto = new ProdutoDAO().consultarPorId(idProduto);
                    //cria um novo item
                    ItemDeCompra novoItem = new ItemDeCompra();
                    novoItem.setProduto(produto);
                    novoItem.setQuantidade(1);
                    //adiciona novo item
                    carrinho.addNovoItem(novoItem);
                }
                //carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
            }//fim addProduto
            else if (acao.equals("removeProduto")) {
                //recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();
                //recupera um carrinho de produtos da sessão
                CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
                //recupera o id do produto
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                ItemDeCompra itemRemove = new ItemDeCompra();
                Produto prodRemove = new Produto();
                prodRemove.setId(idProduto);
                itemRemove.setProduto(prodRemove);
                carrinho.removerItem(itemRemove);

//carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
            } else if (acao.equals("cancelaCompra")) {
                //recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();

                //remove o carrinho da sessão
                sessao.removeAttribute("carrinho");
                sessao.removeAttribute("idCliente");
//                sessao.setAttribute("erro", "A venda foi cancelada");

                //redireciona para pagina principal
//                response.sendRedirect("/projetox/VendaServlet01");
                response.sendRedirect("/Loja/index");

            }
        } catch (Exception erro) {
            request.setAttribute("erro", erro);
            System.out.println("ERRO: "+erro);
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

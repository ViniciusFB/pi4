package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.ProdutoDAO;
import br.senac.tads.pi4.models.CarrinhoDeCompra;
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
                request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

                //verifica se já exista um carrinho na sessao
                if (carrinho == null) {
                    //cria um carrinho

                    carrinho = new CarrinhoDeCompra();
                    sessao.setAttribute("carrinho", carrinho);
                    sessao.setAttribute("numItens", 0);
                }
                //verifica se o produto existe no carrinho
                if (carrinho.getItens() != null) {
                    for (ItemDeCompra item : carrinho.getItens()) {
                        if (item.getProduto().getId() == idProduto) {
                            //incrementa a quantidade
                            Produto produto = new Produto();
                            item.setQuantidadeEstoque(produto.getQuantidade());
                            int qtdeEstoque = item.getQuantidadeEstoque();
                            int qtd = item.getQuantidade();

                            if (qtd != qtdeEstoque) {

                                item.setQuantidade(qtd + 1);
                                addProduto(request, sessao);
                            } else {
//                                sessao.setAttribute("mensagem", "O estoque para esse produto está esgotado");
                            }
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
                    addProduto(request, sessao);
                }
                //carrega a pagina do carrinho de compras
                double vaTotal = round(carrinho.calculaTotal(), 2);
                sessao.setAttribute("valorTotal", vaTotal);
                request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
            }//fim addProduto
            if (acao.equals("delUnidade")) {
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
                request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

                //verifica se o produto existe no carrinho
                if (carrinho.getItens() != null) {
                    for (ItemDeCompra item : carrinho.getItens()) {
                        if (item.getProduto().getId() == idProduto) {
                            //incrementa a quantidade
                            item.setQuantidade(item.getQuantidade() - 1);
                            delUnidade(request, sessao);

                            existe = true;
                        }
                    }
                }
                //se não existe o item ou produto, cria um novo
                if (existe == false) {
                    System.out.println("Não existe nenhum produto no carrinho");
                }
                //carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
            }//fim delUnidade
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
                int qtdRemove = itemRemove.getQuantidade();
                System.out.println("QTD Remove = " + qtdRemove);
                carrinho.removerItem(itemRemove);
                double vaTotal = round(carrinho.calculaTotal(), 2);
                sessao.setAttribute("valorTotal", vaTotal);
                removeProduto(request, sessao, qtdRemove);
//carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
            } else if (acao.equals("cancelaCompra")) {
                //recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();

                //remove o carrinho da sessão
                sessao.removeAttribute("carrinho");
                sessao.removeAttribute("idUsuario");
//                sessao.setAttribute("erro", "A venda foi cancelada");

                //redireciona para pagina principal
//                response.sendRedirect("/projetox/VendaServlet01");
                response.sendRedirect("/Loja/index");

            }
        } catch (Exception erro) {
            request.setAttribute("erro", erro);
            System.out.println("ERRO: " + erro);
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String acao = request.getParameter("acao");

        if (acao == null) {
            HttpSession sessao = request.getSession();

            String url = request.getRequestURL().toString();
            sessao.setAttribute("urlPage", url);
            request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
        } else if (acao.equals("removeProduto")) {
            HttpSession sessao = request.getSession();
            //recupera um carrinho de produtos da sessão
            CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
            //recupera o id do produto
            int idProduto = Integer.parseInt(request.getParameter("idProduto"));
            ItemDeCompra itemRemove = new ItemDeCompra();
            Produto prodRemove = new Produto();
            prodRemove.setId(idProduto);
            itemRemove.setProduto(prodRemove);
            if (carrinho.getItens() != null) {
                for (ItemDeCompra item : carrinho.getItens()) {
                    if (item.getProduto().getId() == idProduto) {
                        int qtdRemove = item.getQuantidade();
                        removeProduto(request, sessao, qtdRemove);
                    }
                }
            }
            carrinho.removerItem(itemRemove);
            double vaTotal = round(carrinho.calculaTotal(), 2);
            sessao.setAttribute("valorTotal", vaTotal);
//carrega a pagina do carrinho de compras
            request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
        } else if (acao.equals("delUnidade")) {
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
            request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

            //verifica se o produto existe no carrinho
            if (carrinho.getItens() != null) {
                for (ItemDeCompra item : carrinho.getItens()) {
                    if (item.getProduto().getId() == idProduto) {
                        //incrementa a quantidade
                        item.setQuantidade(item.getQuantidade() - 1);
                        double vaTotal = round(carrinho.calculaTotal(), 2);
                        sessao.setAttribute("valorTotal", vaTotal);
                        delUnidade(request, sessao);
                        existe = true;
                    }
                }
            }
            //se não existe o item ou produto, cria um novo
            if (existe == false) {
                System.out.println("Não existe nenhum produto no carrinho");
            }
            //carrega a pagina do carrinho de compras
            request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
        }//fim delUnidade
        else if (acao.equals("addProduto")) {
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
            request.setAttribute("idUsuario", sessao.getAttribute("idUsuario"));

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
                        Produto produto = new Produto();
                        item.setQuantidadeEstoque(produto.getQuantidade());
                        int qtdeEstoque = item.getQuantidadeEstoque();
                        int qtd = item.getQuantidade();

                        if (qtd != qtdeEstoque) {

                            item.setQuantidade(qtd + 1);
                            addProduto(request, sessao);

                        } else {
//                                sessao.setAttribute("mensagem", "O estoque para esse produto está esgotado");
                        }
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
                addProduto(request, sessao);
            }
            //carrega a pagina do carrinho de compras
            double vaTotal = round(carrinho.calculaTotal(), 2);
            sessao.setAttribute("valorTotal", vaTotal);
            request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
        }//fim addProduto

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

    public void addProduto(HttpServletRequest request, HttpSession sessao) {
        int atual = (int) sessao.getAttribute("numItens");
        int novo = atual + 1;
        sessao.setAttribute("numItens", novo);
    }

    public void delUnidade(HttpServletRequest request, HttpSession sessao) {
        int atual = (int) sessao.getAttribute("numItens");
        int novo = atual - 1;
        sessao.setAttribute("numItens", novo);
    }

    public void removeProduto(HttpServletRequest request, HttpSession sessao, int qtdRemove) {
        int atual = (int) sessao.getAttribute("numItens");
        int novo = atual - qtdRemove;
        sessao.setAttribute("numItens", novo);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

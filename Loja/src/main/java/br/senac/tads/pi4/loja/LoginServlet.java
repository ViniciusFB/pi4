/*
 * The MIT License
 *
 * Copyright 2017 bruno.flima4.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.senac.tads.pi4.loja;

import br.senac.tads.pi4.dao.ClienteDAO;
import br.senac.tads.pi4.dao.ProdutoDAO;
import br.senac.tads.pi4.models.Cliente;
import br.senac.tads.pi4.models.Produto;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
 * @author bruno.flima4
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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
        String urlPage = (String) sessao.getAttribute("urlPage");
        Cliente cliente = null;
        ClienteDAO dao = new ClienteDAO();
        String usuario = request.getParameter("usuario");

        URI uri;
        String pagina = "";
        try {
            uri = new URI(urlPage);
            pagina = new File(uri.getPath()).getName();
        } catch (URISyntaxException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cliente = new Cliente((Cliente) dao.obterClientePorEmail(usuario));

        } catch (NullPointerException | NumberFormatException e) {
            System.out.println(e);
            this.getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
        }

        String senha = null;
        try {
            senha = dao.selecionaHashSenha(request.getParameter("usuario")); // Pega a senha criptografada no banco
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String senhaDigitada = this.md5(request.getParameter("senha")); // Criptografa a senha que foi digitada no campo

        //        Redirect para a página de produtos
        
        if(pagina.equals("produtos")) {
            pagina = "produtos?numeroPagina=1";
        }
//        Fim redirect produtos
        if (senha == null) {
            this.getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
        } else if (senha.equals(senhaDigitada)) { // Compara a senha no banco com a senha digitada no campo (ambas criptografadas)
            try {
                sessao.setAttribute("usuario", dao.selecionaNomeByEmailSenha(request.getParameter("usuario"), senha));
                sessao.setAttribute("idCliente", dao.selecionaIdByEmailSenha(request.getParameter("usuario"), senha));

            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
//            this.getServletContext().getRequestDispatcher("/" + pagina).forward(request, response);
            response.sendRedirect(request.getContextPath() + "/" + pagina);

        } else {
            this.getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
        }

    }

    public static String md5(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }
}

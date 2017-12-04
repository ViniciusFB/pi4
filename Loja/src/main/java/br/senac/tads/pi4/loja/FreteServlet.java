package br.senac.tads.pi4.loja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Vinicius Ferreira Batista
 */
@WebServlet(urlPatterns = {"/Frete"})
public class FreteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nCdEmpresa = "";
        String sDsSenha = "";
        String nCdServico = "";
        String tipo = "";
//        String aux = JOptionPane.showInputDialog(null, "Digite o tipo de envio da encomenda \n1 Sedex, 2 Sedex 10 e 3 Pac");
        String aux = request.getParameter("entrega");

        try {
            int codigo = Integer.parseInt(aux);
            switch (codigo) {
                case 1:
                    System.out.println("Opcao 1 - Sedex");
                    nCdServico = "40010";
                    tipo = "Sedex";
                    break;
                case 2:
                    System.out.println("Opcao 2 - Sedex 10");
                    nCdServico = "40215";
                    tipo = "Sedex 10";
                    break;
                case 3:
                    System.out.println("Opcao 3 - PAC");
                    nCdServico = "41106";
                    tipo = "PAC";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Codigo desconhecido!");
                    System.exit(0);
            }
        } catch (NumberFormatException erro) {
            System.out.println("Erro: " + erro);
            System.exit(0);
        }
        String sCepOrigem = request.getParameter("cepOrigem");
        String sCepDestino = request.getParameter("cepDestino");
        String pesoPorUnidade = "1.230";
        double pesoPorUnidadeAux = Double.parseDouble(pesoPorUnidade);
        Double calcular;
        double quantidade = 1; //No mínimo 1 item
        String nVlPesoAux = "5";
        quantidade = Double.parseDouble(nVlPesoAux);
        calcular = quantidade * pesoPorUnidadeAux;
        String nVlPeso = calcular.toString();
        String nCdFormato = "1";
        String nVlComprimento = "30";
        String nVlAltura = "30";
        String nVlLargura = "30";
        String nVlDiametro = "0";
        String sCdMaoPropria = "n";
        String nVlValorDeclarado = "0";
        String sCdAvisoRecebimento = "n";
        String StrRetorno = "xml";
        // URL do webservice correio para calculo de frete
        String urlString = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx";
        // os parametros a serem enviados
        Properties parameters = new Properties();
        parameters.setProperty("nCdEmpresa", nCdEmpresa);
        parameters.setProperty("sDsSenha", sDsSenha);
        parameters.setProperty("nCdServico", nCdServico);
        parameters.setProperty("sCepOrigem", sCepOrigem);
        parameters.setProperty("sCepDestino", sCepDestino);
        parameters.setProperty("nVlPeso", nVlPeso);
        parameters.setProperty("nCdFormato", nCdFormato);
        parameters.setProperty("nVlComprimento", nVlComprimento);
        parameters.setProperty("nVlAltura", nVlAltura);
        parameters.setProperty("nVlLargura", nVlLargura);
        parameters.setProperty("nVlDiametro", nVlDiametro);
        parameters.setProperty("sCdMaoPropria", sCdMaoPropria);
        parameters.setProperty("nVlValorDeclarado", nVlValorDeclarado);
        parameters.setProperty("sCdAvisoRecebimento", sCdAvisoRecebimento);
        parameters.setProperty("StrRetorno", StrRetorno);
        // o iterador, para criar a URL
        Iterator i = parameters.keySet().iterator();
        // o contador
        int counter = 0;
        // enquanto ainda existir parametros
        while (i.hasNext()) {
            // pega o nome
            String name = (String) i.next();
            // pega o valor
            String value = parameters.getProperty(name);
            // adiciona com um conector (? ou &)
            // o primeiro é ?, depois são &
            urlString += (++counter == 1 ? "?" : "&") + name + "=" + value;
        }
        try {
            // cria o objeto url
            URL url = new URL(urlString);
            // cria o objeto httpurlconnection
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            // seta o metodo
            connection.setRequestProperty("Request-Method", "GET");
            // seta a variavel para ler o resultado
            connection.setDoInput(true);
            connection.setDoOutput(false);
            // conecta com a url destino
            connection.connect();
            // abre a conexão pra input
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            // le ate o final
            StringBuffer newData = new StringBuffer();
            String s = "";
            while (null != ((s = br.readLine()))) {
                newData.append(s);
            }
            br.close();
            // Prepara o XML que está em string para executar leitura por nodes
            DocumentBuilder db = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(newData.toString()));
            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("cServico");
            // Faz a leitura dos nodes
            for (int j = 0; j < nodes.getLength(); j++) {
                Element element = (Element) nodes.item(j);
                NodeList valor = element.getElementsByTagName("Valor");
                NodeList prazoEntrega = element.getElementsByTagName("PrazoEntrega");
                Element line = (Element) valor.item(0);
                Element prazo = (Element) prazoEntrega.item(0);
                System.out.println("A encomenda enviada por "
                        + tipo
                        + "\nMedindo: "
                        + nVlComprimento + "x"
                        + nVlAltura + "x"
                        + nVlLargura
                        + "cm\nPesando: "
                        + nVlPeso
                        + " Kg \nCom prazo de entrega de: "
                        + getCharacterDataFromElement(prazo)
                        + " dia(s) úteis \nFicará em R$"
                        + getCharacterDataFromElement(line));
                String valorFrete = getCharacterDataFromElement(line).replaceAll(",", ".");
                String diasUteis = getCharacterDataFromElement(prazo);
                NodeList erro = element.getElementsByTagName("MsgErro");
                line = (Element) erro.item(0);
                HttpSession sessao = request.getSession();
                request.setAttribute("valorFrete", valorFrete);
                sessao.setAttribute("diasUteis", diasUteis);
                double frete = Double.parseDouble(valorFrete);
//                sessao.setAttribute("frete", request.getAttribute("valorFrete"));
                sessao.setAttribute("frete", frete);

                System.out
                        .println("Erro: " + getCharacterDataFromElement(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/jsp/checkout2.jsp").forward(request, response);

    }

    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

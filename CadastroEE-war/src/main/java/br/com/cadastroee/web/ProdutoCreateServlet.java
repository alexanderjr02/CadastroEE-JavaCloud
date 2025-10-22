package br.com.cadastroee.web;

import br.com.cadastroee.ejb.ProdutoService;
import br.com.cadastroee.model.Produto;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/produtos/novo")
public class ProdutoCreateServlet extends HttpServlet {

    @EJB
    private ProdutoService produtoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Produto p = new Produto();
        p.setNome(req.getParameter("nome"));
        p.setDescricao(req.getParameter("descricao"));
        String precoStr = req.getParameter("preco");
        String quantidadeStr = req.getParameter("quantidade");
        if (precoStr != null && !precoStr.isBlank()) {
            p.setPreco(new BigDecimal(precoStr.replace(",", ".")));
        }
        if (quantidadeStr != null && !quantidadeStr.isBlank()) {
            p.setQuantidade(Integer.parseInt(quantidadeStr));
        }
        produtoService.incluir(p);
        resp.sendRedirect(req.getContextPath() + "/produtos");
    }
}
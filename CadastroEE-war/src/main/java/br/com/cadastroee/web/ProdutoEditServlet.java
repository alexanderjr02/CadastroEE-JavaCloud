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

@WebServlet("/produtos/editar")
public class ProdutoEditServlet extends HttpServlet {

    @EJB
    private ProdutoService produtoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr == null) {
            resp.sendRedirect(req.getContextPath() + "/produtos");
            return;
        }
        Long id = Long.parseLong(idStr);
        Produto produto = produtoService.buscarPorId(id);
        req.setAttribute("produto", produto);
        req.getRequestDispatcher("/WEB-INF/jsp/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(req.getParameter("id"));
        Produto p = produtoService.buscarPorId(id);
        if (p != null) {
            p.setNome(req.getParameter("nome"));
            p.setDescricao(req.getParameter("descricao"));
            String precoStr = req.getParameter("preco");
            String quantidadeStr = req.getParameter("quantidade");
            if (precoStr != null && !precoStr.isBlank()) {
                p.setPreco(new BigDecimal(precoStr.replace(",", ".")));
            } else {
                p.setPreco(null);
            }
            if (quantidadeStr != null && !quantidadeStr.isBlank()) {
                p.setQuantidade(Integer.parseInt(quantidadeStr));
            } else {
                p.setQuantidade(null);
            }
            produtoService.alterar(p);
        }
        resp.sendRedirect(req.getContextPath() + "/produtos");
    }
}
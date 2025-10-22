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
import java.util.List;

@WebServlet("/produtos")
public class ProdutoListServlet extends HttpServlet {

    @EJB
    private ProdutoService produtoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> produtos = produtoService.listarTodos();
        req.setAttribute("produtos", produtos);
        req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
    }
}
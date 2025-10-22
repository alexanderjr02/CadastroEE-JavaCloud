package br.com.cadastroee.web;

import br.com.cadastroee.ejb.ProdutoService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/produtos/excluir")
public class ProdutoDeleteServlet extends HttpServlet {

    @EJB
    private ProdutoService produtoService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null && !idStr.isBlank()) {
            Long id = Long.parseLong(idStr);
            produtoService.excluir(id);
        }
        resp.sendRedirect(req.getContextPath() + "/produtos");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
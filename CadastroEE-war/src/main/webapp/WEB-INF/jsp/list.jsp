<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.cadastroee.model.Produto" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">CadastroEE</a>
    </div>
</nav>
<div class="container">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1 class="h3">Produtos</h1>
        <a href="<%=request.getContextPath()%>/produtos/novo" class="btn btn-primary">Novo Produto</a>
    </div>

    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Qtd</th>
                <th class="text-end">Ações</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
            if (produtos != null) {
                for (Produto p : produtos) {
        %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getNome() %></td>
                <td><%= p.getDescricao() %></td>
                <td><%= p.getPreco() != null ? p.getPreco() : "" %></td>
                <td><%= p.getQuantidade() != null ? p.getQuantidade() : "" %></td>
                <td class="text-end">
                    <a href="<%=request.getContextPath()%>/produtos/editar?id=<%= p.getId() %>" class="btn btn-sm btn-outline-secondary">Editar</a>
                    <form action="<%=request.getContextPath()%>/produtos/excluir" method="post" style="display:inline">
                        <input type="hidden" name="id" value="<%= p.getId() %>">
                        <button type="submit" class="btn btn-sm btn-outline-danger" onclick="return confirm('Excluir este produto?')">Excluir</button>
                    </form>
                </td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.com.cadastroee.model.Produto" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Produto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">CadastroEE</a>
    </div>
</nav>
<div class="container">
<%
    Produto produto = (Produto) request.getAttribute("produto");
    boolean editar = produto != null && produto.getId() != null;
%>
    <h1 class="h3 mb-3"><%= editar ? "Editar Produto" : "Novo Produto" %></h1>
    <form action="<%= editar ? request.getContextPath()+"/produtos/editar" : request.getContextPath()+"/produtos/novo" %>" method="post" class="row g-3">
        <% if (editar) { %>
            <input type="hidden" name="id" value="<%= produto.getId() %>" />
        <% } %>
        <div class="col-md-6">
            <label class="form-label">Nome</label>
            <input type="text" name="nome" class="form-control" value="<%= editar ? produto.getNome() : "" %>" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Descrição</label>
            <input type="text" name="descricao" class="form-control" value="<%= editar ? produto.getDescricao() : "" %>">
        </div>
        <div class="col-md-4">
            <label class="form-label">Preço</label>
            <input type="text" name="preco" class="form-control" value="<%= editar && produto.getPreco()!=null ? produto.getPreco() : "" %>">
        </div>
        <div class="col-md-4">
            <label class="form-label">Quantidade</label>
            <input type="number" name="quantidade" class="form-control" value="<%= editar && produto.getQuantidade()!=null ? produto.getQuantidade() : "" %>">
        </div>
        <div class="col-12 d-flex gap-2">
            <button class="btn btn-primary" type="submit">Salvar</button>
            <a class="btn btn-secondary" href="<%=request.getContextPath()%>/produtos">Cancelar</a>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
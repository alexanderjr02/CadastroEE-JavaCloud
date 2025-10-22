# Relatório do Projeto CadastroEE

## 1. Descrição
Implementação de sistema cadastral web usando Servlets, JSP, JPA, EJB e Bootstrap, empacotado em EAR para GlassFish.

## 2. Arquitetura
- Módulos: EJB, WAR e EAR (Maven multi-módulo)
- Camadas: Persistência (JPA), Negócio (EJB), Web (Servlets/JSP)
- Banco: SQL Server, datasource JTA `jdbc/CadastroDS`

## 3. Tecnologias
- Jakarta EE 10 (JPA, EJB, Servlets)
- GlassFish 7
- SQL Server (mssql-jdbc)
- Bootstrap 5
- Maven

## 4. Código relevante
- Entidade `Produto` e `ProdutoService` (CRUD)
- Servlets: listar, novo, editar, excluir
- JSPs: `list.jsp` e `form.jsp`

## 5. Resultados de testes
- Listagem: OK (após deploy e dados existentes)
- Inclusão: OK (formulário → persistência)
- Edição: OK (carrega dados e salva)
- Exclusão: OK (remove registro)

Inclua aqui prints das telas pós-deploy no GlassFish.

## 6. Conclusões
- Jakarta EE facilita separação de camadas e uso de padrões corporativos
- EJB simplifica transações e acesso ao EntityManager
- Bootstrap agiliza o layout das páginas JSP

## 7. Próximos passos
- Adicionar validações e mensagens de erro nas JSPs
- Acrescentar paginação/ordenação na listagem
- Criar testes de integração com Arquillian (opcional)
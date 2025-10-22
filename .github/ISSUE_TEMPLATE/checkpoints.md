---
name: Checkpoints do Trabalho DGT2811
about: Organizar e acompanhar etapas do projeto CadastroEE
title: "[Checkpoint] Etapas do CadastroEE"
labels: [checkpoint, task]
assignees: []
---

## Checklist de Entrega

- [ ] Configurar ambiente: JDK 17, Maven, GlassFish 7, SQL Server
- [ ] Criar banco e tabela (`sql/create.sql`) no SQL Server
- [ ] Configurar Driver JDBC no GlassFish (`mssql-jdbc.jar`)
- [ ] Criar Pool `CadastroPool` e Resource `jdbc/CadastroDS`
- [ ] Implementar entidade JPA `Produto` e `persistence.xml` (JTA)
- [ ] Implementar EJB `ProdutoService` com CRUD
- [ ] Implementar Servlets (listar, novo, editar, excluir)
- [ ] Implementar JSPs com Bootstrap (lista e formulário)
- [ ] Build do EAR (`mvn clean package`) sem erros
- [ ] Deploy no GlassFish com context root `cadastroee`
- [ ] Testes: listar, incluir, editar e excluir funcionando
- [ ] Gerar relatório PDF com descrição, códigos, resultados e conclusões

## Observações
Inclua prints das telas e notas de configuração específicas do seu ambiente.
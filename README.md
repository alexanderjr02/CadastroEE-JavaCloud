# CadastroEE (Servlets, JPA, EJB, JSP, Bootstrap)

Projeto acadêmico do trabalho prático DGT2811: sistema cadastral web com Jakarta EE 10, GlassFish, SQL Server, Servlets, JPA, EJB e JSP + Bootstrap.

## Estrutura
- `CadastroEE-ejb`: módulo EJB com entidade JPA `Produto` e `ProdutoService` (CRUD).
- `CadastroEE-war`: módulo web com Servlets e JSPs.
- `CadastroEE-ear`: empacota `ejb` e `war` em um EAR para deploy.
- `sql/create.sql`: script para criar banco e tabela no SQL Server.

## Pré-requisitos
- JDK 17
- Maven 3.8+
- GlassFish 7 (Jakarta EE 10)
- SQL Server (local ou remoto)
- Driver JDBC do SQL Server (`mssql-jdbc.jar`)

## Banco de Dados
1. Execute `sql/create.sql` no SQL Server para criar o banco `CadastroEE` e a tabela `Produto`.
2. Anote usuário/senha do SQL Server.

## Configuração do GlassFish
1. Copie `mssql-jdbc.jar` para `GLASSFISH_HOME/glassfish/domains/domain1/lib`.
2. Inicie o servidor: `asadmin start-domain domain1`.
3. Crie o Connection Pool (via Admin Console ou `asadmin`):
   - Nome: `CadastroPool`
   - Driver: `com.microsoft.sqlserver.jdbc.SQLServerDriver`
   - Properties principais:
     - `User` = seu usuário
     - `Password` = sua senha
     - `URL` = `jdbc:sqlserver://localhost:1433;databaseName=CadastroEE;encrypt=false;trustServerCertificate=true`
   - Marque como `Datasource Classname` vazio (usando `Driver Classname`).
   - Teste o pool: "Ping" deve ser "Success".
4. Crie o JDBC Resource:
   - JNDI Name: `jdbc/CadastroDS`
   - Pool: `CadastroPool`
5. Pronto: o `persistence.xml` usa `jdbc/CadastroDS` com JTA.

## Build
Na raiz do projeto:
```bash
mvn clean package
```
Isso gera `CadastroEE-ear/target/CadastroEE-ear-1.0-SNAPSHOT.ear`.

## Deploy
No Admin Console do GlassFish:
- Deploy do arquivo EAR gerado.
- Context Root configurado como `cadastroee` (já definido no EAR).

Acesse:
```
http://localhost:8080/cadastroee/produtos
```

## Funcionalidades
- Listar produtos
- Incluir produto
- Editar produto
- Excluir produto

## NetBeans (opcional)
- Abra como projeto Maven.
- Execute o build pelo NetBeans e configure o GlassFish como servidor.
- Faça o deploy do EAR pelo NetBeans.

## Organização do código
- Pacotes:
  - `br.com.cadastroee.model`: entidades JPA
  - `br.com.cadastroee.ejb`: EJBs
  - `br.com.cadastroee.web`: Servlets
- JSPs em `CadastroEE-war/src/main/webapp/WEB-INF/jsp/` com Bootstrap via CDN.

## Relatório (entrega)
Crie um relatório (Markdown/Word) com:
- Descrição da arquitetura
- Código relevante (trechos)
- Resultados de testes (prints das telas)
- Conclusões sobre Servlets, JSP, JPA, EJB, Bootstrap e GlassFish

Para exportar em PDF, você pode abrir no Word/LibreOffice e salvar como PDF.

## Observações
- O EAR define o `contextRoot` como `cadastroee`.
- O `persistence.xml` está em `CadastroEE-ejb/src/main/resources/META-INF/persistence.xml`.
- JSP usa scriptlets para simplicidade (evita dependência JSTL). Opcionalmente, você pode usar JSTL.
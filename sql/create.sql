-- Criar banco de dados (ajuste conforme necessário)
CREATE DATABASE CadastroEE;
GO

USE CadastroEE;
GO

-- Criar tabela de produtos
IF OBJECT_ID('dbo.Produto', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Produto (
        id BIGINT IDENTITY(1,1) PRIMARY KEY,
        nome NVARCHAR(120) NOT NULL,
        descricao NVARCHAR(255) NULL,
        preco DECIMAL(15,2) NULL,
        quantidade INT NULL
    );
END;
GO
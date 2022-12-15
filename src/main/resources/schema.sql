CREATE TABLE produtos(
    id INT AUTO_INCREMENT,
    produto_nome VARCHAR(255) NOT NULL,
    produto_preco FLOAT NOT NULL,
    produto_quantidade INT NOT NULL,
    produto_categoria VARCHAR(255) NOT NULL
);

INSERT INTO produtos(produto_nome, produto_preco, produto_quantidade, produto_categoria) VALUES ( 'Camiseta', 59, 3, 'Roupas' );
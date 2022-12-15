--CREATE SEQUENCE table_name_id_seq;

CREATE TABLE tbl_produtos(
                             produto_id serial PRIMARY KEY,
                             produto_nome varchar(100) not null,
                             produto_preco numeric not null,
                             produto_quantidade int DEFAULT(0),
                             produto_categoria varchar(100)

);


package com.br.oliveira.desafio2.service;

import com.br.oliveira.desafio2.entity.Produto;

import java.util.List;

public interface ProdutoService {
    public Produto adicionarProduto(Produto produto);

    public List<Produto> listeProdutosLista();
}

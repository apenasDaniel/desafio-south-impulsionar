package com.br.oliveira.service;

import com.br.oliveira.entity.Produto;

import java.util.List;

public interface ProdutoService {
    public Produto adicionarProduto(Produto produto);

    public List<Produto> listeProdutosLista();

    public void excluirProduto(Long produtoId);

    public Produto edicaoProduto(Long produtoId, Produto produto);
}

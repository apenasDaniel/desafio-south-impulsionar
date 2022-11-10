package com.br.oliveira.desafio2.service;

import com.br.oliveira.desafio2.entity.Produto;
import com.br.oliveira.desafio2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImplement implements ProdutoService{

    @Autowired
    private ProdutoRepository produtoRepository;
    @Override
    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listeProdutosLista() {
        return produtoRepository.findAll();
    }
}

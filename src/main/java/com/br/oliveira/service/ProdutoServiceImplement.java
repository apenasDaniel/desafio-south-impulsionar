package com.br.oliveira.service;

import com.br.oliveira.entity.Produto;
import com.br.oliveira.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public void excluirProduto(Long produtoId) {
        produtoRepository.deleteById(produtoId);
    }

    @Override
    public Produto edicaoProduto(Long produtoId, Produto produto) {
        Produto prodDB = produtoRepository.findById(produtoId).get();

        if (Objects.nonNull(produto.getProdutoNome()) &&
                !"".equalsIgnoreCase(produto.getProdutoNome())) {
            prodDB.setProdutoNome(produto.getProdutoNome());
        }

        if (Objects.nonNull(produto.getProdutoPreco()) &&
                !"".equalsIgnoreCase(String.valueOf(produto.getProdutoPreco()))) {
            prodDB.setProdutoPreco(produto.getProdutoPreco());
        }

        if (Objects.nonNull(produto.getProdutoQuantidade()) &&
                !"".equalsIgnoreCase(String.valueOf(produto.getProdutoQuantidade()))) {
            prodDB.setProdutoQuantidade(produto.getProdutoQuantidade());
        }

        if (Objects.nonNull(produto.getProdutoCategoria()) &&
                !"".equalsIgnoreCase(String.valueOf(produto.getProdutoCategoria()))) {
            prodDB.setProdutoCategoria(produto.getProdutoCategoria());
        }

        return produtoRepository.save(prodDB);
    }
}

package com.br.oliveira.desafio2.resouces;

import com.br.oliveira.desafio2.entity.Produto;

import com.br.oliveira.desafio2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoResources {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/produtos")
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoService.adicionarProduto(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> listeProdutosLista () {
        return produtoService.listeProdutosLista();
    }
}

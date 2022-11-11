package com.br.oliveira.desafio2.resouces;

import com.br.oliveira.desafio2.entity.Produto;

import com.br.oliveira.desafio2.service.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoResources {

    @Autowired
    private ProdutoService produtoService;

    private final Logger LOGGER = LoggerFactory.getLogger(ProdutoResources.class);

    @PostMapping("/produtos")
    public Produto adicionarProduto(@RequestBody Produto produto) {
        LOGGER.info("Produto adicionado através de adicionarProduto no ProdutoResources");
        return produtoService.adicionarProduto(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> listeProdutosLista () {
        LOGGER.info("Produtos listados através de listeProdutosLista no ProdutoResources");
        return produtoService.listeProdutosLista();
    }

    @DeleteMapping("/produtos/{id}")
    public String excluirProduto(@PathVariable("id") Long produtoId) {
        produtoService.excluirProduto(produtoId);
        LOGGER.info("Produto excluído através de excluirProduto no ProdutoResources");
        return "Produto excluído com sucesso.";
    }

    @PutMapping("/produtos/{id}")
    public Produto edicaoProduto(@PathVariable("id") Long produtoId, @RequestBody Produto produto) {
        LOGGER.info("Produto editado através de edicaoProduto no ProdutoResources");
        return produtoService.edicaoProduto(produtoId,produto);
    }
}

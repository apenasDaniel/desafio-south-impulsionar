package com.br.oliveira.resouces;

import com.br.oliveira.entity.Produto;

import com.br.oliveira.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Loja", description = "APIs Loja Online")
public class ProdutoResources {

    @Autowired
    private ProdutoService produtoService;

    private final Logger LOGGER = LoggerFactory.getLogger(ProdutoResources.class);

    @PostMapping("/produtos")
    @Operation(summary = "Adicionar produto.")
    public Produto adicionarProduto(@RequestBody Produto produto) {
        LOGGER.info("Produto adicionado através de adicionarProduto no ProdutoResources");
        return produtoService.adicionarProduto(produto);
    }

    @GetMapping("/produtos")
    @Operation(summary = "Listar produtos cadastrados.")
    public List<Produto> listeProdutosLista () {
        LOGGER.info("Produtos listados através de listeProdutosLista no ProdutoResources");
        return produtoService.listeProdutosLista();
    }

    @DeleteMapping("/produtos/{id}")
    @Operation(summary = "Excluir produto da lista.")
    public String excluirProduto(@PathVariable("id") Long produtoId) {
        produtoService.excluirProduto(produtoId);
        LOGGER.info("Produto excluído através de excluirProduto no ProdutoResources");
        return "Produto excluído com sucesso.";
    }

    @PutMapping("/produtos/{id}")
    @Operation(summary = "Editar informações do produto.")
    public Produto edicaoProduto(@PathVariable("id") Long produtoId, @RequestBody Produto produto) {
        LOGGER.info("Produto editado através de edicaoProduto no ProdutoResources");
        return produtoService.edicaoProduto(produtoId,produto);
    }
}

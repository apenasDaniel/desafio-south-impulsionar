package com.br.oliveira.resources;

import com.br.oliveira.entity.Produto;

import com.br.oliveira.entity.ProdutoCategoria;
import com.br.oliveira.repository.ProdutoRepository;
import com.br.oliveira.service.ProdutoService;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Loja", description = "APIs Loja Online")
public class ProdutoResources {

    @Autowired
    ProdutoRepository service;

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

    @PostMapping("/upload")
    public String uploadData(@RequestParam("file") MultipartFile file) throws Exception {
        List<Produto> produtoList = new ArrayList<>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {
            Produto produto = new Produto();
            produto.setProdutoNome(record.getString("produto_nome"));
            produto.setProdutoPreco(record.getBigDecimal("produto_preco"));
            produto.setProdutoQuantidade(record.getInt("produto_quantidade"));
            produto.setProdutoCategoria(ProdutoCategoria.valueOf(record.getString("produto_categoria")));
            produtoList.add(produto);
        });
        service.saveAll(produtoList);
        return "Upload feito com sucesso.";
    }
}

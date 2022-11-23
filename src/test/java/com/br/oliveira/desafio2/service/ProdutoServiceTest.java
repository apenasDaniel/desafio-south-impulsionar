package com.br.oliveira.desafio2.service;

import com.br.oliveira.desafio2.entity.Produto;
import com.br.oliveira.desafio2.entity.ProdutoCategoria;
import com.br.oliveira.desafio2.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProdutoServiceTest {

    @Autowired
    private ProdutoService produtoService;

    @MockBean
    private ProdutoRepository produtoRepository;

    @BeforeEach
    void setUp() {
        Produto produto =
                Produto.builder()
                        .produtoNome("Camiseta")
                        .produtoPreco(BigDecimal.valueOf(99))
                        .produtoQuantidade(3)
                        .produtoCategoria(ProdutoCategoria.ROUPAS)
                        .produtoId(1L)
                        .build();


    }
}
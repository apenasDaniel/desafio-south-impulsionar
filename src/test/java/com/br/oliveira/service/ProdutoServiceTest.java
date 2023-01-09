package com.br.oliveira.service;

import com.br.oliveira.entity.Produto;
import com.br.oliveira.entity.ProdutoCategoria;
import com.br.oliveira.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

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
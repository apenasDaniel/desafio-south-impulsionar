package com.br.oliveira.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tbl_produtos")
public class Produto {

    @Id
    @Column(name = "produto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produtoId;

    @Column(name = "produto_nome")
    private String produtoNome;

    @Column(name = "produto_preco")
    private BigDecimal produtoPreco;

    @Column(name = "produto_quantidade")
    private int produtoQuantidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "produto_categoria")
    private ProdutoCategoria produtoCategoria;










}

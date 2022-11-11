package com.br.oliveira.desafio2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long produtoId;
    private String produtoNome;
    private BigDecimal produtoPreco;
    private int produtoQuantidade;
    @Enumerated(EnumType.STRING)
    private ProdutoCategoria produtoCategoria;


}

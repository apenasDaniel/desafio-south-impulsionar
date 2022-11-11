package com.br.oliveira.desafio2.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long produtoId;
    private String produtoNome;
    private BigDecimal produtoPreco;
    private int produtoQuantidade;
    @Enumerated(EnumType.STRING)
    private ProdutoCategoria produtoCategoria;

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public BigDecimal getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(BigDecimal produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    public int getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(int produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }

    public ProdutoCategoria getProdutoCategoria() {
        return produtoCategoria;
    }

    public void setProdutoCategoria(ProdutoCategoria produtoCategoria) {
        this.produtoCategoria = produtoCategoria;
    }

    public Produto(Long produtoId, String produtoNome, BigDecimal produtoPreco, int produtoQuantidade, ProdutoCategoria produtoCategoria) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.produtoPreco = produtoPreco;
        this.produtoQuantidade = produtoQuantidade;
        this.produtoCategoria = produtoCategoria;
    }

    public Produto() {
    }

    @Override
    public String toString() {
        return "Produto{" +
                "produtoId=" + produtoId +
                ", produtoNome='" + produtoNome + '\'' +
                ", produtoPreco=" + produtoPreco +
                ", produtoQuantidade=" + produtoQuantidade +
                ", produtoCategoria=" + produtoCategoria +
                '}';
    }
}

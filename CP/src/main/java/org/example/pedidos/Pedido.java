package org.example.pedidos;

import jakarta.persistence.*;
import org.example.produtos.Produto;


import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "itensPedidos",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> itensPedidos;
    private Double preco;
    private Integer estoque;

    public Pedido() {
    }

    public Pedido(Long id, List<Produto> itensPedidos, Double preco, Integer estoque) {
        this.id = id;
        this.itensPedidos = itensPedidos;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<Produto> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}


package com.smartpay.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class EntradaEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long produto_id;
    private int quantidade;
    private LocalDateTime data_entrada;
    private LocalDateTime data_entrada_atualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(LocalDateTime data_entrada) {
        this.data_entrada = data_entrada;
    }

    public LocalDateTime getData_entrada_atualizacao() {
        return data_entrada_atualizacao;
    }

    public void setData_entrada_atualizacao(LocalDateTime data_entrada_atualizacao) {
        this.data_entrada_atualizacao = data_entrada_atualizacao;
    }
}

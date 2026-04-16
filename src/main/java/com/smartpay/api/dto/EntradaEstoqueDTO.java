package com.smartpay.api.dto;

import java.time.LocalDateTime;

public class EntradaEstoqueDTO {
    private Long produto_id;
    private int quantidade;
    private LocalDateTime data_entrada;

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
}


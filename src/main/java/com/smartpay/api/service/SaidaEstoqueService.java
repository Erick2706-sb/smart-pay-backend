package com.smartpay.api.service;

import com.smartpay.api.dto.SaidaEstoqueDTO;
import com.smartpay.api.model.SaidaEstoque;
import com.smartpay.api.repository.SaidaEstoqueRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaidaEstoqueService {

    private final SaidaEstoqueRepository repository;

    public SaidaEstoqueService(SaidaEstoqueRepository repository) {
        this.repository = repository;
    }

    public List<SaidaEstoque> listar(){
        return repository.findAll();
    }

    public SaidaEstoque criar(SaidaEstoqueDTO dto){
        SaidaEstoque saidaEstoque = new SaidaEstoque();

        saidaEstoque.setProduto_id(dto.getProduto_id());
        saidaEstoque.setQuantidade(dto.getQuantidade());
        saidaEstoque.setDestino(dto.getDestino());
        saidaEstoque.setData_saida(LocalDateTime.now());
        return repository.save(saidaEstoque);
    }
}

package com.smartpay.api.service;

import com.smartpay.api.dto.entradaEstoqueDTO;
import com.smartpay.api.model.EntradaEstoque;
import org.springframework.stereotype.Service;
import com.smartpay.api.repository.entradaEstoqueRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class entradaEstoqueService {

    private final entradaEstoqueRepository repository;

    public entradaEstoqueService(entradaEstoqueRepository repository) {
        this.repository = repository;
    }

    public List<EntradaEstoque> listarTodos(){
        return repository.findAll();
    }

    public EntradaEstoque salvar(EntradaEstoque entradaEstoque){
        return repository.save(entradaEstoque);
    }
}

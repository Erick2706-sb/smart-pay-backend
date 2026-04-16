package com.smartpay.api.service;

import com.smartpay.api.dto.EntradaEstoqueDTO;
import com.smartpay.api.model.EntradaEstoque;
import org.springframework.stereotype.Service;
import com.smartpay.api.repository.EntradaEstoqueRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntradaEstoqueService {

    private final EntradaEstoqueRepository repository;

    public EntradaEstoqueService(EntradaEstoqueRepository repository) {
        this.repository = repository;
    }

    public List<EntradaEstoque> listarTodos(){
        return repository.findAll();
    }

    public EntradaEstoque criar(EntradaEstoqueDTO dto){
        EntradaEstoque entradaEstoque= new EntradaEstoque();
        entradaEstoque.setProduto_id(dto.getProduto_id());
        entradaEstoque.setQuantidade(dto.getQuantidade());
        entradaEstoque.setData_entrada(LocalDateTime.now());
        return repository.save(entradaEstoque);
    }

}

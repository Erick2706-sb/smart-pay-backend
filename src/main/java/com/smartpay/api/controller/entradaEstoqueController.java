package com.smartpay.api.controller;

import com.smartpay.api.dto.entradaEstoqueDTO;
import com.smartpay.api.model.EntradaEstoque;
import com.smartpay.api.service.entradaEstoqueService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/entradaEstoque")
public class entradaEstoqueController {

    private final entradaEstoqueService service;

    public entradaEstoqueController(entradaEstoqueService service) {
        this.service = service;
    }

    @GetMapping
    public List<EntradaEstoque> listar(){
        return service.listarTodos();
    }

    @PostMapping("/criar")
    public EntradaEstoque criar(@RequestBody entradaEstoqueDTO dto){
        EntradaEstoque entradaEstoque= new EntradaEstoque();
        entradaEstoque.setProduto_id(dto.getProduto_id());
        entradaEstoque.setQuantidade(dto.getQuantidade());
        entradaEstoque.setData_entrada(LocalDateTime.now());
        return service.salvar(entradaEstoque);
    }

}

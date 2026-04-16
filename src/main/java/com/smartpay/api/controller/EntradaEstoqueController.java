package com.smartpay.api.controller;

import com.smartpay.api.dto.EntradaEstoqueDTO;
import com.smartpay.api.model.EntradaEstoque;
import com.smartpay.api.service.EntradaEstoqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/entradaEstoque")
public class EntradaEstoqueController {

    private final EntradaEstoqueService service;

    public EntradaEstoqueController(EntradaEstoqueService service) {
        this.service = service;
    }

    @GetMapping
    public List<EntradaEstoque> listar(){
        return service.listarTodos();
    }

    @PostMapping("/criar")
    public EntradaEstoque adicionarEstoque(@RequestBody EntradaEstoqueDTO dto){
        return service.criar(dto);
    }

}

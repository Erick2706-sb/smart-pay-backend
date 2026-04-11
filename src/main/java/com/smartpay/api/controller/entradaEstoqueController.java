package com.smartpay.api.controller;

import com.smartpay.api.model.EntradaEstoque;
import com.smartpay.api.model.Produto;
import com.smartpay.api.service.entradaEstoqueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

package com.smartpay.api.controller;

import com.smartpay.api.dto.SaidaEstoqueDTO;
import com.smartpay.api.model.SaidaEstoque;
import com.smartpay.api.service.EntradaEstoqueService;
import com.smartpay.api.service.SaidaEstoqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/saidaEstoque")
public class SaidaEstoqueController {

    public final SaidaEstoqueService service;

    public SaidaEstoqueController(SaidaEstoqueService service) {
        this.service = service;
    }

    @GetMapping
    public List<SaidaEstoque> listarTodos(){
        return service.listar();
    }
    @PostMapping("/criar")
    public SaidaEstoque saidaEstoque(@RequestBody SaidaEstoqueDTO dto){
        return service.criar(dto);
    }
}

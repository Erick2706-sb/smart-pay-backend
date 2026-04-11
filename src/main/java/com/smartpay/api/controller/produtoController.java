package com.smartpay.api.controller;


import com.smartpay.api.dto.produtoRequest;
import com.smartpay.api.dto.produtoResponse;
import com.smartpay.api.model.Produto;
import com.smartpay.api.service.produtoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class produtoController {

    private final produtoService service;

    public produtoController(produtoService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listarTodos()
    {
        return service.listarAtivos();
    }

    @DeleteMapping("/deletar/{id}")
    public String desativar(@PathVariable Long id) {
        service.desativar(id);
        return "Produto desativado com sucesso";
    }

    @PostMapping("/criar")
     public produtoResponse criar(@RequestBody produtoRequest request){
        return service.criarProduto(request);
    }

    @PutMapping("/atualizar/{id}")
    public produtoResponse atualizar(@PathVariable Long id, @RequestBody produtoRequest request) {
        return service.atualizar(id, request);
    }
}

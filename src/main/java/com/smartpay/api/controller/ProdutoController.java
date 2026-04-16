package com.smartpay.api.controller;


import com.smartpay.api.dto.ProdutoDTO;
import com.smartpay.api.model.Produto;
import com.smartpay.api.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service)
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
     public Produto criar(@RequestBody ProdutoDTO dto)
    {
        return service.criarProduto(dto);
    }

    @PutMapping("/atualizar/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        return service.atualizar(id, dto);
    }
}

package com.smartpay.api.service;

import com.smartpay.api.dto.produtoRequest;
import com.smartpay.api.dto.produtoResponse;

import com.smartpay.api.model.Produto;
import com.smartpay.api.repository.produtoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class produtoService {

    private final produtoRepository repository;


    public produtoService(produtoRepository repository)
    {
        this.repository = repository;
    }

    public List<Produto> listarAtivos() {
        return repository.findByIsAtivado("S");
    }

    public void desativar(Long id) {
        Produto produto = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setIsAtivado("N");
        repository.save(produto);
    }

    public produtoResponse criarProduto(produtoRequest request) {

        Produto produto = new Produto();

        produto.setNome(request.getNome());
        produto.setModelo(request.getModelo());
        produto.setFabricante(request.getFabricante());
        produto.setPreco(request.getPreco());
        produto.setQuantidade(request.getQuantidade());

        Produto salvo = repository.save(produto);

        produtoResponse response =  new produtoResponse();
        response.setId(salvo.getId());
        response.setNome(salvo.getNome());
        response.setModelo(salvo.getModelo());
        response.setFabricante(salvo.getFabricante());
        response.setPreco(salvo.getPreco());
        response.setQuantidade(salvo.getQuantidade());

        return response;
    }



    public produtoResponse atualizar(Long id, produtoRequest request) {

        Produto produto = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(request.getNome());
        produto.setModelo(request.getModelo());
        produto.setFabricante(request.getFabricante());
        produto.setPreco(request.getPreco());
        produto.setQuantidade(request.getQuantidade());

        Produto atualizado = repository.save(produto);

        produtoResponse response = new produtoResponse();
        response.setId(atualizado.getId());
        response.setNome(atualizado.getNome());
        response.setModelo(atualizado.getModelo());
        response.setFabricante(atualizado.getFabricante());
        response.setPreco(atualizado.getPreco());
        response.setQuantidade(atualizado.getQuantidade());

        return response;
    }
}

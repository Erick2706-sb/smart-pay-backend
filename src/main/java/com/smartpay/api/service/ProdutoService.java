package com.smartpay.api.service;

import com.smartpay.api.dto.ProdutoDTO;

import com.smartpay.api.model.Produto;
import com.smartpay.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;


    public ProdutoService(ProdutoRepository repository)
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
    public Produto criarProduto(ProdutoDTO dto){
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setModelo(dto.getModelo());
        produto.setFabricante(dto.getFabricante());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());
        return repository.save(produto);
    }
    public Produto atualizar(Long id, ProdutoDTO dto){
        Produto produto = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(dto.getNome());
        produto.setModelo(dto.getModelo());
        produto.setFabricante(dto.getFabricante());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());
        return repository.save(produto);
    }

}

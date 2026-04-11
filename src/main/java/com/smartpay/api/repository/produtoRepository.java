package com.smartpay.api.repository;

import com.smartpay.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface produtoRepository extends JpaRepository<Produto,Long> {
    List<Produto> findByIsAtivado(String isAtivado);
}

package com.empresa.api.domain.repository;

import com.empresa.api.domain.model.Produto;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepositoryPort {

    Produto save(Produto produto);

    Optional<Produto> findById(Long id);

    List<Produto> findAll();

    List<Produto> findByNome(String nome);

    long count();

    void deleteById(Long id);

    boolean existsById(Long id);
}

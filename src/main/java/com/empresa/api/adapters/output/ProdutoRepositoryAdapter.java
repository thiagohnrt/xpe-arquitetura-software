package com.empresa.api.adapters.output;

import com.empresa.api.domain.model.Produto;
import com.empresa.api.domain.repository.ProdutoRepositoryPort;
import com.empresa.api.infrastructure.persistence.entity.ProdutoEntity;
import com.empresa.api.infrastructure.persistence.jpa.ProdutoJpaRepository;
import com.empresa.api.infrastructure.persistence.mapper.ProdutoPersistenceMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {

    private final ProdutoJpaRepository produtoJpaRepository;

    public ProdutoRepositoryAdapter(ProdutoJpaRepository produtoJpaRepository) {
        this.produtoJpaRepository = produtoJpaRepository;
    }

    @Override
    public Produto save(Produto produto) {
        ProdutoEntity saved = produtoJpaRepository.save(ProdutoPersistenceMapper.toEntity(produto));
        return ProdutoPersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return produtoJpaRepository.findById(id).map(ProdutoPersistenceMapper::toDomain);
    }

    @Override
    public List<Produto> findAll() {
        return produtoJpaRepository.findAll().stream().map(ProdutoPersistenceMapper::toDomain).toList();
    }

    @Override
    public List<Produto> findByNome(String nome) {
        return produtoJpaRepository.findByNomeContainingIgnoreCase(nome).stream().map(ProdutoPersistenceMapper::toDomain).toList();
    }

    @Override
    public long count() {
        return produtoJpaRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        produtoJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return produtoJpaRepository.existsById(id);
    }
}

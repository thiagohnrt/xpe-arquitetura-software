package com.empresa.api.application.service;

import com.empresa.api.application.dto.ProdutoRequest;
import com.empresa.api.application.dto.ProdutoResponse;
import com.empresa.api.application.mapper.ProdutoMapper;
import com.empresa.api.application.usecase.ProdutoUseCase;
import com.empresa.api.domain.exception.NotFoundException;
import com.empresa.api.domain.model.Produto;
import com.empresa.api.domain.repository.ProdutoRepositoryPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoApplicationService implements ProdutoUseCase {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ProdutoApplicationService(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public ProdutoResponse create(ProdutoRequest request) {
        Produto created = produtoRepositoryPort.save(ProdutoMapper.toDomain(request));
        return ProdutoMapper.toResponse(created);
    }

    @Override
    public ProdutoResponse update(Long id, ProdutoRequest request) {
        ensureExists(id);
        Produto updated = produtoRepositoryPort.save(ProdutoMapper.toDomain(id, request));
        return ProdutoMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        ensureExists(id);
        produtoRepositoryPort.deleteById(id);
    }

    @Override
    public ProdutoResponse findById(Long id) {
        Produto produto = produtoRepositoryPort.findById(id)
            .orElseThrow(() -> new NotFoundException("Produto nao encontrado: " + id));
        return ProdutoMapper.toResponse(produto);
    }

    @Override
    public List<ProdutoResponse> findAll() {
        return produtoRepositoryPort.findAll().stream().map(ProdutoMapper::toResponse).toList();
    }

    @Override
    public List<ProdutoResponse> findByNome(String nome) {
        return produtoRepositoryPort.findByNome(nome).stream().map(ProdutoMapper::toResponse).toList();
    }

    @Override
    public long count() {
        return produtoRepositoryPort.count();
    }

    private void ensureExists(Long id) {
        if (!produtoRepositoryPort.existsById(id)) {
            throw new NotFoundException("Produto nao encontrado: " + id);
        }
    }
}

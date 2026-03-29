package com.empresa.api.application.service;

import com.empresa.api.application.dto.ClienteRequest;
import com.empresa.api.application.dto.ClienteResponse;
import com.empresa.api.application.mapper.ClienteMapper;
import com.empresa.api.application.usecase.ClienteUseCase;
import com.empresa.api.domain.exception.NotFoundException;
import com.empresa.api.domain.model.Cliente;
import com.empresa.api.domain.repository.ClienteRepositoryPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClienteApplicationService implements ClienteUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteApplicationService(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public ClienteResponse create(ClienteRequest request) {
        Cliente created = clienteRepositoryPort.save(ClienteMapper.toDomain(request));
        return ClienteMapper.toResponse(created);
    }

    @Override
    public ClienteResponse update(Long id, ClienteRequest request) {
        ensureExists(id);
        Cliente updated = clienteRepositoryPort.save(ClienteMapper.toDomain(id, request));
        return ClienteMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        ensureExists(id);
        clienteRepositoryPort.deleteById(id);
    }

    @Override
    public ClienteResponse findById(Long id) {
        Cliente cliente = clienteRepositoryPort.findById(id)
            .orElseThrow(() -> new NotFoundException("Cliente nao encontrado: " + id));
        return ClienteMapper.toResponse(cliente);
    }

    @Override
    public List<ClienteResponse> findAll() {
        return clienteRepositoryPort.findAll().stream().map(ClienteMapper::toResponse).toList();
    }

    @Override
    public List<ClienteResponse> findByNome(String nome) {
        return clienteRepositoryPort.findByNome(nome).stream().map(ClienteMapper::toResponse).toList();
    }

    @Override
    public long count() {
        return clienteRepositoryPort.count();
    }

    private void ensureExists(Long id) {
        if (!clienteRepositoryPort.existsById(id)) {
            throw new NotFoundException("Cliente nao encontrado: " + id);
        }
    }
}

package com.empresa.api.application.service;

import com.empresa.api.application.dto.PedidoRequest;
import com.empresa.api.application.dto.PedidoResponse;
import com.empresa.api.application.mapper.PedidoMapper;
import com.empresa.api.application.usecase.PedidoUseCase;
import com.empresa.api.domain.exception.NotFoundException;
import com.empresa.api.domain.model.Pedido;
import com.empresa.api.domain.repository.ClienteRepositoryPort;
import com.empresa.api.domain.repository.PedidoRepositoryPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PedidoApplicationService implements PedidoUseCase {

    private final PedidoRepositoryPort pedidoRepositoryPort;
    private final ClienteRepositoryPort clienteRepositoryPort;

    public PedidoApplicationService(PedidoRepositoryPort pedidoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public PedidoResponse create(PedidoRequest request) {
        ensureClienteExists(request.clienteId());
        Pedido created = pedidoRepositoryPort.save(PedidoMapper.toDomain(request));
        return PedidoMapper.toResponse(created);
    }

    @Override
    public PedidoResponse update(Long id, PedidoRequest request) {
        ensureExists(id);
        ensureClienteExists(request.clienteId());
        Pedido updated = pedidoRepositoryPort.save(PedidoMapper.toDomain(id, request));
        return PedidoMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        ensureExists(id);
        pedidoRepositoryPort.deleteById(id);
    }

    @Override
    public PedidoResponse findById(Long id) {
        Pedido pedido = pedidoRepositoryPort.findById(id)
            .orElseThrow(() -> new NotFoundException("Pedido nao encontrado: " + id));
        return PedidoMapper.toResponse(pedido);
    }

    @Override
    public List<PedidoResponse> findAll() {
        return pedidoRepositoryPort.findAll().stream().map(PedidoMapper::toResponse).toList();
    }

    @Override
    public List<PedidoResponse> findByNome(String nome) {
        return pedidoRepositoryPort.findByNome(nome).stream().map(PedidoMapper::toResponse).toList();
    }

    @Override
    public long count() {
        return pedidoRepositoryPort.count();
    }

    private void ensureExists(Long id) {
        if (!pedidoRepositoryPort.existsById(id)) {
            throw new NotFoundException("Pedido nao encontrado: " + id);
        }
    }

    private void ensureClienteExists(Long clienteId) {
        if (!clienteRepositoryPort.existsById(clienteId)) {
            throw new NotFoundException("Cliente nao encontrado para o pedido: " + clienteId);
        }
    }
}

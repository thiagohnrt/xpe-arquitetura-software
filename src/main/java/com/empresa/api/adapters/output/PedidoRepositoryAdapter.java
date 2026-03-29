package com.empresa.api.adapters.output;

import com.empresa.api.domain.model.Pedido;
import com.empresa.api.domain.repository.PedidoRepositoryPort;
import com.empresa.api.infrastructure.persistence.entity.PedidoEntity;
import com.empresa.api.infrastructure.persistence.jpa.PedidoJpaRepository;
import com.empresa.api.infrastructure.persistence.mapper.PedidoPersistenceMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private final PedidoJpaRepository pedidoJpaRepository;

    public PedidoRepositoryAdapter(PedidoJpaRepository pedidoJpaRepository) {
        this.pedidoJpaRepository = pedidoJpaRepository;
    }

    @Override
    public Pedido save(Pedido pedido) {
        PedidoEntity saved = pedidoJpaRepository.save(PedidoPersistenceMapper.toEntity(pedido));
        return PedidoPersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoJpaRepository.findById(id).map(PedidoPersistenceMapper::toDomain);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoJpaRepository.findAll().stream().map(PedidoPersistenceMapper::toDomain).toList();
    }

    @Override
    public List<Pedido> findByNome(String nome) {
        try {
            Long clienteId = Long.parseLong(nome);
            return pedidoJpaRepository.findByClienteId(clienteId).stream().map(PedidoPersistenceMapper::toDomain).toList();
        } catch (NumberFormatException ex) {
            return List.of();
        }
    }

    @Override
    public long count() {
        return pedidoJpaRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        pedidoJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return pedidoJpaRepository.existsById(id);
    }
}

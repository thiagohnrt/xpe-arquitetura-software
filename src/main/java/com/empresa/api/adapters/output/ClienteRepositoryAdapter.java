package com.empresa.api.adapters.output;

import com.empresa.api.domain.model.Cliente;
import com.empresa.api.domain.repository.ClienteRepositoryPort;
import com.empresa.api.infrastructure.persistence.entity.ClienteEntity;
import com.empresa.api.infrastructure.persistence.jpa.ClienteJpaRepository;
import com.empresa.api.infrastructure.persistence.mapper.ClientePersistenceMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository clienteJpaRepository;

    public ClienteRepositoryAdapter(ClienteJpaRepository clienteJpaRepository) {
        this.clienteJpaRepository = clienteJpaRepository;
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity saved = clienteJpaRepository.save(ClientePersistenceMapper.toEntity(cliente));
        return ClientePersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteJpaRepository.findById(id).map(ClientePersistenceMapper::toDomain);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteJpaRepository.findAll().stream().map(ClientePersistenceMapper::toDomain).toList();
    }

    @Override
    public List<Cliente> findByNome(String nome) {
        return clienteJpaRepository.findByNomeContainingIgnoreCase(nome).stream().map(ClientePersistenceMapper::toDomain).toList();
    }

    @Override
    public long count() {
        return clienteJpaRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        clienteJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return clienteJpaRepository.existsById(id);
    }
}

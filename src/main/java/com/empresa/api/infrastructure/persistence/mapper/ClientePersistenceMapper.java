package com.empresa.api.infrastructure.persistence.mapper;

import com.empresa.api.domain.model.Cliente;
import com.empresa.api.infrastructure.persistence.entity.ClienteEntity;

public final class ClientePersistenceMapper {

    private ClientePersistenceMapper() {
    }

    public static ClienteEntity toEntity(Cliente cliente) {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(cliente.getId());
        entity.setNome(cliente.getNome());
        entity.setEmail(cliente.getEmail());
        return entity;
    }

    public static Cliente toDomain(ClienteEntity entity) {
        return new Cliente(entity.getId(), entity.getNome(), entity.getEmail());
    }
}

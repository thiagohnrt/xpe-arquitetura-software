package com.empresa.api.application.mapper;

import com.empresa.api.application.dto.ClienteRequest;
import com.empresa.api.application.dto.ClienteResponse;
import com.empresa.api.domain.model.Cliente;

public final class ClienteMapper {

    private ClienteMapper() {
    }

    public static Cliente toDomain(ClienteRequest request) {
        return new Cliente(null, request.nome(), request.email());
    }

    public static Cliente toDomain(Long id, ClienteRequest request) {
        return new Cliente(id, request.nome(), request.email());
    }

    public static ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
}

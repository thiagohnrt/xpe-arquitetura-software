package com.empresa.api.application.mapper;

import com.empresa.api.application.dto.PedidoRequest;
import com.empresa.api.application.dto.PedidoResponse;
import com.empresa.api.domain.model.Pedido;

public final class PedidoMapper {

    private PedidoMapper() {
    }

    public static Pedido toDomain(PedidoRequest request) {
        return new Pedido(null, request.clienteId(), request.dataPedido(), request.valorTotal());
    }

    public static Pedido toDomain(Long id, PedidoRequest request) {
        return new Pedido(id, request.clienteId(), request.dataPedido(), request.valorTotal());
    }

    public static PedidoResponse toResponse(Pedido pedido) {
        return new PedidoResponse(pedido.getId(), pedido.getClienteId(), pedido.getDataPedido(), pedido.getValorTotal());
    }
}

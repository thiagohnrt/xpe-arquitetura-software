package com.empresa.api.infrastructure.persistence.mapper;

import com.empresa.api.domain.model.Pedido;
import com.empresa.api.infrastructure.persistence.entity.PedidoEntity;

public final class PedidoPersistenceMapper {

    private PedidoPersistenceMapper() {
    }

    public static PedidoEntity toEntity(Pedido pedido) {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(pedido.getId());
        entity.setClienteId(pedido.getClienteId());
        entity.setDataPedido(pedido.getDataPedido());
        entity.setValorTotal(pedido.getValorTotal());
        return entity;
    }

    public static Pedido toDomain(PedidoEntity entity) {
        return new Pedido(entity.getId(), entity.getClienteId(), entity.getDataPedido(), entity.getValorTotal());
    }
}

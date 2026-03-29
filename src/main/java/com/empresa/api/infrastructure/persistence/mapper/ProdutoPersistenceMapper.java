package com.empresa.api.infrastructure.persistence.mapper;

import com.empresa.api.domain.model.Produto;
import com.empresa.api.infrastructure.persistence.entity.ProdutoEntity;

public final class ProdutoPersistenceMapper {

    private ProdutoPersistenceMapper() {
    }

    public static ProdutoEntity toEntity(Produto produto) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(produto.getId());
        entity.setNome(produto.getNome());
        entity.setPreco(produto.getPreco());
        return entity;
    }

    public static Produto toDomain(ProdutoEntity entity) {
        return new Produto(entity.getId(), entity.getNome(), entity.getPreco());
    }
}

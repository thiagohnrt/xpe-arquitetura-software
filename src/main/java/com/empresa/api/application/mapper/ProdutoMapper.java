package com.empresa.api.application.mapper;

import com.empresa.api.application.dto.ProdutoRequest;
import com.empresa.api.application.dto.ProdutoResponse;
import com.empresa.api.domain.model.Produto;

public final class ProdutoMapper {

    private ProdutoMapper() {
    }

    public static Produto toDomain(ProdutoRequest request) {
        return new Produto(null, request.nome(), request.preco());
    }

    public static Produto toDomain(Long id, ProdutoRequest request) {
        return new Produto(id, request.nome(), request.preco());
    }

    public static ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getPreco());
    }
}

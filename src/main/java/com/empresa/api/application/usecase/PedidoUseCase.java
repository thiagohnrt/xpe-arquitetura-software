package com.empresa.api.application.usecase;

import com.empresa.api.application.dto.PedidoRequest;
import com.empresa.api.application.dto.PedidoResponse;
import java.util.List;

public interface PedidoUseCase {

    PedidoResponse create(PedidoRequest request);

    PedidoResponse update(Long id, PedidoRequest request);

    void delete(Long id);

    PedidoResponse findById(Long id);

    List<PedidoResponse> findAll();

    List<PedidoResponse> findByNome(String nome);

    long count();
}

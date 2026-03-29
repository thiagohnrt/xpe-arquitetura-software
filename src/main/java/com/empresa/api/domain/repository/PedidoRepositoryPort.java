package com.empresa.api.domain.repository;

import com.empresa.api.domain.model.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoRepositoryPort {

    Pedido save(Pedido pedido);

    Optional<Pedido> findById(Long id);

    List<Pedido> findAll();

    List<Pedido> findByNome(String nome);

    long count();

    void deleteById(Long id);

    boolean existsById(Long id);
}

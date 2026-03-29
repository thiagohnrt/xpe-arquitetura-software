package com.empresa.api.infrastructure.persistence.jpa;

import com.empresa.api.infrastructure.persistence.entity.PedidoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByClienteId(Long clienteId);
}

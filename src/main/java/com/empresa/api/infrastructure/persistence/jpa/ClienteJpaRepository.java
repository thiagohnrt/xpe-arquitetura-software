package com.empresa.api.infrastructure.persistence.jpa;

import com.empresa.api.infrastructure.persistence.entity.ClienteEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {

    List<ClienteEntity> findByNomeContainingIgnoreCase(String nome);
}

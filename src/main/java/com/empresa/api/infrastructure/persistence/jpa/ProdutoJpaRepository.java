package com.empresa.api.infrastructure.persistence.jpa;

import com.empresa.api.infrastructure.persistence.entity.ProdutoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByNomeContainingIgnoreCase(String nome);
}

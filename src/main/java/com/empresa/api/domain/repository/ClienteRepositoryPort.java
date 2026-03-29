package com.empresa.api.domain.repository;

import com.empresa.api.domain.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {

    Cliente save(Cliente cliente);

    Optional<Cliente> findById(Long id);

    List<Cliente> findAll();

    List<Cliente> findByNome(String nome);

    long count();

    void deleteById(Long id);

    boolean existsById(Long id);
}

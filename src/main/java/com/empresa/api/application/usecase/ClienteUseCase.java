package com.empresa.api.application.usecase;

import com.empresa.api.application.dto.ClienteRequest;
import com.empresa.api.application.dto.ClienteResponse;
import java.util.List;

public interface ClienteUseCase {

    ClienteResponse create(ClienteRequest request);

    ClienteResponse update(Long id, ClienteRequest request);

    void delete(Long id);

    ClienteResponse findById(Long id);

    List<ClienteResponse> findAll();

    List<ClienteResponse> findByNome(String nome);

    long count();
}

package com.empresa.api.application.usecase;

import com.empresa.api.application.dto.ProdutoRequest;
import com.empresa.api.application.dto.ProdutoResponse;
import java.util.List;

public interface ProdutoUseCase {

    ProdutoResponse create(ProdutoRequest request);

    ProdutoResponse update(Long id, ProdutoRequest request);

    void delete(Long id);

    ProdutoResponse findById(Long id);

    List<ProdutoResponse> findAll();

    List<ProdutoResponse> findByNome(String nome);

    long count();
}

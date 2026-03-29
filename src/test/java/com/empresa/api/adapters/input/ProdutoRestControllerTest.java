package com.empresa.api.adapters.input;

import com.empresa.api.application.dto.ProdutoRequest;
import com.empresa.api.application.dto.ProdutoResponse;
import com.empresa.api.application.usecase.ProdutoUseCase;
import com.empresa.api.domain.exception.NotFoundException;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProdutoRestControllerTest {

    @Mock
    private ProdutoUseCase produtoUseCase;

    @InjectMocks
    private ProdutoRestController controller;

    @Test
    void shouldListProdutos() {
        when(produtoUseCase.findAll()).thenReturn(List.of(new ProdutoResponse(1L, "Notebook", new BigDecimal("4999.90"))));

        List<ProdutoResponse> response = controller.findAll();

        assertEquals(1, response.size());
        assertEquals("Notebook", response.getFirst().nome());
    }

    @Test
    void shouldCreateProduto() {
        ProdutoRequest request = new ProdutoRequest("Notebook", new BigDecimal("4999.90"));
        when(produtoUseCase.create(request)).thenReturn(new ProdutoResponse(1L, "Notebook", new BigDecimal("4999.90")));

        ProdutoResponse response = controller.create(request);

        assertEquals(1L, response.id());
        verify(produtoUseCase).create(request);
    }

    @Test
    void shouldDeleteProduto() {
        doNothing().when(produtoUseCase).delete(1L);

        assertDoesNotThrow(() -> controller.delete(1L));
        verify(produtoUseCase).delete(1L);
    }

    @Test
    void shouldPropagateNotFoundWhenProdutoDoesNotExist() {
        doThrow(new NotFoundException("Produto nao encontrado: 999")).when(produtoUseCase).delete(999L);

        assertThrows(NotFoundException.class, () -> controller.delete(999L));
    }
}

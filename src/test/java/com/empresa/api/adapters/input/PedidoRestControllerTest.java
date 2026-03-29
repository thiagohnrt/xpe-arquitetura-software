package com.empresa.api.adapters.input;

import com.empresa.api.application.dto.PedidoRequest;
import com.empresa.api.application.dto.PedidoResponse;
import com.empresa.api.application.usecase.PedidoUseCase;
import com.empresa.api.domain.exception.NotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
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
class PedidoRestControllerTest {

    @Mock
    private PedidoUseCase pedidoUseCase;

    @InjectMocks
    private PedidoRestController controller;

    @Test
    void shouldListPedidos() {
        when(pedidoUseCase.findAll()).thenReturn(List.of(new PedidoResponse(1L, 10L, LocalDate.of(2026, 3, 29), new BigDecimal("350.00"))));

        List<PedidoResponse> response = controller.findAll();

        assertEquals(1, response.size());
        assertEquals(10L, response.getFirst().clienteId());
    }

    @Test
    void shouldCreatePedido() {
        PedidoRequest request = new PedidoRequest(10L, LocalDate.of(2026, 3, 29), new BigDecimal("350.00"));
        when(pedidoUseCase.create(request)).thenReturn(new PedidoResponse(1L, 10L, LocalDate.of(2026, 3, 29), new BigDecimal("350.00")));

        PedidoResponse response = controller.create(request);

        assertEquals(1L, response.id());
        verify(pedidoUseCase).create(request);
    }

    @Test
    void shouldDeletePedido() {
        doNothing().when(pedidoUseCase).delete(1L);

        assertDoesNotThrow(() -> controller.delete(1L));
        verify(pedidoUseCase).delete(1L);
    }

    @Test
    void shouldPropagateNotFoundWhenPedidoDoesNotExist() {
        doThrow(new NotFoundException("Pedido nao encontrado: 999")).when(pedidoUseCase).delete(999L);

        assertThrows(NotFoundException.class, () -> controller.delete(999L));
    }
}

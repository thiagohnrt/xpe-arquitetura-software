package com.empresa.api.adapters.input;

import com.empresa.api.application.dto.ClienteRequest;
import com.empresa.api.application.dto.ClienteResponse;
import com.empresa.api.application.usecase.ClienteUseCase;
import com.empresa.api.domain.exception.NotFoundException;
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
class ClienteRestControllerTest {

    @Mock
    private ClienteUseCase clienteUseCase;

    @InjectMocks
    private ClienteRestController controller;

    @Test
    void shouldListClientes() {
        when(clienteUseCase.findAll()).thenReturn(List.of(new ClienteResponse(1L, "Ana", "ana@email.com")));

        List<ClienteResponse> response = controller.findAll();

        assertEquals(1, response.size());
        assertEquals("Ana", response.getFirst().nome());
    }

    @Test
    void shouldCreateCliente() {
        ClienteRequest request = new ClienteRequest("Ana", "ana@email.com");
        when(clienteUseCase.create(request)).thenReturn(new ClienteResponse(1L, "Ana", "ana@email.com"));

        ClienteResponse response = controller.create(request);

        assertEquals(1L, response.id());
        verify(clienteUseCase).create(request);
    }

    @Test
    void shouldDeleteCliente() {
        doNothing().when(clienteUseCase).delete(1L);

        assertDoesNotThrow(() -> controller.delete(1L));
        verify(clienteUseCase).delete(1L);
    }

    @Test
    void shouldPropagateNotFoundWhenClienteDoesNotExist() {
        doThrow(new NotFoundException("Cliente nao encontrado: 999")).when(clienteUseCase).delete(999L);

        assertThrows(NotFoundException.class, () -> controller.delete(999L));
    }
}

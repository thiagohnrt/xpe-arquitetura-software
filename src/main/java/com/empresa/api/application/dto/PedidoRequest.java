package com.empresa.api.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(name = "PedidoRequest", description = "Dados para criacao ou atualizacao de pedido")
public record PedidoRequest(
    @NotNull(message = "clienteId e obrigatorio")
    @Schema(description = "ID do cliente associado ao pedido", example = "1")
    Long clienteId,
    @NotNull(message = "dataPedido e obrigatorio")
    @Schema(description = "Data do pedido", example = "2026-03-29")
    LocalDate dataPedido,
    @NotNull(message = "valorTotal e obrigatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "valorTotal deve ser maior que zero")
    @Schema(description = "Valor total do pedido", example = "1499.90", minimum = "0.01")
    BigDecimal valorTotal
) {
}

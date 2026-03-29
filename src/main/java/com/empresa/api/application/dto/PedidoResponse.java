package com.empresa.api.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(name = "PedidoResponse", description = "Dados de pedido retornados pela API")
public record PedidoResponse(
    @Schema(description = "Identificador unico do pedido", example = "1")
    Long id,
    @Schema(description = "ID do cliente associado ao pedido", example = "1")
    Long clienteId,
    @Schema(description = "Data do pedido", example = "2026-03-29")
    LocalDate dataPedido,
    @Schema(description = "Valor total do pedido", example = "1499.90")
    BigDecimal valorTotal
) {
}

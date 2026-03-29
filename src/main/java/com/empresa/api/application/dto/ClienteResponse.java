package com.empresa.api.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ClienteResponse", description = "Dados de cliente retornados pela API")
public record ClienteResponse(
    @Schema(description = "Identificador unico do cliente", example = "1")
    Long id,
    @Schema(description = "Nome completo do cliente", example = "Maria Souza")
    String nome,
    @Schema(description = "Email do cliente", example = "maria.souza@empresa.com")
    String email
) {
}

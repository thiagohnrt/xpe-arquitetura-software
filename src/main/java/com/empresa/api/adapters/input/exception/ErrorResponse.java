package com.empresa.api.adapters.input.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(name = "ErrorResponse", description = "Resposta padrao para erros da API")
public record ErrorResponse(
    @Schema(description = "Data e hora em que o erro ocorreu", example = "2026-03-29T10:30:00")
    LocalDateTime timestamp,
    @Schema(description = "Codigo HTTP de status", example = "400")
    int status,
    @Schema(description = "Descricao curta do erro HTTP", example = "Bad Request")
    String error,
    @Schema(description = "Mensagem detalhada do erro", example = "Nome e obrigatorio")
    String message,
    @Schema(description = "Caminho da requisicao que gerou o erro", example = "/clientes")
    String path
) {
}

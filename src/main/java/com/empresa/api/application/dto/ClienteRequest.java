package com.empresa.api.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "ClienteRequest", description = "Dados para criacao ou atualizacao de cliente")
public record ClienteRequest(
    @NotBlank(message = "Nome e obrigatorio")
    @Schema(description = "Nome completo do cliente", example = "Maria Souza")
    String nome,
    @NotBlank(message = "Email e obrigatorio")
    @Email(message = "Email invalido")
    @Schema(description = "Email do cliente", example = "maria.souza@empresa.com", format = "email")
    String email
) {
}

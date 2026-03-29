package com.empresa.api.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Schema(name = "ProdutoRequest", description = "Dados para criacao ou atualizacao de produto")
public record ProdutoRequest(
    @NotBlank(message = "Nome e obrigatorio")
    @Schema(description = "Nome do produto", example = "Notebook X1")
    String nome,
    @NotNull(message = "Preco e obrigatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preco deve ser maior que zero")
    @Schema(description = "Preco unitario do produto", example = "3500.00", minimum = "0.01")
    BigDecimal preco
) {
}

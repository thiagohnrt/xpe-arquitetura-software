package com.empresa.api.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Schema(name = "ProdutoResponse", description = "Dados de produto retornados pela API")
public record ProdutoResponse(
    @Schema(description = "Identificador unico do produto", example = "1")
    Long id,
    @Schema(description = "Nome do produto", example = "Notebook X1")
    String nome,
    @Schema(description = "Preco unitario do produto", example = "3500.00")
    BigDecimal preco
) {
}

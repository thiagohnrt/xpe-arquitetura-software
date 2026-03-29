package com.empresa.api.adapters.input;

import com.empresa.api.adapters.input.exception.ErrorResponse;
import com.empresa.api.application.dto.PedidoRequest;
import com.empresa.api.application.dto.PedidoResponse;
import com.empresa.api.application.usecase.PedidoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@Tag(name = "Pedidos", description = "Operacoes relacionadas a pedidos")
public class PedidoRestController {

    private final PedidoUseCase pedidoUseCase;

    public PedidoRestController(PedidoUseCase pedidoUseCase) {
        this.pedidoUseCase = pedidoUseCase;
    }

    @GetMapping
    @Operation(summary = "Listar pedidos", description = "Retorna todos os pedidos cadastrados")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisicao invalida", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public List<PedidoResponse> findAll() {
        return pedidoUseCase.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pedido por ID", description = "Retorna os dados de um pedido a partir do ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
        @ApiResponse(responseCode = "400", description = "Requisicao invalida", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Pedido nao encontrado", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public PedidoResponse findById(
        @PathVariable
        @Parameter(description = "ID do pedido", example = "1", required = true)
        Long id
    ) {
        return pedidoUseCase.findById(id);
    }

    @GetMapping("/nome/{nome}")
    @Operation(summary = "Buscar pedidos por nome", description = "Retorna pedidos associados ao criterio de nome informado")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisicao invalida", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public List<PedidoResponse> findByNome(
        @PathVariable
        @Parameter(description = "Nome utilizado no criterio de busca", example = "Maria", required = true)
        String nome
    ) {
        return pedidoUseCase.findByNome(nome);
    }

    @GetMapping("/count")
    @Operation(summary = "Contar pedidos", description = "Retorna a quantidade total de pedidos cadastrados")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Contagem retornada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisicao invalida", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public long count() {
        return pedidoUseCase.count();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar pedido", description = "Cria um novo pedido com os dados informados")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados invalidos ou regra de negocio violada", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public PedidoResponse create(
        @Valid
        @RequestBody
        @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados para criacao do pedido", required = true)
        PedidoRequest request
    ) {
        return pedidoUseCase.create(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar pedido", description = "Atualiza os dados de um pedido existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados invalidos ou regra de negocio violada", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Pedido nao encontrado", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public PedidoResponse update(
        @PathVariable
        @Parameter(description = "ID do pedido", example = "1", required = true)
        Long id,
        @Valid
        @RequestBody
        @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados para atualizacao do pedido", required = true)
        PedidoRequest request
    ) {
        return pedidoUseCase.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir pedido", description = "Remove um pedido existente pelo ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Pedido removido com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisicao invalida", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Pedido nao encontrado", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public void delete(
        @PathVariable
        @Parameter(description = "ID do pedido", example = "1", required = true)
        Long id
    ) {
        pedidoUseCase.delete(id);
    }
}

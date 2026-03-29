package com.empresa.api.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

    private Long id;
    private Long clienteId;
    private LocalDate dataPedido;
    private BigDecimal valorTotal;

    public Pedido() {
    }

    public Pedido(Long id, Long clienteId, LocalDate dataPedido, BigDecimal valorTotal) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}

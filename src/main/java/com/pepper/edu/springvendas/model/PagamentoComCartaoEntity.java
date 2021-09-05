package com.pepper.edu.springvendas.model;

import com.pepper.edu.springvendas.enums.EstadoPagamentoEnum;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartaoEntity extends AbstractPagamentoEntity {

    private Integer numeroDeParcelas;

    public PagamentoComCartaoEntity() {
    }

    public PagamentoComCartaoEntity(Integer id, EstadoPagamentoEnum estado, PedidoEntity pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}

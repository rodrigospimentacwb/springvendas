package com.pepper.edu.springvendas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pepper.edu.springvendas.enums.EstadoPagamentoEnum;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoComBoletoEntity extends AbstractPagamentoEntity {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamento;

    public PagamentoComBoletoEntity() {
    }

    public PagamentoComBoletoEntity(Integer id, EstadoPagamentoEnum estado, PedidoEntity pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}

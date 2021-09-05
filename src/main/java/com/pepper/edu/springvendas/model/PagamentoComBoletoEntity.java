package com.pepper.edu.springvendas.model;

import com.pepper.edu.springvendas.enums.EstadoPagamentoEnum;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoComBoletoEntity extends AbstractPagamentoEntity {

    private Date dataVencimento;
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

package com.pepper.edu.springvendas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pepper.edu.springvendas.enums.EstadoPagamentoEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PAGAMENTO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractPagamentoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer estado;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    @JsonIgnore
    private PedidoEntity pedido;

    public AbstractPagamentoEntity() {
    }

    public AbstractPagamentoEntity(Integer id, EstadoPagamentoEnum estado, PedidoEntity pedido) {
        this.id = id;
        this.estado = (estado == null) ? null : estado.getCod();
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamentoEnum getEstado() {
        return EstadoPagamentoEnum.toEnum(estado);
    }

    public void setEstado(EstadoPagamentoEnum estado) {
        this.estado = estado.getCod();
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPagamentoEntity that = (AbstractPagamentoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

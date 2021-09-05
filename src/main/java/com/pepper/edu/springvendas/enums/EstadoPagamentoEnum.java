package com.pepper.edu.springvendas.enums;

public enum EstadoPagamentoEnum {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private Integer cod;
    private String descricao;

    EstadoPagamentoEnum(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod(){
        return cod;
    }

    public String getDescricao(){
        return descricao;
    }

    public static EstadoPagamentoEnum toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for (EstadoPagamentoEnum x : EstadoPagamentoEnum.values()) {
            if(cod.equals(x.cod)){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}

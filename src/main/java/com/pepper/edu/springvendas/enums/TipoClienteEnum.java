package com.pepper.edu.springvendas.enums;

public enum TipoClienteEnum {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private Integer cod;
    private String descricao;

    TipoClienteEnum(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod(){
        return cod;
    }

    public String getDescricao(){
        return descricao;
    }

    public static TipoClienteEnum toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for (TipoClienteEnum x : TipoClienteEnum.values()) {
            if(cod.equals(x.cod)){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}

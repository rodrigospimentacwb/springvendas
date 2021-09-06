package com.pepper.edu.springvendas.controller.dto;

import com.pepper.edu.springvendas.model.CategoriaEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Max(value = 80, message = "O tamanho deve ter até 80 caracteres")
    @Min(value = 5, message = "O tamanho deve ser maior que 5 caracteres")
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO(CategoriaEntity obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

package com.pepper.edu.springvendas.service;

import com.pepper.edu.springvendas.model.CategoriaEntity;
import com.pepper.edu.springvendas.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public CategoriaEntity buscar(Integer id) {
        Optional<CategoriaEntity> categoria = repository.findById(id);
        return categoria.orElse(null);
    }
}

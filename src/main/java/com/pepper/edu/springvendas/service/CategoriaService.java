package com.pepper.edu.springvendas.service;

import com.pepper.edu.springvendas.exceptions.ObjectNotFoundException;
import com.pepper.edu.springvendas.model.CategoriaEntity;
import com.pepper.edu.springvendas.repository.CategoriaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaEntity find(Integer id) {
        Optional<CategoriaEntity> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaEntity.class.getName()));
    }

    public CategoriaEntity insert(CategoriaEntity categoria){
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public CategoriaEntity update(CategoriaEntity categoria) {
        find(categoria.getId());
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id) {
        find(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new com.pepper.edu.springvendas.exceptions.DataIntegrityViolationException("Não é possível excluir uma categoria que possui produtos");
        }
    }

    public List<CategoriaEntity> findAll() {
        return categoriaRepository.findAll();
    }
}

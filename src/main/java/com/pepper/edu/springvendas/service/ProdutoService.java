package com.pepper.edu.springvendas.service;

import com.pepper.edu.springvendas.exceptions.ObjectNotFoundException;
import com.pepper.edu.springvendas.model.CategoriaEntity;
import com.pepper.edu.springvendas.model.ProdutoEntity;
import com.pepper.edu.springvendas.repository.CategoriaRepository;
import com.pepper.edu.springvendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoEntity find(Integer id) {
        Optional<ProdutoEntity> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + ProdutoEntity.class.getName()));
    }

    public Page<ProdutoEntity> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        List<CategoriaEntity> categorias = categoriaRepository.findAllById(ids);
        return produtoRepository.findPage(nome, categorias, pageRequest);
    }
}

package com.pepper.edu.springvendas.repository;

import com.pepper.edu.springvendas.model.CategoriaEntity;
import com.pepper.edu.springvendas.model.ProdutoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {

    @Transactional(readOnly=true)
    @Query("SELECT DISTINCT obj FROM ProdutoEntity obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
    Page<ProdutoEntity> findPage(
            @Param("nome") String nome,
            @Param("categorias") List<CategoriaEntity> categorias,
            Pageable pageRequest);

//    @Transactional(readOnly=true)
//    Page<ProdutoEntity> findDistinctByNomeContainingAndCategoriasIn(
//            String nome,
//            List<CategoriaEntity> categorias,
//            Pageable pageRequest);
}

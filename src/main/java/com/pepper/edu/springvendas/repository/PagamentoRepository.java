package com.pepper.edu.springvendas.repository;

import com.pepper.edu.springvendas.model.AbstractPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<AbstractPagamentoEntity, Integer> {

}

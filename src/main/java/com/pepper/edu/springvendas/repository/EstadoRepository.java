package com.pepper.edu.springvendas.repository;

import com.pepper.edu.springvendas.model.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoEntity, Integer> {

}

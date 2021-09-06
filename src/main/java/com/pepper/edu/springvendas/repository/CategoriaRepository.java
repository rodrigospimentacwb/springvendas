package com.pepper.edu.springvendas.repository;

import com.pepper.edu.springvendas.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {


}

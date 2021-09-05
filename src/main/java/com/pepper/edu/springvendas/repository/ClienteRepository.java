package com.pepper.edu.springvendas.repository;

import com.pepper.edu.springvendas.model.CategoriaEntity;
import com.pepper.edu.springvendas.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

}

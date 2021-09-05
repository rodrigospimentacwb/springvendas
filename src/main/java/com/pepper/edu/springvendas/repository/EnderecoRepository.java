package com.pepper.edu.springvendas.repository;

import com.pepper.edu.springvendas.model.ClienteEntity;
import com.pepper.edu.springvendas.model.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

}

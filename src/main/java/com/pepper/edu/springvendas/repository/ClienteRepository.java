package com.pepper.edu.springvendas.repository;

import com.pepper.edu.springvendas.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    @Transactional(readOnly = true)
    ClienteEntity findByEmail(String email);
}

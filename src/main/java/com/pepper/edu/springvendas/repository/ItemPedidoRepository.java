package com.pepper.edu.springvendas.repository;

import com.pepper.edu.springvendas.model.ItemPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Integer> {

}

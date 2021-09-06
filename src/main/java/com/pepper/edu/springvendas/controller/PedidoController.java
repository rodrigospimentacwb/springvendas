package com.pepper.edu.springvendas.controller;

import com.pepper.edu.springvendas.model.PedidoEntity;
import com.pepper.edu.springvendas.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PedidoEntity> find(@PathVariable Integer id){
        PedidoEntity pedido = pedidoService.find(id);
        return ResponseEntity.ok().body(pedido);
    }

}

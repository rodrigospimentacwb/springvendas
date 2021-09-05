package com.pepper.edu.springvendas.controller;

import com.pepper.edu.springvendas.model.ClienteEntity;
import com.pepper.edu.springvendas.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        ClienteEntity cliente = clienteService.find(id);
        return ResponseEntity.ok().body(cliente);
    }

}

package com.pepper.edu.springvendas.controller;

import com.pepper.edu.springvendas.controller.dto.ClienteDTO;
import com.pepper.edu.springvendas.model.ClienteEntity;
import com.pepper.edu.springvendas.model.ClienteEntity;
import com.pepper.edu.springvendas.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClienteEntity> find(@PathVariable Integer id){
        ClienteEntity cliente = clienteService.find(id);
        return ResponseEntity.ok().body(cliente);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id){
        ClienteEntity cliente = clienteService.fromDTO(objDto);
        cliente.setId(id);
        cliente = clienteService.update(cliente);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<ClienteEntity> clientes = clienteService.findAll();
        List<ClienteDTO> clientesDto = clientes.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(clientesDto);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome")String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC")String direction){
        Page<ClienteEntity> clientes = clienteService.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> clientesDto = clientes.map(obj -> new ClienteDTO(obj));
        return ResponseEntity.ok().body(clientesDto);
    }
    
}

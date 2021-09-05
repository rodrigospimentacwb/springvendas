package com.pepper.edu.springvendas.service;

import com.pepper.edu.springvendas.exceptions.ObjectNotFoundException;
import com.pepper.edu.springvendas.model.ClienteEntity;
import com.pepper.edu.springvendas.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteEntity find(Integer id) {
        Optional<ClienteEntity> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + ClienteEntity.class.getName()));
    }
}

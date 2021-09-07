package com.pepper.edu.springvendas.service;

import com.pepper.edu.springvendas.controller.dto.ClienteDTO;
import com.pepper.edu.springvendas.exceptions.ObjectNotFoundException;
import com.pepper.edu.springvendas.model.ClienteEntity;
import com.pepper.edu.springvendas.repository.ClienteRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public ClienteEntity update(ClienteEntity cliente) {
        ClienteEntity newObj = find(cliente.getId());
        updateData(newObj, cliente);
        return clienteRepository.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new com.pepper.edu.springvendas.exceptions.DataIntegrityViolationException(
                    "Não é possível excluir este cliente porque há entidades relacionadas");
        }
    }

    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    public Page<ClienteEntity> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return clienteRepository.findAll(pageRequest);
    }

    public ClienteEntity fromDTO(ClienteDTO dto){
        return new ClienteEntity(dto.getId(), dto.getNome(), dto.getEmail(), null, null);
    }

    private void updateData(ClienteEntity newObj, ClienteEntity cliente) {
        newObj.setNome(cliente.getNome());
        newObj.setEmail(cliente.getEmail());
    }
}

package com.pepper.edu.springvendas.service;

import com.pepper.edu.springvendas.controller.dto.ClienteDTO;
import com.pepper.edu.springvendas.controller.dto.ClienteNewDTO;
import com.pepper.edu.springvendas.enums.TipoClienteEnum;
import com.pepper.edu.springvendas.exceptions.ObjectNotFoundException;
import com.pepper.edu.springvendas.model.CategoriaEntity;
import com.pepper.edu.springvendas.model.CidadeEntity;
import com.pepper.edu.springvendas.model.ClienteEntity;
import com.pepper.edu.springvendas.model.EnderecoEntity;
import com.pepper.edu.springvendas.repository.CidadeRepository;
import com.pepper.edu.springvendas.repository.ClienteRepository;
import com.pepper.edu.springvendas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final CidadeRepository cidadeRepository;
    private final EnderecoRepository enderecoRepository;

    public ClienteService(ClienteRepository clienteRepository, CidadeRepository cidadeRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.cidadeRepository = cidadeRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public ClienteEntity find(Integer id) {
        Optional<ClienteEntity> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + ClienteEntity.class.getName()));
    }

    public ClienteEntity insert(ClienteEntity cliente){
        cliente.setId(null);
        cliente = clienteRepository.save(cliente);
        enderecoRepository.saveAll(cliente.getEnderecos());
        return cliente;
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
                    "Não é possível excluir este cliente porque há pedidos relacionados");
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

    public ClienteEntity fromDTO(ClienteNewDTO dto){
        ClienteEntity cli = new ClienteEntity(null, dto.getNome(), dto.getEmail(), dto.getCpfOuCnpj(), TipoClienteEnum.toEnum(dto.getTipo()));
        Optional<CidadeEntity> cid = cidadeRepository.findById(dto.getCidadeId());
        EnderecoEntity end = new EnderecoEntity(null, dto.getLogradouro(), dto.getNumero(), dto.getComplemento(), dto.getBairro(), dto.getCep(), cli, cid.get());
        cli.getEnderecos().add(end);
        cli.getTelefones().add(dto.getTelefone1());
        if(dto.getTelefone2() != null){
            cli.getTelefones().add(dto.getTelefone2());
        }
        if(dto.getTelefone3() != null){
            cli.getTelefones().add(dto.getTelefone3());
        }
        return cli;
    }

    private void updateData(ClienteEntity newObj, ClienteEntity cliente) {
        newObj.setNome(cliente.getNome());
        newObj.setEmail(cliente.getEmail());
    }
}

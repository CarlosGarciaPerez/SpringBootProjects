package com.api.modelMapper.service;

import com.api.modelMapper.Clientemapper;
import com.api.modelMapper.dto.ClienteDTO;
import com.api.modelMapper.model.Cliente;
import com.api.modelMapper.repository.IClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private Clientemapper clienteMapper;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IClienteRepository clienteRepository;

    public ClienteDTO save(ClienteDTO clienteDTO){
        Cliente cliente = mapper.map(clienteDTO, Cliente.class);
        return mapper.map(clienteRepository.save(cliente), ClienteDTO.class);
    }

    public List<ClienteDTO> getClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(cliente -> mapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    public ClienteDTO getCliente(Integer id){
        Cliente cliente = clienteRepository.findById(id).get();
        return mapper.map(cliente, ClienteDTO.class);
    }

    public ClienteDTO update(Integer id, ClienteDTO clienteDTO){
        Cliente cliente = clienteRepository.findById(id).get();
        mapper.map(clienteDTO, cliente);
        Cliente updateCliente = clienteRepository.save(cliente);
        return mapper.map(updateCliente, ClienteDTO.class);
    }

    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }


}

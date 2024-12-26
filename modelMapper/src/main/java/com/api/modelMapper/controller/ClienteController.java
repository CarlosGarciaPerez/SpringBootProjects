package com.api.modelMapper.controller;

import com.api.modelMapper.dto.ClienteDTO;
import com.api.modelMapper.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public ResponseEntity<ClienteDTO> saveCliente(@RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<>(clienteService.save(clienteDTO), HttpStatus.CREATED);
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteDTO>> getClientes(){
        return new ResponseEntity<>(clienteService.getClientes(),HttpStatus.OK);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable Integer clienteId){
        return new ResponseEntity<>(clienteService.getCliente(clienteId),HttpStatus.OK);
    }

    @PutMapping("/cliente/{clienteId}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Integer clienteId, @RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<>(clienteService.update(clienteId,clienteDTO),HttpStatus.OK);
    }

    @DeleteMapping("/cliente/{clienteId}")
    public ResponseEntity<?> deleteCliente(@PathVariable Integer clienteId){
        clienteService.delete(clienteId);
        return new ResponseEntity<>("Cliente eliminado!",HttpStatus.OK);
    }



}

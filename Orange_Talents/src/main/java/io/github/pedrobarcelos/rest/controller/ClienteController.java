package io.github.pedrobarcelos.rest.controller;

import io.github.pedrobarcelos.domain.entity.Cliente;
import io.github.pedrobarcelos.domain.repository.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController( Clientes clientes ) {
        this.clientes = clientes;
    }

    @GetMapping("{cpf}")
    public Cliente getClienteById( @PathVariable String cpf ){
        return clientes
                .findById(cpf)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save( @RequestBody Cliente cliente ){
        return clientes.save(cliente);
    }

    @DeleteMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable String cpf ){
        clientes.findById(cpf)
                .map( cliente -> {
                    clientes.delete(cliente );
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Cliente não encontrado") );

    }

    @PutMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable String cpf,
                        @RequestBody Cliente cliente ){
        clientes
                .findById(cpf)
                .map( clienteExistente -> {
                    cliente.setCpf(clienteExistente.getCpf());
                    clientes.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Cliente não encontrado") );
    }

    @GetMapping
    public List<Cliente> find( Cliente filtro ){
        ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(
                                            ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return clientes.findAll(example);
    }

}

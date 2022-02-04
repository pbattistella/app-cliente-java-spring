package br.com.api.cliente.service;

import br.com.api.cliente.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    public Cliente create(Cliente cliente);
    public Cliente update(Long id, Cliente cliente);
    public void delete(Long id);
    public Optional<Cliente> read(Long id);

    public List<Cliente> findAll();


}

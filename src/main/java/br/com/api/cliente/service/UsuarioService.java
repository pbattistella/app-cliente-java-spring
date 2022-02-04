package br.com.api.cliente.service;

import br.com.api.cliente.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public Usuario create(Usuario usuario);
    public Usuario update (Long id, Usuario usuario);
    public boolean delete(Long id);
    public Optional<Usuario> read(Long id);

    public List<Usuario> findAll();
}

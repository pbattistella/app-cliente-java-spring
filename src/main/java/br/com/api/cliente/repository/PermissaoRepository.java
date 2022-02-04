package br.com.api.cliente.repository;

import br.com.api.cliente.model.Permissao;
import br.com.api.cliente.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

    public List<Permissao> findByUsuariosIn(Usuario ... usuarios);

}

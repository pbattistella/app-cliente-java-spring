package br.com.api.cliente.repository;

import br.com.api.cliente.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void insertUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome("Arnaldo");
        usuario.setUsername("zitrino");
        usuario.setPassword(new BCryptPasswordEncoder().encode("venhaserfeliz"));

        usuarioRepository.save(usuario);
        assertEquals("zitrino", usuario.getUsername());

    }

}
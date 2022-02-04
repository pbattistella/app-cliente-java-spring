package br.com.api.cliente.controller;

import br.com.api.cliente.model.Usuario;
import br.com.api.cliente.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario)
        throws URISyntaxException{
        Usuario createdUsuario = usuarioService.create(usuario);
        if (createdUsuario == null){
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdUsuario.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(createdUsuario);
        }
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable Long id){
        Usuario updatedUsuario = usuarioService.update(id, usuario);
        if (updatedUsuario == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedUsuario);
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Optional<Usuario>> read(@PathVariable Long id){
        Optional<Usuario> foundUsuario = usuarioService.read(id);
        if(foundUsuario.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundUsuario);
        }
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> allUsuarios = usuarioService.findAll();
        if(allUsuarios.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allUsuarios);
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    private ResponseEntity<Object> delete(@PathVariable Long id){
        if (usuarioService.delete(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

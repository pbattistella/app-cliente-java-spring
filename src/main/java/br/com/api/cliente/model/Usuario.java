package br.com.api.cliente.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=80)
    @NotNull
    private String nome;

    @Size(max=150)
    @NotNull
    @Column(unique = true)
    private String username;

    @Size(max=255)
    @NotNull
    private String password;

    @ManyToMany
    @JoinTable(
            name="usuario_permissao",
            joinColumns=@JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name="permissao_id")
    )
    private List<Permissao> permissoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public String toString() {
        return "Usuario: " + id + " - " + nome + ", Username:" + username;

    }
}

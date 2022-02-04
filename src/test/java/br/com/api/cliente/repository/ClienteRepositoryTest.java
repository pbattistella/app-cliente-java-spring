package br.com.api.cliente.repository;

import br.com.api.cliente.model.Cliente;
import br.com.api.cliente.model.Endereco;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteRepositoryTest {

    @Autowired
    ClienteRepository clienteRepository;

    @Test
    public void insertCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome("João da Silva");
        cliente.setEmail("jsilva@gmail.com");
        cliente.setDataNascimento(( Date.valueOf("2000-01-01")));
        assertEquals(cliente, clienteRepository.save(cliente));
    }
}
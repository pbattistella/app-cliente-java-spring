package br.com.api.cliente.controller;

import br.com.api.cliente.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    private String uri = "https://viacep.com.br/ws/{cep}/json" ;

    @GetMapping(value = "/{cep}", produces = "application/json")
    public Endereco getCep(@PathVariable String cep){

        if (!cep.isEmpty()){
            RestTemplate template = new RestTemplate();
            //System.out.println("Endereco: " + template.getForObject(uri, Endereco.class, cep));
            return template.getForObject(uri, Endereco.class, cep);
        } else {
            return  null;
        }
    }
}

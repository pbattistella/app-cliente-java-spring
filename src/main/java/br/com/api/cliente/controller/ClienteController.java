package br.com.api.cliente.controller;

import br.com.api.cliente.model.Cliente;
import br.com.api.cliente.service.ClienteServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    ClienteServiceImple clienteService;

    @GetMapping("/cliente/list")
    public String showClienteList(Model model){
        model.addAttribute("clientes", clienteService.findAll());
        return "cliente/list";
    }

    @GetMapping("/cliente/add")
    public String add(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cliente/add";
    }

    @PostMapping("/cliente/save")
    public String save(Cliente cliente, Model model){
        try{
            if(cliente.getId() == null){
                clienteService.create(cliente);
            } else {
                clienteService.update(cliente.getId(), cliente);
            }
            return "redirect:/cliente/list";
        } catch (Exception e){
            System.out.println(e.getMessage());
            model.addAttribute("cliente", cliente);
            model.addAttribute("erro", true);
            model.addAttribute("erroMsg", "Ocorreu erro ao salvar o cliente.");
            if (cliente.getId() == null) return "cliente/add";
            else return "cliente/edit";
        }
    }

    @GetMapping("/cliente/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("cliente", clienteService.read(id));
        return "cliente/edit";
    }

    @GetMapping("/cliente/delete/{id}")
    public String delete(@PathVariable Long id){
        clienteService.delete(id);
        return "redirect:/cliente/list";
    }
}

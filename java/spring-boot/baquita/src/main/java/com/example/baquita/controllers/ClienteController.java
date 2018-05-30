package com.example.baquita.controllers;

import com.example.baquita.models.Cliente;
import com.example.baquita.models.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by luis.bacca on 5/30/18.
 */
@Controller
@RequestMapping(path="/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(path="/add")
    public @ResponseBody String addNewCliente(@RequestParam String name, @RequestParam String email){
        Cliente cliente = new Cliente();
        cliente.setName(name);
        cliente.setEmail(email);
        clienteRepository.save(cliente);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }


}

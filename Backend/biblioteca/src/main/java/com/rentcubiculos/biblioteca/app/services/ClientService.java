/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcubiculos.biblioteca.app.services;

import com.rentcubiculos.biblioteca.app.entities.Client;
import com.rentcubiculos.biblioteca.app.repositories.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class ClientService {
      @Autowired
    private ClientRepository repository;
    
    //GET todos los registros
    public List<Client> getClients()
    {
        return repository.findAll();
    }
    
    //Registrar
    public Client saveClient(Client client)
    {
        return repository.save(client);
    }
    
    //Actualizar
    public Client updateClient(Client client){
        Client exist = repository.findById(client.getIdClient()).orElse(null);
        exist.setName(client.getName());
        exist.setEmail(client.getEmail());
        exist.setAge(client.getAge());
        exist.setPassword(client.getPassword());
        return repository.save(exist);        
    }
    
    //Borrar
    public String deleteClient(int id)
    {
        repository.deleteById(id);
        return "Cliente removido" + id;
    }
}

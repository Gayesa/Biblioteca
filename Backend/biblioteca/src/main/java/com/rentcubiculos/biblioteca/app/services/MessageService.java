/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcubiculos.biblioteca.app.services;

import com.rentcubiculos.biblioteca.app.entities.Message;
import com.rentcubiculos.biblioteca.app.repositories.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class MessageService {
      @Autowired
    private MessageRepository repository;
    
    //GET todos los registros
    public List<Message> getMessages()
    {
        return repository.findAll();
    }
    
    //Registrar
    public Message saveMessage(Message message)
    {
        return repository.save(message);
    }
    
    //Actualizar
    public Message updateMessage(Message message){
        Message exist = repository.findById(message.getIdMessage()).orElse(null);
        exist.setMessageText(message.getMessageText());              
        return repository.save(exist);        
    }
    
    //Borrar
    public String deleteMessage(int id)
    {
        repository.deleteById(id);
        return "Mensaje removido" + id;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcubiculos.biblioteca.app.repositories;
import com.rentcubiculos.biblioteca.app.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author johan
 */
public interface MessageRepository extends JpaRepository<Message,Integer>{
    
}

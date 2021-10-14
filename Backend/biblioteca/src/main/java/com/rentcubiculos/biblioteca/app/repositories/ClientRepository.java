/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcubiculos.biblioteca.app.repositories;

import com.rentcubiculos.biblioteca.app.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author johan
 */
public interface ClientRepository extends JpaRepository<Client,Integer> {
    
}

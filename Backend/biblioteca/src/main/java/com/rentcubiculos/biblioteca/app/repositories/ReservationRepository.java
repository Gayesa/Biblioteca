/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rentcubiculos.biblioteca.app.repositories;

import com.rentcubiculos.biblioteca.app.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author johan
 */
public interface ReservationRepository extends JpaRepository<Reservation,Integer>{
    
}

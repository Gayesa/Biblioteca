/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentcubiculos.biblioteca.app.services;

import com.rentcubiculos.biblioteca.app.entities.Reservation;
import com.rentcubiculos.biblioteca.app.repositories.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;
    
     //GET todos los registros
    public List<Reservation> getReservations()
    {
        return repository.findAll();
    }
    
    //Registrar
    public Reservation saveReservation(Reservation reservation)
    {
        return repository.save(reservation);
    }
    
    //Actualizar
    public Reservation updateReservation(Reservation reservation){
        Reservation exist = repository.findById(reservation.getIdReservation()).orElse(null);
        exist.setStartDate(reservation.getStartDate());
        exist.setDevolutionDate(reservation.getDevolutionDate());
        exist.setStatus(reservation.getStatus());        
        return repository.save(exist);        
    }
    
    //Borrar
    public String deleteReservation(int id)
    {
        repository.deleteById(id);
        return "Reservacion eliminada" + id;
    }
    
}

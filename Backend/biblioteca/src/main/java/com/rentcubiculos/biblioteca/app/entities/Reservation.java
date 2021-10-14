/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentcubiculos.biblioteca.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author johan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation implements Serializable {
    @Id 
   @GeneratedValue( strategy = GenerationType.IDENTITY)
   private int idReservation;
    
   private Date startDate;
   
   private Date devolutionDate;
   
   private String status="created";
   
   @ManyToOne
   @JoinColumn(name="idLibrary")
   @JsonIgnoreProperties("reservations")
   private Library lib;
   
   @ManyToOne
   @JoinColumn(name="idClient")
   @JsonIgnoreProperties({"reservations","messages"})
   private Client client;
   
   //@OneToOne (cascade={CascadeType.REMOVE},mappedBy="reservation")
   @OneToOne(cascade = CascadeType.ALL)
   @JsonIgnoreProperties("reservation")
   @JoinColumn(name = "idScore")
   private Score score;
   
}

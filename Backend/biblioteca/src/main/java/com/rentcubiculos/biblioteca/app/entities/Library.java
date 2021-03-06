/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcubiculos.biblioteca.app.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="library")
public class Library implements Serializable {
   @Id 
   @GeneratedValue( strategy = GenerationType.IDENTITY)
   @Column(name="idLibrary")
   private int id;
   
   @Column(length = 45)
   private String name;
   
   @Column(length = 45)
   private String target;
   
   private int capacity;   
  
   @Column(length = 250)
   private String description;
   
   //Relaciones
   @ManyToOne
   @JoinColumn(name="id")
   @JsonIgnoreProperties("libs")
   private Category category;
   
   
   @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="lib")
   @JsonIgnoreProperties("lib")
   private List<Message> messages;
  
   @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="lib")
   @JsonIgnoreProperties("lib")
   private List<Reservation> reservations;
   

}

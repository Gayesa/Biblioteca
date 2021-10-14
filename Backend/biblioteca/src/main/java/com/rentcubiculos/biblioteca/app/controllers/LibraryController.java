/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcubiculos.biblioteca.app.controllers;
import com.rentcubiculos.biblioteca.app.entities.Library;
import com.rentcubiculos.biblioteca.app.services.LibraryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author johan
 */
@RestController
@RequestMapping("Lib")
public class LibraryController {
    @Autowired
    private LibraryService service;
    
    @GetMapping("/all")
    public List<Library> findAllLibrary(){
        return service.getLibraries();
    }
    
    @PostMapping("/save")
    public ResponseEntity insertLibrary(@RequestBody Library library){
        service.saveLibrary(library);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateLibrary(@RequestBody Library library){
        service.updateLibrary(library);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteLibrary(@RequestBody Library library){
        service.deleteLibrary(library.getIdLibrary());
        return ResponseEntity.status(204).build();
    } 
}

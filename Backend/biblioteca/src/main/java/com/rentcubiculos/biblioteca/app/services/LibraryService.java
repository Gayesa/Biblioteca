/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcubiculos.biblioteca.app.services;

import com.rentcubiculos.biblioteca.app.entities.Library;
import com.rentcubiculos.biblioteca.app.repositories.LibraryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class LibraryService {
    @Autowired
    private LibraryRepository repository;
    
    //GET todos los registros
    public List<Library> getLibraries()
    {
        return repository.findAll();
    }
    
    //Registrar
    public Library saveLibrary(Library library)
    {
        return repository.save(library);
    }
    
    //Actualizar
    public Library updateLibrary(Library library){
        Library exist = repository.findById(library.getIdLibrary()).orElse(null);
        exist.setName(library.getName());
        exist.setTarget(library.getTarget());
        exist.setCapacity(library.getCapacity());
        //exist.setCategory(library.getCategory());
        return repository.save(exist);        
    }
    
    //Borrar
    public String deleteLibrary(int id)
    {
        repository.deleteById(id);
        return "Cubiculo removido" + id;
    }
    
    //Buscar por nombre
    public Library getLibraryByName(String name){
        return repository.findByName(name);
    }
    
    //Buscar por id
    public Library getLibraryById(int id){
        return repository.findById(id).orElse(null);
    }
    
}

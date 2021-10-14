/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcubiculos.biblioteca.app.services;

import com.rentcubiculos.biblioteca.app.entities.Category;
import com.rentcubiculos.biblioteca.app.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    
     //GET todos los registros
    public List<Category> getCategories()
    {
        return repository.findAll();
    }
    
    //Registrar
    public Category saveCategory(Category category)
    {
        return repository.save(category);
    }
    
    //Actualizar
    public Category updateCategory(Category category){
        Category exist = repository.findById(category.getIdCategory()).orElse(null);
        exist.setName(category.getName());
        exist.setDescription(category.getDescription());       
        return repository.save(exist);        
    }
    
    //Borrar
    public String deleteCategory(int id)
    {
        repository.deleteById(id);
        return "Categoria removida" + id;
    }
     
    
}

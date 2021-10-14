/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcubiculos.biblioteca.app.controllers;

import com.rentcubiculos.biblioteca.app.entities.Category;
import com.rentcubiculos.biblioteca.app.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author johan
 */
@RestController
@RequestMapping("Category")
public class CategoryController {
    @Autowired
    private CategoryService service;
    
    @GetMapping("/all")
    public List<Category> findAllCategory(){
        return service.getCategories();
    }
    
    @PostMapping("/save")
    public ResponseEntity insertCategory(@RequestBody Category category){
        service.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category){
        service.updateCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteCategory(@RequestBody Category category){
        service.deleteCategory(category.getId());
        return ResponseEntity.status(204).build();
    } 
    
}

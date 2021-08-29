package com.pepper.edu.springvendas.controller;

import com.pepper.edu.springvendas.model.CategoriaEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @RequestMapping(method = RequestMethod.GET)
    public List<CategoriaEntity> listar(){

        CategoriaEntity cat1 = new CategoriaEntity(1,"Informática");
        CategoriaEntity cat2 = new CategoriaEntity(2,"Escritório");
        return List.of(cat1,cat2);
    }

}

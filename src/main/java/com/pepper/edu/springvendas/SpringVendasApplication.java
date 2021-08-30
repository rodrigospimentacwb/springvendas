package com.pepper.edu.springvendas;

import com.pepper.edu.springvendas.model.CategoriaEntity;
import com.pepper.edu.springvendas.repository.CategoriaRepository;
import com.pepper.edu.springvendas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringVendasApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringVendasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        CategoriaEntity cat1 = new CategoriaEntity(null, "Informática");
        CategoriaEntity cat2 = new CategoriaEntity(null, "Escritório");

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
    }
}

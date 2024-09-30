package com.salesianostriana.dam.monumentos.controller;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repository.Monumentosrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MonumentosController {

    private final Monumentosrepository monumentosrepository;
    private final com.salesianostriana.dam.monumentos.repository.repositoryMonumentos repositoryMonumentos;


    @GetMapping("/monumento/")
    public ResponseEntity<List<Monumento>> getAll() {
        List<Monumento> result = repositoryMonumentos.findAll();

        if (result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);

    }


    @GetMapping("/monumento/{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id) {
        return ResponseEntity.of(monumentosrepository.findById(id));

    }

    @PostMapping("/monumento/")
    public ResponseEntity<Monumento> create(@RequestBody Monumento monumento) {
        Monumento nuevo = monumentosrepository.save(monumento);

        return ResponseEntity.status(201).body(nuevo);
    }

}

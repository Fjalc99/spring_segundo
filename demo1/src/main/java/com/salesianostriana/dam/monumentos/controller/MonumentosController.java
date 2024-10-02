package com.salesianostriana.dam.monumentos.controller;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentosRepository;
import com.salesianostriana.dam.monumentos.service.MonumentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MonumentosController {

    private final MonumentosRepository monumentosrepository;


    private final MonumentosService monumentosservice;
    private final MonumentosService monumentosService;


    @GetMapping("/monumento/")
    public ResponseEntity<List<Monumento>> obtenerMonumentos() {
        List<Monumento> monumentos = monumentosrepository.findAll();

        if (monumentos.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(monumentos);

    }


    @GetMapping("/monumento/{id}")
    public ResponseEntity<Monumento> obtenerMonumentoPorId(@PathVariable Long id) {
        Monumento monumento = monumentosrepository.findById(id).orElse(null);

        return monumento != null ? ResponseEntity.ok(monumento) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping("/monumento/")
    public ResponseEntity<Monumento> guardarMonumento(@RequestBody Monumento monumento) {
        Monumento nuevoMonumento = monumentosrepository.save(monumento);

        return ResponseEntity.status(201).body(nuevoMonumento);
    }

    @PutMapping("/monumento/{id}")
    public ResponseEntity<Monumento> editarMonumento(@PathVariable Long id, @RequestBody Monumento monumento) {

        return ResponseEntity.ok(monumentosService.editarMonumento(monumento,id));
    }

    @DeleteMapping("/monumento/{id}")
    public ResponseEntity<?> eliminarMonumento(@PathVariable Long id) {

        if (monumentosrepository.existsById(id)){
            monumentosService.eliminarMonumento(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }



    }

}

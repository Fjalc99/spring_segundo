package com.salesianostriana.dam.monumentos.controller;

import com.salesianostriana.dam.monumentos.models.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentoRepository;
import com.salesianostriana.dam.monumentos.service.MonumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/monumento/")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentorepository;
    private final MonumentoService monumentoService;


/*
    @GetMapping("/monumento/")
    public ResponseEntity<List<Monumento>> obtenerMonumentos() {
        List<Monumento> monumentos = monumentorepository.findAll();

        if (monumentos.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(monumentos);

    }

    */



    @GetMapping
    public ResponseEntity<List<Monumento>> obtenerMonumentos(@RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection) {
     List<Monumento> result = monumentoService.query(sortDirection);
     if (result.isEmpty())
         return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/monumento/{id}")
    public ResponseEntity<Monumento> obtenerMonumentoPorId(@PathVariable Long id) {
        Monumento monumento = monumentorepository.findById(id).orElse(null);

        return monumento != null ? ResponseEntity.ok(monumento) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping
    public ResponseEntity<Monumento> crearMonumento(@RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentorepository.save(monumento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> editarMonumento(@RequestBody Monumento monumento, @PathVariable Long id) {
        return monumentoService.editarMonumento(monumento, id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMonumento(@PathVariable Long id) {
        monumentorepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
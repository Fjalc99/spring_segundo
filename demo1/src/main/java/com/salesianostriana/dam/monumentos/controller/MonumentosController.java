package com.salesianostriana.dam.monumentos.controller;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MonumentosController {

    private final MonumentosRepository monumentosrepository;



    @GetMapping("/monumento/")
    public ResponseEntity<List<Monumento>> getAll() {
        List<Monumento> result = monumentosrepository.findAll();

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

    @PutMapping("/monumento/{id}")
    public ResponseEntity<Monumento> edit(@PathVariable Long id,
                                       @RequestBody Monumento monumento) {

        return ResponseEntity.of(monumentosrepository.findById(id)
                .map(antiguo -> {
                        antiguo.setNombrePais(monumento.getNombrePais());
                        antiguo.setImagen(monumento.getImagen());
                        antiguo.setLatitud(monumento.getLatitud());
                        antiguo.setLongitud(monumento.getLongitud());
                        antiguo.setCodigoPais(monumento.getCodigoPais());
                        antiguo.setNombreCiudad(monumento.getNombreCiudad());
                        antiguo.setNombreMonumento(monumento.getNombreMonumento());
                        antiguo.setDescripcion(monumento.getDescripcion());
                    return monumentosrepository.save(antiguo);
                }));
    }

    @DeleteMapping("/monumento/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (monumentosrepository.existsById(id))
            monumentosrepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

}

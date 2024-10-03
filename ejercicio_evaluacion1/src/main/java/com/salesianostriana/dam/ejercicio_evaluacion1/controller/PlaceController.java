package com.salesianostriana.dam.ejercicio_evaluacion1.controller;

import com.salesianostriana.dam.ejercicio_evaluacion1.model.Place;
import com.salesianostriana.dam.ejercicio_evaluacion1.repository.PlaceRepository;
import com.salesianostriana.dam.ejercicio_evaluacion1.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    private final PlaceRepository placeRepository;

    @GetMapping("/places/")
    public ResponseEntity<List<Place>> obtenerTodos() {
        List<Place> places = placeService.obtenerTodos();

        if (places.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(places);
    }

    @GetMapping("/places/{id}")
    public ResponseEntity<Place> obtenerUno(@PathVariable Long id){

        Place place = placeService.obtenerUno(id).orElse(null);
        return place != null ? ResponseEntity.ok(place): ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/places/")
    public ResponseEntity<Place> addPlace(@RequestBody Place place){
        Place nuevoPlace = placeRepository.save(place);

        return ResponseEntity.status(201).body(nuevoPlace);
    }

    @PutMapping("/places/{id}")
    public ResponseEntity<Place> editarPlace (@PathVariable Long id, @RequestBody Place place){
        return ResponseEntity.ok(placeService.editarPlace(place,id));
    }

    @DeleteMapping("/places/{id}")
    public ResponseEntity<Place> eliminarPlace(@PathVariable Long id, @RequestBody Place place){

        if (placeRepository.existsById(id)){
            placeService.eliminarPlace(id);

            return ResponseEntity.ok().build();

        }else{
            return ResponseEntity.notFound().build();
        }
    }

}

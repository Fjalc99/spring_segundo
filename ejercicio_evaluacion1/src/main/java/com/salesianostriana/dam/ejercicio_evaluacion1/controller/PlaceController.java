package com.salesianostriana.dam.ejercicio_evaluacion1.controller;

import com.salesianostriana.dam.ejercicio_evaluacion1.model.Place;
import com.salesianostriana.dam.ejercicio_evaluacion1.model.Tag;
import com.salesianostriana.dam.ejercicio_evaluacion1.repository.PlaceRepository;
import com.salesianostriana.dam.ejercicio_evaluacion1.repository.TagRepository;
import com.salesianostriana.dam.ejercicio_evaluacion1.service.PlaceService;
import com.salesianostriana.dam.ejercicio_evaluacion1.service.TagService;
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

    private final TagService tagService;
    private final TagRepository tagRepository;

    @GetMapping("/place/")
    public ResponseEntity<List<Place>> obtenerTodos() {
        List<Place> places = placeService.obtenerTodos();

        if (places.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(places);
    }

    @GetMapping("/place/{id}")
    public ResponseEntity<Place> obtenerUno(@PathVariable Long id){

        Place place = placeService.obtenerUno(id).orElse(null);
        return place != null ? ResponseEntity.ok(place): ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/place/")
    public ResponseEntity<Place> addPlace(@RequestBody Place place){
        Place nuevoPlace = placeRepository.save(place);

        return ResponseEntity.status(201).body(nuevoPlace);
    }

    @PutMapping("/place/{id}")
    public ResponseEntity<Place> editarPlace (@PathVariable Long id, @RequestBody Place place){
        if (placeRepository.existsById(id)){
            return ResponseEntity.ok(placeService.editarPlace(place,id));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/place/{id}")
    public ResponseEntity<?> eliminarPlace(@PathVariable Long id){

        if (placeRepository.existsById(id)){
            placeService.eliminarPlace(id);

            return ResponseEntity.ok().build();

        }else{
            return ResponseEntity.notFound().build();
        }
    }

 /*  @PutMapping("/place/id/tag/add/{nuevo_tag")
    public ResponseEntity<Place> agregarTag (@RequestBody Place place, @PathVariable Long id){

        return agregarTag();
    } */





}

package com.salesianostriana.dam.ejercicio_evaluacion1.controller;

import com.salesianostriana.dam.ejercicio_evaluacion1.model.Place;
import com.salesianostriana.dam.ejercicio_evaluacion1.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/places/")
    public ResponseEntity<List<Place>> obtenerTodos() {
        List<Place> places = placeService.obtenerTodos();

        if (places.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(places);
    }



}

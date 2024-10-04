package com.salesianostriana.dam.ejercicio_evaluacion1.initData;


import com.salesianostriana.dam.ejercicio_evaluacion1.model.Place;
import com.salesianostriana.dam.ejercicio_evaluacion1.model.Tag;
import com.salesianostriana.dam.ejercicio_evaluacion1.repository.PlaceRepository;
import com.salesianostriana.dam.ejercicio_evaluacion1.repository.TagRepository;
import com.salesianostriana.dam.ejercicio_evaluacion1.service.PlaceService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final TagRepository tagRepository;
    private final PlaceRepository placeRepository;

    @PostConstruct
    public void initData(){

       placeRepository.save((Place.builder()
               .nombre("TroteBurguer")
               .direccion("Bollullos de la mitación")
               .descripcion("Hamburguesas de buena calidad y carne madurada")
               .latitud("37°20′23.64″ N")
               .longitud("6°8′15.65″ W")
               .foto("https://lh3.googleusercontent.com/p/AF1QipMjhWQHEqeBlyFNM06uQPavIoRWesuCxClUwMeG=s680-w680-h510")
               .tags(new ArrayList<>())
               .build()));

        placeRepository.save((Place.builder()
                .nombre("Telepizza")
                .direccion("Bollullos de la mitación")
                .descripcion("Hamburguesas de buena calidad y carne madurada")
                .latitud("37°20′23.64″ N")
                .longitud("6°8′15.65″ W")
                .foto("https://lh3.googleusercontent.com/p/AF1QipMjhWQHEqeBlyFNM06uQPavIoRWesuCxClUwMeG=s680-w680-h510")
                .tags(new ArrayList<>())
                .build()));



        tagRepository.save(Tag.builder()
                .nombreEtiqueta("Domicilio")
                .places(new ArrayList<>())
                .build());



    }




}

package com.salesianostriana.dam.ejercicio_evaluacion1.service;

import com.salesianostriana.dam.ejercicio_evaluacion1.model.Place;
import com.salesianostriana.dam.ejercicio_evaluacion1.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;


    public List<Place> obtenerTodos(){
        return placeRepository.findAll();
    }

    public Optional<Place> obtenerUno(Long id){
        return placeRepository.findById(id);
    }


    public Place addPlace (Place p){
        return  placeRepository.save(p);
    }

    public Place editarPlace(Place p){
        return  placeRepository.save(p);
    }



}

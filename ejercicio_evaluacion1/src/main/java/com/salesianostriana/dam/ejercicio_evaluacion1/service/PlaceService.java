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


    public void addPlace (Place p){

          placeRepository.save(p);
    }

    public Place editarPlace(Place place, Long id){

        Place placeAntiguo = placeRepository.findById(id).orElse(null);

        if (placeAntiguo != null) {
            return placeRepository.save(place);
        }
        return place;
    }

    public void eliminarPlace(Long id){
        placeRepository.deleteById(id);
    }

}

package com.salesianostriana.dam.ejercicio_evaluacion1.initData;


import com.salesianostriana.dam.ejercicio_evaluacion1.model.Place;
import com.salesianostriana.dam.ejercicio_evaluacion1.repository.PlaceRepository;
import com.salesianostriana.dam.ejercicio_evaluacion1.service.PlaceService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

    private final PlaceService  placeService;
    private final PlaceRepository placeRepository;

    @PostConstruct
    public void initData(){

       Place burguer = new Place();
       burguer.setNombre("TroteBurguer");
       burguer.setDireccion("Bollullos de la mitación");
       burguer.setLatitud("37°20′23.64″ N");
       burguer.setLongitud(" 6°8′15.65″ W");
       burguer.setDescripcion("Hamburguesas de buena calidad y carne madurada");
       burguer.setFoto("https://lh3.googleusercontent.com/p/AF1QipMjhWQHEqeBlyFNM06uQPavIoRWesuCxClUwMeG=s680-w680-h510");

       placeRepository.save(burguer);
    }

}

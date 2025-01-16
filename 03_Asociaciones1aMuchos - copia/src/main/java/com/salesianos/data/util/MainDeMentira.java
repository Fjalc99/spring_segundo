package com.salesianos.data.util;

import com.salesianos.data.model.Actor;
import com.salesianos.data.model.Pelicula;
import com.salesianos.data.repos.ActorRepository;
import com.salesianos.data.repos.PeliculaRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ActorRepository   actorRepository;
    private final PeliculaRepository    peliculaRepository;

    @PostConstruct
    public void run(){

        Actor a =  Actor.builder()
                .apellidos("Alcantarilla Calado")
                .nombre("Francisco")
                .build();

        Actor a1 =  Actor.builder()
                .apellidos("Ortega Lucena")
                .nombre("Marisa")
                .build();

        Pelicula p = Pelicula.builder()
                .nombre("La que se avecina")
                .build();

        Pelicula p1 = Pelicula.builder()
                .nombre("La que se avecina")
                .build();

        p.addActores(a);
        p1.addActores(a1);

        peliculaRepository.save(p);
        actorRepository.save(a);

        peliculaRepository.save(p1);
        actorRepository.save(a1);


    }

}

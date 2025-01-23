package com.salesianos.singleTable.dataSeed;



import com.salesianos.singleTable.Service.ContenidoService;
import com.salesianos.singleTable.models.Cancion;
import com.salesianos.singleTable.models.Contenido;
import com.salesianos.singleTable.models.Pelicula;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private  final ContenidoService contenidoService;


    @PostConstruct
    public void run(){

        Pelicula p = Pelicula.builder()
                .creador("Marisa")
                .genero("Romance")
                .titulo("Your Name")
                .duracion(130)
                .build();

        Cancion c = Cancion.builder()
                .duracion(3.55)
                .titulo("Opening 1")
                .creador("Fran")
                .album("Jujutsu Kaisen")
                .build();


        contenidoService.save(p);
        contenidoService.save(c);


        System.out.println("Lista de todo el contenido:");
        List<Contenido> contenidos = contenidoService.getAll();
        contenidos.forEach(System.out::println);

    }

}

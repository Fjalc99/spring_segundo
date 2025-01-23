package com.salesianos.joined.dataSeed;

import com.salesianos.joined.models.Cirujano;
import com.salesianos.joined.models.Enfermero;
import com.salesianos.joined.models.Trabajador;
import com.salesianos.joined.repository.TrabajadorRepository;
import com.salesianos.joined.service.TrabajadorService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {


    private final TrabajadorService trabajadorService;

    @PostConstruct
    public void run(){

        Cirujano c = Cirujano.builder()
                .nombre("Fran")
                .apellidos("Alcantarilla Calado")
                .numConsulta("10")
                .build();

        Enfermero e = Enfermero.builder()
                .nombre("Marisa")
                .apellidos("Ortega Lucena")
                .areaDetrabajo("Radiologia")
                .build();


        trabajadorService.saveTrabajador(c);
        trabajadorService.saveTrabajador(e);

        List<Trabajador> trabajadores = trabajadorService.getAll();
        trabajadores.forEach(System.out::println);

    }
}

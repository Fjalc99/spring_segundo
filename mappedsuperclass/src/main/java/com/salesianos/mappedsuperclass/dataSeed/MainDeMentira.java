package com.salesianos.mappedsuperclass.dataSeed;


import com.salesianos.mappedsuperclass.models.Coche;
import com.salesianos.mappedsuperclass.models.Moto;
import com.salesianos.mappedsuperclass.models.Vehiculo;
import com.salesianos.mappedsuperclass.service.VehiculoService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final VehiculoService vehiculoService;

    @PostConstruct
    public void run(){

        Moto m = Moto.builder()
                .marca("Honda")
                .cilindrada(250)
                .modelo("Q3")
                .build();

        Coche c = Coche.builder()
                .modelo("RS7")
                .marca("Audi")
                .numeroDePuertas(4)
                .build();


        vehiculoService.saveCoche(c);
        vehiculoService.saveMoto(m);

        vehiculoService.listCoche().forEach(System.out::println);
        vehiculoService.listMoto().forEach(System.out::println);

    }

}

package com.salesianostriana.dam.monumentos.initData;


import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentosRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

    private final MonumentosRepository monumentosRepository;

    @PostConstruct
    public void initData() {


        Monumento giralda = new Monumento();
        giralda.setDescripcion("La giralda es de los monumentos mas antiguo de sevilla");
        giralda.setNombreMonumento("Giralda");
        giralda.setLatitud("37°23′10″N");
        giralda.setLongitud("5°59′33″O");
        giralda.setImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/240px-La_Giralda_August_2012_Seville_Spain.jpg");
        giralda.setId(1);
        giralda.setNombreCiudad("Sevilla");
        giralda.setCodigoPais("ES");
        giralda.setNombrePais("España");

        monumentosRepository.save(giralda);


        Monumento mezquita = new Monumento();
        mezquita.setDescripcion("La Mezquita es de los monumentos mas antiguo de Cordoba");
        mezquita.setNombreMonumento("Mezquita");
        mezquita.setLatitud("37°52′44″N");
        mezquita.setLongitud("4°46′46″O");
        mezquita.setImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Cordoba_Cathedral_2024_-_Overview.jpg/280px-Cordoba_Cathedral_2024_-_Overview.jpg");
        mezquita.setId(2);
        mezquita.setNombreCiudad("Cordoba");
        mezquita.setCodigoPais("ES");
        mezquita.setNombrePais("España");

        monumentosRepository.save(mezquita);


    }
}

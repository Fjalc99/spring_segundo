package com.salesianostriana.dam.monumentos.initData;

import com.salesianostriana.dam.monumentos.models.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

    private final MonumentoRepository monumentoRepository;

    @PostConstruct
    public void init() {

        Monumento giralda = new Monumento();
        giralda.setDescripcion("La giralda es de los monumentos mas antiguo de sevilla");
        giralda.setNombreMonumento("Giralda");
        giralda.setLatitud("37°23′10″N");
        giralda.setLongitud("5°59′33″O");
        giralda.setImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/240px-La_Giralda_August_2012_Seville_Spain.jpg");
        giralda.setNombreCiudad("Sevilla");
        giralda.setCodPais("ES");
        giralda.setNombrePais("España");
        monumentoRepository.save(giralda);

        Monumento mezquita = new Monumento();
        mezquita.setDescripcion("La Mezquita es de los monumentos mas antiguo de Cordoba");
        mezquita.setNombreMonumento("Mezquita");
        mezquita.setLatitud("37°52′44″N");
        mezquita.setLongitud("4°46′46″O");
        mezquita.setImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Cordoba_Cathedral_2024_-_Overview.jpg/280px-Cordoba_Cathedral_2024_-_Overview.jpg");
        mezquita.setNombreCiudad("Cordoba");
        mezquita.setCodPais("ES");
        mezquita.setNombrePais("España");
        monumentoRepository.save(mezquita);

        Monumento plazaVazquezDeMolina = new Monumento();
        plazaVazquezDeMolina.setDescripcion("La Plaza Vázquez de Molina es de los monumentos mas antiguo de Jaén");
        plazaVazquezDeMolina.setNombreMonumento("Plaza Vázquez de Molina");
        plazaVazquezDeMolina.setLatitud("37°52′44″N");
        plazaVazquezDeMolina.setLongitud("4°46′46″O");
        plazaVazquezDeMolina.setImagen("https://upload.wikimedia.org/wikipedia/commons/6/6f/Iglesia_del_salvador_ubeda_001.jpg");
        plazaVazquezDeMolina.setNombreCiudad("Jaén");
        plazaVazquezDeMolina.setCodPais("ES");
        plazaVazquezDeMolina.setNombrePais("España");
        monumentoRepository.save(plazaVazquezDeMolina);
    }
}
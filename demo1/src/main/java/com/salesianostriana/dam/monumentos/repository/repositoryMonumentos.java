package com.salesianostriana.dam.monumentos.repository;


import com.salesianostriana.dam.monumentos.model.Monumento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class repositoryMonumentos {

    private List<Monumento> monumento;

    public repositoryMonumentos() {
        monumento = new ArrayList<Monumento>();


        monumento.add(
                Monumento.builder()
                        .id(1)
                        .nombrePais("Spain")
                        .nombreCiudad("Seville")
                        .latitud("37° 20' 44.54376\" N ")
                        .longitud(" 5° 58' 17.61925\" W")
                        .nombreMonumento("Giralda")
                        .descripcion("La Giralda es la torre campanario de la catedral de Santa María de la Sede de la ciudad de Sevilla, en Andalucía (España).")
                        .imagen("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/240px-La_Giralda_August_2012_Seville_Spain.jpg")
                        .build()
        );

    }

    public List<Monumento> findAll() {
        return Collections.unmodifiableList(monumento);
    }

    public Optional<Monumento> findById(int id) {
        return monumento.stream().filter(a -> a.getId() == id).findFirst();
    }

    public Monumento save(Monumento m) {
        monumento.add(m);
        return m;
    }

    public Monumento edit(Monumento m) {
        int pos;
        if ((pos = indexOf(m.getId())) == -1) {
            return save(m);
        }
        else {
            return monumento.set(pos, m);
        }
    }


    public void delete(Monumento m) {
        int pos;
        if ((pos = indexOf(m.getId())) != -1) {
            monumento.remove(pos);
        }
    }




    private int indexOf(Long id) {

        int pos = -1;

        for(int i = 0; i < monumento.size() && pos == -1; i++) {
            if (monumento.get(i).getId() == id)
                pos = i;
        }

        return pos;
    }
}

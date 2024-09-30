package com.salesianostriana.dam.monumentos.repository;


import com.salesianostriana.dam.monumentos.model.Monumentos;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class repositoryMonumentos {

    private List<Monumentos> monumentos;

    public repositoryMonumentos() {
        monumentos = new ArrayList<Monumentos>();

    }

    public List<Monumentos> findAll() {
        return Collections.unmodifiableList(monumentos);
    }

    public Optional<Monumentos> findById(int id) {
        return monumentos.stream().filter(a -> a.getId() == id).findFirst();
    }

    public Monumentos save(Monumentos m) {
        monumentos.add(m);
        return m;
    }

    public Monumentos edit(Monumentos m) {
        int pos;
        if ((pos = indexOf(m.getId())) == -1) {
            return save(m);
        }
        else {
            return monumentos.set(pos, m);
        }
    }


    public void delete(Monumentos m) {
        int pos;
        if ((pos = indexOf(m.getId())) != -1) {
            monumentos.remove(pos);
        }
    }




    private int indexOf(Long id) {

        int pos = -1;

        for(int i = 0; i < monumentos.size() && pos == -1; i++) {
            if (monumentos.get(i).getId() == id)
                pos = i;
        }

        return pos;
    }
}

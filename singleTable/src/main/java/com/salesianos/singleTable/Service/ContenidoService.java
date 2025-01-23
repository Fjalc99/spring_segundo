package com.salesianos.singleTable.Service;


import com.salesianos.singleTable.models.Contenido;
import com.salesianos.singleTable.repository.ContenidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContenidoService {

    private final ContenidoRepository contenidoRepository;


    public Contenido save(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    public List<Contenido> getAll (){
        return contenidoRepository.findAll();
    }

    public Optional<Contenido> getById(Long id){
        return contenidoRepository.findById(id);
    }

    public void deleteContenido(Long id){
        contenidoRepository.deleteById(id);
    }
}

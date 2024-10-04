package com.salesianostriana.dam.monumentos.service;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonumentosService {

    private final MonumentosRepository monumentosRepository;


    public List <Monumento> obtenerMonumentos() {
        return monumentosRepository.findAll();
    }

    public Optional<Monumento> obtenerMonumentoPorId(Long id) {
        return monumentosRepository.findById(id);
    }

    public void guardarMonumento(Monumento monumento) {
        monumentosRepository.save(monumento);
    }

    public  void eliminarMonumento(Long id) {
        monumentosRepository.deleteById(id);
    }

    public Monumento editarMonumento(Monumento monumento, Long id) {
        Monumento monumentoAntiguo = monumentosRepository.findById(id).orElse(null);

        if (monumentoAntiguo != null) {
           return monumentosRepository.save(monumento);
        }
        return monumento;
    }
}

package com.salesianostriana.dam.monumentos.service;

import com.salesianostriana.dam.monumentos.models.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    private final MonumentoRepository monumentoRepository;

    public List<Monumento> obtenerMonumentos() {
        return monumentoRepository.findAll();
    }

    public Optional<Monumento> obtenerMonumentoPorId(Long id) {
        return monumentoRepository.findById(id);
    }

    public void guardarMonumento(Monumento monumento) {
        monumentoRepository.save(monumento);
    }

    public void eliminarMonumento(Long id) {
        monumentoRepository.deleteById(id);
    }

    public Optional<Monumento> editarMonumento(Monumento monumento, Long id) {
        return monumentoRepository.findById(id)
                .map(m -> {
                    m.setNombreCiudad(monumento.getNombreCiudad());
                    m.setNombreMonumento(monumento.getNombreMonumento());
                    m.setDescripcion(monumento.getDescripcion());
                    m.setLatitud(monumento.getLatitud());
                    m.setLongitud(monumento.getLongitud());
                    m.setImagen(monumento.getImagen());
                    m.setCodPais(monumento.getCodPais());
                    m.setNombrePais(monumento.getNombrePais());
                    return monumentoRepository.save(m);
                });

    }

    public List<Monumento> query(String sortDirection) {
        List<Monumento> result = monumentoRepository.findAll();

        if (sortDirection.equalsIgnoreCase("asc"))
            result.sort(Comparator.comparing(Monumento::getNombreCiudad));
        else if (sortDirection.equalsIgnoreCase("desc"))
            result.sort(Comparator.comparing(Monumento::getNombreCiudad).reversed());

        return Collections.unmodifiableList(result);
    }

}

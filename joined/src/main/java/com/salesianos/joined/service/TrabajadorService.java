package com.salesianos.joined.service;

import com.salesianos.joined.models.Trabajador;
import com.salesianos.joined.repository.TrabajadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;


    public List<Trabajador> getAll(){
        return trabajadorRepository.findAll();
    }

    public Optional<Trabajador> getTrabajador(Long id){
        return trabajadorRepository.findById(id);
    }

    public Trabajador saveTrabajador(Trabajador trabajador){
        return trabajadorRepository.save(trabajador);
    }

    public void deleteTrabajador(Long id){
        trabajadorRepository.deleteById(id);
    }

}

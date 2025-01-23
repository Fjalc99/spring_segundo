package com.salesianos.mappedsuperclass.service;

import com.salesianos.mappedsuperclass.models.Coche;
import com.salesianos.mappedsuperclass.models.Moto;
import com.salesianos.mappedsuperclass.models.Vehiculo;
import com.salesianos.mappedsuperclass.repository.CocheRepository;
import com.salesianos.mappedsuperclass.repository.MotoRepository;
import com.salesianos.mappedsuperclass.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final MotoRepository motoRepository;
    private final CocheRepository cocheRepository;








    public Coche saveCoche(Coche coche){
        return cocheRepository.save(coche);
    }

    public List<Coche> listCoche(){
        return cocheRepository.findAll();
    }



    public Moto saveMoto(Moto moto){
        return motoRepository.save(moto);
    }

    public List<Moto> listMoto(){
        return motoRepository.findAll();
    }


}

package com.salesianostriana.dam.ejercicio_evaluacion1.service;


import com.salesianostriana.dam.ejercicio_evaluacion1.model.Tag;
import com.salesianostriana.dam.ejercicio_evaluacion1.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository   tagRepository;

    private List<Tag> obtenerTags(){
        return tagRepository.findAll();
    }

    private Optional<Tag> obtenerTagId(Long id){
        return tagRepository.findById(id);

    }

    private void guardarTag(Tag tag){
        tagRepository.save(tag);
    }


    private Tag editarTag(Tag tag, Long id){
        Tag nuevoTag = tagRepository.findById(id).orElse(null);
        if (nuevoTag != null){
            return tagRepository.save(tag);
        }
        return tag;
    }


    private void eliminarTag(Long id){

        tagRepository.deleteById(id);
    }
}

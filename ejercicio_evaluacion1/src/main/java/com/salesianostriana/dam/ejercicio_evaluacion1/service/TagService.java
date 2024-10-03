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

    public List<Tag> obtenerTags(){

        return tagRepository.findAll();
    }

    public Optional<Tag> obtenerTagId(Long id){
        return tagRepository.findById(id);

    }

    public void guardarTag(Tag tag){
        tagRepository.save(tag);
    }


    public Tag editarTag(Tag tag, Long id){
        Tag nuevoTag = tagRepository.findById(id).orElse(null);
        if (nuevoTag != null){
            return tagRepository.save(tag);
        }
        return tag;
    }


    public void eliminarTag(Long id){

        tagRepository.deleteById(id);
    }
}

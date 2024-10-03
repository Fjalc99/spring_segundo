package com.salesianostriana.dam.ejercicio_evaluacion1.controller;

import com.salesianostriana.dam.ejercicio_evaluacion1.model.Tag;
import com.salesianostriana.dam.ejercicio_evaluacion1.repository.TagRepository;
import com.salesianostriana.dam.ejercicio_evaluacion1.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TagController {


    private final TagService tagService;

    private final TagRepository tagRepository;


    @GetMapping("/tag/")
    public ResponseEntity<List<Tag>> obtenerTodosTags(){
        List<Tag> listaTags = tagService.obtenerTags();
        if (listaTags.isEmpty()){
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok().build();
    }



}

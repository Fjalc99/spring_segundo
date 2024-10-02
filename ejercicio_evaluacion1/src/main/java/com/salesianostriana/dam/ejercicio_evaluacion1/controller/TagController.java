package com.salesianostriana.dam.ejercicio_evaluacion1.controller;

import com.salesianostriana.dam.ejercicio_evaluacion1.model.Tag;
import com.salesianostriana.dam.ejercicio_evaluacion1.repository.TagRepository;
import com.salesianostriana.dam.ejercicio_evaluacion1.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TagController {

    @Autowired
    private TagService tagService;
    @Autowired
    private TagRepository tagRepository;




}

package com.salesianos.data.controller;

import com.salesianos.data.dto.EditCategoriaCmd;
import com.salesianos.data.dto.GetCategoriaDto;
import com.salesianos.data.model.Categoria;
import com.salesianos.data.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria/")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<GetCategoriaDto> getAllCategorias() {
        return categoriaService.findAll()
                .stream()
                .map(GetCategoriaDto::of).toList();
    }

    @GetMapping("/{id}")
    public GetCategoriaDto getByIdCategoria(Long id) {
        return GetCategoriaDto.of(categoriaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody EditCategoriaCmd nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        categoriaService.save(nuevo));
    }


    @PutMapping("/{id}")
    public Categoria edit(@RequestBody EditCategoriaCmd aEditar,
                          @PathVariable Long id) {
        return categoriaService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }



}

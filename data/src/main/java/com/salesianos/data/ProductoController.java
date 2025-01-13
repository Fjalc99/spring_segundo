package com.salesianos.data;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto/")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService   productoService;

    @GetMapping
    public List<Producto> getAll(){
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto getByID(@PathVariable Long id){
        return productoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto nuevo){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(nuevo));
    }

    @PutMapping("/{id}")
    public  Producto edit (@RequestBody Producto producto, @PathVariable Long id){
        return productoService.edit(producto, id);
    }

    @DeleteMapping("/{id}")
    public void delete (Long id){
        productoService.delete(id);
    }

}

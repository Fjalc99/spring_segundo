package com.salesianos.data;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository repo;

    @PostConstruct
    public void run(){
        Producto p = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto")
                .precio(123.45)
                .build();
        repo.save(p);
    }

}

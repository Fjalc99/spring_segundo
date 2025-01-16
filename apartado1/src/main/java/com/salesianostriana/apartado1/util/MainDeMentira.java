package com.salesianostriana.apartado1.util;


import com.salesianostriana.apartado1.models.Categoria;
import com.salesianostriana.apartado1.models.Producto;
import com.salesianostriana.apartado1.repository.CategoriaRepository;
import com.salesianostriana.apartado1.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository  productoRepository;
    private final CategoriaRepository categoriaRepository;


    @PostConstruct
    public void  run(){


        Producto p1 = Producto.builder()
                .nombre("Mac")
                .pvp(1234.99)
                .build();

        Producto p2 = Producto.builder()
                .nombre("Disco de los beatles")
                .pvp(12345.99)
                .build();


        Categoria categoriaSuperior = Categoria.builder()
                .nombre("Movil")
                .build();

        categoriaRepository.save(categoriaSuperior);




        Categoria c1 = Categoria.builder()
                .nombre("Tecnologia")
                .build();

        Categoria c2 = Categoria.builder()
                .nombre("Musica")
                .build();


        categoriaSuperior.addCategoriaSuperior(categoriaSuperior);

        categoriaRepository.save(categoriaSuperior);



        productoRepository.save(p1);
        categoriaRepository.save(c1);

        productoRepository.save(p2);
        categoriaRepository.save(c2);

        c1.addProducto(p1);
        c2.addProducto(p2);










    }

}

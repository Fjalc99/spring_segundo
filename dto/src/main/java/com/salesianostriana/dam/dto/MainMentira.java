package com.salesianostriana.dam.dto;

import com.salesianostriana.dam.dto.apartado1.dto.ProductoDto;
import com.salesianostriana.dam.dto.apartado1.models.Categoria;
import com.salesianostriana.dam.dto.apartado1.models.Producto;
import com.salesianostriana.dam.dto.apartado2.dto.AlumnoDto;
import com.salesianostriana.dam.dto.apartado2.models.Alumno;
import com.salesianostriana.dam.dto.apartado2.models.Curso;
import com.salesianostriana.dam.dto.apartado2.models.Direccion;

import java.util.List;

public class MainMentira {
     public static  void main(String[] args) {

         Categoria categoria = new Categoria();
         categoria.setId(1L);
         categoria.setNombre("Categoria 1");

            Producto producto = Producto.builder()
                    .id(1L)
                    .nombre("Producto 1")
                    .desc("Descripción del producto 1")
                    .pvp(100.0)
                    .imagenes(List.of("imagen1.jpg", "imagen2.jpg"))
                    .categoria(categoria)
                    .build();

            ProductoDto productoDto = ProductoDto.of(producto);
            System.out.println(productoDto);




         Direccion direccion = Direccion.builder()
                 .id(1L)
                 .tipoVia("Calle")
                 .linea1("Calle Falsa, 123")
                 .linea2("aaaa")
                 .cp("41000")
                 .poblacion("Sevilla")
                 .provincia("Sevilla")
                 .build();

         Curso curso = Curso.builder()
                 .id(1L)
                 .nombre("1º DAM")
                 .tipo("Diurno")
                 .tutor("Fernando")
                 .aula("Aula 101")
                 .build();


         Alumno alumno = Alumno.builder()
                 .id(1L)
                 .nombre("Pepe")
                 .apellido1("Pérez")
                 .apellido2("García")
                 .telefono("123456789")
                 .email("fjalcantarilla@gmail.com")
                 .direccion(direccion)
                 .curso(curso)
                 .build();
         AlumnoDto alumnoDto =  AlumnoDto.of(alumno);
         System.out.println(alumnoDto);
     }
}

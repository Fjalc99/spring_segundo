package com.salesianostriana.apartado2.util;

import com.salesianostriana.apartado2.models.CursoOnline;
import com.salesianostriana.apartado2.models.Profesor;
import com.salesianostriana.apartado2.models.Video;
import com.salesianostriana.apartado2.repository.CursoRepository;
import com.salesianostriana.apartado2.repository.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final CursoRepository cursoRepository;
    private final ProfesorRepository profesorRepository;

    @PostConstruct
    public void run(){



        Profesor p = Profesor.builder()
                .nombre("Fran")
                .email("a@gmail.com")
                .puntuacion(9.0)
                .build();

        CursoOnline c = CursoOnline.builder()
                .nombre("Spring")
                .build();

        Video v = Video.builder()
                .url("adadada")
                .orden("aadadadada")
                .descripcion("adadadadada")
                .build();

        profesorRepository.save(p);
        cursoRepository.save(c);

        c.addVideos(v);
        v.addCurso(c);


        profesorRepository.save(p);
        cursoRepository.save(c);

        System.out.println(p);
        System.out.println(v);
        System.out.println(c);
    }
}

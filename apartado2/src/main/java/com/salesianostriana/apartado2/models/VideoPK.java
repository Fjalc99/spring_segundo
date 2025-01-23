package com.salesianostriana.apartado2.models;

import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoPK{

    private Long id;
    private CursoOnline cursoOnline;

}

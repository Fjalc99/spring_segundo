package com.salesianostriana.apartado2.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    private String orden;
}

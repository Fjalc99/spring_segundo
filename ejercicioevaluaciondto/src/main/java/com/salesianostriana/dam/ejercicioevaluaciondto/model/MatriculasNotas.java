package com.salesianostriana.dam.ejercicioevaluaciondto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculasNotas {

    @Id
    @GeneratedValue
    private LocalDate año;

    private double nota;
}

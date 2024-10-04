package com.salesianostriana.dam.ejercicio_evaluacion1.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Place {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String direccion;

    private String  latitud;

    private String longitud;

    private String descripcion;

    private String foto;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("places")
    @JoinTable(name="place_tag", joinColumns = @JoinColumn(name="place_id"), foreignKey = @ForeignKey(name = "FK_place_tag"),
     inverseJoinColumns  = @JoinColumn(name = "tag_id"))
    private List <Tag> tags;

    public void addTag(Tag t) {
        if (this.getTags()==null) {
            this.setTags((new ArrayList<>()));
        }
        this.getTags().add(t);

        if (t.getPlaces()==null)
            t.setPlaces(new ArrayList<>());
        t.getPlaces().add(this);
    }

    public void removeTag(Tag t) {
       t.getPlaces().remove(this);
       this.getTags().remove(t);
    }









}

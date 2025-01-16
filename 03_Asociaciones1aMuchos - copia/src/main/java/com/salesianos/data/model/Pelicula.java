package com.salesianos.data.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Pelicula {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "peliculas", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private Set<Actor> actores = new HashSet<>();


    //Metodo helper

    public void addActores (Actor actor){
       actor.getPeliculas().add(this);
       actores.add(actor);
    }

    public void removeActores(Actor actor){
        actores.remove(actor);
        actor.getPeliculas().remove(this);
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Pelicula pelicula = (Pelicula) o;
        return getId() != null && Objects.equals(getId(), pelicula.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

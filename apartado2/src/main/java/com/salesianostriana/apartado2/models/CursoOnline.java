package com.salesianostriana.apartado2.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double puntuacion;

    @ManyToOne(cascade = CascadeType.ALL)
    private Profesor profesor;


    @OneToMany(mappedBy = "cursoOnline",
    fetch = FetchType.EAGER,
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @ToString.Exclude
    @Builder.Default
    private List<Video> listaVideos = new ArrayList<>();





    public void addVideos(Video v){
        v.setCursoOnline(this);
        listaVideos.add(v);
    }

    public void removeVideos(Video v){
        listaVideos.remove(v);
        v.setCursoOnline(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CursoOnline that = (CursoOnline) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

package com.salesianostriana.apartado2.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@IdClass(VideoPK.class)
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    @Id
    @ManyToOne
    private CursoOnline cursoOnline;

    private String orden;

    private String titulo;

    private String descripcion;

    private String url;

    public void addCurso (CursoOnline c){
        c.getListaVideos().add(this);

    }

    public void removeCurso(CursoOnline c){
        c.getListaVideos().remove(this);
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Video video = (Video) o;
        return getId() != null && Objects.equals(getId(), video.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

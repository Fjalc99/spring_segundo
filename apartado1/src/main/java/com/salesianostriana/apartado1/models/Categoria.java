package com.salesianostriana.apartado1.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;


    @OneToMany(mappedBy = "categoria",
    fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Producto> listaProductos = new HashSet<>();



    @OneToMany
    @Builder.Default
    private Set<Categoria> categoriaSuperior = new HashSet<>();


    //Helper
     public void addProducto(Producto p){
         p.setCategoria(this);
         listaProductos.add(p);
     }

     public void removeProducto(Producto p){
         listaProductos.remove(p);
         p.setCategoria(null);
     }

     public void addCategoriaSuperior(Categoria categoria){
         categoriaSuperior.add(categoria);
     }

     public void removeCategoriaSuperior(Categoria categoria){
         categoriaSuperior.remove(categoria);
     }



    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Categoria categoria = (Categoria) o;
        return getId() != null && Objects.equals(getId(), categoria.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}


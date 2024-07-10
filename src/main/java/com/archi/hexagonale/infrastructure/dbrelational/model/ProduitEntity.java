package com.archi.hexagonale.infrastructure.dbrelational.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

@Entity(name = ProduitEntity.ENTITY_NAME)
@Getter
@Setter
public class ProduitEntity {

    public static final String ENTITY_NAME = "produit";

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "reference")
    private UUID reference ;

    private  String designation;

    private String description;

    private Double prix;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !this.getClass()
                .equals(o.getClass())) {
            return false;
        }
        ProduitEntity produitEntity = (ProduitEntity) o;
        return Objects.equals(reference, produitEntity.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }

}

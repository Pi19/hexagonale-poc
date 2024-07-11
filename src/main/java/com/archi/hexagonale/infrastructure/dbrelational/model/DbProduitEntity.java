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

@Entity(name = DbProduitEntity.ENTITY_NAME)
@Getter
@Setter
public class DbProduitEntity {

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
        DbProduitEntity dbProduitEntity = (DbProduitEntity) o;
        return Objects.equals(reference, dbProduitEntity.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }

}

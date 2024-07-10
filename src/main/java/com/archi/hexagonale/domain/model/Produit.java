package com.archi.hexagonale.domain.model;


import java.util.UUID;


public record Produit(UUID reference , String designation ,String description ,Double prix) {
    public static class Builder {
          private  UUID reference ;
          private  String designation;
          private String description;
          private Double prix;

        public Builder reference(UUID reference) { this.reference = reference; return this; }
        public Builder designation(String designation) { this.designation = designation ; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder prix(Double prix) { this.prix = prix; return this; }

        public Produit build() {
            return new Produit(reference, designation, description , prix);
        }
    }
}

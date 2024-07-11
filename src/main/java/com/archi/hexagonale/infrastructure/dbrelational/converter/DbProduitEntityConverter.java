package com.archi.hexagonale.infrastructure.dbrelational.converter;

import com.archi.hexagonale.domain.model.Produit;
import com.archi.hexagonale.infrastructure.dbrelational.model.DbProduitEntity;

public final class DbProduitEntityConverter {

    private DbProduitEntityConverter() {
        //nothing
    }

    public static DbProduitEntity toProduitEntity (Produit produit){
        var dbPEntity = new DbProduitEntity();
        dbPEntity.setDescription(produit.getDescription());
        dbPEntity.setDesignation(produit.getDesignation());
        dbPEntity.setPrix(produit.getPrix());
        return  dbPEntity;
    }

    public static Produit toDomainProduit (DbProduitEntity entity){
        return  new Produit(entity.getReference(),entity.getDescription(),
                 entity.getDesignation() ,entity.getPrix());
    }
}

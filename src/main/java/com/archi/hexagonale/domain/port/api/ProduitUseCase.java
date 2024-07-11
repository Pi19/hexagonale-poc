package com.archi.hexagonale.domain.port.api;

import com.archi.hexagonale.domain.model.Produit;

import java.util.UUID;

public interface ProduitUseCase {
    UUID createProduit(Produit produit);
    Produit readProduitByRef(UUID reference);
}

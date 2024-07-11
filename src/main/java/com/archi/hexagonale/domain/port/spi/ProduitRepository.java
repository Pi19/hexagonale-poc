package com.archi.hexagonale.domain.port.spi;

import com.archi.hexagonale.domain.model.Produit;

import java.util.Optional;
import java.util.UUID;

public interface ProduitRepository {
    UUID saveProduit(Produit produit);
    Optional<Produit> readProduitByRef(UUID pReference);
}
